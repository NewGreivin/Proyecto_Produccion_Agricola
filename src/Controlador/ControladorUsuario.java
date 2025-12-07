package Controlador;

import Modelo.Dtos.UsuarioDTO;
import Modelo.Facade.ServicioFacade;
import Modelo.Objetos.Trabajadores.Trabajador;
import Modelo.Objetos.Usuarios.Rol;
import java.util.List;

/**
 *
 * @author Ricardo Chaves 
 */

public class ControladorUsuario {
    private final ServicioFacade serviciofacade;

    public ControladorUsuario() {
        this.serviciofacade = ServicioFacade.getInstancia();
    }
    
    public UsuarioDTO buscarPorUsername(String username) throws Exception{
            return serviciofacade.getServicioUsuario().buscarPorUsername(username);
    }
    
    public boolean validarCredenciales(String username, String passwordHash) throws Exception{
            return serviciofacade.getServicioUsuario().validarCredenciales(username, passwordHash);
    }
    
    public boolean existeUsername(String username) throws Exception {
            return serviciofacade.getServicioUsuario().existeUsername(username);
    }
    
    public List<UsuarioDTO> listarPorRol(String rol) throws Exception {
            return serviciofacade.getServicioUsuario().listarPorRol(rol);
    }
    
    public boolean crear(String username, String passwordHash, Rol rol, Trabajador idTrabajador) throws Exception {
            serviciofacade.getServicioUsuario().crearUsuario(username, passwordHash, rol, idTrabajador);
            return true; 
    }
    
    public List<UsuarioDTO> listar() throws Exception {
            return serviciofacade.getServicioUsuario().listar();
    }
    
    public boolean actualizar(int id, String passwordHash, Rol rol) throws Exception {
            serviciofacade.getServicioUsuario().actualizar(id, passwordHash, rol);
            return true;
    }
    
    public boolean eliminar(int id) throws Exception {
            serviciofacade.getServicioUsuario().eliminar(id);
            return true;
    }
}
