package Modelo.Objetos.Cosechas;

import Modelo.Objetos.Cultivos.Cultivo;
import java.time.LocalDate;

/**
 * @author Greivin
 */

public class Cosecha {
    private int id; //Se genera de forma Autocremental en DB
    private LocalDate fecha;
    private double cantidadRecolectada;
    private CalidadCosecha calidad;
    private DestinoCosecha destino;
    private Cultivo idCultivo;
    private double porcentajeProductividad; //NO se almacena en la DB

    public int getId() { return id; }
    public LocalDate getFecha() { return fecha; }
    public double getCantidadRecolectada() { return cantidadRecolectada; }
    public CalidadCosecha getCalidad() { return calidad; }
    public DestinoCosecha getDestino() { return destino; }
    public Cultivo getIdCultivo() { return idCultivo; }
    public double getPorcentajeProductividad() { return porcentajeProductividad; }

    public void setCalidad(CalidadCosecha calidad) { this.calidad = calidad; }
    public void setDestino(DestinoCosecha destino) { this.destino = destino; }
    
    public Cosecha(LocalDate fecha, double cantidadRecolectada, CalidadCosecha calidad, DestinoCosecha destino, Cultivo idCultivo) {
        this.fecha = fecha;
        this.cantidadRecolectada = cantidadRecolectada;
        this.calidad = calidad;
        this.destino = destino;
        this.idCultivo = idCultivo;
    }
}