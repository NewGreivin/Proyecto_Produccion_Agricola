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
    
    public UsuarioDTO buscarPorUsername(String username){
        try{
            return serviciofacade.getServicioUsuario().buscarPorUsername(username);
        } catch(Exception e){
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public boolean validarCredenciales(String username, String passwordHash){
        try{
            serviciofacade.getServicioUsuario().validarCredenciales(username, passwordHash);
            return true;
        } catch(Exception e){
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public boolean existeUsername(String username){
        try{
            serviciofacade.getServicioUsuario().existeUsername(username);
            return true;
        } catch(Exception e){
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public List<UsuarioDTO> listarPorRol(String rol) {
        try {
            return serviciofacade.getServicioUsuario().listarPorRol(rol);
        } catch(Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public boolean crear(String id, String username, String passwordHash, Rol rol, Trabajador idTrabajdor) {
        try {
            serviciofacade.getServicioUsuario().crearUsuario(id, username, passwordHash, rol, idTrabajdor);
            return true;
        } catch(Exception e){
            throw new IllegalArgumentException(e.getMessage(), e);
        } 
    }
    
    public List<UsuarioDTO> listar() {
        try {
            return serviciofacade.getServicioUsuario().listar();
        } catch(Exception e){
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public boolean actualizar(String id, String passwordHash, Rol rol){
        try {
            serviciofacade.getServicioUsuario().actualizar(id, passwordHash, rol);
            return true;
        } catch(Exception e){
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
    
    public boolean eliminar(String id) {
        try {
            serviciofacade.getServicioUsuario().eliminar(id);
            return true;
        } catch(Exception e){
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
