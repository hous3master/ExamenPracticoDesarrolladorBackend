package xyz.bitacore.examenpracticodesarrolladorbackend.serviceimplements;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.OrdenPedidosEvaluadores;
import xyz.bitacore.examenpracticodesarrolladorbackend.repositories.IOrdenPedidosEvaluadoresRepository;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IOrdenPedidosEvaluadoresService;

import java.util.List;

@Service
public class OrdenPedidosEvaluadoresServiceImplement implements IOrdenPedidosEvaluadoresService {
    @Autowired
    private IOrdenPedidosEvaluadoresRepository myRepository;

    // Add an item to table
    @Override
    public void insert(OrdenPedidosEvaluadores OrdenPedidosEvaluadores) {
        myRepository.save(OrdenPedidosEvaluadores);
    }

    // Delete an item by ID on table
    @Override
    public void delete(int idOrdenPedidosEvaluadores){
        myRepository.deleteById(idOrdenPedidosEvaluadores);
    }

    // Retrieve an items by ID from table
    @Override
    public OrdenPedidosEvaluadores listId(int idOrdenPedidosEvaluadores){
        return myRepository.findById(idOrdenPedidosEvaluadores).orElse(new OrdenPedidosEvaluadores());
    }

    // Retrieve all items from table
    @Override
    public List<OrdenPedidosEvaluadores> list() {
        return myRepository.findAll();
    }
}