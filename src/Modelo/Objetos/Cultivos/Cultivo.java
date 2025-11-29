package Modelo.Objetos.Cultivos;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author MARISOL
 */

public class Cultivo {
    private String id;                    
    private String nombre;
    private TipoCultivo tipo;
    private double areaSembrada;
    private EstadoCrecimiento estado;
    private LocalDate fechaSiembra;
    private LocalDate fechaEstimCosecha;

    public Cultivo(String id,String nombre,TipoCultivo tipo,double areaSembrada,EstadoCrecimiento estado,LocalDate fechaSiembra,LocalDate fechaEstimCosecha) {
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

    public void setId(String id)throws Exception {
        if (id == null || id.isBlank()) {
            throw new Exception("El ID del cultivo no puede estar vacio");
        }
        this.id = id.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre)throws Exception {
        if (nombre == null || nombre.isBlank()) {
            throw new Exception("El nombre del cultivo es obligatorio");
        }
        this.nombre = nombre.trim();
    }

    public TipoCultivo getTipo() {
        return tipo;
    }

    public void setTipo(TipoCultivo tipo)throws Exception {
        if (tipo == null) {
            throw new Exception("El tipo de cultivo es obligatorio");
        }
        this.tipo = tipo;
    }

    public double getAreaSembrada() {
        return areaSembrada;
    }

    public void setAreaSembrada(double areaSembrada)throws Exception {
        if (areaSembrada <= 0) {
            throw new Exception("El area sembrada debe ser mayor a 0");
        }
        this.areaSembrada = areaSembrada;
    }

    public EstadoCrecimiento getEstado() {
        return estado;
    }

    public void setEstado(EstadoCrecimiento estado)throws Exception {
        if (estado == null) {
            throw new Exception("El estado de crecimiento es obligatorio");
        }
        this.estado = estado;
    }

    public LocalDate getFechaSiembra() {
        return fechaSiembra;
    }

    public void setFechaSiembra(LocalDate fechaSiembra)throws Exception {
        if (fechaSiembra == null) {
            throw new Exception("La fecha de siembra es obligatoria");
        }
        this.fechaSiembra = fechaSiembra;
    }

    public LocalDate getFechaEstimCosecha() {
        return fechaEstimCosecha;
    }

    public void setFechaEstimCosecha(LocalDate fechaEstimCosecha)throws Exception {
        if (fechaEstimCosecha != null && fechaSiembra != null && fechaEstimCosecha.isBefore(fechaSiembra)) {
            throw new Exception("La fecha de cosecha no puede ser anterior a la de siembra");
        }
        this.fechaEstimCosecha = fechaEstimCosecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Cultivo)) 
            return false;
        Cultivo cultivo = (Cultivo) o;
        return Objects.equals(id, cultivo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
