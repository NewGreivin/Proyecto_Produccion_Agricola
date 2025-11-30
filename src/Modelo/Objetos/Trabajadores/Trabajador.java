package Modelo.Objetos.Trabajadores;

import Utilidades.ValidacionUtil;
import java.util.Objects;

/**
 *
 * @author MARISOL
 */

public class Trabajador {
    private static final double salarioMinimo = 350000;
                
    private String cedula;
    private String nombre;
    private String telefono;
    private String correo;
    private String puesto;
    private String horario;
    private double salario;

    public String getCedula() {
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

    public Trabajador(String cedula,String nombre,String telefono,String correo, String puesto,String horario,double salario) throws Exception {
        validarTextoObligatorio(cedula, "La cedula es obligatoria");
        validarTextoObligatorio(nombre, "El nombre es obligatorio");
        
        this.cedula = cedula;
        this.nombre = nombre;
        
        setTelefono(telefono);
        setCorreo(correo);
        setPuesto(puesto);
        setHorario(horario);
        setSalario(salario);
    }
    
    public void validar() throws Exception {
        validarTextoObligatorio(this.cedula, "La cédula es obligatoria.");
        validarTextoObligatorio(this.nombre, "El nombre es obligatorio.");
        setTelefono(this.telefono);
        setCorreo(this.correo);
        setPuesto(this.puesto);
        setHorario(this.horario);
        setSalario(this.salario);
    }
    
    private void validarTextoObligatorio(String valor, String mensajeError)throws Exception{
        if(valor == null || valor.isBlank()){
            throw new Exception(mensajeError);
        }
    }
    
    
}
