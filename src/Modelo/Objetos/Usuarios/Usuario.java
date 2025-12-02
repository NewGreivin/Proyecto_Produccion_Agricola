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
        if (passwordHash != null && !passwordHash.isBlank()) {
            this.passwordHash = passwordHash;
        } else {
            throw new IllegalArgumentException("Password no puede ser null");
        }

    }

    public void setRol(Rol rol) {
        if (rol != null) {
            this.rol = rol;
        } else {
            throw new IllegalArgumentException("Rol no puede ser null");
        }

    }

    public Usuario(String id, String username, String passwordHash, Rol rol, Trabajador idTrabajador) {
        if (id != null && !id.isBlank()) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Id no puede ser null");
        }
        
        if (username != null && !username.isBlank()) {
            this.username = username;
        } else {
            throw new IllegalArgumentException("Usuario no puede ser vacio");
        }
        
        if (passwordHash != null && !passwordHash.isBlank()) {
            this.passwordHash = passwordHash;
        } else {
            throw new IllegalArgumentException("Password no puede ser null");
        }
        
        if (rol != null) {
            this.rol = rol;
        } else {
            throw new IllegalArgumentException("Rol no puede ser null");
        }
        
        if (idTrabajador != null) {
            this.idTrabajador = idTrabajador;
        } else {
            throw new IllegalArgumentException("Rol no puede ser null");
        }
    }
    
    public Usuario(String username, String passwordHash, Rol rol, Trabajador idTrabajador) {
        if (username != null && !username.isBlank()) {
            this.username = username;
        } else {
            throw new IllegalArgumentException("Usuario no puede ser vacio");
        }
        
        if (passwordHash != null && !passwordHash.isBlank()) {
            this.passwordHash = passwordHash;
        } else {
            throw new IllegalArgumentException("Password no puede ser null");
        }
        
        if (rol != null) {
            this.rol = rol;
        } else {
            throw new IllegalArgumentException("Rol no puede ser null");
        }
      
        if (idTrabajador != null) {
            this.idTrabajador = idTrabajador;
        } else {
            throw new IllegalArgumentException("Rol no puede ser null");
        }
    }
    
}
