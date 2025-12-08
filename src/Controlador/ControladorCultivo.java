package Controlador;

import Modelo.Dtos.CultivoDTO;
import Modelo.Facade.ServicioFacade;
import Modelo.Objetos.Cultivos.EstadoCrecimiento;
import Modelo.Objetos.Cultivos.TipoCultivo;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author MARISOL
 */

public class ControladorCultivo {
    private final ServicioFacade facade;

    public ControladorCultivo() {
        this.facade = ServicioFacade.getInstancia();
    }

    public boolean crearCultivo(String nombre, TipoCultivo tipo,double area, EstadoCrecimiento estado,LocalDate siembra, LocalDate cosecha) throws Exception {
        facade.getServicioCultivo().crear(nombre, tipo, area, estado, siembra, cosecha);
        return true;
    }

    public List<CultivoDTO> listar() throws Exception {
        return facade.getServicioCultivo().listar();
    }

    public boolean eliminar(int id) throws Exception {
        facade.getServicioCultivo().eliminar(id);
        return true;
    }

    public List<CultivoDTO> buscarPorTipo(TipoCultivo tipo) throws Exception {
        if (tipo == null) return List.of();
        return facade.getServicioCultivo().buscarPorTipo(tipo.name());
    }

    public List<CultivoDTO> buscarPorEstado(EstadoCrecimiento estado) throws Exception {
        if (estado == null) return List.of();
        return facade.getServicioCultivo().buscarPorEstado(estado.name());
    }

    public boolean actualizarCultivo(CultivoDTO dto) throws Exception {
        facade.getServicioCultivo().actualizar(dto);
        return true;
    }
}

