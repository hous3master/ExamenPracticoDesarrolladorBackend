package xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Cliente;
import java.util.List;

public interface IClienteService {
    void insert(Cliente Cliente);
    void delete(int id);
    Cliente listId(int id);
    List<Cliente> list();
}