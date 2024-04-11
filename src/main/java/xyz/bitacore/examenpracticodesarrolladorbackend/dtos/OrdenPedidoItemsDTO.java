package xyz.bitacore.examenpracticodesarrolladorbackend.dtos;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.*;

public class OrdenPedidoItemsDTO {
    private int idOrdenPedidoItems;
    private int cantidad;
    private double precioUnitario;
    private double subTotal;
    private Producto producto;

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