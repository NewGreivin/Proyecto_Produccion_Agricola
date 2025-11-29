package Modelo.Dtos;

/**
 *
 * @author MARISOL
 */

public class TrabajadorDTO {
    private String id;
    private String cedula;
    private String nombre;
    private String telefono;
    private String correo;
    private String puesto;
    private String horario;
    private double salario;

    public String getId() {
        return id;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPuesto() {
        return puesto;
    }

    public String getHorario() {
        return horario;
    }

    public double getSalario() {
        return salario;
    }
    
    public TrabajadorDTO(String id,String cedula,String nombre,String telefono,String correo,String puesto,String horario,double salario) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.puesto = puesto;
        this.horario = horario;
        this.salario = salario;
    }
}
