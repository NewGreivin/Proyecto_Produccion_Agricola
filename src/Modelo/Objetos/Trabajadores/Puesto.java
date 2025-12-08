/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Modelo.Objetos.Trabajadores;

/**
 *
 * @author Ricardo Chaves
 */
public enum Puesto {
    Jornalero ("Jornalero"),         
    Peon_Agricola ("Peon_Agricola"),         
    Operario_Agricola ("Operario_Agricola"),    
    Encargado_Finca ("Encargado_Finca"), 
    Supervisor_Campo ("Supervisor_Campo"),   
    Capataz ("Capataz"),         
    Tractorista ("Tractorista"),        
    Aplicador_Agroquimicos ("Aplicador_Agroquimicos"),     
    Tecnico_Agricola ("Tecnico_Agricola"),      
    Ingeniero_Argonomo ("Ingeniero_Argonomo"),       
    Recolector ("Recolector"),   
    Empacador ("Empacador"),   
    Irrigador ("Irrigador"),   
    Vigilante_Finca ("Vigilante_Finca"),   
    Administrador_Finca ("Administrador_Finca");
    
    private final String Puesto;

    public String getPuesto() {
        return Puesto;
    }

    private Puesto(String Puesto) {
        this.Puesto = Puesto;
    }
}
