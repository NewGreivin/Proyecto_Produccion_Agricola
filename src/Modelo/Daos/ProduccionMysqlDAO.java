package Modelo.Daos;

import Db.ConexionBD;
import Modelo.Dtos.ProduccionDTO;
import Modelo.Interfaces.IProduccionDAO;
import Modelo.Mappers.ProduccionMapper;
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
        private final ProduccionMapper mapper;

    public ProduccionMysqlDAO() {
        conexion = ConexionBD.getInstance();
        mapper = new ProduccionMapper();
    }
    
    @Override
    public List<ProduccionDTO> buscarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ProduccionDTO> buscarPorCultivo(String idCultivo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ProduccionDTO> buscarPorDestino(String destino) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ProduccionDTO> buscarPorFecha(String fecha) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ProduccionDTO> buscarPorCalidad(String calidad) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void crear(ProduccionDTO t) {
        String sql = "INSERT INTO produccion (fecha, cantidad_recolectada, calidad, destino, id_cultivo) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = conexion.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, t.getFecha().toString());
            pst.setDouble(2, t.getCantidadRecolectada());
            pst.setString(3, t.getCalidad().name());
            pst.setString(4, t.getDestino().name());
            pst.setString(5, t.getIdCultivo().getId());
            pst.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<ProduccionDTO> listar() {
    throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizar(ProduccionDTO t) {

    }

    @Override
    public void eliminar(String t) {

    }

}