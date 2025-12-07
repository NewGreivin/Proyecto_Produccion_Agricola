package Modelo.Daos;

import Db.ConexionBD;
import Modelo.Dtos.CultivoDTO;
import Modelo.Interfaces.ICultivoDAO;
import Modelo.Objetos.Cultivos.EstadoCrecimiento;
import Modelo.Objetos.Cultivos.TipoCultivo;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author MARISOL
 */

public class CultivoMysqlDAO implements ICultivoDAO{
    private final ConexionBD conexion = ConexionBD.getInstance();

    @Override
    public List<CultivoDTO> buscarPorTipo(String tipo) {
        List<CultivoDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM cultivos WHERE tipo = ?";

        try (Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, tipo);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    lista.add(new CultivoDTO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        TipoCultivo.valueOf(rs.getString("tipo")),
                        rs.getDouble("area_sembrada"),
                        EstadoCrecimiento.valueOf(rs.getString("estado_crecimiento")),
                        rs.getDate("fecha_siembra").toLocalDate(),
                        rs.getDate("fecha_estim_cosecha").toLocalDate()));
                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Error en buscar por tipo", e);
        }
        return lista;
    }

    @Override
    public List<CultivoDTO> buscarPorEstado(String estado) {
        List<CultivoDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM cultivos WHERE estado_crecimiento = ?";

        try (Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, estado);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    lista.add(new CultivoDTO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        TipoCultivo.valueOf(rs.getString("tipo")),
                        rs.getDouble("area_sembrada"),
                        EstadoCrecimiento.valueOf(rs.getString("estado_crecimiento")),
                        rs.getDate("fecha_siembra").toLocalDate(),
                        rs.getDate("fecha_estim_cosecha").toLocalDate()));
                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Error en buscar por estado", e);
        }
        return lista;
    }

    @Override
    public List<CultivoDTO> buscarPorNombre(String nombre) {
        List<CultivoDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM cultivos WHERE nombre LIKE ?";

        try (Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, "%" + nombre + "%");

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    lista.add(new CultivoDTO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        TipoCultivo.valueOf(rs.getString("tipo")),
                        rs.getDouble("area_sembrada"),
                        EstadoCrecimiento.valueOf(rs.getString("estado_crecimiento")),
                        rs.getDate("fecha_siembra").toLocalDate(),
                        rs.getDate("fecha_estim_cosecha").toLocalDate()));
                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Error en buscar por nombre", e);
        }
        return lista;
    }

    @Override
    public List<CultivoDTO> buscarPorFechaSiembra(String fecha) {
        List<CultivoDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM cultivos WHERE fecha_siembra = ?";

        try {
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, fecha);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                    Integer id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    TipoCultivo tipo = TipoCultivo.valueOf(rs.getString("tipo"));
                    double areaSembrada = rs.getDouble("area_sembrada");
                    EstadoCrecimiento estado = EstadoCrecimiento.valueOf(rs.getString("estado_crecimiento"));
                    LocalDate fechaSiembra = rs.getDate("fecha_siembra").toLocalDate();
                    LocalDate fechaEstimCosecha = rs.getDate("fecha_estim_cosecha").toLocalDate();

                    CultivoDTO dto = new CultivoDTO(id, nombre, tipo, areaSembrada, estado, fechaSiembra, fechaEstimCosecha);

                    lista.add(dto);

                }
            }catch (Exception e) {
            throw new IllegalArgumentException("Error en buscar por fechaSiembra", e);
        }
            return lista;
        }

    @Override
    public List<CultivoDTO> cultivosProximosACosechar() {
        List<CultivoDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM cultivos WHERE fecha_estim_cosecha <= DATE_ADD(CURDATE(), INTERVAL 7 DAY) ORDER BY fecha_estim_cosecha ASC";

        try (Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    lista.add(new CultivoDTO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        TipoCultivo.valueOf(rs.getString("tipo")),
                        rs.getDouble("area_sembrada"),
                        EstadoCrecimiento.valueOf(rs.getString("estado_crecimiento")),
                        rs.getDate("fecha_siembra").toLocalDate(),
                        rs.getDate("fecha_estim_cosecha").toLocalDate()));
                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Error en Cultivos proximos a cosechar", e);
        }
        return lista;
    }

    @Override
    public void crear(CultivoDTO t) {
        String sql = "INSERT INTO cultivos (id, nombre, tipo, area_sembrada, estado_crecimiento, fecha_siembra, fecha_estim_cosecha) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = conexion.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
           
           pst.setInt(1, t.getId());
           pst.setString(2, t.getNombre());
           pst.setString(3, t.getTipo().name());
           pst.setDouble(4, t.getAreaSembrada());
           pst.setString(5, t.getEstado().name());
           pst.setString(6, t.getFechaSiembra().toString());
           pst.setString(7, t.getFechaEstimCosecha().toString());
           
           pst.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException("No se pudo registrar el cultivo", e);
        }
    }

    @Override
    public List<CultivoDTO> listar() {
        List<CultivoDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM cultivos";
        
        try (Connection conn = conexion.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
           
           while(rs.next()){
               Integer id = rs.getInt("id");
               String nombre = rs.getString("nombre");
               TipoCultivo tipo = TipoCultivo.valueOf(rs.getString("tipo"));
               double area = rs.getDouble("area_sembrada");
               EstadoCrecimiento estado = EstadoCrecimiento.valueOf(rs.getString("estado_crecimiento"));
               LocalDate fechaSiembra = rs.getDate("fecha_siembra").toLocalDate();
               LocalDate fechaEstim = rs.getDate("fecha_estim_cosecha").toLocalDate();

               CultivoDTO dto = new CultivoDTO(id, nombre, tipo, area, estado, fechaSiembra, fechaEstim);
               lista.add(dto);
           }
        }catch(SQLException e){
            throw new IllegalArgumentException("No se pudo listar el cultivo", e);
        }
        return lista;
    }

    @Override
    public void actualizar(CultivoDTO t) {
        String sql = "UPDATE cultivos SET nombre=?, tipo=?, area_sembrada=?, estado_crecimiento=?, fecha_siembra=?, fecha_estim_cosecha=? WHERE id=?";
        
        try (Connection conn = conexion.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
           
           pst.setString(1, t.getNombre());
           pst.setString(2, t.getTipo().name());
           pst.setDouble(3, t.getAreaSembrada());
           pst.setString(4, t.getEstado().name());
           pst.setString(5, t.getFechaSiembra().toString());
           pst.setString(6, t.getFechaEstimCosecha().toString());
           pst.setInt(7, t.getId());
           
           pst.executeUpdate();
        }catch(SQLException e){
            throw new IllegalArgumentException("No se pudo actualizar el cultivo", e);
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM cultivos WHERE id=?";
        
        try (Connection conn = conexion.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
           
           pst.setInt(1, id);
           pst.executeUpdate();
        }catch(SQLException e){
            throw new IllegalArgumentException("No se pudo elminar el cultivo", e);
        }
    }   

    @Override
    public CultivoDTO buscarPorId(Integer id) {
        String sql = "SELECT * FROM cultivos WHERE id = ?";

    try (Connection conn = conexion.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {

            return new CultivoDTO(
                rs.getInt("id"),
                rs.getString("nombre"),
                TipoCultivo.valueOf(rs.getString("tipo")),
                rs.getDouble("areaSembrada"),
                EstadoCrecimiento.valueOf(rs.getString("estadoCrecimiento")),
                rs.getDate("fechaSiembra").toLocalDate(),
                rs.getDate("fechaEstimCosecha").toLocalDate()
            );
        }

    } catch (SQLException e) {
        throw new IllegalArgumentException("Error buscando cultivo por ID", e);
    }
    return null; 
    }
}

