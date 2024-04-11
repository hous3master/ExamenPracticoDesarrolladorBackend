package xyz.bitacore.examenpracticodesarrolladorbackend.dtos;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.*;
import java.time.LocalDate;

public class VendedorDTO {
    private int idVendedor;
    private String nombreCompleto;

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombrecompleto() {
        return nombreCompleto;
    }

    public void setNombrecompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

}