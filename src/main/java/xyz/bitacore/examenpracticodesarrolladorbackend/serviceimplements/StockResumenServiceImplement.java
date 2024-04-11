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

    // Add an item to table
    @Override
    public void insert(StockResumen StockResumen) {
        myRepository.save(StockResumen);
    }

    // Delete an item by ID on table
    @Override
    public void delete(int idStockResumen){
        myRepository.deleteById(idStockResumen);
    }

    // Retrieve an items by ID from table
    @Override
    public StockResumen listId(int idStockResumen){
        return myRepository.findById(idStockResumen).orElse(new StockResumen());
    }

    // Retrieve all items from table
    @Override
    public List<StockResumen> list() {
        return myRepository.findAll();
    }
}