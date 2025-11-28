package Modelo.Objetos.Almacenamientos;

import java.time.LocalDate;

/**
 *
 * @author Ricardo Chaves
 */

public class Almacenamiento {
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

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    
    //Actualizar cuando sea necesario.
    public boolean llevaMuchoTiempo(){
        return true;
    }

    public Almacenamiento(int id, String producto, double cantidad, LocalDate fechaIngreso, LocalDate fechaSalida) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }
}
