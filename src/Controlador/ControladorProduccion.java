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
    
    public boolean crearProduccion(LocalDate fecha, double cantidadRecolectada,CalidadProduccion calidad, 
            DestinoProduccion destino,Cultivo cultivo) {
        try {
            facade.getServicioProduccion().crear(fecha, cantidadRecolectada, calidad, destino, cultivo);
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public List<ProduccionDTO> obtenerTodasLasProducciones() {
        try {
            return facade.getServicioProduccion().listar();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public List<ProduccionDTO> buscarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        try {
            return facade.getServicioProduccion().buscarPorRangoFecha(fechaInicio, fechaFin);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public List<ProduccionDTO> buscarPorCultivo(String idCultivo) {
        try {
            return facade.getServicioProduccion().buscarPorCultivo(idCultivo);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public List<ProduccionDTO> buscarPorDestino(DestinoProduccion destino) {
        try {
            return facade.getServicioProduccion().buscarPorDestino(destino);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public List<ProduccionDTO> buscarPorFecha(LocalDate fecha) {
        try {
            return facade.getServicioProduccion().buscarPorFecha(fecha);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public List<ProduccionDTO> buscarPorCalidad(CalidadProduccion calidad) {
        try {
            return facade.getServicioProduccion().buscarPorCalidad(calidad);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
        public boolean actualizarProduccion(String id, CalidadProduccion calidad, DestinoProduccion destino) {
        try {
            facade.getServicioProduccion().actualizar(id, calidad, destino);
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public boolean eliminarProduccion(String id) {
        try {
            facade.getServicioProduccion().eliminar(id);
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public double calcularProductividad(ProduccionDTO produccionDTO) {
        try {
            return facade.getServicioProduccion().calcularProductividad(produccionDTO);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public String obtenerResumenProduccion(ProduccionDTO produccionDTO) {
        try {
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
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public String obtenerEstadisticas(LocalDate fechaInicio, LocalDate fechaFin) {
        try {
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
                "Estadísticas de %s a %s\n" +
                "Total de producciones: %d\n" +
                "Cantidad total: %.2f\n" +
                "Promedio por producción: %.2f\n" +
                "Extra: %d | Primera: %d | Segunda: %d | Tercera: %d | Industrial: %d | Descarte: %d",
                fechaInicio, fechaFin,
                producciones.size(),
                totalCantidad,
                promedioCantidad,
                cantidadExtra, cantidadPrimera, cantidadSegunda, cantidadTercera, cantidadIndustrial, cantidadDescarte
            );
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}