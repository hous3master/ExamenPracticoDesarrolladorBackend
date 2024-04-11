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

    // ======= CRUD =======
    // Crear
    @Override
    public void insert(OrdenPedidoItems OrdenPedidoItems) {
        myRepository.save(OrdenPedidoItems);
    }

    // Eliminar por ID
    @Override
    public void delete(int idOrdenPedidoItems){
        myRepository.deleteById(idOrdenPedidoItems);
    }

    // Leer por ID
    @Override
    public OrdenPedidoItems listId(int idOrdenPedidoItems){
        return myRepository.findById(idOrdenPedidoItems).orElse(new OrdenPedidoItems());
    }

    // Leer toda la tabla
    @Override
    public List<OrdenPedidoItems> list() {
        return myRepository.findAll();
    }
}