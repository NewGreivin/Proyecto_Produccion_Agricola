package Utilidades;

import java.security.MessageDigest;

/**
 *
 * @author Ricardo Chaves
 */

public class EncriptacionUtil {
    public static String hashSHA256(String texto){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(texto.getBytes());
            
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format(String.format("%02x", b)));
            }
            
            return sb.toString();
        } catch (Exception e){
            throw new RuntimeException("Error al crear hash", e); 
        }
    }
}
