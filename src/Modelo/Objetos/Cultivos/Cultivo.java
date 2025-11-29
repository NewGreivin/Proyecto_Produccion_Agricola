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

    public Cultivo(String id,
                   String nombre,
                   TipoCultivo tipo,
                   double areaSembrada,
                   EstadoCrecimiento estado,
                   LocalDate fechaSiembra,
                   LocalDate fechaEstimCosecha) {

        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.areaSembrada = areaSembrada;
        this.estado = estado;
        this.fechaSiembra = fechaSiembra;
        this.fechaEstimCosecha = fechaEstimCosecha;
        validar();
    }

    public String getId() {
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

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(TipoCultivo tipo) {
        this.tipo = tipo;
    }

    public void setAreaSembrada(double areaSembrada) {
        this.areaSembrada = areaSembrada;
    }

    public void setEstado(EstadoCrecimiento estado) {
        this.estado = estado;
    }

    public void setFechaSiembra(LocalDate fechaSiembra) {
        this.fechaSiembra = fechaSiembra;
    }

    public void setFechaEstimCosecha(LocalDate fechaEstimCosecha) {
        this.fechaEstimCosecha = fechaEstimCosecha;
    }
    

    public void validar() {
        setId(this.id);
        setNombre(this.nombre);
        setTipo(this.tipo);
        setAreaSembrada(this.areaSembrada);
        setEstado(this.estado);
        setFechaSiembra(this.fechaSiembra);
        setFechaEstimCosecha(this.fechaEstimCosecha);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cultivo)) return false;
        Cultivo cultivo = (Cultivo) o;
        return Objects.equals(id, cultivo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
