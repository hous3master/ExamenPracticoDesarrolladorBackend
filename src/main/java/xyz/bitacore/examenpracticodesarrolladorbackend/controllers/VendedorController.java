package xyz.bitacore.examenpracticodesarrolladorbackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.VendedorDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Vendedor;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IVendedorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/vendedor")
public class VendedorController {
    @Autowired
    private IVendedorService myService;

    // Add an item to table
    @PostMapping
    public void registrar(@RequestBody VendedorDTO dto) {
        ModelMapper m = new ModelMapper();
        Vendedor myItem = m.map(dto, Vendedor.class);
        myService.insert(myItem);
    }

    // Delete an item by ID on table
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Retrieve an items by ID from table
    @GetMapping("/{id}")
    public VendedorDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        VendedorDTO myItem = m.map(myService.listId(id), VendedorDTO.class);
        return myItem;
    }

    // Retrieve all items from table
    @GetMapping
    public List<VendedorDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, VendedorDTO.class);
        }).collect(Collectors.toList());
    }

    // (Exclusive to controller) Modify values on table
    @PutMapping
    public void modificar(@RequestBody VendedorDTO dto) {
        ModelMapper m = new ModelMapper();
        Vendedor d = m.map(dto, Vendedor.class);
        myService.insert(d);
    }
}