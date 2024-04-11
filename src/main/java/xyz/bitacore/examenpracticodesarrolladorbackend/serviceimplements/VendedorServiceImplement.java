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

    // ======= CRUD =======
    // Crear
    @Override
    public void insert(Vendedor Vendedor) {
        myRepository.save(Vendedor);
    }

    // Eliminar por ID
    @Override
    public void delete(int idVendedor){
        myRepository.deleteById(idVendedor);
    }

    // Leer por ID
    @Override
    public Vendedor listId(int idVendedor){
        return myRepository.findById(idVendedor).orElse(new Vendedor());
    }

    // Leer toda la tabla
    @Override
    public List<Vendedor> list() {
        return myRepository.findAll();
    }
}