package xyz.bitacore.examenpracticodesarrolladorbackend.dtos;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.*;

public class OrdenPedidoItemsDTO {
    private int idOrdenPedidoItems;
    private int cantidad;
    private double precioUnitario;
    private double subTotal;
    private Producto producto;
    private OrdenPedido ordenPedido;

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