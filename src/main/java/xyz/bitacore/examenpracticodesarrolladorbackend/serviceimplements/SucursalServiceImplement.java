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

    // ======= CRUD =======
    // Crear
    @Override
    public void insert(Sucursal Sucursal) {
        myRepository.save(Sucursal);
    }

    // Eliminar por ID
    @Override
    public void delete(int idSucursal){
        myRepository.deleteById(idSucursal);
    }

    // Leer por ID
    @Override
    public Sucursal listId(int idSucursal){
        return myRepository.findById(idSucursal).orElse(new Sucursal());
    }

    // Leer toda la tabla
    @Override
    public List<Sucursal> list() {
        return myRepository.findAll();
    }
}