package Modelo.Objetos.Produccion;

/**
 * @author Greivin
 */
public enum CalidadProduccion {
    EXTRA("Extra"),
    PRIMERA("Primera"),
    SEGUNDA("Segunda"),
    TERCERA("Tercera"),
    INDUSTRIAL("Industrial"),
    DESCARTE("Descarte");
    
    private String calidad;
    public String getCalidad() { return calidad; }
    private CalidadProduccion(String calidad) { this.calidad = calidad; }
}