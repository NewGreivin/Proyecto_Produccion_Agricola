package Modelo.Strategy;

import Modelo.Objetos.Cultivos.Cultivo;
import java.util.List;

/**
 * @author Greivin
 */

public class ServicioFiltrosCultivo {
    private IFiltroCultivoStrategy estrategiaActual;

    public IFiltroCultivoStrategy getEstrategiaActual() { return estrategiaActual; }

    public void setEstrategiaActual(IFiltroCultivoStrategy estrategiaActual) {
        this.estrategiaActual = estrategiaActual; }

    public ServicioFiltrosCultivo() {
        this.estrategiaActual = null;
    }

    public ServicioFiltrosCultivo(IFiltroCultivoStrategy estrategiaActual) { this.estrategiaActual = estrategiaActual; }
    
    public List<Cultivo> aplicarFiltro(List<Cultivo> cultivos) {
        if (estrategiaActual == null) {
            throw new IllegalStateException("No hay una Strategy de filtrar establecida");
        }
        return estrategiaActual.filtrar(cultivos);
    }

    public List<Cultivo> filtrar(List<Cultivo> cultivos) {
        return aplicarFiltro(cultivos);
    }
}
