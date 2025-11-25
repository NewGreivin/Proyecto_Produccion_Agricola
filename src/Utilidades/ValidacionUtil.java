package Utilidades;

import java.time.LocalDate;

/**
 *
 * @author Ricardo Chaves
 */

public class ValidacionUtil {
    public static boolean ValidarNoFutura(LocalDate date){
        LocalDate hoy = LocalDate.now();
        return !date.isAfter(hoy);
    }
    
    public static boolean ValidarNoPasada(LocalDate date){
        LocalDate hoy = LocalDate.now();
        return !date.isBefore(hoy);
    }
    
    public static boolean CorreoValido(String correo){
        return correo != null && correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
    
    public static boolean TelefonoValido(String telefono){
        return telefono != null && telefono.matches("^[5678][0-9]{7}$");
    }
}
