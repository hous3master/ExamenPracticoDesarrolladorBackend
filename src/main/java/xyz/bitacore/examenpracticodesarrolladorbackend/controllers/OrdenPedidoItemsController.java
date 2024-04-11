package xyz.bitacore.examenpracticodesarrolladorbackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.OrdenPedidoItemsDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.OrdenPedidoItems;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IOrdenPedidoItemsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ordenpedidoitems")
public class OrdenPedidoItemsController {
    @Autowired
    private IOrdenPedidoItemsService myService;

    // Add an item to table
    @PostMapping
    public void registrar(@RequestBody OrdenPedidoItemsDTO dto) {
        ModelMapper m = new ModelMapper();
        OrdenPedidoItems myItem = m.map(dto, OrdenPedidoItems.class);
        myService.insert(myItem);
    }

    // Delete an item by ID on table
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Retrieve an items by ID from table
    @GetMapping("/{id}")
    public OrdenPedidoItemsDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        OrdenPedidoItemsDTO myItem = m.map(myService.listId(id), OrdenPedidoItemsDTO.class);
        return myItem;
    }

    // Retrieve all items from table
    @GetMapping
    public List<OrdenPedidoItemsDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, OrdenPedidoItemsDTO.class);
        }).collect(Collectors.toList());
    }

    // (Exclusive to controller) Modify values on table
    @PutMapping
    public void modificar(@RequestBody OrdenPedidoItemsDTO dto) {
        ModelMapper m = new ModelMapper();
        OrdenPedidoItems d = m.map(dto, OrdenPedidoItems.class);
        myService.insert(d);
    }
}