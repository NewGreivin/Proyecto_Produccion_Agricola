package Controlador;

import Modelo.Dtos.ProduccionDTO;
import Modelo.Facade.ServicioFacade;
import Modelo.Objetos.Produccion.CalidadProduccion;
import Modelo.Objetos.Produccion.DestinoProduccion;
import Modelo.Objetos.Cultivos.Cultivo;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Greivin
 */
public class ControladorProduccion {

    private final ServicioFacade facade;

    public ControladorProduccion() {
        this.facade = ServicioFacade.getInstancia();
    }

    public boolean crearProduccion(LocalDate fecha, double cantidadRecolectada, CalidadProduccion calidad,
            DestinoProduccion destino, Cultivo cultivo) throws Exception {
        facade.getServicioProduccion().crear(fecha, cantidadRecolectada, calidad, destino, cultivo);
        return true;
    }

    public List<ProduccionDTO> obtenerTodasLasProducciones() throws Exception {
        return facade.getServicioProduccion().listar();
    }

    public List<ProduccionDTO> buscarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
        return facade.getServicioProduccion().buscarPorRangoFecha(fechaInicio, fechaFin);
    }

    public List<ProduccionDTO> buscarPorCultivo(String idCultivo) throws Exception {
        return facade.getServicioProduccion().buscarPorCultivo(idCultivo);
    }

    public List<ProduccionDTO> buscarPorDestino(DestinoProduccion destino) throws Exception {
        return facade.getServicioProduccion().buscarPorDestino(destino);
    }

    public List<ProduccionDTO> buscarPorFecha(LocalDate fecha) throws Exception {
        return facade.getServicioProduccion().buscarPorFecha(fecha);
    }

    public List<ProduccionDTO> buscarPorCalidad(CalidadProduccion calidad) throws Exception {
        return facade.getServicioProduccion().buscarPorCalidad(calidad);
    }

    public boolean actualizarProduccion(String id, LocalDate fecha, double cantidad, CalidadProduccion calidad, DestinoProduccion destino) throws Exception {
        facade.getServicioProduccion().actualizar(id, fecha, cantidad, calidad, destino);
        return true;
    }

    public boolean eliminarProduccion(int id) throws Exception {
        facade.getServicioProduccion().eliminar(id);
        return true;
    }

    public double calcularProductividad(ProduccionDTO produccionDTO) throws Exception {
        return facade.getServicioProduccion().calcularProductividad(produccionDTO);
    }

    public String obtenerResumenProduccion(ProduccionDTO produccionDTO) throws Exception {
        if (produccionDTO == null) {
            throw new Exception("Producción no disponible");
        }
        double productividad = calcularProductividad(produccionDTO);
        return String.format(
                "ID: %s | Fecha: %s | Cantidad: %.2f | Calidad: %s | Destino: %s | Productividad: %.2f%%",
                produccionDTO.getId(),
                produccionDTO.getFecha(),
                produccionDTO.getCantidadRecolectada(),
                produccionDTO.getCalidad(),
                produccionDTO.getDestino(),
                productividad
        );
    }

    public String obtenerEstadisticas(LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
        List<ProduccionDTO> producciones = buscarPorRangoFecha(fechaInicio, fechaFin);

        if (producciones.isEmpty()) {
            return "No hay producciones en el rango especificado";
        }
        double totalCantidad = 0;
        int cantidadExtra = 0;
        int cantidadPrimera = 0;
        int cantidadSegunda = 0;
        int cantidadTercera = 0;
        int cantidadIndustrial = 0;
        int cantidadDescarte = 0;

        for (int i = 0; i < producciones.size(); i++) {
            ProduccionDTO produccion = producciones.get(i);
            totalCantidad += produccion.getCantidadRecolectada();

            CalidadProduccion calidad = produccion.getCalidad();
            if (calidad == CalidadProduccion.EXTRA) {
                cantidadExtra++;
            } else if (calidad == CalidadProduccion.PRIMERA) {
                cantidadPrimera++;
            } else if (calidad == CalidadProduccion.SEGUNDA) {
                cantidadSegunda++;
            } else if (calidad == CalidadProduccion.TERCERA) {
                cantidadTercera++;
            } else if (calidad == CalidadProduccion.INDUSTRIAL) {
                cantidadIndustrial++;
            } else if (calidad == CalidadProduccion.DESCARTE) {
                cantidadDescarte++;
            }
        }

        double promedioCantidad = totalCantidad / producciones.size();

        return String.format(
                "Estadísticas de %s a %s\n"
                + "Total de producciones: %d\n"
                + "Cantidad total: %.2f\n"
                + "Promedio por producción: %.2f\n"
                + "Extra: %d | Primera: %d | Segunda: %d | Tercera: %d | Industrial: %d | Descarte: %d",
                fechaInicio, fechaFin,
                producciones.size(),
                totalCantidad,
                promedioCantidad,
                cantidadExtra, cantidadPrimera, cantidadSegunda, cantidadTercera, cantidadIndustrial, cantidadDescarte
        );
    }
}
