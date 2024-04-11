package xyz.bitacore.examenpracticodesarrolladorbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.EstadoPedido;

@Repository
public interface IEstadoPedidoRepository extends JpaRepository<EstadoPedido, Integer> { }