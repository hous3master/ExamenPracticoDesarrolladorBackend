package xyz.bitacore.examenpracticodesarrolladorbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Producto;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.StockResumen;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Sucursal;

@Repository
public interface IStockResumenRepository extends JpaRepository<StockResumen, Integer> {
    // Buscar por idSucursal e idProducto en StockResumen
    StockResumen findStockResumenBySucursalAndProducto(Sucursal sucursal, Producto producto);
}