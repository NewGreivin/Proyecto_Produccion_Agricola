package Modelo.Interfaces;

import Modelo.Objetos.Usuarios.Usuario;
import java.util.List;

/**
 *
 * @author Ricardo Chaves 
 */

public interface IUsuarioDAO extends ICRUD<Usuario> {
    Usuario buscarPorUsername(String username);
    boolean validarCredenciales(String username, String passwordHash);
    boolean existeUsername(String username);
    List<Usuario> listarPorRol(String rol);
}
