package Modelo.Interfaces;

import Modelo.Objetos.Trabajadores.Trabajador;
import java.util.List;

/**
 *
 * @author MARISOL
 */

public interface ITrabajadorDAO extends ICRUD<Trabajador> {
    Trabajador buscarPorCedula(String cedula);
    boolean existeCedula(String cedula);
    List<Trabajador> buscarPorNombre(String nombre);
    List<Trabajador> buscarPorPuesto(String puesto);
}
