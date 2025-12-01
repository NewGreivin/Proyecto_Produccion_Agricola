package Modelo.Strategy;

import Modelo.Objetos.Cultivos.Cultivo;
import java.util.List;

/**
 * @author Greivin
 */

public interface IFiltroCultivoStrategy {
    List<Cultivo> filtrar(List<Cultivo> cultivos);
}
