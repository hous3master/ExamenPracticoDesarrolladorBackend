package xyz.bitacore.examenpracticodesarrolladorbackend.serviceimplements;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.StockResumen;
import xyz.bitacore.examenpracticodesarrolladorbackend.repositories.IStockResumenRepository;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IStockResumenService;

import java.util.List;

@Service
public class StockResumenServiceImplement implements IStockResumenService {
    @Autowired
    private IStockResumenRepository myRepository;

    // ======= CRUD =======
    // Crear
    @Override
    public void insert(StockResumen StockResumen) {
        myRepository.save(StockResumen);
    }

    // Eliminar por ID
    @Override
    public void delete(int idStockResumen){
        myRepository.deleteById(idStockResumen);
    }

    // Leer por ID
    @Override
    public StockResumen listId(int idStockResumen){
        return myRepository.findById(idStockResumen).orElse(new StockResumen());
    }

    // Leer toda la tabla
    @Override
    public List<StockResumen> list() {
        return myRepository.findAll();
    }
}