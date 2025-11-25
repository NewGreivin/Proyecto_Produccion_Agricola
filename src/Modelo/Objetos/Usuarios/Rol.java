/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Modelo.Objetos.Usuarios;

/**
 *
 * @author Ricardo Chaves
 */
public enum Rol {
    ADMINISTRADOR("ADMINISTRADOR"),
    TRABAJADOR("TRABAJADOR");

    private String rol;
    
    private Rol(String rol){
        this.rol = rol;
    }
    
    public String getRol(){
        return rol;
    }
    
}
