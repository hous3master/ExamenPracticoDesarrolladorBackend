package xyz.bitacore.examenpracticodesarrolladorbackend.serviceimplements;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Vendedor;
import xyz.bitacore.examenpracticodesarrolladorbackend.repositories.IVendedorRepository;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IVendedorService;

import java.util.List;

@Service
public class VendedorServiceImplement implements IVendedorService {
    @Autowired
    private IVendedorRepository myRepository;

    // Add an item to table
    @Override
    public void insert(Vendedor Vendedor) {
        myRepository.save(Vendedor);
    }

    // Delete an item by ID on table
    @Override
    public void delete(int idVendedor){
        myRepository.deleteById(idVendedor);
    }

    // Retrieve an items by ID from table
    @Override
    public Vendedor listId(int idVendedor){
        return myRepository.findById(idVendedor).orElse(new Vendedor());
    }

    // Retrieve all items from table
    @Override
    public List<Vendedor> list() {
        return myRepository.findAll();
    }
}