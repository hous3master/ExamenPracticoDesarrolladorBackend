package xyz.bitacore.examenpracticodesarrolladorbackend.dtos;

import xyz.bitacore.examenpracticodesarrolladorbackend.entities.*;
import java.time.LocalDate;

public class OrdenPedidosEvaluadoresDTO {
    private int idOrdenPedidosEvaluadores;
    private LocalDate fechaEvaluacion;
    private String comentarios;
    private String resultado;
    private OrdenPedido ordenPedido;
    private Usuario usuario;

    public int getIdOrdenPedidosEvaluadores() {
        return idOrdenPedidosEvaluadores;
    }

    public void setIdOrdenPedidosEvaluadores(int idOrdenPedidosEvaluadores) {
        this.idOrdenPedidosEvaluadores = idOrdenPedidosEvaluadores;
    }

    public LocalDate getFechaevaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaevaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public OrdenPedido getOrdenPedido() {
        return ordenPedido;
    }

    public void setOrdenPedido(OrdenPedido ordenPedido) {
        this.ordenPedido = ordenPedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}