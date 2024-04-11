package xyz.bitacore.examenpracticodesarrolladorbackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.ProductoDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Producto;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IProductoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private IProductoService myService;

    // Add an item to table
    @PostMapping
    public void registrar(@RequestBody ProductoDTO dto) {
        ModelMapper m = new ModelMapper();
        Producto myItem = m.map(dto, Producto.class);
        myService.insert(myItem);
    }

    // Delete an item by ID on table
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Retrieve an items by ID from table
    @GetMapping("/{id}")
    public ProductoDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        ProductoDTO myItem = m.map(myService.listId(id), ProductoDTO.class);
        return myItem;
    }

    // Retrieve all items from table
    @GetMapping
    public List<ProductoDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ProductoDTO.class);
        }).collect(Collectors.toList());
    }

    // (Exclusive to controller) Modify values on table
    @PutMapping
    public void modificar(@RequestBody ProductoDTO dto) {
        ModelMapper m = new ModelMapper();
        Producto d = m.map(dto, Producto.class);
        myService.insert(d);
    }
}