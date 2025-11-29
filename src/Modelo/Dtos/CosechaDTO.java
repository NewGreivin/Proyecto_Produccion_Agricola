package Modelo.Dtos;

import Modelo.Objetos.Cosechas.CalidadCosecha;
import Modelo.Objetos.Cosechas.DestinoCosecha;
import Modelo.Objetos.Cultivos.Cultivo;
import java.time.LocalDate;

/**
 *
 * @author Greivin
 */

public class CosechaDTO {
    private final String id; //Se genera de forma Autocremental en DB
    private final LocalDate fecha;
    private final double cantidadRecolectada;
    private final CalidadCosecha calidad;
    private final DestinoCosecha destino;
    private final Cultivo idCultivo;

    public String getId() { return id; }
    public LocalDate getFecha() { return fecha; }
    public double getCantidadRecolectada() { return cantidadRecolectada; }
    public CalidadCosecha getCalidad() { return calidad; }
    public DestinoCosecha getDestino() { return destino; }
    public Cultivo getIdCultivo() { return idCultivo; }

    public CosechaDTO(String id, LocalDate fecha, double cantidadRecolectada, CalidadCosecha calidad, DestinoCosecha destino, Cultivo idCultivo) {
        this.id = id;
        this.fecha = fecha;
        this.cantidadRecolectada = cantidadRecolectada;
        this.calidad = calidad;
        this.destino = destino;
        this.idCultivo = idCultivo;
    }
}