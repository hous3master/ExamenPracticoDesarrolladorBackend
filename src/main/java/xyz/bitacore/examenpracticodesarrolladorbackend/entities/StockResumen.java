package xyz.bitacore.examenpracticodesarrolladorbackend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "StockResumen")
public class StockResumen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStockResumen;

    @Column(name = "cantidadDisponible")
    private int cantidadDisponible;

    @Column(name = "cantidadEnPedido")
    private int cantidadEnPedido;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idSucursal")
    private Sucursal sucursal;

    public StockResumen() { }

    public StockResumen(int idStockResumen,int cantidadDisponible, int cantidadEnPedido, Producto producto, Sucursal sucursal) {
        this.idStockResumen = idStockResumen;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadEnPedido = cantidadEnPedido;
        this.producto = producto;
        this.sucursal = sucursal;
    }

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