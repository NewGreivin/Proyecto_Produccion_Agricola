package Modelo.Interfaces;

import Modelo.Objetos.Produccion.Produccion;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Greivin
 */

public interface IProduccionDAO extends ICRUD<Produccion> {
    List<Produccion> buscarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin);
    List<Produccion> buscarPorCultivo(String idCultivo);
    List<Produccion> buscarPorDestino(String destino);
    List<Produccion> buscarPorFecha(String fecha);
    List<Produccion> buscarPorCalidad(String calidad);
}