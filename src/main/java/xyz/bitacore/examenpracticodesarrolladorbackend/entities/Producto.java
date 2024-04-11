package xyz.bitacore.examenpracticodesarrolladorbackend.entities;

import jakarta.persistence.*;
import xyz.bitacore.examenpracticodesarrolladorbackend.entities.*;
import java.time.LocalDate;

@Entity
@Table(name = "Producto")
public class Producto {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idProducto;

@Column(name = "descripcion", nullable = false)
private String descripcion;

public Producto() { }

public Producto(int idProducto,String descripcion) {
    this.idProducto = idProducto;
    this.descripcion = descripcion;
}

public int getIdProducto() {
    return idProducto;
}

public void setIdProducto(int idProducto) {
    this.idProducto = idProducto;
}

public String getDescripcion() {
    return descripcion;
}

public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

}