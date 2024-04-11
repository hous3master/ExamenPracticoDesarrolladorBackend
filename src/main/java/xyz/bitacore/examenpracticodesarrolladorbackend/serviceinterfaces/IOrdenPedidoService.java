package xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.OrdenPedido;
import java.util.List;

public interface IOrdenPedidoService {
    void insert(OrdenPedido OrdenPedido);
    void delete(int id);
    OrdenPedido listId(int id);
    List<OrdenPedido> list();
}