package Modelo.Objetos.Trabajadores;

import java.util.Objects;

/**
 *
 * @author MARISOL
 */

public class Trabajador {
    private String id;               
    private String cedula;
    private String nombre;
    private String telefono;
    private String correo;
    private String puesto;
    private String horario;
    private double salario;
    
    public Trabajador(String id,String cedula,String nombre,String telefono,String correo, String puesto,String horario,double salario) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.puesto = puesto;
        this.horario = horario;
        this.salario = salario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id)throws Exception {
        if (id == null || id.isBlank()) {
            throw new Exception("El ID del trabajador no puede estar vacio");
        }
        this.id = id.trim();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula)throws Exception {
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cédula es obligatoria");
        }
        this.cedula = cedula.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre)throws Exception {
        if (nombre == null || nombre.isBlank()) {
            throw new Exception("El nombre es obligatorio");
        }
        this.nombre = nombre.trim();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono)throws Exception {
        if (telefono == null || telefono.isBlank()) {
            throw new Exception("El telefono es obligatorio");
        }
        this.telefono = telefono.trim();
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo)throws Exception {
        if (correo == null || correo.isBlank()) {
            throw new Exception("El correo es obligatorio");
        }
        if (!correo.contains("@")) {
            throw new Exception("Formato de correo invalido");
        }
        this.correo = correo.trim();
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto)throws Exception {
        if (puesto == null || puesto.isBlank()) {
            throw new Exception("El puesto es obligatorio");
        }
        this.puesto = puesto.trim();
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario)throws Exception {
        if (horario == null || horario.isBlank()) {
            throw new Exception("El horario es obligatorio");
        }
        this.horario = horario.trim();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario)throws Exception {
        if (salario < 0) {
            throw new Exception("El salario no puede ser menor a 0");
        }
        this.salario = salario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) 
            return true;
        if (!(o instanceof Trabajador)) 
            return false;
        Trabajador that = (Trabajador) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
