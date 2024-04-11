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

    // Add an item to table
    @Override
    public void insert(Usuario Usuario) {
        myRepository.save(Usuario);
    }

    // Delete an item by ID on table
    @Override
    public void delete(int idUsuario){
        myRepository.deleteById(idUsuario);
    }

    // Retrieve an items by ID from table
    @Override
    public Usuario listId(int idUsuario){
        return myRepository.findById(idUsuario).orElse(new Usuario());
    }

    // Retrieve all items from table
    @Override
    public List<Usuario> list() {
        return myRepository.findAll();
    }
}