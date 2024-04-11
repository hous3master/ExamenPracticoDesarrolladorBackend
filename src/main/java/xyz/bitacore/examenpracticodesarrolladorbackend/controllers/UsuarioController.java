package xyz.bitacore.examenpracticodesarrolladorbackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.UsuarioDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Usuario;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService myService;

    // Add an item to table
    @PostMapping
    public void registrar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario myItem = m.map(dto, Usuario.class);
        myService.insert(myItem);
    }

    // Delete an item by ID on table
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Retrieve an items by ID from table
    @GetMapping("/{id}")
    public UsuarioDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        UsuarioDTO myItem = m.map(myService.listId(id), UsuarioDTO.class);
        return myItem;
    }

    // Retrieve all items from table
    @GetMapping
    public List<UsuarioDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    // (Exclusive to controller) Modify values on table
    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario d = m.map(dto, Usuario.class);
        myService.insert(d);
    }
}