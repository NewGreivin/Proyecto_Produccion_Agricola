package Modelo.Objetos.Usuarios;

/**
 *
 * @author Ricardo Chaves
 */

public class Usuario {
    private String id;   
    private String username; 
    private String passwordHash;
    private Rol rol;
    private int idTrabajador;

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

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario(String id, String username, String passwordHash, Rol rol, int idTrabajador) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.rol = rol;
        this.idTrabajador = idTrabajador;
    }
}
