
package Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Greivin
 */
public class UtilDate {
    public static LocalDate toLocalDate(String date){
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    public static String toString(LocalDate date){
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
