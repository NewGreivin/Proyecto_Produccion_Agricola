package Modelo.Objetos.Almacenamientos;

import java.time.LocalDate;

/**
 *
 * @author Ricardo Chaves
 */

public class Almacenamiento {
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

    public void setFechaSalida(LocalDate fechaSalida) {
        if (fechaSalida != null && !fechaSalida.isBefore(fechaIngreso)) {
            this.fechaSalida = fechaSalida;
        } else {
            throw new IllegalArgumentException("Fecha salida no puede ser null ni anterior a la fecha de ingreso");
        }
    }
    
    
    //Actualizar cuando sea necesario.
    public boolean llevaMuchoTiempo(){
        return true;
    }

    public Almacenamiento(String id, String producto, double cantidad, LocalDate fechaIngreso, LocalDate fechaSalida) {
        if (id != null && !id.isBlank()) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Id no puede ser null");
        }
        
        if (producto != null && !producto.isBlank()) {
            this.producto = producto;
        } else {
            throw new IllegalArgumentException("Producto no puede ser null");
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
