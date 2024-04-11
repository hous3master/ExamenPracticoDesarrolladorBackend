package xyz.bitacore.examenpracticodesarrolladorbackend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.StockResumenDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.StockResumen;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IStockResumenService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/stockresumen")
public class StockResumenController {
    @Autowired
    private IStockResumenService myService;

    // ======= CRUD =======
    // Crear
    @PostMapping
    public void registrar(@RequestBody StockResumenDTO dto) {
        ModelMapper m = new ModelMapper();
        StockResumen myItem = m.map(dto, StockResumen.class);
        myService.insert(myItem);
    }

    // Eliminar por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Leer por ID
    @GetMapping("/{id}")
    public StockResumenDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        StockResumenDTO myItem = m.map(myService.listId(id), StockResumenDTO.class);
        return myItem;
    }

    // Leer toda la tabla
    @GetMapping
    public List<StockResumenDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, StockResumenDTO.class);
        }).collect(Collectors.toList());
    }

    // Actualizar por ID
    @PutMapping
    public void modificar(@RequestBody StockResumenDTO dto) {
        ModelMapper m = new ModelMapper();
        StockResumen d = m.map(dto, StockResumen.class);
        myService.insert(d);
    }
}