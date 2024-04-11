package xyz.bitacore.examenpracticodesarrolladorbackend.dtos;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.*;
import java.time.LocalDate;

public class OrdenPedidoDTO {
    private int idOrdenPedido;
    private String codigo;
    private int diasCredito;
    private String observaciones;
    private LocalDate fechaEmision;
    private double totalGravado;
    private double totalGV;
    private double total;
    private LocalDate fechaVencimiento;
    private Vendedor vendedor;
    private FormaPago formaPago;
    private Sucursal sucursal;
    private EstadoPedido estadoPedido;
    private Cliente cliente;

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

    public int getDiascredito() {
        return diasCredito;
    }

    public void setDiascredito(int diasCredito) {
        this.diasCredito = diasCredito;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDate getFechaemision() {
        return fechaEmision;
    }

    public void setFechaemision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getTotalgravado() {
        return totalGravado;
    }

    public void setTotalgravado(double totalGravado) {
        this.totalGravado = totalGravado;
    }

    public double getTotalgv() {
        return totalGV;
    }

    public void setTotalgv(double totalGV) {
        this.totalGV = totalGV;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getFechavencimiento() {
        return fechaVencimiento;
    }

    public void setFechavencimiento(LocalDate fechaVencimiento) {
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