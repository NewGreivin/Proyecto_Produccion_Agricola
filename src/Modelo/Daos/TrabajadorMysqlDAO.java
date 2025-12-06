package Modelo.Daos;

import Db.ConexionBD;
import Modelo.Dtos.TrabajadorDTO;
import Modelo.Interfaces.ITrabajadorDAO;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MARISOL
 */

public class TrabajadorMysqlDAO implements ITrabajadorDAO {
    private final ConexionBD conexion;

    public TrabajadorMysqlDAO(ConexionBD conexion) {
        this.conexion = ConexionBD.getInstance();
    }
    
    @Override
    public TrabajadorDTO buscarPorCedula(int cedulaABuscar) {
        String sql = "SELECT cedula, nombre, telefono, correo, puesto, horario, salario " + "FROM trabajador WHERE cedula = ?";
        
        try{
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setInt(1, cedulaABuscar);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                rs.getInt("cedula");
                rs.getString("nombre");
                rs.getString("telefono");
                rs.getString("correo");
                rs.getString("puesto");
                rs.getString("horario");
                rs.getDouble("salario");
                
            }
        }catch(SQLException e){
            throw new IllegalArgumentException("Error buscando trabajador por cedula", e);
        }
        return null;
    }

    @Override
    public boolean existeCedula(int cedula) {
        String sql = "SELECT COUNT(*) FROM trabajador WHERE cedula = ?";

        try {
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, cedula);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        throw new IllegalArgumentException("Error al verificar existencia de cedula", e);
    }

    return false;
    }

    @Override
    public List<TrabajadorDTO> buscarPorNombre(String nombre) {
        List<TrabajadorDTO> lista = new ArrayList<>();
        String sql = "SELECT cedula, nombre, telefono, correo, puesto, horario, salario " + "FROM trabajador WHERE nombre LIKE ?";

        try{
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, "%" + nombre + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                lista.add(new TrabajadorDTO(
                    rs.getInt("cedula"),
                    rs.getString("nombre"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getString("puesto"),
                    rs.getString("horario"),
                    rs.getDouble("salario")));
                }
            } catch (SQLException e) {
                throw new IllegalArgumentException("Error al buscar por nombre", e);
        }
        return lista;
    }

    @Override
    public List<TrabajadorDTO> buscarPorPuesto(String puesto) {
        List<TrabajadorDTO> lista = new ArrayList<>();
        String sql = "SELECT cedula, nombre, telefono, correo, puesto, horario, salario " + "FROM trabajador WHERE puesto LIKE ?";

        try {
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, "%" + puesto + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                lista.add(new TrabajadorDTO(
                    rs.getInt("cedula"),
                    rs.getString("nombre"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getString("puesto"),
                    rs.getString("horario"),
                    rs.getDouble("salario")));
                }
            } catch (SQLException e) {
                throw new IllegalArgumentException("Error al buscar por puesto", e);
        }
        return lista;
    }

    @Override
    public void crear(TrabajadorDTO t) {
        String sql = "INSERT INTO trabajador (cedula,nombre,telefono,correo,puesto,horario,salario) " + "VALUES (?,??,?,?,?,?)";        
        
        try{
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setInt(1, t.getCedula());
            pst.setString(2, t.getNombre());
            pst.setString(3, t.getTelefono());
            pst.setString(4, t.getCorreo());
            pst.setString(5, t.getPuesto());
            pst.setString(6, t.getHorario());
            pst.setDouble(7, t.getSalario());
            
            pst.executeUpdate();
        }catch(SQLException e){
            throw new IllegalArgumentException("No se pudo crear el trabajador", e);
        }
    }

    @Override
    public List<TrabajadorDTO> listar() {
        List<TrabajadorDTO> lista = new ArrayList<>();
        String sql = "SELECT cedula, nombre, telefono, correo, puesto, horario, salario FROM trabajador";
        
        try{
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Integer cedula = rs.getInt("cedula");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String puesto = rs.getString("puesto");
                String horario = rs.getString("horario");
                Double salario = rs.getDouble("salario");
                
                TrabajadorDTO dto = new TrabajadorDTO(cedula,nombre,telefono,correo,puesto,horario,salario);
                lista.add(dto);
            }
        }catch(SQLException e){
            throw new IllegalArgumentException("No se pudo listar trabajadores", e);
        }
        return lista;
    }

    @Override
    public void actualizar(TrabajadorDTO t) {
        String sql = "UPDATE trabajador SET nombre=?,telefono=?,correo=?,puesto=?,horario=?,salario=?" + "WHERE cedula = ?";
        
        try{
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, t.getNombre());
            pst.setString(2, t.getTelefono());
            pst.setString(3, t.getCorreo());
            pst.setString(4, t.getPuesto());
            pst.setString(5, t.getHorario());
            pst.setDouble(6, t.getSalario());
            pst.setInt(7, t.getCedula());
            
            pst.executeUpdate();
        }catch(SQLException e){
            throw new IllegalArgumentException("No se pudo actualizar el trabajador, e");
        }
    }

    @Override
    public void eliminar(int cedula) {
        String sql = "DELETE FROM trabajador WHERE cedula = ?";
        
        try{
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setInt(1, cedula);
            pst.executeUpdate();
        }catch (SQLException e){
            throw new IllegalArgumentException("No se pudo eliminar el trabajador");
        }
    }

}