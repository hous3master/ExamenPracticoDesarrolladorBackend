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

    // Add an item to table
    @Override
    public void insert(FormaPago FormaPago) {
        myRepository.save(FormaPago);
    }

    // Delete an item by ID on table
    @Override
    public void delete(int idFormaPago){
        myRepository.deleteById(idFormaPago);
    }

    // Retrieve an items by ID from table
    @Override
    public FormaPago listId(int idFormaPago){
        return myRepository.findById(idFormaPago).orElse(new FormaPago());
    }

    // Retrieve all items from table
    @Override
    public List<FormaPago> list() {
        return myRepository.findAll();
    }
}