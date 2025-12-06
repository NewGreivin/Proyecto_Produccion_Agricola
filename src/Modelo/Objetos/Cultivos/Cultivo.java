package Modelo.Objetos.Cultivos;

import Utilidades.ValidacionUtil;
import java.time.LocalDate;

/**
 *
 * @author MARISOL
 */

public class Cultivo {
    private int id;                    
    private String nombre;
    private TipoCultivo tipo;
    private double areaSembrada;
    private EstadoCrecimiento estado;
    private LocalDate fechaSiembra;
    private LocalDate fechaEstimCosecha;
    
 public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoCultivo getTipo() {
        return tipo;
    }

    public double getAreaSembrada() {
        return areaSembrada;
    }

    public void setAreaSembrada(double areaSembrada)throws Exception {
        validarAreaSembrada(areaSembrada);
        this.areaSembrada = areaSembrada;
    }

    public EstadoCrecimiento getEstado() {
        return estado;
    }

    public void setEstado(EstadoCrecimiento estado)throws Exception {
        validarObjetoO(estado, "El estado es obligatorio");
        this.estado = estado;
    }

    public LocalDate getFechaSiembra() {
        return fechaSiembra;
    }

    public LocalDate getFechaEstimCosecha() {
        return fechaEstimCosecha;
    }

    public void setFechaEstimCosecha(LocalDate fechaEstimCosecha)throws Exception {
        validarFechaEstimCosecha(fechaEstimCosecha);
        this.fechaEstimCosecha = fechaEstimCosecha;
    }
    
    public Cultivo(int id,String nombre,TipoCultivo tipo,double areaSembrada,EstadoCrecimiento estado,LocalDate fechaSiembra,LocalDate fechaEstimCosecha) throws Exception {
        validarId(id);
        validarTextoObligatorio(nombre, "El nombre de cultivo es obligatorio");
        validarObjetoO(tipo, "El tipo de cultivo es obligatorio");
        validarFechaSiembra(fechaSiembra);
        
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.areaSembrada = areaSembrada;
        this.estado = estado;
        this.fechaSiembra = fechaSiembra;
        this.fechaEstimCosecha = fechaEstimCosecha;
    }
    
    private void validarId(int id)throws Exception{
        if(id <= 0){
            throw new Exception("El id debe ser un numero positivo");
        }
    }
    
    private void validarTextoObligatorio(String valor, String msj)throws Exception{
        if(valor == null || valor.isBlank()){
            throw new Exception(msj);
        }
    }
    
    private void validarObjetoO(Object obj, String mensajeError)throws Exception {
        if (obj == null) {
            throw new Exception(mensajeError);
        }
    }
    
    private void validarAreaSembrada(double area)throws Exception{
        if(area <= 0){
            throw new Exception("El area sembrada debe ser mayor a 0");
        }
    }
    
    private void validarFechaSiembra(LocalDate fechaSiembra)throws Exception{
        if(fechaSiembra == null){
            throw new Exception("La fecha de siembra es obligatoria");
        }
        if(!ValidacionUtil.ValidarNoFutura(fechaSiembra)){
            throw new Exception("La fecha de siembra no puede ser futura");
        }
    }
    
    private void validarFechaEstimCosecha(LocalDate fechaEstimCosecha)throws Exception{
        if(fechaEstimCosecha == null){
            throw new Exception("La fecha de estimada cosecha es obligatoria");
        }
        if(this.fechaSiembra == null){
            throw new Exception("La fecha de siembra debe existir antes de fecha estimada");
        }
        if(!fechaEstimCosecha.isAfter(this.fechaSiembra)){
            throw new Exception("La fecha de estimada cosecha debe ser despues a la fecha de siembra");
        }
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}
