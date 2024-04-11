package xyz.bitacore.examenpracticodesarrolladorbackend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "OrdenPedidoItems")
public class OrdenPedidoItems {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idOrdenPedidoItems;

@Column(name = "cantidad", nullable = false)
private int cantidad;

@Column(name = "precioUnitario", nullable = false)
private double precioUnitario;

@Column(name = "subTotal", nullable = false)
private double subTotal;

@ManyToOne
@JoinColumn(name = "idProducto")
private Producto producto;

public OrdenPedidoItems() { }

public OrdenPedidoItems(int idOrdenPedidoItems,int cantidad, double precioUnitario, double subTotal, Producto producto) {
    this.idOrdenPedidoItems = idOrdenPedidoItems;
    this.cantidad = cantidad;
    this.precioUnitario = precioUnitario;
    this.subTotal = subTotal;
    this.producto = producto;
}

public int getIdOrdenPedidoItems() {
    return idOrdenPedidoItems;
}

public void setIdOrdenPedidoItems(int idOrdenPedidoItems) {
    this.idOrdenPedidoItems = idOrdenPedidoItems;
}

public int getCantidad() {
    return cantidad;
}

public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
}

public double getPreciounitario() {
    return precioUnitario;
}

public void setPreciounitario(double precioUnitario) {
    this.precioUnitario = precioUnitario;
}

public double getSubtotal() {
    return subTotal;
}

public void setSubtotal(double subTotal) {
    this.subTotal = subTotal;
}

public Producto getProducto() {
    return producto;
}

public void setProducto(Producto producto) {
    this.producto = producto;
}

}