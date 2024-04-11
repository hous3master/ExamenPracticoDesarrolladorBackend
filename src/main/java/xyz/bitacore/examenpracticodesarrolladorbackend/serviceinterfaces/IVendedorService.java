package xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Vendedor;
import java.util.List;

public interface IVendedorService {
    void insert(Vendedor Vendedor);
    void delete(int id);
    Vendedor listId(int id);
    List<Vendedor> list();
}