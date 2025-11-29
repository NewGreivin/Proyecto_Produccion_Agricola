package Modelo.Dtos;

import Modelo.Objetos.Cultivos.EstadoCrecimiento;
import Modelo.Objetos.Cultivos.TipoCultivo;
import java.time.LocalDate;

/**
 *
 * @author MARISOL
 */

public class CultivoDTO {
    private String id;
    private String nombre;
    private TipoCultivo tipo;
    private double areaSembrada;
    private EstadoCrecimiento estado;
    private LocalDate fechaSiembra;
    private LocalDate fechaEstimCosecha;

    public CultivoDTO(String id,String nombre,TipoCultivo tipo,double areaSembrada, EstadoCrecimiento estado,LocalDate fechaEstimCosecha) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.areaSembrada = areaSembrada;
        this.estado = estado;
        this.fechaSiembra = fechaSiembra;
        this.fechaEstimCosecha = fechaEstimCosecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoCultivo getTipo() {
        return tipo;
    }

    public void setTipo(TipoCultivo tipo) {
        this.tipo = tipo;
    }

    public double getAreaSembrada() {
        return areaSembrada;
    }

    public void setAreaSembrada(double areaSembrada) {
        this.areaSembrada = areaSembrada;
    }

    public EstadoCrecimiento getEstado() {
        return estado;
    }

    public void setEstado(EstadoCrecimiento estado) {
        this.estado = estado;
    }

    public LocalDate getFechaSiembra() {
        return fechaSiembra;
    }

    public void setFechaSiembra(LocalDate fechaSiembra) {
        this.fechaSiembra = fechaSiembra;
    }

    public LocalDate getFechaEstimCosecha() {
        return fechaEstimCosecha;
    }

    public void setFechaEstimCosecha(LocalDate fechaEstimCosecha) {
        this.fechaEstimCosecha = fechaEstimCosecha;
    }

}
