package Modelo.Dtos;

import Modelo.Objetos.Trabajadores.Trabajador;
import Modelo.Objetos.Usuarios.Rol;

/**
 *
 * @author Ricardo Chaves
 */

public class UsuarioDTO {
    private final Integer id;   
    private final String username; 
    private final String passwordHash;
    private final Rol rol;
    private final Trabajador idTrabajador;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Rol getRol() {
        return rol;
    }

    public Trabajador getIdTrabajador() {
        return idTrabajador;
    }

    public UsuarioDTO(Integer id, String username, String passwordHash, Rol rol, Trabajador idTrabajador) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.rol = rol;
        this.idTrabajador = idTrabajador; 
    }
}
