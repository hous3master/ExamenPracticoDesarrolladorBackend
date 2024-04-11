package xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.OrdenPedidosEvaluadores;
import java.util.List;

public interface IOrdenPedidosEvaluadoresService {
    void insert(OrdenPedidosEvaluadores OrdenPedidosEvaluadores);
    void delete(int id);
    OrdenPedidosEvaluadores listId(int id);
    List<OrdenPedidosEvaluadores> list();
}