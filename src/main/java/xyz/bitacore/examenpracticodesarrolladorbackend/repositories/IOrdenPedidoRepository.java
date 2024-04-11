package xyz.bitacore.examenpracticodesarrolladorbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.bitacore.examenpracticodesarrolladorbackend.dtos.OrdenPedidoResumenDTO;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.OrdenPedido;

import java.util.List;

@Repository
public interface IOrdenPedidoRepository extends JpaRepository<OrdenPedido, Integer> {
    // Find if order exists by id
    Boolean existsOrdenPedidoByIdOrdenPedido(Integer idOrdenPedido);

    // Listar los pedidos pendientes de evaluacion (id estado es 2) filtrando por el usuario evaluador
    @Query(value = "SELECT op.codigo, op.fecha_emision, u.nombre_completo, op.total " +
            "FROM orden_pedido AS op " +
            "INNER JOIN orden_pedidos_evaluadores AS ope ON op.id_orden_pedido = ope.id_orden_pedido " +
            "INNER JOIN usuario AS u ON ope.id_usuario = u.id_usuario " +
            "WHERE op.id_estado_pedido = 2 " +
            "AND ope.id_usuario = :idUsuario", nativeQuery = true)
    List<String[]> listarPedidosPendientesEvaluacionPorEvaluador(Integer idUsuario);

}