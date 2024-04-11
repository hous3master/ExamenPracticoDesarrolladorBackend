package xyz.bitacore.examenpracticodesarrolladorbackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.EstadoPedidoDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.OrdenPedidoDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.OrdenPedidoItemsDTO;
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

    @PatchMapping("/actualizar-estado-pendiente-evaluacion/{id-orden-pedido}")
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

        // Crear orden de pedido evaluadores con id de la orden de pedido y el usuario correspondiente (asignado aleatoriamente)
        // Paso 1: Calcular el usuario
        /*
        IdUsuario	Nombre  Rango de importe total en la orden
        1	Marco Silverio 1-5000
        2	Luis Almeyda  1-5000
        3	Ivan Moran 1-5000
        4	Ibarra   5001-10000
        5	Perlacios   5001-10000
        6	Ortiz   > 10000
        7	Eche    > 10000
        */
        OrdenPedidosEvaluadores ordenPedidosEvaluadores = new OrdenPedidosEvaluadores();
        Usuario usuario = new Usuario();
        if (ordenPedido.getTotal() >= 1 && ordenPedido.getTotal() <= 5000) {
            usuario.setIdUsuario(1 + (int)(Math.random() * 3));
        } else if (ordenPedido.getTotal() >= 5001 && ordenPedido.getTotal() <= 10000) {
            usuario.setIdUsuario(4 + (int)(Math.random() * 2));
        } else if (ordenPedido.getTotal() > 10000) {
            usuario.setIdUsuario(6 + (int)(Math.random() * 2));
        }
        ordenPedidosEvaluadores.setUsuario(usuario);

        // Actualizar el estado de la orden de pedido a "2"="Pendiente de evaluación"
        EstadoPedido estadoPedido = new EstadoPedido();
        estadoPedido.setIdEstadoPedido(2);
        ordenPedido.setEstadoPedido(estadoPedido);

        // Guardar en DB
        myService.insert(ordenPedido);
        ordenPedidosEvaluadoresRepository.save(ordenPedidosEvaluadores);
    }

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