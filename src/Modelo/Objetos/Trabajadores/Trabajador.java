package Modelo.Objetos.Trabajadores;

import Utilidades.ValidacionUtil;

/**
 *
 * @author MARISOL
 */

public class Trabajador {
    private static final double salarioMinimo = 350000;
                
    private int cedula;
    private String nombre;
    private String telefono;
    private String correo;
    private String puesto;
    private String horario;
    private double salario;

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono)throws Exception {
        validarTextoObligatorio(telefono, "El telefono es obligatorio");
        if(!ValidacionUtil.TelefonoValido(telefono)){
         throw new Exception("El telefono no tiene formato valido");   
        }
        this.telefono = telefono.trim();
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo)throws Exception {
        validarTextoObligatorio(correo, "El correo es obligatorio");
        if(!ValidacionUtil.CorreoValido(correo)){
         throw new Exception("El correo no tiene formato valido");   
        }
        this.correo = correo.trim();
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto)throws Exception {
        validarTextoObligatorio(puesto, "El puesto es obligatorio");
        this.puesto = puesto.trim();
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario)throws Exception {
        validarTextoObligatorio(horario, "El horario es obligatorio");
        this.horario = horario.trim();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario)throws Exception {
        if (salario < salarioMinimo) {
            throw new Exception("El salario no puede ser menor al salario minimo");
        }
        this.salario = salario;
    }

    public Trabajador(int cedula,String nombre,String telefono,String correo, String puesto,String horario,double salario) throws Exception {
        validarTextoObligatorio(nombre, "El nombre es obligatorio");
        validarCedula(cedula);
        
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.puesto = puesto;
        this.horario = horario;
        this.salario = salario;
    }
    
    private void validarTextoObligatorio(String valor, String mensajeError)throws Exception{
        if(valor == null || valor.isBlank()){
            throw new Exception(mensajeError);
        }
    }
    
    private void validarCedula(int cedula)throws Exception{
        if(cedula <= 0){
            throw new Exception("La cedula debe ser un numero mayor a cero");
        }
    }

    @Override
    public String toString() {
        return nombre + "(" + cedula + ")";
    }
}
