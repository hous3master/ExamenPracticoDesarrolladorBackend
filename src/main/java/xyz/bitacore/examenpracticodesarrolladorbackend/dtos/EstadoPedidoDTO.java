package xyz.bitacore.examenpracticodesarrolladorbackend.dtos;

public class EstadoPedidoDTO {
    private int idEstadoPedido;
    private String descripcion;

    public int getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(int idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}