package xyz.bitacore.examenpracticodesarrolladorbackend.serviceimplements;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Usuario;
import xyz.bitacore.examenpracticodesarrolladorbackend.repositories.IUsuarioRepository;
import xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository myRepository;

    // ======= CRUD =======
    // Crear
    @Override
    public void insert(Usuario Usuario) {
        myRepository.save(Usuario);
    }

    // Eliminar por ID
    @Override
    public void delete(int idUsuario){
        myRepository.deleteById(idUsuario);
    }

    // Leer por ID
    @Override
    public Usuario listId(int idUsuario){
        return myRepository.findById(idUsuario).orElse(new Usuario());
    }

    // Leer toda la tabla
    @Override
    public List<Usuario> list() {
        return myRepository.findAll();
    }
}