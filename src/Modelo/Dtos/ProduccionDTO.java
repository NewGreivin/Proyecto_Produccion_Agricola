package Modelo.Dtos;

import Modelo.Objetos.Produccion.CalidadProduccion;
import Modelo.Objetos.Produccion.DestinoProduccion;
import Modelo.Objetos.Cultivos.Cultivo;
import java.time.LocalDate;

/**
 *
 * @author Greivin
 */

public class ProduccionDTO {
    private final int id; //Se genera de forma Autocremental en DB
    private final LocalDate fecha;
    private final double cantidadRecolectada;
    private final CalidadProduccion calidad;
    private final DestinoProduccion destino;
    private final Cultivo idCultivo;

    public int getId() { return id; }
    public LocalDate getFecha() { return fecha; }
    public double getCantidadRecolectada() { return cantidadRecolectada; }
    public CalidadProduccion getCalidad() { return calidad; }
    public DestinoProduccion getDestino() { return destino; }
    public Cultivo getIdCultivo() { return idCultivo; }

    public ProduccionDTO(int id, LocalDate fecha, double cantidadRecolectada, CalidadProduccion calidad, DestinoProduccion destino, Cultivo idCultivo) {
        this.id = id;
        this.fecha = fecha;
        this.cantidadRecolectada = cantidadRecolectada;
        this.calidad = calidad;
        this.destino = destino;
        this.idCultivo = idCultivo;
    }
}