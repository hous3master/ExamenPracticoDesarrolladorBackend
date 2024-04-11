package xyz.bitacore.examenpracticodesarrolladorbackend.serviceimplements;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.FormaPago;
import xyz.bitacore.examenpracticodesarrolladorbackend.repositories.IFormaPagoRepository;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IFormaPagoService;

import java.util.List;

@Service
public class FormaPagoServiceImplement implements IFormaPagoService {
    @Autowired
    private IFormaPagoRepository myRepository;

    // ======= CRUD =======
    // Crear
    @Override
    public void insert(FormaPago FormaPago) {
        myRepository.save(FormaPago);
    }

    // Eliminar por ID
    @Override
    public void delete(int idFormaPago){
        myRepository.deleteById(idFormaPago);
    }

    // Leer por ID
    @Override
    public FormaPago listId(int idFormaPago){
        return myRepository.findById(idFormaPago).orElse(new FormaPago());
    }

    // Leer toda la tabla
    @Override
    public List<FormaPago> list() {
        return myRepository.findAll();
    }
}