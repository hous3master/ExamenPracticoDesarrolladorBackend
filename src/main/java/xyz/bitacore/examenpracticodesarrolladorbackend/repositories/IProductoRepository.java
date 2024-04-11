package xyz.bitacore.examenpracticodesarrolladorbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Producto;
import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> { }