package xyz.bitacore.examenpracticodesarrolladorbackend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "EstadoPedido")
public class EstadoPedido {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idEstadoPedido;

@Column(name = "descripcion", nullable = false)
private String descripcion;

public EstadoPedido() { }

public EstadoPedido(int idEstadoPedido, String descripcion) {
    this.idEstadoPedido = idEstadoPedido;
    this.descripcion = descripcion;
}

public int getIdEstadoPedido() {
    return idEstadoPedido;
}

public void setIdEstadoPedido(int idEstadoPedido) {
    this.idEstadoPedido = idEstadoPedido;
}

public String getDescripcion() {
    return descripcion;
}

public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

}