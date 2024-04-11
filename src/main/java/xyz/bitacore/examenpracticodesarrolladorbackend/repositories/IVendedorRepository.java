package xyz.bitacore.examenpracticodesarrolladorbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Vendedor;
import java.util.List;

@Repository
public interface IVendedorRepository extends JpaRepository<Vendedor, Integer> { }