package Modelo.Servicios;

import Modelo.Dtos.UsuarioDTO;
import Modelo.Factory.DAOFactory;
import Modelo.Interfaces.IUsuarioDAO;
import Modelo.Mappers.UsuarioMapper;
import Modelo.Objetos.Trabajadores.Trabajador;
import Modelo.Objetos.Usuarios.Rol;
import Modelo.Objetos.Usuarios.Usuario;
import Utilidades.EncriptacionUtil;
import java.util.List;
import Utilidades.ValidacionUtil;

/**
 *
 * @author Ricardo Chaves
 */

public class ServicioUsuario {
    
    private final IUsuarioDAO usuarioDao;
    private final UsuarioMapper usuarioMapper;

    public ServicioUsuario() {
        this.usuarioDao = DAOFactory.crearUsuarioDAO();
        this.usuarioMapper = new UsuarioMapper();
    }
    
    public void crearUsuario(String id, String username, String passwordHash, Rol rol, Trabajador idTrabajador) throws Exception{
        if (!ValidacionUtil.PasswordValido(passwordHash)) {
            throw new IllegalArgumentException("La contraseña debe tener como minimo 6 caractares, contener numeros y letras.");
        }
        String password = EncriptacionUtil.hashSHA256(passwordHash);
        Usuario usuario = new Usuario(id, username, password, rol, idTrabajador);
        UsuarioDTO udto = usuarioMapper.toDTO(usuario);
        usuarioDao.crear(udto);
    }
    
    public List<UsuarioDTO> listar(){
        return usuarioDao.listar();
    }
    
    public UsuarioDTO buscarPorUsername(String username){
        return usuarioDao.buscarPorUsername(username);
    }
    
    public boolean validarCredenciales(String username, String passwordHash){
        String passwordhash = EncriptacionUtil.hashSHA256(passwordHash);
        return usuarioDao.validarCredenciales(username, passwordhash);
    }
    
    public boolean existeUsername(String username){
        return usuarioDao.existeUsername(username);
    }
    
    public List<UsuarioDTO> listarPorRol(String rol){
        return usuarioDao.listarPorRol(rol);
    }
    
    public void actualizar(String id, String passwordHash, Rol rol) throws Exception{
        List<UsuarioDTO> usuarios = listar();
        UsuarioDTO UsuariosExistentes = null;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(id)) {
                UsuariosExistentes = usuarios.get(i);
                break;
            }
        }
        Usuario usuario = usuarioMapper.toEntity(UsuariosExistentes);
        if (!ValidacionUtil.PasswordValido(passwordHash)) {
            throw new IllegalArgumentException("La contraseña debe tener minimo 6 caracteres, contener nuermos y letras.");
        }
        String hashPassword = EncriptacionUtil.hashSHA256(passwordHash);
        
        usuario.setPasswordHash(hashPassword);
        usuario.setRol(rol);
        
        UsuarioDTO udto = usuarioMapper.toDTO(usuario);
        usuarioDao.actualizar(udto);
    }
    
    public void eliminar(String id) throws Exception{
        usuarioDao.eliminar(id);
    }
}
