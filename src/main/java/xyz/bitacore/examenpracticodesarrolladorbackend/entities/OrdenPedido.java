package xyz.bitacore.examenpracticodesarrolladorbackend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "OrdenPedido")
public class OrdenPedido {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idOrdenPedido;

@Column(name = "codigo")
private String codigo;

@Column(name = "diasCredito")
private int diasCredito;

@Column(name = "observaciones")
private String observaciones;

@Column(name = "fechaEmision")
private LocalDate fechaEmision;

@Column(name = "totalGravado")
private double totalGravado;

@Column(name = "totalIGV")
private double totalIGV;

@Column(name = "total")
private double total;

@Column(name = "fechaVencimiento")
private LocalDate fechaVencimiento;

@ManyToOne
@JoinColumn(name = "idVendedor")
private Vendedor vendedor;

@ManyToOne
@JoinColumn(name = "idFormaPago")
private FormaPago formaPago;

@ManyToOne
@JoinColumn(name = "idSucursal")
private Sucursal sucursal;

@ManyToOne
@JoinColumn(name = "idEstadoPedido")
private EstadoPedido estadoPedido;

@ManyToOne
@JoinColumn(name = "idCliente")
private Cliente cliente;

public OrdenPedido() { }

public OrdenPedido(int idOrdenPedido,String codigo, int diasCredito, String observaciones, LocalDate fechaEmision, double totalGravado, double totalIGV, double total, LocalDate fechaVencimiento, Vendedor vendedor, FormaPago formaPago, Sucursal sucursal, EstadoPedido estadoPedido, Cliente cliente) {
    this.idOrdenPedido = idOrdenPedido;
    this.codigo = codigo;
    this.diasCredito = diasCredito;
    this.observaciones = observaciones;
    this.fechaEmision = fechaEmision;
    this.totalGravado = totalGravado;
    this.totalIGV = totalIGV;
    this.total = total;
    this.fechaVencimiento = fechaVencimiento;
    this.vendedor = vendedor;
    this.formaPago = formaPago;
    this.sucursal = sucursal;
    this.estadoPedido = estadoPedido;
    this.cliente = cliente;
}

    public int getIdOrdenPedido() {
        return idOrdenPedido;
    }

    public void setIdOrdenPedido(int idOrdenPedido) {
        this.idOrdenPedido = idOrdenPedido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getDiasCredito() {
        return diasCredito;
    }

    public void setDiasCredito(int diasCredito) {
        this.diasCredito = diasCredito;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getTotalGravado() {
        return totalGravado;
    }

    public void setTotalGravado(double totalGravado) {
        this.totalGravado = totalGravado;
    }

    public double getTotalIGV() {
        return totalIGV;
    }

    public void setTotalIGV(double totalIGV) {
        this.totalIGV = totalIGV;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}