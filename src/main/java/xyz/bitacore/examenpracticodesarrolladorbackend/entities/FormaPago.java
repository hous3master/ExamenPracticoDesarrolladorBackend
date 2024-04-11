package xyz.bitacore.examenpracticodesarrolladorbackend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "FormaPago")
public class FormaPago {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idFormaPago;

@Column(name = "descripcion")
private String descripcion;

public FormaPago() { }

public FormaPago(int idFormaPago,String descripcion) {
    this.idFormaPago = idFormaPago;
    this.descripcion = descripcion;
}

public int getIdFormaPago() {
    return idFormaPago;
}

public void setIdFormaPago(int idFormaPago) {
    this.idFormaPago = idFormaPago;
}

public String getDescripcion() {
    return descripcion;
}

public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

}