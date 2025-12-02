package Controlador;

import Modelo.Dtos.AlmacenamientoDTO;
import Modelo.Facade.ServicioFacade;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Ricardo Chaves
 */

public class ControladorAlmacenamiento {
    private final ServicioFacade serviciofacade;

    public ControladorAlmacenamiento() {
        this.serviciofacade = ServicioFacade.getInstancia();
    }
    
    public List<AlmacenamientoDTO> buscarPorProducto(String nombre) {
        try {
            return serviciofacade.getServicioAlmacenamiento().buscarPorProducto(nombre);
        } catch(Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public List<AlmacenamientoDTO> buscarPorFechaIngreso(LocalDate fecha) {
        try {
            return serviciofacade.getServicioAlmacenamiento().buscarPorFechaIngreso(fecha);
        } catch(Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public List<AlmacenamientoDTO> productoVencidos() {
        try {
            return serviciofacade.getServicioAlmacenamiento().buscarPorProductosVencidos();
        } catch(Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public List<AlmacenamientoDTO> productosSinSalida() {
        try {
            return serviciofacade.getServicioAlmacenamiento().productosSinSalida();
        } catch(Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public boolean crear(String id, String producto, double cantidad, LocalDate fechaIngreso, LocalDate fechaSalida) {
        try {
            serviciofacade.getServicioAlmacenamiento().crear(id, producto, cantidad, fechaIngreso, fechaSalida);
            return true;
        } catch(Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public List<AlmacenamientoDTO> listar() {
        try {
            return serviciofacade.getServicioAlmacenamiento().listar();
        } catch(Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public boolean actualizar(String id, LocalDate fechaSalida) {
        try {
            serviciofacade.getServicioAlmacenamiento().actualizar(id, fechaSalida);
            return true;
        } catch(Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public boolean eliminar(String id) {
        try {
            serviciofacade.getServicioAlmacenamiento().eliminar(id);
            return true;
        } catch(Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
