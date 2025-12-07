package Modelo.Daos;

import Db.ConexionBD;
import Modelo.Dtos.ProduccionDTO;
import Modelo.Interfaces.IProduccionDAO;
import Modelo.Objetos.Produccion.CalidadProduccion;
import Modelo.Objetos.Produccion.DestinoProduccion;
import Modelo.Objetos.Cultivos.Cultivo;
import Modelo.Objetos.Cultivos.TipoCultivo;
import Modelo.Objetos.Cultivos.EstadoCrecimiento;
import java.sql.Connection;
import java.sql.PreparedStatement; 
import java.time.LocalDate;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Greivin
 */

public class ProduccionMysqlDAO implements IProduccionDAO {
    private final ConexionBD conexion;

    public ProduccionMysqlDAO() {
        conexion = ConexionBD.getInstance();
    }
    
    @Override
    public List<ProduccionDTO> buscarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        List<ProduccionDTO> producciones = new ArrayList<>();
        String sql = "SELECT id, fecha, cantidad_recolectada, calidad, destino, id_cultivo FROM produccion WHERE fecha BETWEEN ? AND ? ORDER BY fecha DESC";
        
        try {
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, fechaInicio.toString());
            pst.setString(2, fechaFin.toString());
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                String id = rs.getString(1);
                LocalDate fecha = rs.getDate(2).toLocalDate();
                double cantidad = rs.getDouble(3);
                String calidadStr = rs.getString(4);
                String destinoStr = rs.getString(5);
                String idCultivo = rs.getString(6);
                
                ProduccionDTO dto = new ProduccionDTO(id, fecha, cantidad, 
                    CalidadProduccion.valueOf(calidadStr), 
                    DestinoProduccion.valueOf(destinoStr), obtenerCultivoPorId(idCultivo));
                producciones.add(dto);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo buscar por rango de fecha", e);
         }
        return producciones;
    }

    @Override
    public List<ProduccionDTO> buscarPorCultivo(String idCultivo) {
        List<ProduccionDTO> producciones = new ArrayList<>();
        String sql = "SELECT id, fecha, cantidad_recolectada, calidad, destino, id_cultivo FROM produccion WHERE id_cultivo = ? ORDER BY fecha DESC";
        
        try {
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, idCultivo);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                String id = rs.getString(1);
                LocalDate fecha = rs.getDate(2).toLocalDate();
                double cantidad = rs.getDouble(3);
                String calidadStr = rs.getString(4);
                String destinoStr = rs.getString(5);
                String idCultivoStr = rs.getString(6);
                
                ProduccionDTO dto = new ProduccionDTO(id, fecha, cantidad, 
                    CalidadProduccion.valueOf(calidadStr), 
                    DestinoProduccion.valueOf(destinoStr), obtenerCultivoPorId(idCultivoStr));
                producciones.add(dto);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo buscar por cultivo", e);
        }
        
        return producciones;
    }

    @Override
    public List<ProduccionDTO> buscarPorDestino(String destino) {
        List<ProduccionDTO> producciones = new ArrayList<>();
        String sql = "SELECT id, fecha, cantidad_recolectada, calidad, destino, id_cultivo FROM produccion WHERE destino = ? ORDER BY fecha DESC";
        
        try {
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, destino);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                String id = rs.getString(1);
                LocalDate fecha = rs.getDate(2).toLocalDate();
                double cantidad = rs.getDouble(3);
                String calidadStr = rs.getString(4);
                String destinoStr = rs.getString(5);
                String idCultivo = rs.getString(6);
                
                ProduccionDTO dto = new ProduccionDTO(id, fecha, cantidad, 
                    CalidadProduccion.valueOf(calidadStr), 
                    DestinoProduccion.valueOf(destinoStr), obtenerCultivoPorId(idCultivo));
                producciones.add(dto);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo buscar por destino", e);
        }
        
        return producciones;
    }

    @Override
    public List<ProduccionDTO> buscarPorFecha(String fecha) {
        List<ProduccionDTO> producciones = new ArrayList<>();
        String sql = "SELECT id, fecha, cantidad_recolectada, calidad, destino, id_cultivo FROM produccion WHERE DATE(fecha) = ?";
        
        try {
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, fecha);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                String id = rs.getString(1);
                LocalDate fecha2 = rs.getDate(2).toLocalDate();
                double cantidad = rs.getDouble(3);
                String calidadStr = rs.getString(4);
                String destinoStr = rs.getString(5);
                String idCultivo = rs.getString(6);

                ProduccionDTO dto = new ProduccionDTO(id, fecha2, cantidad, 
                    CalidadProduccion.valueOf(calidadStr), 
                    DestinoProduccion.valueOf(destinoStr), obtenerCultivoPorId(idCultivo));
                producciones.add(dto);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo buscar por fecha", e);
        }
        
        return producciones;
    }

    @Override
    public List<ProduccionDTO> buscarPorCalidad(String calidad) {
        List<ProduccionDTO> producciones = new ArrayList<>();
        String sql = "SELECT id, fecha, cantidad_recolectada, calidad, destino, id_cultivo FROM produccion WHERE calidad = ? ORDER BY fecha DESC";
        
        try {
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, calidad);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                String id = rs.getString(1);
                LocalDate fecha = rs.getDate(2).toLocalDate();
                double cantidad = rs.getDouble(3);
                String calidadStr = rs.getString(4);
                String destinoStr = rs.getString(5);
                String idCultivo = rs.getString(6);
                
                ProduccionDTO dto = new ProduccionDTO(id, fecha, cantidad, 
                    CalidadProduccion.valueOf(calidadStr), 
                    DestinoProduccion.valueOf(destinoStr), obtenerCultivoPorId(idCultivo));
                producciones.add(dto);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo buscar por calidad", e);
        }
        
        return producciones;
    }

    @Override
    public void crear(ProduccionDTO t) {
        String sql = "INSERT INTO produccion (fecha, cantidad_recolectada, calidad, destino, id_cultivo) VALUES (?, ?, ?, ?, ?)";
        
        try {
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, t.getFecha().toString());
            pst.setDouble(2, t.getCantidadRecolectada());
            pst.setString(3, t.getCalidad().name());
            pst.setString(4, t.getDestino().name());
            pst.setInt(5, t.getIdCultivo().getId());
            
            pst.executeUpdate();
            pst.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<ProduccionDTO> listar() {
        List<ProduccionDTO> producciones = new ArrayList<>();
        String sql = "SELECT id, fecha, cantidad_recolectada, calidad, destino, id_cultivo FROM produccion";
         
        try {
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                String id = rs.getString(1);
                LocalDate fecha = rs.getDate(2).toLocalDate();
                double cantidad = rs.getDouble(3);
                String calidadStr = rs.getString(4);
                String destinoStr = rs.getString(5);
                String idCultivo = rs.getString(6);
                
                ProduccionDTO dto = new ProduccionDTO(id, fecha, cantidad, 
                    CalidadProduccion.valueOf(calidadStr), 
                    DestinoProduccion.valueOf(destinoStr), obtenerCultivoPorId(idCultivo));
                producciones.add(dto);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo listar producciones", e);
        }
        
        return producciones;
    }

    @Override
    public void actualizar(ProduccionDTO t) {
        String sql = "UPDATE produccion SET fecha = ?, cantidad_recolectada = ?, calidad = ?, destino = ?, id_cultivo = ? WHERE id = ?";
        
        try {
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, t.getFecha().toString());
            pst.setDouble(2, t.getCantidadRecolectada());
            pst.setString(3, t.getCalidad().name());
            pst.setString(4, t.getDestino().name());
            pst.setInt(5, t.getIdCultivo().getId());
            pst.setString(6, t.getId());
            
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM produccion WHERE id = ?";
        
        try {
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setInt(1, id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //Metodo de Ayuda para el ID del cultivo
    private Cultivo obtenerCultivoPorId(String idCultivo) {
        String sql = "SELECT id, nombre, tipo, area_sembrada, estado_crecimiento, fecha_siembra, fecha_estim_cosecha FROM cultivos WHERE id = ?";
        
        try {
            Connection conn = conexion.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, idCultivo);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                TipoCultivo tipo = TipoCultivo.valueOf(rs.getString(3));
                double areaSembrada = rs.getDouble(4);
                EstadoCrecimiento estado = EstadoCrecimiento.valueOf(rs.getString(5));
                LocalDate fechaSiembra = rs.getDate(6).toLocalDate();
                LocalDate fechaEstimCosecha = rs.getDate(7).toLocalDate();

                Cultivo cultivo = new Cultivo(id, nombre, tipo, areaSembrada, estado, fechaSiembra, fechaEstimCosecha);
                
                rs.close();
                pst.close();
                return cultivo;
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

}