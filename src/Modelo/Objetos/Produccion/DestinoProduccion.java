package Modelo.Objetos.Produccion;

/**
 * @author Greivin
 */
public enum DestinoProduccion {
    VENTA("Venta"),
    ALMACENAMIENTO("Almacenamiento");
    
    private String destino;
    public String getDestino() { return destino; }
    private DestinoProduccion(String destino) { this.destino = destino;  }
}
