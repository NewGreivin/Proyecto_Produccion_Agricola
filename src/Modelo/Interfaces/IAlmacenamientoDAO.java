package Modelo.Interfaces;

import Modelo.Objetos.Almacenamientos.Almacenamiento;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Ricardo Chaves
 */

public interface IAlmacenamientoDAO extends ICRUD<Almacenamiento> {
    List<Almacenamiento> buscarPorProducto(String nombre);
    List<Almacenamiento> buscarPorFechaIngreso(LocalDate fecha);
    List<Almacenamiento> productoVencidos();
    List<Almacenamiento> productosSinSalida();
}
