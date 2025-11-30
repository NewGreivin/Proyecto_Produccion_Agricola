package Modelo.Interfaces;

import Modelo.Dtos.CultivoDTO;
import java.util.List;

/**
 *
 * @author MARISOL
 */

public interface ICultivoDAO extends ICRUD<CultivoDTO> {
    List<CultivoDTO> buscarPorTipo(String tipo);
    List<CultivoDTO> buscarPorEstado(String estado);
    List<CultivoDTO> buscarPorNombre(String nombre);
    List<CultivoDTO> buscarPorFechaSiembra(String fecha);
    List<CultivoDTO> cultivosProximosACosechar();
}
