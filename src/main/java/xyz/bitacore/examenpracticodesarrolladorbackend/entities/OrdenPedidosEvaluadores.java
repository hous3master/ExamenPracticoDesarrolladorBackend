package xyz.bitacore.examenpracticodesarrolladorbackend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "OrdenPedidosEvaluadores")
public class OrdenPedidosEvaluadores {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idOrdenPedidosEvaluadores;

@Column(name = "fechaEvaluacion", nullable = false)
private LocalDate fechaEvaluacion;

@Column(name = "comentarios", nullable = false)
private String comentarios;

@Column(name = "resultado", nullable = false)
private String resultado;

@ManyToOne
@JoinColumn(name = "idOrdenPedido")
private OrdenPedido ordenPedido;

@ManyToOne
@JoinColumn(name = "idUsuario")
private Usuario usuario;

public OrdenPedidosEvaluadores() { }

public OrdenPedidosEvaluadores(int idOrdenPedidosEvaluadores,LocalDate fechaEvaluacion, String comentarios, String resultado, OrdenPedido ordenPedido, Usuario usuario) {
    this.idOrdenPedidosEvaluadores = idOrdenPedidosEvaluadores;
    this.fechaEvaluacion = fechaEvaluacion;
    this.comentarios = comentarios;
    this.resultado = resultado;
    this.ordenPedido = ordenPedido;
    this.usuario = usuario;
}

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