package Modelo.Objetos.Cultivos;

/**
 *
 * @author MARISOL
 */

public enum EstadoCrecimiento {
    SEMBRADO("Sembrado"),
    GERMINACION("Germinacion"),
    CRECIMIENTO("Crecimiento"),
    MADURO("Maduro"),
    COSECHADO("Cosechado");

    private final String descripcion;

    EstadoCrecimiento(String descripcion) {
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
