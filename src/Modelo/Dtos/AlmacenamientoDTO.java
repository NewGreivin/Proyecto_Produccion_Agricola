package Modelo.Dtos;

import java.time.LocalDate;

/**
 *
 * @author Ricardo Chaves
 */

public class AlmacenamientoDTO {
    private final Integer id;
    private final String producto;
    private final double cantidad;
    private final LocalDate fechaIngreso;
    private final LocalDate fechaSalida;

    public Integer getId() {
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

    public AlmacenamientoDTO(Integer id, String producto, double cantidad, LocalDate fechaIngreso, LocalDate fechaSalida) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }
}
