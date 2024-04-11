package xyz.bitacore.examenpracticodesarrolladorbackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.OrdenPedidoDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.OrdenPedido;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IOrdenPedidoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ordenpedido")
public class OrdenPedidoController {
    @Autowired
    private IOrdenPedidoService myService;

    // Add an item to table
    @PostMapping
    public void registrar(@RequestBody OrdenPedidoDTO dto) {
        ModelMapper m = new ModelMapper();
        OrdenPedido myItem = m.map(dto, OrdenPedido.class);
        myService.insert(myItem);
    }

    // Delete an item by ID on table
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Retrieve an items by ID from table
    @GetMapping("/{id}")
    public OrdenPedidoDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        OrdenPedidoDTO myItem = m.map(myService.listId(id), OrdenPedidoDTO.class);
        return myItem;
    }

    // Retrieve all items from table
    @GetMapping
    public List<OrdenPedidoDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, OrdenPedidoDTO.class);
        }).collect(Collectors.toList());
    }

    // (Exclusive to controller) Modify values on table
    @PutMapping
    public void modificar(@RequestBody OrdenPedidoDTO dto) {
        ModelMapper m = new ModelMapper();
        OrdenPedido d = m.map(dto, OrdenPedido.class);
        myService.insert(d);
    }
}