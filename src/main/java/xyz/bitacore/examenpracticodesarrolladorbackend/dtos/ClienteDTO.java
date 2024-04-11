package xyz.bitacore.examenpracticodesarrolladorbackend.dtos;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.*;
import java.time.LocalDate;

public class ClienteDTO {
    private int idCliente;
    private String razonSocial;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getRazonsocial() {
        return razonSocial;
    }

    public void setRazonsocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

}