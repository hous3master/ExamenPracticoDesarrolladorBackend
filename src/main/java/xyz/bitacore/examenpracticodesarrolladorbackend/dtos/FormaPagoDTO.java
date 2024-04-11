package xyz.bitacore.examenpracticodesarrolladorbackend.dtos;

public class FormaPagoDTO {
    private int idFormaPago;
    private String descripcion;

    public int getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(int idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}