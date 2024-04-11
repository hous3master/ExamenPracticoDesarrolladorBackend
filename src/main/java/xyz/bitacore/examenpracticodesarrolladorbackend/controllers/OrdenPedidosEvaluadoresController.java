package xyz.bitacore.examenpracticodesarrolladorbackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.OrdenPedidosEvaluadoresDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.OrdenPedidosEvaluadores;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IOrdenPedidosEvaluadoresService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ordenpedidosevaluadores")
public class OrdenPedidosEvaluadoresController {
    @Autowired
    private IOrdenPedidosEvaluadoresService myService;

    // Add an item to table
    @PostMapping
    public void registrar(@RequestBody OrdenPedidosEvaluadoresDTO dto) {
        ModelMapper m = new ModelMapper();
        OrdenPedidosEvaluadores myItem = m.map(dto, OrdenPedidosEvaluadores.class);
        myService.insert(myItem);
    }

    // Delete an item by ID on table
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Retrieve an items by ID from table
    @GetMapping("/{id}")
    public OrdenPedidosEvaluadoresDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        OrdenPedidosEvaluadoresDTO myItem = m.map(myService.listId(id), OrdenPedidosEvaluadoresDTO.class);
        return myItem;
    }

    // Retrieve all items from table
    @GetMapping
    public List<OrdenPedidosEvaluadoresDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, OrdenPedidosEvaluadoresDTO.class);
        }).collect(Collectors.toList());
    }

    // (Exclusive to controller) Modify values on table
    @PutMapping
    public void modificar(@RequestBody OrdenPedidosEvaluadoresDTO dto) {
        ModelMapper m = new ModelMapper();
        OrdenPedidosEvaluadores d = m.map(dto, OrdenPedidosEvaluadores.class);
        myService.insert(d);
    }
}