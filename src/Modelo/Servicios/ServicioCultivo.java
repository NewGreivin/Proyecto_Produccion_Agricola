package Modelo.Servicios;

import Modelo.Daos.CultivoMysqlDAO;
import Modelo.Dtos.CultivoDTO;
import Modelo.Mappers.CultivoMapper;
import Modelo.Objetos.Cultivos.Cultivo;
import Modelo.Objetos.Cultivos.EstadoCrecimiento;
import Modelo.Objetos.Cultivos.TipoCultivo;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author MARISOL
 */

public class ServicioCultivo {
    private final CultivoMysqlDAO cultivoDAO;
    private final CultivoMapper mapper;

    public ServicioCultivo() {
        this.cultivoDAO = new CultivoMysqlDAO();
        this.mapper = new CultivoMapper();
    }

    public void crear(int id, String nombre, TipoCultivo tipo,double area, EstadoCrecimiento estado,LocalDate siembra, LocalDate cosecha) throws Exception {
        List<CultivoDTO> existentes = cultivoDAO.listar();
        for (CultivoDTO c : existentes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                throw new Exception("Ya existe un cultivo con ese nombre");
            }
        }
        Cultivo cultivo = new Cultivo(id, nombre, tipo, area, estado, siembra, cosecha);
        cultivoDAO.crear(mapper.toDTO(cultivo));
    }

    public List<CultivoDTO> listar() {
        return cultivoDAO.listar();
    }

    public List<CultivoDTO> buscarPorTipo(String tipo) {
        return cultivoDAO.buscarPorTipo(tipo);
    }

    public List<CultivoDTO> buscarPorEstado(String estado) {
        return cultivoDAO.buscarPorEstado(estado);
    }

    public void actualizar(CultivoDTO dto) throws Exception {
        cultivoDAO.actualizar(dto);
    }

    public void eliminar(int id) {
        cultivoDAO.eliminar(id);
    }
}
