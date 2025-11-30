package Modelo.Interfaces;

import Modelo.Dtos.TrabajadorDTO;
import Modelo.Objetos.Trabajadores.Trabajador;
import java.util.List;

/**
 *
 * @author MARISOL
 */

public interface ITrabajadorDAO extends ICRUD<TrabajadorDTO> {
    Trabajador buscarPorCedula(String cedula);
    boolean existeCedula(String cedula);
    List<Trabajador> buscarPorNombre(String nombre);
    List<Trabajador> buscarPorPuesto(String puesto);
}
