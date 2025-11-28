package Modelo.Dtos;

import java.time.LocalDate;

/**
 *
 * @author Ricardo Chaves
 */

public class AlmacenamientoDTO {
    private int id;
    private String producto;
    private double cantidad;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;

    public int getId() {
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

    public AlmacenamientoDTO(int id, String producto, double cantidad, LocalDate fechaIngreso, LocalDate fechaSalida) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }
}
