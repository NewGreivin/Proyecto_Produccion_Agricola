package Modelo.Objetos.Produccion;

import Modelo.Objetos.Cultivos.Cultivo;
import java.time.LocalDate;

/**
 * @author Greivin
 */

public class Produccion {
    private String id; //Se genera de forma Autocremental en DB
    private LocalDate fecha;
    private double cantidadRecolectada;
    private CalidadProduccion calidad;
    private DestinoProduccion destino;
    private Cultivo idCultivo;
    private double porcentajeProductividad; //NO se almacena en la DB

    public String getId() { return id; }
    public LocalDate getFecha() { return fecha; }
    public double getCantidadRecolectada() { return cantidadRecolectada; }
    public CalidadProduccion getCalidad() { return calidad; }
    public DestinoProduccion getDestino() { return destino; }
    public Cultivo getIdCultivo() { return idCultivo; }
    public double getPorcentajeProductividad() { return porcentajeProductividad; }

    public void setCalidad(CalidadProduccion calidad) throws Exception {
        validarDestino(destino);
        this.calidad = calidad; 
    }
    public void setDestino(DestinoProduccion destino) throws Exception {
        validarDestino(destino);
        this.destino = destino; 
    }
    
    public Produccion(LocalDate fecha, double cantidadRecolectada, CalidadProduccion calidad, DestinoProduccion destino, Cultivo idCultivo) throws Exception {
        validarFecha(fecha);
        validarCantidadRecolectada(cantidadRecolectada);
        validarCalidad(calidad);
        validarDestino(destino);
        validarCultivo(idCultivo);
        this.fecha = fecha;
        this.cantidadRecolectada = cantidadRecolectada;
        this.calidad = calidad;
        this.destino = destino;
        this.idCultivo = idCultivo;
        this.porcentajeProductividad = 0.0;
    }

    public Produccion(String id, LocalDate fecha, double cantidadRecolectada, CalidadProduccion calidad, DestinoProduccion destino, Cultivo idCultivo) throws Exception {
        validarFecha(fecha);
        validarCantidadRecolectada(cantidadRecolectada);
        validarCalidad(calidad);
        validarDestino(destino);
        validarCultivo(idCultivo);
        this.id = id;
        this.fecha = fecha;
        this.cantidadRecolectada = cantidadRecolectada;
        this.calidad = calidad;
        this.destino = destino;
        this.idCultivo = idCultivo;
        this.porcentajeProductividad = 0.0;
    }
    
    //  METODOS DE VALIDACION
    private void validarFecha(LocalDate fecha) throws Exception {
        if (fecha == null) {
            throw new Exception("La fecha no puede ser nula");
        }
        if (fecha.isAfter(LocalDate.now())) {
            throw new Exception("La fecha no puede ser futura");
        }
    }
    private void validarCantidadRecolectada(double cantidad) throws Exception {
        if (cantidad <= 0) {
            throw new Exception("La cantidad recolectada debe ser mayor a 0");
        }
    }
    private void validarCalidad(CalidadProduccion calidad) throws Exception {
        if (calidad == null) {
            throw new Exception("La calidad no puede ser nula");
        }
    }
    private void validarDestino(DestinoProduccion destino) throws Exception {
        if (destino == null) {
            throw new Exception("El destino no puede ser nulo");
        }
    }
    private void validarCultivo(Cultivo cultivo) throws Exception {
        if (cultivo == null) {
            throw new Exception("El cultivo no puede ser nulo");
        }
    }

    public double calcularPorcentajeProductividad() throws Exception {
        if (idCultivo == null) {
            throw new Exception("Cultivo no asignado");
        }
        if (cantidadRecolectada <= 0) {
            throw new Exception("Cantidad recolectada inválida");
        }
        if (idCultivo.getAreaSembrada() <= 0) {
            throw new Exception("Área sembrada del cultivo inválida");
        }
        
        double porcentaje = (cantidadRecolectada / idCultivo.getAreaSembrada()) * 100;
        if (porcentaje > 100) {
            porcentaje = 100;
        }
        return porcentaje;
    }
}