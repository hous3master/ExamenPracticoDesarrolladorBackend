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

    // ======= CRUD =======
    // Crear
    @Override
    public void insert(OrdenPedido OrdenPedido) {
        myRepository.save(OrdenPedido);
    }

    // Eliminar por ID
    @Override
    public void delete(int idOrdenPedido){
        myRepository.deleteById(idOrdenPedido);
    }

    // Leer por ID
    @Override
    public OrdenPedido listId(int idOrdenPedido){
        return myRepository.findById(idOrdenPedido).orElse(new OrdenPedido());
    }

    // Leer toda la tabla
    @Override
    public List<OrdenPedido> list() {
        return myRepository.findAll();
    }
}