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

    // ======= CRUD =======
    // Crear
    @Override
    public void insert(OrdenPedidosEvaluadores OrdenPedidosEvaluadores) {
        myRepository.save(OrdenPedidosEvaluadores);
    }

    // Eliminar por ID
    @Override
    public void delete(int idOrdenPedidosEvaluadores){
        myRepository.deleteById(idOrdenPedidosEvaluadores);
    }

    // Leer por ID
    @Override
    public OrdenPedidosEvaluadores listId(int idOrdenPedidosEvaluadores){
        return myRepository.findById(idOrdenPedidosEvaluadores).orElse(new OrdenPedidosEvaluadores());
    }

    // Leer toda la tabla
    @Override
    public List<OrdenPedidosEvaluadores> list() {
        return myRepository.findAll();
    }
}