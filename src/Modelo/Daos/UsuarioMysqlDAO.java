package Modelo.Daos;

import Db.ConexionBD;
import Modelo.Dtos.TrabajadorDTO;
import Modelo.Dtos.UsuarioDTO;
import Modelo.Interfaces.IUsuarioDAO;
import Modelo.Mappers.TrabajadorMapper;
import Modelo.Objetos.Trabajadores.Trabajador;
import Modelo.Objetos.Usuarios.Rol;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ricardo Chaves
 */

public class UsuarioMysqlDAO implements IUsuarioDAO{
    private ConexionBD conexionBD;

    public UsuarioMysqlDAO() {
        this.conexionBD = ConexionBD.getInstance();
    }
  
    @Override
    public UsuarioDTO buscarPorUsername(String username) {
        try{
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("SELECT id, username, password_hash, rol, id_trabajador FROM usuarios where username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            TrabajadorMysqlDAO trabmysql = new TrabajadorMysqlDAO();
            TrabajadorMapper trabmapper = new TrabajadorMapper();
            
            if (rs.next()) {
                String trap = rs.getString(5);
                TrabajadorDTO trabjdto = trabmysql.buscarPorCedula(trap);
                Trabajador trabajador = trabmapper.toEntity(trabjdto);
                
                return new UsuarioDTO(rs.getString(1), rs.getString(2), rs.getString(3), Rol.valueOf(rs.getString(4)), trabajador);
            }
        } catch(Exception e) {
            throw new IllegalArgumentException("Sucedio un error: ", e);
        }
        return null;
    }

    @Override
    public boolean validarCredenciales(String username, String passwordHash) {
        try{
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("SELECT id FROM usuarios WHERE username = ? AND password_hash = ?");
            
            ps.setString(1, username);
            ps.setString(2, passwordHash);
            
            ResultSet rs = ps.executeQuery();
            
            return rs.next();
            
        } catch(SQLException e) {
            throw new IllegalArgumentException("Sucedio un errro", e);
        }
    }

    @Override
    public boolean existeUsername(String username) {
        try{
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("SELECT id FROM usuarios WHERE username = ? ");
            
            ps.setString(1, username);
            
            ResultSet rs = ps.executeQuery();
            
            return rs.next();
        } catch(SQLException e){
            throw new IllegalArgumentException("Sucedio un error: ", e);
        }
    }

    @Override
    public List<UsuarioDTO> listarPorRol(String rol) {
        List<UsuarioDTO> lista = new ArrayList<>();
        
        try{
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("SELECT id, username, password_hash, rol, id_trabajador FROM usuarios where rol = ?");
            ps.setString(1, rol);
            ResultSet rs = ps.executeQuery();
            
            TrabajadorMysqlDAO trabmysql = new TrabajadorMysqlDAO();
            TrabajadorMapper trabmapper = new TrabajadorMapper();
            
            while(rs.next()) {
                String idt = rs.getString(5);
                TrabajadorDTO trabdto = trabmysql.buscarPorCedula(idt);
                Trabajador trabajador = trabmapper.toEntity(trabdto);
                
                UsuarioDTO udto = new UsuarioDTO(rs.getString(1), rs.getString(2), rs.getString(3), Rol.valueOf(rs.getString(4)), trabajador);
                lista.add(udto);
            }
        } catch(Exception e){
            throw new IllegalArgumentException("Sucedio un error: ", e);
        }
        return lista;
    }

    @Override
    public void crear(UsuarioDTO t) {
        try {
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO usuarios (id, username, password_hash, rol, id_trabajador) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, t.getId());
            ps.setString(2, t.getUsername());
            ps.setString(3, t.getPasswordHash());
            ps.setString(4, t.getRol().name());
            ps.setString(5, t.getIdTrabajador().getCedula());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException("No se pudo crear", e);
        }
    }

    @Override
    public List<UsuarioDTO> listar() {
        List<UsuarioDTO> lista = new ArrayList<>();
        
        try {
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("SELECT id, username, password_hash, rol, id_trabajador FROM usuarios");
            ResultSet rs = ps.executeQuery();
            
            TrabajadorMysqlDAO trabDAO = new TrabajadorMysqlDAO();
            TrabajadorMapper mapper = new TrabajadorMapper();
                
            while (rs.next()) {
                String idtrap = rs.getString(5);
                TrabajadorDTO trabajadorDTO = trabDAO.buscarPorCedula(idtrap);
                Trabajador trabajador = mapper.toEntity(trabajadorDTO);     
                
                UsuarioDTO udto = new UsuarioDTO(rs.getString(1), rs.getString(2), rs.getString(3), Rol.valueOf(rs.getString(4)), trabajador);
                lista.add(udto);
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException("No se pudo listar", ex);
        }
        return lista;
    }

    @Override
    public void actualizar(UsuarioDTO t) {
        try {
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("UPDATE usuarios SET password_hash = ?, rol = ? WHERE id = ?");
            
            ps.setString(1, t.getPasswordHash());
            ps.setString(2, t.getRol().name());
            
            ps.setString(3, t.getId());
            
            int filas = ps.executeUpdate();
            
            if (filas == 0) {
                throw new IllegalArgumentException("No existe un usuario con ID: " + t.getId());
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("No se pudo actualizar", e);
        }
    }

    @Override
    public void eliminar(String id) {
        try {
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            
            ps.setString(1, id);
            
            int filas = ps.executeUpdate();
            
            if (filas == 0) {
                throw new IllegalArgumentException("No existe un Usuario con este ID: " + id);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("No se pudo eliminar: ", e);
        }
    }

}
