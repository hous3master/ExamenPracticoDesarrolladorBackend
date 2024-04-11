package xyz.bitacore.examenpracticodesarrolladorbackend.serviceimplements;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Sucursal;
import xyz.bitacore.examenpracticodesarrolladorbackend.repositories.ISucursalRepository;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.ISucursalService;

import java.util.List;

@Service
public class SucursalServiceImplement implements ISucursalService {
    @Autowired
    private ISucursalRepository myRepository;

    // Add an item to table
    @Override
    public void insert(Sucursal Sucursal) {
        myRepository.save(Sucursal);
    }

    // Delete an item by ID on table
    @Override
    public void delete(int idSucursal){
        myRepository.deleteById(idSucursal);
    }

    // Retrieve an items by ID from table
    @Override
    public Sucursal listId(int idSucursal){
        return myRepository.findById(idSucursal).orElse(new Sucursal());
    }

    // Retrieve all items from table
    @Override
    public List<Sucursal> list() {
        return myRepository.findAll();
    }
}