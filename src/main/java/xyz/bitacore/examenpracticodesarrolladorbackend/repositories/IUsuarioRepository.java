package xyz.bitacore.examenpracticodesarrolladorbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Usuario;
import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> { }