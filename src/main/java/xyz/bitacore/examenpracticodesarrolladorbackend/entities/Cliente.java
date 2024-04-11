package xyz.bitacore.examenpracticodesarrolladorbackend.entities;

import jakarta.persistence.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.*;
import java.time.LocalDate;

@Entity
@Table(name = "Cliente")
public class Cliente {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idCliente;

@Column(name = "razonSocial", nullable = false)
private String razonSocial;

public Cliente() { }

public Cliente(int idCliente,String razonSocial) {
    this.idCliente = idCliente;
    this.razonSocial = razonSocial;
}

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