package xyz.bitacore.examenpracticodesarrolladorbackend.serviceimplements;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Producto;
import xyz.bitacore.examenpracticodesarrolladorbackend.repositories.IProductoRepository;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IProductoService;

import java.util.List;

@Service
public class ProductoServiceImplement implements IProductoService {
    @Autowired
    private IProductoRepository myRepository;

    // Add an item to table
    @Override
    public void insert(Producto Producto) {
        myRepository.save(Producto);
    }

    // Delete an item by ID on table
    @Override
    public void delete(int idProducto){
        myRepository.deleteById(idProducto);
    }

    // Retrieve an items by ID from table
    @Override
    public Producto listId(int idProducto){
        return myRepository.findById(idProducto).orElse(new Producto());
    }

    // Retrieve all items from table
    @Override
    public List<Producto> list() {
        return myRepository.findAll();
    }
}