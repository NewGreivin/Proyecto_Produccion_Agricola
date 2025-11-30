package Modelo.Interfaces;

import Modelo.Dtos.UsuarioDTO;
import java.util.List;

/**
 *
 * @author Ricardo Chaves 
 */

public interface IUsuarioDAO extends ICRUD<UsuarioDTO> {
    UsuarioDTO buscarPorUsername(String username);
    boolean validarCredenciales(String username, String passwordHash);
    boolean existeUsername(String username);
    List<UsuarioDTO> listarPorRol(String rol);
}
