package xyz.bitacore.examenpracticodesarrolladorbackend.entities;

import jakarta.persistence.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.*;
import java.time.LocalDate;

@Entity
@Table(name = "Usuario")
public class Usuario {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idUsuario;

@Column(name = "nombreCompleto")
private String nombreCompleto;

public Usuario() { }

public Usuario(int idUsuario,String nombreCompleto) {
    this.idUsuario = idUsuario;
    this.nombreCompleto = nombreCompleto;
}

public int getIdUsuario() {
    return idUsuario;
}

public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
}

public String getNombrecompleto() {
    return nombreCompleto;
}

public void setNombrecompleto(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
}

}