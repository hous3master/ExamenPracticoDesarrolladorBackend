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

    // Add an item to table
    @Override
    public void insert(Cliente Cliente) {
        myRepository.save(Cliente);
    }

    // Delete an item by ID on table
    @Override
    public void delete(int idCliente){
        myRepository.deleteById(idCliente);
    }

    // Retrieve an items by ID from table
    @Override
    public Cliente listId(int idCliente){
        return myRepository.findById(idCliente).orElse(new Cliente());
    }

    // Retrieve all items from table
    @Override
    public List<Cliente> list() {
        return myRepository.findAll();
    }
}