package Modelo.Interfaces;

import Modelo.Dtos.ProduccionDTO;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Greivin
 */

public interface IProduccionDAO extends ICRUD<ProduccionDTO> {
    List<ProduccionDTO> buscarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin);
    List<ProduccionDTO> buscarPorCultivo(String idCultivo);
    List<ProduccionDTO> buscarPorDestino(String destino);
    List<ProduccionDTO> buscarPorFecha(String fecha);
    List<ProduccionDTO> buscarPorCalidad(String calidad);
}