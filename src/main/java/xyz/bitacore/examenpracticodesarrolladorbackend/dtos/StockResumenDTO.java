package xyz.bitacore.examenpracticodesarrolladorbackend.dtos;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.*;

public class StockResumenDTO {
    private int idStockResumen;
    private int cantidadDisponible;
    private int cantidadEnPedido;
    private Producto producto;
    private Sucursal sucursal;

    public int getIdStockResumen() {
        return idStockResumen;
    }

    public void setIdStockResumen(int idStockResumen) {
        this.idStockResumen = idStockResumen;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getCantidadEnPedido() {
        return cantidadEnPedido;
    }

    public void setCantidadEnPedido(int cantidadEnPedido) {
        this.cantidadEnPedido = cantidadEnPedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}