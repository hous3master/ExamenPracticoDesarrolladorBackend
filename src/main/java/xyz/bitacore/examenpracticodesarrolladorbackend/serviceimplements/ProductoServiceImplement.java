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

    // ======= CRUD =======
    // Crear
    @Override
    public void insert(Producto Producto) {
        myRepository.save(Producto);
    }

    // Eliminar por ID
    @Override
    public void delete(int idProducto){
        myRepository.deleteById(idProducto);
    }

    // Leer por ID
    @Override
    public Producto listId(int idProducto){
        return myRepository.findById(idProducto).orElse(new Producto());
    }

    // Leer toda la tabla
    @Override
    public List<Producto> list() {
        return myRepository.findAll();
    }
}