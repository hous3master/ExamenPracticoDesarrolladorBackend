package xyz.bitacore.examenpracticodesarrolladorbackend.entities;

import jakarta.persistence.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.*;
import java.time.LocalDate;

@Entity
@Table(name = "Vendedor")
public class Vendedor {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idVendedor;

@Column(name = "nombreCompleto", nullable = false)
private String nombreCompleto;

public Vendedor() { }

public Vendedor(int idVendedor,String nombreCompleto) {
    this.idVendedor = idVendedor;
    this.nombreCompleto = nombreCompleto;
}

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