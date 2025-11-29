package Modelo.Dtos;

import java.time.LocalDate;

/**
 *
 * @author Ricardo Chaves
 */

public class AlmacenamientoDTO {
    private String id;
    private String producto;
    private double cantidad;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;

    public String getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public AlmacenamientoDTO(String id, String producto, double cantidad, LocalDate fechaIngreso, LocalDate fechaSalida) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }
}
