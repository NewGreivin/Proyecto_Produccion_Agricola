package Modelo.Dtos;

import Modelo.Objetos.Cultivos.EstadoCrecimiento;
import Modelo.Objetos.Cultivos.TipoCultivo;
import java.time.LocalDate;

/**
 *
 * @author MARISOL
 */

public class CultivoDTO {
    private final Integer id;
    private final String nombre;
    private final TipoCultivo tipo;
    private final double areaSembrada;
    private final EstadoCrecimiento estado;
    private final LocalDate fechaSiembra;
    private final LocalDate fechaEstimCosecha;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoCultivo getTipo() {
        return tipo;
    }

    public double getAreaSembrada() {
        return areaSembrada;
    }

    public EstadoCrecimiento getEstado() {
        return estado;
    }

    public LocalDate getFechaSiembra() {
        return fechaSiembra;
    }

    public LocalDate getFechaEstimCosecha() {
        return fechaEstimCosecha;
    }
    
    public CultivoDTO(Integer id,String nombre,TipoCultivo tipo,double areaSembrada, EstadoCrecimiento estado,LocalDate fechaSiembra,LocalDate fechaEstimCosecha) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.areaSembrada = areaSembrada;
        this.estado = estado;
        this.fechaSiembra = fechaSiembra;
        this.fechaEstimCosecha = fechaEstimCosecha;
    }

    @Override
    public String toString() {
        return nombre + "(" + id + ")";
    }
}
