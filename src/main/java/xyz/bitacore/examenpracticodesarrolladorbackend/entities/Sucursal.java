package xyz.bitacore.examenpracticodesarrolladorbackend.entities;

import jakarta.persistence.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.*;
import java.time.LocalDate;

@Entity
@Table(name = "Sucursal")
public class Sucursal {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idSucursal;

@Column(name = "descripcion", nullable = false)
private String descripcion;

public Sucursal() { }

public Sucursal(int idSucursal,String descripcion) {
    this.idSucursal = idSucursal;
    this.descripcion = descripcion;
}

public int getIdSucursal() {
    return idSucursal;
}

public void setIdSucursal(int idSucursal) {
    this.idSucursal = idSucursal;
}

public String getDescripcion() {
    return descripcion;
}

public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

}