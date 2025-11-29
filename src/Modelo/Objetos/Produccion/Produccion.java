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

    public void setCalidad(CalidadProduccion calidad) { this.calidad = calidad; }
    public void setDestino(DestinoProduccion destino) { this.destino = destino; }
    
    public Produccion(LocalDate fecha, double cantidadRecolectada, CalidadProduccion calidad, DestinoProduccion destino, Cultivo idCultivo) {
        this.fecha = fecha;
        this.cantidadRecolectada = cantidadRecolectada;
        this.calidad = calidad;
        this.destino = destino;
        this.idCultivo = idCultivo;
    }
}