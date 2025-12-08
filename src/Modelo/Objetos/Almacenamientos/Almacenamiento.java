package Modelo.Objetos.Almacenamientos;

import Modelo.Objetos.Cultivos.Cultivo;
import java.time.LocalDate;

/**
 *
 * @author Ricardo Chaves
 */

public class Almacenamiento {
    private int id;
    private Cultivo cultivo;
    private double cantidad;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;

    public int getId() {
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

    public void setFechaSalida(LocalDate fechaSalida) {
        if (fechaSalida != null && !fechaSalida.isBefore(fechaIngreso)) {
            this.fechaSalida = fechaSalida;
        } else {
            throw new IllegalArgumentException("Fecha salida no puede ser null ni anterior a la fecha de ingreso");
        }
    }

    public boolean llevaMuchoTiempo(){
        return true;
    }

    public Almacenamiento(int id, Cultivo cultivo, double cantidad, LocalDate fechaIngreso, LocalDate fechaSalida) {
        this.id = id;
        
        if (cultivo != null) {
            this.cultivo = cultivo;
        } else {
            throw new IllegalArgumentException("Cultivo no puede ser null");
        }
        
        if (cantidad > 0) {
            this.cantidad = cantidad;
        } else {
            throw new IllegalArgumentException("Cantidad no puede ser menor a 0");
        }
        
        if (fechaIngreso != null) {
            this.fechaIngreso = fechaIngreso;
        } else {
            throw new IllegalArgumentException("Fecha Ingreso no puede ser null");
        }
        
        if (fechaSalida != null && !fechaSalida.isBefore(fechaIngreso)) {
            this.fechaSalida = fechaSalida;
        } else {
            throw new IllegalArgumentException("Fecha salida no puede ser null ni anterior a la fecha de ingreso");
        }  
    }
    
    public Almacenamiento(Cultivo cultivo, double cantidad, LocalDate fechaIngreso, LocalDate fechaSalida) {
        if (cultivo != null) {
            this.cultivo = cultivo;
        } else {
            throw new IllegalArgumentException("Cultivo no puede ser null");
        }
        
        if (cantidad > 0) {
            this.cantidad = cantidad;
        } else {
            throw new IllegalArgumentException("Cantidad no puede ser menor a 0");
        }
        
        if (fechaIngreso != null) {
            this.fechaIngreso = fechaIngreso;
        } else {
            throw new IllegalArgumentException("Fecha Ingreso no puede ser null");
        }
        
        if (fechaSalida != null && !fechaSalida.isBefore(fechaIngreso)) {
            this.fechaSalida = fechaSalida;
        } else {
            throw new IllegalArgumentException("Fecha salida no puede ser null ni anterior a la fecha de ingreso");
        }  
    }
}
