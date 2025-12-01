package Modelo.Strategy;

import Modelo.Objetos.Cultivos.Cultivo;
import Modelo.Objetos.Cultivos.TipoCultivo;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Greivin
 */

public class FiltroPorTipo implements IFiltroCultivoStrategy {
    private TipoCultivo tipo;
    
    public FiltroPorTipo(TipoCultivo tipo) { this.tipo = tipo; }

    @Override
    public List<Cultivo> filtrar(List<Cultivo> cultivos) {
        List<Cultivo> resultado = new ArrayList<>();
        
        for (int i = 0; i < cultivos.size(); i++) {
            Cultivo cultivo = cultivos.get(i);
            if (cultivo.getTipo() == tipo) {
                resultado.add(cultivo);
            }
        }
        
        return resultado;
    }
}
