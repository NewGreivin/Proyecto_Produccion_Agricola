package Modelo.Servicios;

import Modelo.Dtos.ProduccionDTO;
import Modelo.Factory.DAOFactory;
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
        this.produccionDAO = DAOFactory.crearProduccionDAO();
        this.mapper = new ProduccionMapper();
    }

    public void crear(LocalDate fecha, double cantidadRecolectada, CalidadProduccion calidad,
            DestinoProduccion destino, Cultivo cultivo) throws Exception {
        Produccion produccion = new Produccion(fecha, cantidadRecolectada, calidad, destino, cultivo);
        ProduccionDTO dto = mapper.toDTO(produccion);
        produccionDAO.crear(dto);
    }

    public List<ProduccionDTO> listar() {
        return produccionDAO.listar();
    }

    public List<ProduccionDTO> buscarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        return produccionDAO.buscarPorRangoFecha(fechaInicio, fechaFin);
    }

    public List<ProduccionDTO> buscarPorCultivo(String idCultivo) {
        return produccionDAO.buscarPorCultivo(idCultivo);
    }

    public List<ProduccionDTO> buscarPorDestino(DestinoProduccion destino) {
        return produccionDAO.buscarPorDestino(destino.name());
    }

    public List<ProduccionDTO> buscarPorFecha(LocalDate fecha) {
        return produccionDAO.buscarPorFecha(fecha.toString());
    }

    public List<ProduccionDTO> buscarPorCalidad(CalidadProduccion calidad) {
        return produccionDAO.buscarPorCalidad(calidad.name());
    }

    public void actualizar(String id, CalidadProduccion calidad, DestinoProduccion destino) throws Exception {
        List<ProduccionDTO> producciones = listar();
        ProduccionDTO produccionExistente = null;
        for (int i = 0; i < producciones.size(); i++) {
            if (producciones.get(i).getId().equals(id)) {
                produccionExistente = producciones.get(i);
                break;
            }
        }
        Produccion produccion = mapper.toEntity(produccionExistente);
        produccion.setCalidad(calidad);
        produccion.setDestino(destino);
        ProduccionDTO dto = mapper.toDTO(produccion);
        produccionDAO.actualizar(dto);
    }

    public void eliminar(String id) throws Exception {
        produccionDAO.eliminar(id);
    }

    public double calcularProductividad(ProduccionDTO produccionDTO) throws Exception {
        Produccion produccion = mapper.toEntity(produccionDTO);
        return produccion.calcularPorcentajeProductividad();
    }
}
