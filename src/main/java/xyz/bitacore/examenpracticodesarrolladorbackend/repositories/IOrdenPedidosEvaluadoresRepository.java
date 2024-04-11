package xyz.bitacore.examenpracticodesarrolladorbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.OrdenPedidosEvaluadores;

@Repository
public interface IOrdenPedidosEvaluadoresRepository extends JpaRepository<OrdenPedidosEvaluadores, Integer> { }