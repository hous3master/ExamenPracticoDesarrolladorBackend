package xyz.bitacore.examenpracticodesarrolladorbackend.dtos;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.*;
import java.time.LocalDate;

public class UsuarioDTO {
    private int idUsuario;
    private String nombreCompleto;

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