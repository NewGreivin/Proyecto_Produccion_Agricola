package Modelo.Interfaces;

import Modelo.Dtos.CultivoDTO;
import Modelo.Objetos.Cultivos.Cultivo;
import java.util.List;

/**
 *
 * @author MARISOL
 */

public interface ICultivoDAO extends ICRUD<CultivoDTO> {
    List<Cultivo> buscarPorTipo(String tipo);
    List<Cultivo> buscarPorEstado(String estado);
    List<Cultivo> buscarPorNombre(String nombre);
    List<Cultivo> buscarPorFechaSiembra(String fecha);
    List<Cultivo> cultivosProximosACosechar();
}
