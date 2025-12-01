package Modelo.Interfaces;

import Modelo.Dtos.TrabajadorDTO;
import java.util.List;

/**
 *
 * @author MARISOL
 */

public interface ITrabajadorDAO extends ICRUD<TrabajadorDTO> {
    TrabajadorDTO buscarPorCedula(String cedula);
    boolean existeCedula(String cedula);
    List<TrabajadorDTO> buscarPorNombre(String nombre);
    List<TrabajadorDTO> buscarPorPuesto(String puesto);
}
