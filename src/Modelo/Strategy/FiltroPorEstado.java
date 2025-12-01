package Modelo.Strategy;

import Modelo.Objetos.Cultivos.Cultivo;
import Modelo.Objetos.Cultivos.EstadoCrecimiento;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Greivin
 */
public class FiltroPorEstado implements IFiltroCultivoStrategy {
    private EstadoCrecimiento estado;

    public FiltroPorEstado(EstadoCrecimiento estado) { this.estado = estado; }

    @Override
    public List<Cultivo> filtrar(List<Cultivo> cultivos) {
        List<Cultivo> resultado = new ArrayList<>();

        for (int i = 0; i < cultivos.size(); i++) {
            Cultivo cultivo = cultivos.get(i);
            if (cultivo.getEstado() == estado) {
                resultado.add(cultivo);
            }
        }

        return resultado;
    }
}
