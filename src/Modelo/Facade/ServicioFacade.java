package Modelo.Facade;

import Modelo.Servicios.ServicioAlmacenamiento;
import Modelo.Servicios.ServicioCultivo;
import Modelo.Servicios.ServicioProduccion;
import Modelo.Servicios.ServicioTrabajador;

/**
 * @author Greivin
 */

public class ServicioFacade {
    private static ServicioFacade instancia;
    
    private final ServicioAlmacenamiento servicioAlmacenamiento;
    private final ServicioCultivo servicioCultivo;
    private final ServicioProduccion servicioProduccion;
    private final ServicioTrabajador servicioTrabajador;
    //private final ServicioUsuario servicioUsuario;

    public ServicioAlmacenamiento getServicioAlmacenamiento() { return servicioAlmacenamiento; }
    public ServicioCultivo getServicioCultivo() { return servicioCultivo; }
    public ServicioProduccion getServicioProduccion() { return servicioProduccion; }
    public ServicioTrabajador getServicioTrabajador() { return servicioTrabajador; }
    //public ServicioUsuario getServicioUsuario() { return servicioUsuario; }

    public ServicioFacade() {
        this.servicioAlmacenamiento = new ServicioAlmacenamiento();
        this.servicioCultivo = new ServicioCultivo();
        this.servicioProduccion = new ServicioProduccion();
        this.servicioTrabajador = new ServicioTrabajador();
        //this.servicioUsuario = new ServicioUsuario();
    }

    public static ServicioFacade getInstancia() {
        if (instancia == null) {
            instancia = new ServicioFacade();
        }
        return instancia;
    }
}
