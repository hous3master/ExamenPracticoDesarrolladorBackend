package xyz.bitacore.examenpracticodesarrolladorbackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.EstadoPedidoDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.EstadoPedido;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IEstadoPedidoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/estadopedido")
public class EstadoPedidoController {
    @Autowired
    private IEstadoPedidoService myService;

    // ======= CRUD =======
    // Crear
    @PostMapping
    public void registrar(@RequestBody EstadoPedidoDTO dto) {
        ModelMapper m = new ModelMapper();
        EstadoPedido myItem = m.map(dto, EstadoPedido.class);
        myService.insert(myItem);
    }

    // Eliminar por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Leer por ID
    @GetMapping("/{id}")
    public EstadoPedidoDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        EstadoPedidoDTO myItem = m.map(myService.listId(id), EstadoPedidoDTO.class);
        return myItem;
    }

    // Leer toda la tabla
    @GetMapping
    public List<EstadoPedidoDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EstadoPedidoDTO.class);
        }).collect(Collectors.toList());
    }

    // Actualizar por ID
    @PutMapping
    public void modificar(@RequestBody EstadoPedidoDTO dto) {
        ModelMapper m = new ModelMapper();
        EstadoPedido d = m.map(dto, EstadoPedido.class);
        myService.insert(d);
    }
}