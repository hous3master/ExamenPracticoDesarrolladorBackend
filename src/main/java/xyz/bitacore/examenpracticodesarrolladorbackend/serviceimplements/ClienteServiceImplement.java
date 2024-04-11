package xyz.bitacore.examenpracticodesarrolladorbackend.serviceimplements;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Cliente;
import xyz.bitacore.examenpracticodesarrolladorbackend.repositories.IClienteRepository;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IClienteService;

import java.util.List;

@Service
public class ClienteServiceImplement implements IClienteService {
    @Autowired
    private IClienteRepository myRepository;

    // ======= CRUD =======
    // Crear
    @Override
    public void insert(Cliente Cliente) {
        myRepository.save(Cliente);
    }

    // Eliminar por ID
    @Override
    public void delete(int idCliente){
        myRepository.deleteById(idCliente);
    }

    // Leer por ID
    @Override
    public Cliente listId(int idCliente){
        return myRepository.findById(idCliente).orElse(new Cliente());
    }

    // Leer toda la tabla
    @Override
    public List<Cliente> list() {
        return myRepository.findAll();
    }
}