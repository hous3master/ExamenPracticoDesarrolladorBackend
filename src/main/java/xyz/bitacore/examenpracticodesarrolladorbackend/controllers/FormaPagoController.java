package xyz.bitacore.examenpracticodesarrolladorbackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.FormaPagoDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.FormaPago;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IFormaPagoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/formapago")
public class FormaPagoController {
    @Autowired
    private IFormaPagoService myService;

    // ======= CRUD =======
    // Crear
    @PostMapping
    public void registrar(@RequestBody FormaPagoDTO dto) {
        ModelMapper m = new ModelMapper();
        FormaPago myItem = m.map(dto, FormaPago.class);
        myService.insert(myItem);
    }

    // Eliminar por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Leer por ID
    @GetMapping("/{id}")
    public FormaPagoDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        FormaPagoDTO myItem = m.map(myService.listId(id), FormaPagoDTO.class);
        return myItem;
    }

    // Leer toda la tabla
    @GetMapping
    public List<FormaPagoDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, FormaPagoDTO.class);
        }).collect(Collectors.toList());
    }

    // Actualizar por ID
    @PutMapping
    public void modificar(@RequestBody FormaPagoDTO dto) {
        ModelMapper m = new ModelMapper();
        FormaPago d = m.map(dto, FormaPago.class);
        myService.insert(d);
    }
}