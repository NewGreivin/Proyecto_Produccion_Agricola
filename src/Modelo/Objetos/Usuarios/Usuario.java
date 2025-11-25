package Modelo.Objetos.Usuarios;

import Modelo.Objetos.Trabajadores.Trabajador;

/**
 *
 * @author Ricardo Chaves
 */

public class Usuario {
    private String id;   
    private String username; 
    private String passwordHash;
    private Rol rol;
    private Trabajador idTrabajador;

    public String getId() {
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

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario(String id, String username, String passwordHash, Rol rol, Trabajador idTrabajador) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.rol = rol;
        this.idTrabajador = idTrabajador;
    }
}
