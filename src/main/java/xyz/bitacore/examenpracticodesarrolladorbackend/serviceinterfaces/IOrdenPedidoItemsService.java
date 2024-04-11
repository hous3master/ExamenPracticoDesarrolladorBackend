package xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.OrdenPedidoItems;
import java.util.List;

public interface IOrdenPedidoItemsService {
    void insert(OrdenPedidoItems OrdenPedidoItems);
    void delete(int id);
    OrdenPedidoItems listId(int id);
    List<OrdenPedidoItems> list();
}