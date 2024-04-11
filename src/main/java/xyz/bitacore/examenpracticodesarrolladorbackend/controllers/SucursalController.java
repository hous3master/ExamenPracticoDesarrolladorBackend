package xyz.bitacore.examenpracticodesarrolladorbackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.SucursalDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Sucursal;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.ISucursalService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/sucursal")
public class SucursalController {
    @Autowired
    private ISucursalService myService;

    // ======= CRUD =======
    // Crear
    @PostMapping
    public void registrar(@RequestBody SucursalDTO dto) {
        ModelMapper m = new ModelMapper();
        Sucursal myItem = m.map(dto, Sucursal.class);
        myService.insert(myItem);
    }

    // Eliminar por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Leer por ID
    @GetMapping("/{id}")
    public SucursalDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        SucursalDTO myItem = m.map(myService.listId(id), SucursalDTO.class);
        return myItem;
    }

    // Leer toda la tabla
    @GetMapping
    public List<SucursalDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SucursalDTO.class);
        }).collect(Collectors.toList());
    }

    // Actualizar por ID
    @PutMapping
    public void modificar(@RequestBody SucursalDTO dto) {
        ModelMapper m = new ModelMapper();
        Sucursal d = m.map(dto, Sucursal.class);
        myService.insert(d);
    }
}