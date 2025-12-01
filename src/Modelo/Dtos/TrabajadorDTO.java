package Modelo.Dtos;

/**
 *
 * @author MARISOL
 */

public class TrabajadorDTO {
    private final String cedula;
    private final String nombre;
    private final String telefono;
    private final String correo;
    private final String puesto;
    private final String horario;
    private final double salario;

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
    
    public TrabajadorDTO(String cedula,String nombre,String telefono,String correo,String puesto,String horario,double salario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.puesto = puesto;
        this.horario = horario;
        this.salario = salario;
    }
}
