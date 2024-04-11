package xyz.bitacore.examenpracticodesarrolladorbackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.ClienteDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Cliente;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IClienteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private IClienteService myService;

    // Add an item to table
    @PostMapping
    public void registrar(@RequestBody ClienteDTO dto) {
        ModelMapper m = new ModelMapper();
        Cliente myItem = m.map(dto, Cliente.class);
        myService.insert(myItem);
    }

    // Delete an item by ID on table
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Retrieve an items by ID from table
    @GetMapping("/{id}")
    public ClienteDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        ClienteDTO myItem = m.map(myService.listId(id), ClienteDTO.class);
        return myItem;
    }

    // Retrieve all items from table
    @GetMapping
    public List<ClienteDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ClienteDTO.class);
        }).collect(Collectors.toList());
    }

    // (Exclusive to controller) Modify values on table
    @PutMapping
    public void modificar(@RequestBody ClienteDTO dto) {
        ModelMapper m = new ModelMapper();
        Cliente d = m.map(dto, Cliente.class);
        myService.insert(d);
    }
}