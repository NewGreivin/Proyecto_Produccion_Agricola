package Modelo.Objetos.Cosechas;

/**
 * @author Greivin
 */
public enum DestinoCosecha {
    VENTA("Venta"),
    ALMACENAMIENTO("Almacenamiento");
    
    private String destino;
    public String getDestino() { return destino; }
    private DestinoCosecha(String destino) { this.destino = destino;  }
}
