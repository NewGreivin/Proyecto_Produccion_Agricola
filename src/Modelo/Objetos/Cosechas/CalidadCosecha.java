package Modelo.Objetos.Cosechas;

/**
 * @author Greivin
 */
public enum CalidadCosecha {
    EXTRA("Extra"),
    PRIMERA("Primera"),
    SEGUNDA("Segunda"),
    TERCERA("Tercera"),
    INDUSTRIAL("Industrial"),
    DESCARTE("Descarte");
    
    private String calidad;
    public String getCalidad() { return calidad; }
    private CalidadCosecha(String calidad) { this.calidad = calidad; }
}