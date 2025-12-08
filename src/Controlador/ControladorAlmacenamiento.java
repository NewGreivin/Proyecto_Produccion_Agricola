package Controlador;

import Modelo.Dtos.AlmacenamientoDTO;
import Modelo.Facade.ServicioFacade;
import Modelo.Objetos.Cultivos.Cultivo;
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
    
    public List<AlmacenamientoDTO> buscarPorProducto(String nombre) throws Exception {
            return serviciofacade.getServicioAlmacenamiento().buscarPorProducto(nombre);
    }
    
    public List<AlmacenamientoDTO> buscarPorFechaIngreso(LocalDate fecha) throws Exception {
            return serviciofacade.getServicioAlmacenamiento().buscarPorFechaIngreso(fecha);
    }
    
    public List<AlmacenamientoDTO> productoVencidos() throws Exception {
            return serviciofacade.getServicioAlmacenamiento().buscarPorProductosVencidos();
    }
    
    public List<AlmacenamientoDTO> productosSinSalida() throws Exception {
            return serviciofacade.getServicioAlmacenamiento().productosSinSalida();
    }
    
    public boolean crear(Cultivo producto, double cantidad, LocalDate fechaIngreso, LocalDate fechaSalida) throws Exception {
            serviciofacade.getServicioAlmacenamiento().crear(producto, cantidad, fechaIngreso, fechaSalida);
            return true;
    }
    
    public List<AlmacenamientoDTO> listar() throws Exception {
            return serviciofacade.getServicioAlmacenamiento().listar();
    }
    
    public boolean actualizar(int id, LocalDate fechaSalida) throws Exception {
            serviciofacade.getServicioAlmacenamiento().actualizar(id, fechaSalida);
            return true;
    }
    
    public boolean eliminar(int id) throws Exception {
            serviciofacade.getServicioAlmacenamiento().eliminar(id);
            return true;
    }
}
