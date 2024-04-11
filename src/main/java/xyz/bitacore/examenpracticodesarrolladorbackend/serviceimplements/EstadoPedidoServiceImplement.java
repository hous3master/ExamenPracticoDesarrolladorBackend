package xyz.bitacore.examenpracticodesarrolladorbackend.serviceimplements;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.EstadoPedido;
import xyz.bitacore.examenpracticodesarrolladorbackend.repositories.IEstadoPedidoRepository;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IEstadoPedidoService;

import java.util.List;

@Service
public class EstadoPedidoServiceImplement implements IEstadoPedidoService {
    @Autowired
    private IEstadoPedidoRepository myRepository;

    // Add an item to table
    @Override
    public void insert(EstadoPedido EstadoPedido) {
        myRepository.save(EstadoPedido);
    }

    // Delete an item by ID on table
    @Override
    public void delete(int idEstadoPedido){
        myRepository.deleteById(idEstadoPedido);
    }

    // Retrieve an items by ID from table
    @Override
    public EstadoPedido listId(int idEstadoPedido){
        return myRepository.findById(idEstadoPedido).orElse(new EstadoPedido());
    }

    // Retrieve all items from table
    @Override
    public List<EstadoPedido> list() {
        return myRepository.findAll();
    }
}