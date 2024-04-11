package xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Producto;
import java.util.List;

public interface IProductoService {
    void insert(Producto Producto);
    void delete(int id);
    Producto listId(int id);
    List<Producto> list();
}