package Modelo.Dtos;

import Modelo.Objetos.Cultivos.Cultivo;
import java.time.LocalDate;

/**
 *
 * @author Ricardo Chaves
 */

public class AlmacenamientoDTO {
    private final Integer id;
    private final Cultivo cultivo;
    private final double cantidad;
    private final LocalDate fechaIngreso;
    private final LocalDate fechaSalida;

    public Integer getId() {
        return id;
    }

    public Cultivo getCultivo() {
        return cultivo;
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

    public AlmacenamientoDTO(Integer id, Cultivo cultivo, double cantidad, LocalDate fechaIngreso, LocalDate fechaSalida) {
        this.id = id;
        this.cultivo = cultivo;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }
}
