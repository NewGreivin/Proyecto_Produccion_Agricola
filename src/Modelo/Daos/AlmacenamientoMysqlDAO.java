package Modelo.Daos;

import Db.ConexionBD;
import Modelo.Dtos.AlmacenamientoDTO;
import Modelo.Interfaces.IAlmacenamientoDAO;
import Modelo.Objetos.Cultivos.Cultivo;
import Modelo.Objetos.Cultivos.EstadoCrecimiento;
import Modelo.Objetos.Cultivos.TipoCultivo;
import java.time.LocalDate;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Ricardo Chaves
 */

public class AlmacenamientoMysqlDAO implements IAlmacenamientoDAO {
    private ConexionBD conexionBD;

    public AlmacenamientoMysqlDAO() {
        this.conexionBD = ConexionBD.getInstance();
    }
    
    @Override
    public List<AlmacenamientoDTO> buscarPorProducto(String nombre) {
        List<AlmacenamientoDTO> lista = new ArrayList<>();
        
        try{
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement(
                "SELECT a.id, a.id_cultivo, a.cantidad, a.fecha_ingreso, a.fecha_salida, " +
                "c.nombre, c.tipo, c.area_sembrada, c.estado_crecimiento, c.fecha_siembra, c.fecha_estim_cosecha " +
                "FROM almacenamiento a " +
                "INNER JOIN cultivos c ON a.id_cultivo = c.id " +
                "WHERE c.nombre LIKE ?");
            ps.setString(1, "%" + nombre + "%");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Cultivo cultivo = new Cultivo(
                    rs.getInt("id_cultivo"),
                    rs.getString("nombre"),
                    TipoCultivo.valueOf(rs.getString("tipo")),
                    rs.getDouble("area_sembrada"),
                    EstadoCrecimiento.valueOf(rs.getString("estado_crecimiento")),
                    rs.getDate("fecha_siembra").toLocalDate(),
                    rs.getDate("fecha_estim_cosecha").toLocalDate()
                );
                
                AlmacenamientoDTO adto = new AlmacenamientoDTO(
                    rs.getInt("id"), 
                    cultivo, 
                    rs.getDouble("cantidad"), 
                    rs.getDate("fecha_ingreso").toLocalDate(), 
                    rs.getDate("fecha_salida").toLocalDate()
                );
                lista.add(adto);
            }
        } catch (SQLException e){
            throw new IllegalArgumentException("Se genero un error", e);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al crear objeto Cultivo", e);
        }
        return lista;
    }

    @Override
    public List<AlmacenamientoDTO> buscarPorFechaIngreso(LocalDate fecha) {
        List<AlmacenamientoDTO> lista = new ArrayList<>();
        
        try {
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement(
                "SELECT a.id, a.id_cultivo, a.cantidad, a.fecha_ingreso, a.fecha_salida, " +
                "c.nombre, c.tipo, c.area_sembrada, c.estado_crecimiento, c.fecha_siembra, c.fecha_estim_cosecha " +
                "FROM almacenamiento a " +
                "INNER JOIN cultivos c ON a.id_cultivo = c.id " +
                "WHERE a.fecha_ingreso = ?");
            ps.setString(1, fecha.toString());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Cultivo cultivo = new Cultivo(
                    rs.getInt("id_cultivo"),
                    rs.getString("nombre"),
                    TipoCultivo.valueOf(rs.getString("tipo")),
                    rs.getDouble("area_sembrada"),
                    EstadoCrecimiento.valueOf(rs.getString("estado_crecimiento")),
                    rs.getDate("fecha_siembra").toLocalDate(),
                    rs.getDate("fecha_estim_cosecha").toLocalDate()
                );
                
                AlmacenamientoDTO adto = new AlmacenamientoDTO(
                    rs.getInt("id"), 
                    cultivo, 
                    rs.getDouble("cantidad"), 
                    rs.getDate("fecha_ingreso").toLocalDate(), 
                    rs.getDate("fecha_salida").toLocalDate()
                );
                lista.add(adto);
            } 
        } catch(SQLException e) {
            throw new IllegalArgumentException("Se produjo un error", e);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al crear objeto Cultivo", e);
        }
        return lista;
    }

    @Override
    public List<AlmacenamientoDTO> productoVencidos() {
        List<AlmacenamientoDTO> lista = new ArrayList<>();
        
        try {
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement(
                "SELECT a.id, a.id_cultivo, a.cantidad, a.fecha_ingreso, a.fecha_salida, " +
                "c.nombre, c.tipo, c.area_sembrada, c.estado_crecimiento, c.fecha_siembra, c.fecha_estim_cosecha " +
                "FROM almacenamiento a " +
                "INNER JOIN cultivos c ON a.id_cultivo = c.id " +
                "WHERE a.fecha_salida < CURDATE()");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Cultivo cultivo = new Cultivo(
                    rs.getInt("id_cultivo"),
                    rs.getString("nombre"),
                    TipoCultivo.valueOf(rs.getString("tipo")),
                    rs.getDouble("area_sembrada"),
                    EstadoCrecimiento.valueOf(rs.getString("estado_crecimiento")),
                    rs.getDate("fecha_siembra").toLocalDate(),
                    rs.getDate("fecha_estim_cosecha").toLocalDate()
                );
                
                AlmacenamientoDTO adto = new AlmacenamientoDTO(
                    rs.getInt("id"), 
                    cultivo, 
                    rs.getDouble("cantidad"), 
                    rs.getDate("fecha_ingreso").toLocalDate(), 
                    rs.getDate("fecha_salida").toLocalDate()
                );
                lista.add(adto);
            }
        } catch(SQLException e){
            throw new IllegalArgumentException("Se produjo un error en el listado: ", e);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al crear objeto Cultivo", e);
        }
        return lista;
    }

    @Override
    public List<AlmacenamientoDTO> productosSinSalida() {
        List<AlmacenamientoDTO> lista = new ArrayList<>();
        
        try{
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement(
                "SELECT a.id, a.id_cultivo, a.cantidad, a.fecha_ingreso, a.fecha_salida, " +
                "c.nombre, c.tipo, c.area_sembrada, c.estado_crecimiento, c.fecha_siembra, c.fecha_estim_cosecha " +
                "FROM almacenamiento a " +
                "INNER JOIN cultivos c ON a.id_cultivo = c.id " +
                "WHERE a.fecha_salida = a.fecha_ingreso");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Cultivo cultivo = new Cultivo(
                    rs.getInt("id_cultivo"),
                    rs.getString("nombre"),
                    TipoCultivo.valueOf(rs.getString("tipo")),
                    rs.getDouble("area_sembrada"),
                    EstadoCrecimiento.valueOf(rs.getString("estado_crecimiento")),
                    rs.getDate("fecha_siembra").toLocalDate(),
                    rs.getDate("fecha_estim_cosecha").toLocalDate()
                );
                
                AlmacenamientoDTO adto = new AlmacenamientoDTO(
                    rs.getInt("id"), 
                    cultivo, 
                    rs.getDouble("cantidad"), 
                    rs.getDate("fecha_ingreso").toLocalDate(), 
                    rs.getDate("fecha_salida").toLocalDate()
                );
                lista.add(adto);
            }
        } catch(SQLException e){
            throw new IllegalArgumentException("Se produjo un error en el listado", e);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al crear objeto Cultivo", e);
        }
        return lista;
    }

    @Override
    public void crear(AlmacenamientoDTO t) {
        try {
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO almacenamiento(id_cultivo, cantidad, fecha_ingreso, fecha_salida) VALUES (?, ?, ?, ?)");
            
            ps.setInt(1, t.getCultivo().getId());
            ps.setDouble(2, t.getCantidad());
            ps.setDate(3, Date.valueOf(t.getFechaIngreso()));
            ps.setDate(4, Date.valueOf(t.getFechaSalida()));
            
            ps.executeUpdate();
        } catch(SQLException e) {
            throw new IllegalArgumentException("Se produjo un error: ", e);
        }
    }

    @Override
    public List<AlmacenamientoDTO> listar() {
        List<AlmacenamientoDTO> lista = new ArrayList<>();
        
        try {
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement(
                "SELECT a.id, a.id_cultivo, a.cantidad, a.fecha_ingreso, a.fecha_salida, " +
                "c.nombre, c.tipo, c.area_sembrada, c.estado_crecimiento, c.fecha_siembra, c.fecha_estim_cosecha " +
                "FROM almacenamiento a " +
                "INNER JOIN cultivos c ON a.id_cultivo = c.id");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Cultivo cultivo = new Cultivo(
                    rs.getInt("id_cultivo"),
                    rs.getString("nombre"),
                    TipoCultivo.valueOf(rs.getString("tipo")),
                    rs.getDouble("area_sembrada"),
                    EstadoCrecimiento.valueOf(rs.getString("estado_crecimiento")),
                    rs.getDate("fecha_siembra").toLocalDate(),
                    rs.getDate("fecha_estim_cosecha").toLocalDate()
                );
                
                AlmacenamientoDTO adto = new AlmacenamientoDTO(
                    rs.getInt("id"), 
                    cultivo, 
                    rs.getDouble("cantidad"), 
                    rs.getDate("fecha_ingreso").toLocalDate(), 
                    rs.getDate("fecha_salida").toLocalDate()
                );
                lista.add(adto);
            }
        } catch(SQLException e) {
            throw new IllegalArgumentException("No se pudo lista: ", e);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al crear objeto Cultivo", e);
        }
        return lista;
    }

    @Override
    public void actualizar(AlmacenamientoDTO t) {
        try{
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("UPDATE almacenamiento SET fecha_salida = ? where id = ?");
            
            ps.setDate(1, Date.valueOf(t.getFechaSalida()));
            ps.setInt(2, t.getId());
            
            int fila = ps.executeUpdate();
            
            if(fila == 0){
                throw new IllegalArgumentException("No se actulizo nada" + t.getId());
            }
            
        } catch(SQLException e){
            throw new IllegalArgumentException("Sucedio un error: ", e);
        }
    }

    @Override
    public void eliminar(int id) {
        try{
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("DELETE FROM almacenamiento WHERE id = ?");
            ps.setInt(1, id);
            
            int fila = ps.executeUpdate();
            if (fila == 0) {
                throw new IllegalArgumentException("No se encontro que eliminar con el ID: " + id);
            }
        } catch(SQLException e){
            throw new IllegalArgumentException("Sucedio un error: ", e);
        }
    }

}
