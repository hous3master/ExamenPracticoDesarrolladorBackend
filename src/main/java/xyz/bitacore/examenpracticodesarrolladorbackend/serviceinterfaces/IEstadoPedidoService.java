package xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.EstadoPedido;
import java.util.List;

public interface IEstadoPedidoService {
    void insert(EstadoPedido EstadoPedido);
    void delete(int id);
    EstadoPedido listId(int id);
    List<EstadoPedido> list();
}