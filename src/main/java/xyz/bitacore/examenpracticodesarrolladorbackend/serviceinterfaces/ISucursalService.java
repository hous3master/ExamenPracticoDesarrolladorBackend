package xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Sucursal;
import java.util.List;

public interface ISucursalService {
    void insert(Sucursal Sucursal);
    void delete(int id);
    Sucursal listId(int id);
    List<Sucursal> list();
}