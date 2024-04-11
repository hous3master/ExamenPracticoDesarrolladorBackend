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

    public int getCantidaddisponible() {
        return cantidadDisponible;
    }

    public void setCantidaddisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getCantidadenpedido() {
        return cantidadEnPedido;
    }

    public void setCantidadenpedido(int cantidadEnPedido) {
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