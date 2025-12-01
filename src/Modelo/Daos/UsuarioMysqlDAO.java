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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean validarCredenciales(String username, String passwordHash) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existeUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<UsuarioDTO> listarPorRol(String rol) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void crear(UsuarioDTO t) {
        try {
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO usuarios VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, t.getId());
            ps.setString(2, t.getPasswordHash());
            ps.setString(3, t.getUsername());
            ps.setString(4, t.getRol().name());
            ps.setString(5, t.idTrabajador().getCedula());
            
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
            
            ps.setString(5, t.getId());
            
            int filas = ps.executeUpdate();
            
            if (filas == 0) {
                throw new IllegalArgumentException("No existe un usuario con ID: " + t.getId());
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("No se pudo actualizar", e);
        }
    }

    @Override
    public void eliminar(String t) {
        try {
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            
            ps.setString(1, t);
            
            int filas = ps.executeUpdate();
            
            if (filas == 0) {
                throw new IllegalArgumentException("No existe un Usuario con este ID: " + t);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("No se pudo eliminar: ", e);
        }
    }

}
