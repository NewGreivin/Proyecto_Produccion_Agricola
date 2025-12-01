package Modelo.Servicios;

import Modelo.Daos.ProduccionMysqlDAO;
import Modelo.Dtos.ProduccionDTO;
import Modelo.Mappers.ProduccionMapper;
import Modelo.Objetos.Produccion.CalidadProduccion;
import Modelo.Objetos.Produccion.DestinoProduccion;
import Modelo.Objetos.Produccion.Produccion;
import Modelo.Objetos.Cultivos.Cultivo;
import Modelo.Interfaces.IProduccionDAO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Greivin
 */

public class ServicioProduccion {
    private final IProduccionDAO produccionDAO;
    private final ProduccionMapper mapper;
    
    public ServicioProduccion() {
        this.produccionDAO = new ProduccionMysqlDAO();
        this.mapper = new ProduccionMapper();
    }

    public void crear(LocalDate fecha, double cantidadRecolectada, 
                      CalidadProduccion calidad, DestinoProduccion destino, 
                      Cultivo cultivo) throws Exception {
        try {
            if (fecha == null || calidad == null || destino == null || cultivo == null) {
                throw new Exception("Todos los parámetros son requeridos");
            }
            // Crear objeto Produccion con validaciones internas
            Produccion produccion = new Produccion(fecha, cantidadRecolectada, calidad, destino, cultivo);
            
            ProduccionDTO dto = mapper.toDTO(produccion);
            produccionDAO.crear(dto);
        } catch (Exception e) {
            throw new Exception("Error al crear la producción: " + e.getMessage(), e);
        }
    }

    public List<ProduccionDTO> listar() {
        try {
            return produccionDAO.listar();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al listar producciones: " + e.getMessage(), e);
        }
    }

    public List<ProduccionDTO> buscarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        try {
            if (fechaInicio == null || fechaFin == null) {
                throw new Exception("Las fechas no pueden ser nulas");
            }
            if (fechaInicio.isAfter(fechaFin)) {
                throw new Exception("La fecha de inicio no puede ser posterior a la fecha final");
            }
            return produccionDAO.buscarPorRangoFecha(fechaInicio, fechaFin);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al buscar por rango de fecha: " + e.getMessage(), e);
        }
    }

    public List<ProduccionDTO> buscarPorCultivo(String idCultivo) {
        try {
            if (idCultivo == null || idCultivo.trim().isEmpty()) {
                throw new Exception("El ID del cultivo no puede estar vacío");
            }
            return produccionDAO.buscarPorCultivo(idCultivo);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al buscar por cultivo: " + e.getMessage(), e);
        }
    }

    public List<ProduccionDTO> buscarPorDestino(DestinoProduccion destino) {
        try {
            if (destino == null) {
                throw new Exception("El destino no puede ser nulo");
            }
            return produccionDAO.buscarPorDestino(destino.name());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al buscar por destino: " + e.getMessage(), e);
        }
    }

    public List<ProduccionDTO> buscarPorFecha(LocalDate fecha) {
        try {
            if (fecha == null) {
                throw new Exception("La fecha no puede ser nula");
            }
            return produccionDAO.buscarPorFecha(fecha.toString());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al buscar por fecha: " + e.getMessage(), e);
        }
    }

    public List<ProduccionDTO> buscarPorCalidad(CalidadProduccion calidad) {
        try {
            if (calidad == null) {
                throw new Exception("La calidad no puede ser nula");
            }
            return produccionDAO.buscarPorCalidad(calidad.name());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al buscar por calidad: " + e.getMessage(), e);
        }
    }
    
    public void actualizar(String id, LocalDate fecha, double cantidadRecolectada,
                          CalidadProduccion calidad, DestinoProduccion destino,
                          Cultivo cultivo) throws Exception {
        try {
            if (id == null || id.trim().isEmpty()) {
                throw new Exception("El ID de la producción no puede estar vacío");
            }
            
            // Crear nuevo objeto Produccion con validaciones
            Produccion produccion = new Produccion(id, fecha, cantidadRecolectada, calidad, destino, cultivo);
            
            ProduccionDTO dto = mapper.toDTO(produccion);
            produccionDAO.actualizar(dto);
        } catch (Exception e) {
            throw new Exception("Error al actualizar la producción: " + e.getMessage(), e);
        }
    }

    public void eliminar(String id) throws Exception {
        try {
            if (id == null || id.trim().isEmpty()) {
                throw new Exception("El ID de la producción no puede estar vacío");
            }
            produccionDAO.eliminar(id);
        } catch (Exception e) {
            throw new Exception("Error al eliminar la producción: " + e.getMessage(), e);
        }
    }
    
    public double calcularProductividad(ProduccionDTO produccionDTO) throws Exception {
        try {
            Produccion produccion = mapper.toEntity(produccionDTO);
            return produccion.calcularPorcentajeProductividad();
        } catch (Exception e) {
            throw new Exception("Error al calcular productividad: " + e.getMessage(), e);
        }
    }
}