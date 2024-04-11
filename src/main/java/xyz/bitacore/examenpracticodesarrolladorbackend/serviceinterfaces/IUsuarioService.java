package xyz.bitacore.examenpracticodesarrolladorbackend.serviceinterfaces;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.Usuario;
import java.util.List;

public interface IUsuarioService {
    void insert(Usuario Usuario);
    void delete(int id);
    Usuario listId(int id);
    List<Usuario> list();
}