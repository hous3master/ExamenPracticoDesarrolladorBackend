package xyz.bitacore.examenpracticodesarrolladorbackend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "OrdenPedidoItems")
public class OrdenPedidoItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrdenPedidoItems;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precioUnitario")
    private double precioUnitario;

    @Column(name = "subTotal")
    private double subTotal;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idOrdenPedido")
    private OrdenPedido ordenPedido;

    public OrdenPedidoItems() {
    }

    public OrdenPedidoItems(int idOrdenPedidoItems, int cantidad, double precioUnitario, double subTotal, Producto producto, OrdenPedido ordenPedido) {
        this.idOrdenPedidoItems = idOrdenPedidoItems;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
        this.producto = producto;
        this.ordenPedido = ordenPedido;
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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public OrdenPedido getOrdenPedido() {
        return ordenPedido;
    }

    public void setOrdenPedido(OrdenPedido ordenPedido) {
        this.ordenPedido = ordenPedido;
    }
}