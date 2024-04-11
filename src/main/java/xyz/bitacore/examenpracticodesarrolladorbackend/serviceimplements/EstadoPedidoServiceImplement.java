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

    // ======= CRUD =======
    // Crear
    @Override
    public void insert(EstadoPedido EstadoPedido) {
        myRepository.save(EstadoPedido);
    }

    // Eliminar por ID
    @Override
    public void delete(int idEstadoPedido){
        myRepository.deleteById(idEstadoPedido);
    }

    // Leer por ID
    @Override
    public EstadoPedido listId(int idEstadoPedido){
        return myRepository.findById(idEstadoPedido).orElse(new EstadoPedido());
    }

    // Leer toda la tabla
    @Override
    public List<EstadoPedido> list() {
        return myRepository.findAll();
    }
}