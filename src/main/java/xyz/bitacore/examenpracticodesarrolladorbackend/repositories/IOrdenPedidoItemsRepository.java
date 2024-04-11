package xyz.bitacore.examenpracticodesarrolladorbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.OrdenPedidoItems;

@Repository
public interface IOrdenPedidoItemsRepository extends JpaRepository<OrdenPedidoItems, Integer> { }