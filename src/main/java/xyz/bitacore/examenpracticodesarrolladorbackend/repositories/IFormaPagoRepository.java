package xyz.bitacore.examenpracticodesarrolladorbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.FormaPago;

@Repository
public interface IFormaPagoRepository extends JpaRepository<FormaPago, Integer> { }