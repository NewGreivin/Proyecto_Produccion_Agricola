package Modelo.Interfaces;

import Modelo.Dtos.AlmacenamientoDTO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Ricardo Chaves
 */

public interface IAlmacenamientoDAO extends ICRUD<AlmacenamientoDTO> {
    List<AlmacenamientoDTO> buscarPorProducto(String nombre);
    List<AlmacenamientoDTO> buscarPorFechaIngreso(LocalDate fecha);
    List<AlmacenamientoDTO> productoVencidos();
    List<AlmacenamientoDTO> productosSinSalida();
}
