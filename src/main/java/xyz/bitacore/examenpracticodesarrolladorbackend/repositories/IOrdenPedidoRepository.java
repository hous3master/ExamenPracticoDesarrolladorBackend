package xyz.bitacore.examenpracticodesarrolladorbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.OrdenPedido;

@Repository
public interface IOrdenPedidoRepository extends JpaRepository<OrdenPedido, Integer> {
    // Find if order exists by id
    Boolean existsOrdenPedidoByIdOrdenPedido(Integer idOrdenPedido);
}