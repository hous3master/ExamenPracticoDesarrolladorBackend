package xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.StockResumen;
import java.util.List;

public interface IStockResumenService {
    void insert(StockResumen StockResumen);
    void delete(int id);
    StockResumen listId(int id);
    List<StockResumen> list();
}