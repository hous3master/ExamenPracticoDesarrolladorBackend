package xyz.bitacore.examenpracticodesarrolladorbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.OrdenPedido;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.OrdenPedidosEvaluadores;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Usuario;

import java.util.List;

@Repository
public interface IOrdenPedidosEvaluadoresRepository extends JpaRepository<OrdenPedidosEvaluadores, Integer> {
    List<OrdenPedidosEvaluadores> findAllByOrdenPedido(OrdenPedido ordenPedido);
    OrdenPedidosEvaluadores findByOrdenPedidoAndUsuario(OrdenPedido ordenPedido, Usuario usuario);
}