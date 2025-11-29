package Modelo.Objetos.Cultivos;

/**
 *
 * @author MARISOL
 */

public enum TipoCultivo {
    VEGETAL("Vegetal"),
    FRUTAL("Frutal"),
    CEREAL("Cereal"),
    LEGUMINOSA("Leguminosa"),
    TUBERCULO("Tuberculo"),
    FLOR("Flor"),
    OTRO("Otro");

    private final String descripcion;

    TipoCultivo(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
