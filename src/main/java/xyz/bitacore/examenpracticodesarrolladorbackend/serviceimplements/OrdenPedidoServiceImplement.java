package xyz.bitacore.examenpracticodesarrolladorbackend.serviceimplements;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.OrdenPedido;
import xyz.bitacore.examenpracticodesarrolladorbackend.repositories.IOrdenPedidoRepository;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IOrdenPedidoService;

import java.util.List;

@Service
public class OrdenPedidoServiceImplement implements IOrdenPedidoService {
    @Autowired
    private IOrdenPedidoRepository myRepository;

    // Add an item to table
    @Override
    public void insert(OrdenPedido OrdenPedido) {
        myRepository.save(OrdenPedido);
    }

    // Delete an item by ID on table
    @Override
    public void delete(int idOrdenPedido){
        myRepository.deleteById(idOrdenPedido);
    }

    // Retrieve an items by ID from table
    @Override
    public OrdenPedido listId(int idOrdenPedido){
        return myRepository.findById(idOrdenPedido).orElse(new OrdenPedido());
    }

    // Retrieve all items from table
    @Override
    public List<OrdenPedido> list() {
        return myRepository.findAll();
    }
}