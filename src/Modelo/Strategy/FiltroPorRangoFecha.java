package Modelo.Strategy;

import Modelo.Objetos.Cultivos.Cultivo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Greivin
 */

public class FiltroPorRangoFecha implements IFiltroCultivoStrategy {
    
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public FiltroPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    @Override
    public List<Cultivo> filtrar(List<Cultivo> cultivos) {
        List<Cultivo> resultado = new ArrayList<>();
        
        for (int i = 0; i < cultivos.size(); i++) {
            Cultivo cultivo = cultivos.get(i);
            LocalDate fechaSiembra = cultivo.getFechaSiembra();
            
            if (fechaSiembra != null && 
                !fechaSiembra.isBefore(fechaInicio) && 
                !fechaSiembra.isAfter(fechaFin)) {
                resultado.add(cultivo);
            }
        }
        
        return resultado;
    }
}
