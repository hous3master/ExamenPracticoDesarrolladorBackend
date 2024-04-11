package xyz.bitacore.examenpracticodesarrolladorbackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.EstadoPedidoDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.OrdenPedidoDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.OrdenPedidoItemsDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.OrdenPedidoResumenDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.repositories.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IOrdenPedidoService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ordenpedido")
public class OrdenPedidoController {
    @Autowired
    private IOrdenPedidoService myService;

    @Autowired
    private IOrdenPedidoItemsRepository ordenPedidoItemsRepository;
    @Autowired
    private IProductoRepository productoRepository;
    @Autowired
    private ISucursalRepository sucursalRepository;
    @Autowired
    private IStockResumenRepository stockResumenRepository;
    @Autowired
    private IOrdenPedidoRepository ordenPedidoRepository;
    @Autowired
    private IOrdenPedidosEvaluadoresRepository ordenPedidosEvaluadoresRepository;
    @Autowired
    private IUsuarioRepository usuarioRepository;

    // Evaluar un pedido
    @PutMapping("/evaluar-pedido/{id-usuario}")
    public void evaluarPedido(@PathVariable("id-usuario") int idUsuario, @RequestParam int idOrdenPedido, @RequestParam String resultado, @RequestBody(required = false) String comentarios) {
        // Validar que el usuario exista
        if (usuarioRepository.existsById(idUsuario) == false) {
            throw new IllegalArgumentException("El usuario no existe");
        }

        // Obtener la lista de todas orden de pedido
        OrdenPedido ordenPedido = myService.listId(idOrdenPedido);

        // Validar que la orden de pedido exista
        if (ordenPedido == null) {
            throw new IllegalArgumentException("La orden de pedido no existe");
        }

        // Validar que el estado del pedido sea "2"="Pendiente de evaluación"
        if (ordenPedido.getEstadoPedido().getIdEstadoPedido() != 2) {
            throw new IllegalArgumentException("El estado del pedido debe ser 'Pendiente de evaluación'");
        }

        // Validar que el usuario tenga autoridad para evaluar la orden de pedido
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(new Usuario());
        if (ordenPedido.getTotal() >= 1 && ordenPedido.getTotal() <= 5000) {
            if (usuario.getIdUsuario() < 1 || usuario.getIdUsuario() > 3) {
                throw new SecurityException("El usuario no tiene autoridad para evaluar la orden de pedido");
            }
        } else if (ordenPedido.getTotal() > 5000 && ordenPedido.getTotal() <= 10000) {
            if (usuario.getIdUsuario() < 4 || usuario.getIdUsuario() > 5) {
                throw new SecurityException("El usuario no tiene autoridad para evaluar la orden de pedido");
            }
        } else if (ordenPedido.getTotal() > 10000) {
            if (usuario.getIdUsuario() < 6 || usuario.getIdUsuario() > 7) {
                throw new SecurityException("El usuario no tiene autoridad para evaluar la orden de pedido");
            }
        }

        // Validar que el resultado sea "Aprobado" o "Desaprobado"
        if (!resultado.equals("Aprobado") && !resultado.equals("Desaprobado")) {
            throw new IllegalArgumentException("El resultado debe ser 'Aprobado' o 'Desaprobado'");
        }

        // Obtener la orden de pedido evaluadores
        OrdenPedidosEvaluadores ordenPedidosEvaluadores = ordenPedidosEvaluadoresRepository.findByOrdenPedidoAndUsuario(ordenPedido, usuario);
        // Asignar resultado a orden pedido evaluadores
        ordenPedidosEvaluadores.setResultado(resultado);
        // Aisgnar fecha de evaluacion actual a orden pedido evaluadores
        ordenPedidosEvaluadores.setFechaevaluacion(LocalDate.now());
        // Asignar comentarios a orden pedido evaluadores
        ordenPedidosEvaluadores.setComentarios(comentarios);
        // Guardar orden de pedido evaluadores en DB
        ordenPedidosEvaluadoresRepository.save(ordenPedidosEvaluadores);

        // Si el total de la orden de pedido es menor o igual a 10000
        if (ordenPedido.getTotal() <= 10000) {
            // Si el resultado es aprobado, asignar el estado de la misma orden a "3"="Aprobado"
            if (resultado.equals("Aprobado")) {
                EstadoPedido estadoPedido = new EstadoPedido();
                estadoPedido.setIdEstadoPedido(3);
                ordenPedido.setEstadoPedido(estadoPedido);
                myService.insert(ordenPedido);

                // Enviar un correo a cfmorenofernandez@gmail.com

            }
            // Si es desaprobado, asignar el estado de la misma orden a "4"="Desaprobado"
            if (resultado.equals("Desaprobado")) {
                EstadoPedido estadoPedido = new EstadoPedido();
                estadoPedido.setIdEstadoPedido(4);
                ordenPedido.setEstadoPedido(estadoPedido);
                myService.insert(ordenPedido);
            }
        }

        // Si es > 10000
        if (ordenPedido.getTotal() > 10000) {
            // Si es desaprobado
            if (resultado.equals("Desaprobado")) {
                // Asignar el estado de la misma orden a "4"="Desaprobado"
                EstadoPedido estadoPedido = new EstadoPedido();
                estadoPedido.setIdEstadoPedido(4);
                ordenPedido.setEstadoPedido(estadoPedido);
                myService.insert(ordenPedido);
            }
            // Si es aprobado
            if (resultado.equals("Aprobado")) {
                // Paso 1: Obtener la lista de ordenes de pedido evaluadores
                List<OrdenPedidosEvaluadores> OrdenPedidosEvaluadoresList = ordenPedidosEvaluadoresRepository.findAllByOrdenPedido(ordenPedido);

                // Paso 2: Filtrar la lista de ordenes de pedido evaluadores por resultado "Aprobado"
                List<OrdenPedidosEvaluadores> OrdenPedidosEvaluadoresListFiltrada = OrdenPedidosEvaluadoresList.stream().filter(x -> x.getResultado().equals("Aprobado")).toList();

                // Si ya hay un aprobado, asignar el estado de la misma orden a "3"="Aprobado"
                if (!OrdenPedidosEvaluadoresListFiltrada.isEmpty()) {
                    EstadoPedido estadoPedido = new EstadoPedido();
                    estadoPedido.setIdEstadoPedido(3);
                    ordenPedido.setEstadoPedido(estadoPedido);
                    myService.insert(ordenPedido);
                }
            }
        }
    }

    // Listar los pedidos pendientes de evaluacion (id estado es 2) filtrando por el usuario evaluador
    @GetMapping("/listar-pedidos-pendientes-evaluacion-por-evaluador/{id-usuario}")
    public List<OrdenPedidoResumenDTO> listarPedidosPendientesEvaluacionPorUsuarioEvaluador(@PathVariable("id-usuario")Integer idUsuario){
        List<String[]> lista = ordenPedidoRepository.listarPedidosPendientesEvaluacionPorEvaluador(idUsuario);
        List<OrdenPedidoResumenDTO> listaDTO = lista.stream().map(x -> {
            OrdenPedidoResumenDTO dto = new OrdenPedidoResumenDTO();
            dto.setCodigo(x[0]);
            dto.setFechaEmision(LocalDate.parse(x[1]));
            dto.setNombreCompleto(x[2]);
            dto.setTotal(Double.parseDouble(x[3]));
            return dto;
        }).toList();

        // Validar que el usuario exista
        if (listaDTO.isEmpty()) {
            throw new IllegalArgumentException("El usuario no existe o no tiene pedidos pendientes de evaluación");
        }

        return listaDTO;
    }

    // Cambiar el estado de un pedido en Borrador a “Pendiente Evaluacion”
    @PutMapping("/actualizar-estado-pendiente-evaluacion/{id-orden-pedido}")
    public void cambiarEstado(@PathVariable("id-orden-pedido")Integer idOrdenPedido){
        // Validar que la orden de pedido exista
        if (ordenPedidoRepository.existsOrdenPedidoByIdOrdenPedido(idOrdenPedido) == false) {
            throw new IllegalArgumentException("La orden de pedido no existe");
        }

        // Obtener la orden de pedido
        OrdenPedido ordenPedido = myService.listId(idOrdenPedido);

        // Validar el estado del pedido solo si tiene el estado "1"=“Borrador”.
        if (ordenPedido.getEstadoPedido().getIdEstadoPedido() != 1) {
            throw new IllegalArgumentException("El estado del pedido solo puede ser cambiado si es 'Borrador'");
        }

        // Iterar cada usuario con autoridad para evaluar la orden de pedido
        // Paso 1: Obtener la lista de todos los usuarios
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        // Paso 2: Filtrar la lista de usuarios segun el nivel de autoridad requerido por la orden
        List<Usuario> listaUsuariosFiltrada = listaUsuarios.stream().filter(x -> {
            if (ordenPedido.getTotal() >= 1 && ordenPedido.getTotal() <= 5000) {
                return x.getIdUsuario() >= 1 && x.getIdUsuario() <= 3;
            } else if (ordenPedido.getTotal() > 5000 && ordenPedido.getTotal() <= 10000) {
                return x.getIdUsuario() >= 4 && x.getIdUsuario() <= 5;
            } else if (ordenPedido.getTotal() > 10000) {
                return x.getIdUsuario() >= 6 && x.getIdUsuario() <= 7;
            }
            return false;
        }).toList();

        // Para cada usuario autorizado
        for (Usuario usuario : listaUsuariosFiltrada) {
            // Crear orden de pedido evaluadores
            OrdenPedidosEvaluadores ordenPedidosEvaluadores = new OrdenPedidosEvaluadores();

            // Asignar el usuario evaluador segun el nivel de autoridad requerido por la orden
            ordenPedidosEvaluadores.setUsuario(usuario);

            // Asignar la orden de pedido a orden de pedido evaluadores
            ordenPedidosEvaluadores.setOrdenPedido(ordenPedido);

            // Asignar "Sin Respuesta" a resultado en orden de pedido evaluadores
            ordenPedidosEvaluadores.setResultado("Sin Respuesta");

            // Guardar orden de pedido evaluadores en DB
            ordenPedidosEvaluadoresRepository.save(ordenPedidosEvaluadores);
        }

        // Asignar el estado de la orden de pedido a "2"="Pendiente de evaluación"
        EstadoPedido estadoPedido = new EstadoPedido();
        estadoPedido.setIdEstadoPedido(2);
        ordenPedido.setEstadoPedido(estadoPedido);

        // Guardar orden de pedido en DB
        myService.insert(ordenPedido);
    }

    // Registrar una orden de pedido con los items asociados
    @PostMapping("/crear-orden-items-asociados")
    public void crearOrdenPedido(@RequestParam int idVendedor, @RequestParam int idFormaPago, @RequestParam int idSucursal, @RequestParam int diasCredito, @RequestParam String observaciones, @RequestParam int idCliente, @RequestBody List<OrdenPedidoItemsDTO> ordenPedidoItemsDTOList) {
        // Crear una orden de pedido vacia, y almacenar el ID
        OrdenPedido ordenPedido = new OrdenPedido();
        myService.insert(ordenPedido);
        Integer idOrdenPedido = myService.list().get(myService.list().size() - 1).getIdOrdenPedido();

        // Validar que el pedido no puede tener productos o items duplicados
        int size = ordenPedidoItemsDTOList.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (ordenPedidoItemsDTOList.get(i).getProducto().getIdProducto() == ordenPedidoItemsDTOList.get(j).getProducto().getIdProducto()) {
                    throw new IllegalArgumentException("No se puede tener productos duplicados en un pedido");
                }
            }
        }

        // Validar agregar como minimo un producto al pedido.
        if (ordenPedidoItemsDTOList.size() <= 0) {
            throw new IllegalArgumentException("Se debe agregar al menos un producto al pedido");
        }

        // Validar forma de pago es “1” entonces los dias de credito deben de ser “0”.
        if (idFormaPago == 1 && diasCredito != 0) {
            throw new IllegalArgumentException("Si la forma de pago es 1, los días de crédito deben ser 0");
        }

        // Validar forma de pago es diferente a “1” entonces los dias de credito solo pueden ser 30,60 o 90 dias.
        if (idFormaPago != 1 && diasCredito != 30 && diasCredito != 60 && diasCredito != 90) {
            throw new IllegalArgumentException("Si la forma de pago es diferente a 1, los días de crédito solo pueden ser 30, 60 o 90 días");
        }

        // Validar cantidad maxima de caracteres para las observaciones es de 200.
        if (observaciones.length() > 200) {
            throw new IllegalArgumentException("La cantidad máxima de caracteres para las observaciones es de 200");
        }

        // Validar que cantidad solicitada tenga stock disponible
        for (OrdenPedidoItemsDTO ordenPedidoItemsDTO : ordenPedidoItemsDTOList) {
            int cantidadDisponible = stockResumenRepository.findStockResumenBySucursalAndProducto(sucursalRepository.findById(idSucursal).orElse(new Sucursal()), ordenPedidoItemsDTO.getProducto()).getCantidadDisponible();
            if (ordenPedidoItemsDTO.getCantidad() > cantidadDisponible) {
                throw new IllegalArgumentException("La cantidad solicitada de " + ordenPedidoItemsDTO.getProducto().getDescripcion() + " supera el stock disponible");
            }
        }

        // Para cada item
        for (OrdenPedidoItemsDTO ordenPedidoItemsDTO : ordenPedidoItemsDTOList) {
            // Calcular subtotal como multiplicacion de precioUnitario * cantidad
            ordenPedidoItemsDTO.setSubTotal(ordenPedidoItemsDTO.getPrecioUnitario() * ordenPedidoItemsDTO.getCantidad());
            // Definir su orden de pedido
            ordenPedidoItemsDTO.setOrdenPedido(myService.listId(idOrdenPedido));
            // Guardar en DB
            ModelMapper m = new ModelMapper();
            OrdenPedidoItems ordenPedidoItems = m.map(ordenPedidoItemsDTO, OrdenPedidoItems.class);
            ordenPedidoItemsRepository.save(ordenPedidoItems);
        }

        // Para la orden de pedido

        // Asignar parametros
        Vendedor vendedor = new Vendedor();
        vendedor.setIdVendedor(idVendedor);
        ordenPedido.setVendedor(vendedor);

        FormaPago formaPago = new FormaPago();
        formaPago.setIdFormaPago(idFormaPago);
        ordenPedido.setFormaPago(formaPago);

        Sucursal sucursal = new Sucursal();
        sucursal.setIdSucursal(idSucursal);
        ordenPedido.setSucursal(sucursal);

        ordenPedido.setDiasCredito(diasCredito);
        ordenPedido.setObservaciones(observaciones);

        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);
        ordenPedido.setCliente(cliente);

        // Asignar fecha de pedido como la fecha del sistema
        ordenPedido.setFechaEmision(java.time.LocalDate.now());

        // Asignar total gravado es la suma de todos los subtotales de la orden
        BigDecimal totalGravado = BigDecimal.valueOf(ordenPedidoItemsRepository.findAll().stream().mapToDouble(OrdenPedidoItems::getSubTotal).sum());
        totalGravado = totalGravado.setScale(2, RoundingMode.HALF_EVEN);
        ordenPedido.setTotalGravado(totalGravado.doubleValue());

        // Asignar total IGV es el 18% del total gravado
        BigDecimal totalIGV = totalGravado.multiply(BigDecimal.valueOf(0.18));
        totalIGV = totalIGV.setScale(2, RoundingMode.HALF_EVEN);
        ordenPedido.setTotalIGV(totalIGV.doubleValue());

        // Asignar total es la suma de total gravado y total IGV
        BigDecimal total = totalGravado.add(totalIGV);
        total = total.setScale(2, RoundingMode.HALF_EVEN);
        ordenPedido.setTotal(total.doubleValue());

        // Calcular fecha de vencimiento (fecha de emision + dias de credito. No considerar sabados ni domingos.)
        // Paso 1: Calcular cantidad de sabados y domingos
        int diasSabadosDomingos = 0;
        for (int i = 1; i <= diasCredito; i++) {
            LocalDate fecha = ordenPedido.getFechaEmision().plusDays(i);
            if (fecha.getDayOfWeek().getValue() == 6 || fecha.getDayOfWeek().getValue() == 7) {
                diasSabadosDomingos++;
            }
        }
        // Paso 2: Calcular y asignar fecha de vencimiento
        ordenPedido.setFechaVencimiento(ordenPedido.getFechaEmision().plusDays(diasCredito + diasSabadosDomingos));

        // Asignar codigo de orden de pedido como el [<descripcion de sucursal (en mayusculas)>_C<id del cliente>_<id de la orden de pedido>]
        ordenPedido.setCodigo(sucursalRepository.findById(idSucursal).get().getDescripcion().toUpperCase() + "_C" + idCliente + "_" + idOrdenPedido);

        // Asignar estado de pedido como "1"="Borrador"
        EstadoPedido estadoPedido = new EstadoPedido();
        estadoPedido.setIdEstadoPedido(1);
        ordenPedido.setEstadoPedido(estadoPedido);

        // Guardar Orden en DB (Modificar la existente)
        myService.insert(ordenPedido);
    }

    // ======= CRUD =======
    // Crear
    @PostMapping
    public void registrar(@RequestBody OrdenPedidoDTO dto) {
        ModelMapper m = new ModelMapper();
        OrdenPedido myItem = m.map(dto, OrdenPedido.class);
        myService.insert(myItem);
    }

    // Eliminar por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Leer por ID
    @GetMapping("/{id}")
    public OrdenPedidoDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        OrdenPedidoDTO myItem = m.map(myService.listId(id), OrdenPedidoDTO.class);
        return myItem;
    }

    // Leer toda la tabla
    @GetMapping
    public List<OrdenPedidoDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, OrdenPedidoDTO.class);
        }).collect(Collectors.toList());
    }

    // Actualizar por ID
    @PutMapping
    public void modificar(@RequestBody OrdenPedidoDTO dto) {
        ModelMapper m = new ModelMapper();
        OrdenPedido d = m.map(dto, OrdenPedido.class);
        myService.insert(d);
    }
}