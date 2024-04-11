package xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.FormaPago;
import java.util.List;

public interface IFormaPagoService {
    void insert(FormaPago FormaPago);
    void delete(int id);
    FormaPago listId(int id);
    List<FormaPago> list();
}