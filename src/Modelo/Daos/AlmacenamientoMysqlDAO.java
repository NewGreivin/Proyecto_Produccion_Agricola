package Modelo.Daos;

import Db.ConexionBD;
import Modelo.Dtos.AlmacenamientoDTO;
import Modelo.Interfaces.IAlmacenamientoDAO;
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
            PreparedStatement ps = cn.prepareStatement("SELECT id, producto, cantidad, fecha_ingreso, fecha_salida FROM almacenamiento WHERE producto = ?");
            ps.setString(1, nombre);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                AlmacenamientoDTO adto = new AlmacenamientoDTO(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4).toLocalDate(), rs.getDate(5).toLocalDate());
                lista.add(adto);
            }
        } catch (SQLException e){
            throw new IllegalArgumentException("Se genero un error", e);
        } 
        return lista;
    }

    @Override
    public List<AlmacenamientoDTO> buscarPorFechaIngreso(LocalDate fecha) {
        List<AlmacenamientoDTO> lista = new ArrayList<>();
        
        try {
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("SELECT id, producto, cantidad, fecha_ingreso, fecha_salida FROM almacenamiento WHERE fecha_ingreso = ?");
            ps.setString(1, fecha.toString());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                AlmacenamientoDTO adto = new AlmacenamientoDTO(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4).toLocalDate(), rs.getDate(5).toLocalDate());
                lista.add(adto);
            } 
        } catch(SQLException e) {
            throw new IllegalArgumentException("Se produjo un error", e);
        }
        return lista;
    }

    @Override
    public List<AlmacenamientoDTO> productoVencidos() {
        List<AlmacenamientoDTO> lista = new ArrayList<>();
        
        try {
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("SELECT id, producto, cantidad, fecha_ingreso, fecha_salida FROM almacenamiento WHERE fecha_salida < CURDATE()");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                AlmacenamientoDTO adto = new AlmacenamientoDTO(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4).toLocalDate(), rs.getDate(5).toLocalDate());
                lista.add(adto);
            }
        } catch(SQLException e){
            throw new IllegalArgumentException("Se produjo un error en el listado: ", e);
        }
        return lista;
    }

    @Override
    public List<AlmacenamientoDTO> productosSinSalida() {
        List<AlmacenamientoDTO> lista = new ArrayList<>();
        
        try{
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("SELECT id, producto, cantidad, fecha_ingreso, fecha_salida FROM almacenamiento WHERE fecha_salida = fecha_ingreso");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                AlmacenamientoDTO adto = new AlmacenamientoDTO(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4).toLocalDate(), rs.getDate(5).toLocalDate());
                lista.add(adto);
            }
        } catch(SQLException e){
            throw new IllegalArgumentException("Se produjo un error en el listado", e);
        }
        return lista;
    }

    @Override
    public void crear(AlmacenamientoDTO t) {
        try {
            Connection cn = conexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO almacenamiento(producto, cantidad, fecha_ingreso, fecha_salida) VALUES (?, ?, ?, ?)");
            
            
            ps.setString(1, t.getProducto());
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
            PreparedStatement ps = cn.prepareStatement("SELECT id, producto, cantidad, fecha_ingreso, fecha_salida FROM almacenamiento");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                AlmacenamientoDTO adto = new AlmacenamientoDTO(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4).toLocalDate(), rs.getDate(5).toLocalDate());
                lista.add(adto);
            }
        } catch(SQLException e) {
            throw new IllegalArgumentException("No se pudo lista: ", e);
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
