package Modelo.Mappers;

import Modelo.Dtos.UsuarioDTO;
import Modelo.Objetos.Usuarios.Usuario;

/**
 *
 * @author Ricardo Chaves
 */

public class UsuarioMapper {
    public UsuarioDTO toDTO(Usuario usuario){
        UsuarioDTO UsuDTO = new UsuarioDTO(usuario.getId(), usuario.getUsername(), usuario.getPasswordHash(), usuario.getRol(), usuario.getIdTrabajador());
        return UsuDTO;
    }
    
    public Usuario toEntity(UsuarioDTO UserDTO){
        Usuario user = new Usuario(UserDTO.getId(), UserDTO.getUsername(), UserDTO.getPasswordHash(), UserDTO.getRol(), UserDTO.getIdTrabajador());
        return user;
    }
}
