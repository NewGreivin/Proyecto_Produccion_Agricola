package Modelo.Objetos.Produccion;

import Modelo.Objetos.Cultivos.Cultivo;
import java.time.LocalDate;

/**
 * @author Greivin
 */

public class Produccion {
    private int id; //Se genera de forma Autocremental en DB
    private LocalDate fecha;
    private double cantidadRecolectada;
    private CalidadProduccion calidad;
    private DestinoProduccion destino;
    private Cultivo idCultivo;
    private double porcentajeProductividad; //NO se almacena en la DB

    public int getId() { return id; }
    public LocalDate getFecha() { return fecha; }
    public double getCantidadRecolectada() { return cantidadRecolectada; }
    public CalidadProduccion getCalidad() { return calidad; }
    public DestinoProduccion getDestino() { return destino; }
    public Cultivo getIdCultivo() { return idCultivo; }
    public double getPorcentajeProductividad() { return porcentajeProductividad; }

    public void setCalidad(CalidadProduccion calidad) throws Exception {
        validarCalidad(calidad);
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

    public Produccion(int id, LocalDate fecha, double cantidadRecolectada, CalidadProduccion calidad, DestinoProduccion destino, Cultivo idCultivo) throws Exception {
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
        
        // Rendimiento máximo esperado (kg/m²) según tipo de cultivo
        double rendimientoMaximo = obtenerRendimientoMaximo();
        
        // Convertir hectáreas a m² (1 hectárea = 10,000 m²)
        double areaEnMetrosCuadrados = idCultivo.getAreaSembrada() * 10000;
        
        // Cantidad máxima esperada para excelente productividad
        double cantidadMaximaEsperada = areaEnMetrosCuadrados * rendimientoMaximo;
        
        // Calcular porcentaje respecto al máximo esperado
        double porcentaje = (cantidadRecolectada / cantidadMaximaEsperada) * 100;
        
        // Limitar a 100% máximo
        if (porcentaje > 100) {
            porcentaje = 100;
        }
        
        // Redondear a 2 decimales
        porcentaje = Math.round(porcentaje * 100.0) / 100.0;
        
        return porcentaje;
    }
    
    /**
     * Obtiene el rendimiento máximo esperado según el tipo de cultivo (kg/m²)
     */
    private double obtenerRendimientoMaximo() {
        if (idCultivo == null || idCultivo.getTipo() == null) {
            return 0.5; // Valor por defecto
        }
        
        switch (idCultivo.getTipo()) {
            case VEGETAL:
                return 0.6; // 0.6 kg/m² máximo
            case FRUTAL:
                return 0.4; // 0.4 kg/m² máximo
            case CEREAL:
                return 0.3; // 0.3 kg/m² máximo
            case LEGUMINOSA:
                return 0.25; // 0.25 kg/m² máximo
            case TUBERCULO:
                return 0.8; // 0.8 kg/m² máximo
            case FLOR:
                return 0.5; // 0.5 kg/m² máximo
            case OTRO:
                return 0.4; // 0.4 kg/m² por defecto
            default:
                return 0.4;
        }
    }
}