package xyz.bitacore.examenpracticodesarrolladorbackend.serviceimplements;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.OrdenPedidoItems;
import xyz.bitacore.examenpracticodesarrolladorbackend.repositories.IOrdenPedidoItemsRepository;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IOrdenPedidoItemsService;

import java.util.List;

@Service
public class OrdenPedidoItemsServiceImplement implements IOrdenPedidoItemsService {
    @Autowired
    private IOrdenPedidoItemsRepository myRepository;

    // Add an item to table
    @Override
    public void insert(OrdenPedidoItems OrdenPedidoItems) {
        myRepository.save(OrdenPedidoItems);
    }

    // Delete an item by ID on table
    @Override
    public void delete(int idOrdenPedidoItems){
        myRepository.deleteById(idOrdenPedidoItems);
    }

    // Retrieve an items by ID from table
    @Override
    public OrdenPedidoItems listId(int idOrdenPedidoItems){
        return myRepository.findById(idOrdenPedidoItems).orElse(new OrdenPedidoItems());
    }

    // Retrieve all items from table
    @Override
    public List<OrdenPedidoItems> list() {
        return myRepository.findAll();
    }
}