package xyz.bitacore.examenpracticodesarrolladorbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.StockResumen;

@Repository
public interface IStockResumenRepository extends JpaRepository<StockResumen, Integer> { }