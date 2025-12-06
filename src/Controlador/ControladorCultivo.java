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

    public boolean crearCultivo(int id, String nombre, TipoCultivo tipo,double area, EstadoCrecimiento estado,LocalDate siembra, LocalDate cosecha) {
        try {
            facade.getServicioCultivo().crear(id, nombre, tipo, area, estado, siembra, cosecha);
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public List<CultivoDTO> listar() {
        return facade.getServicioCultivo().listar();
    }

    public boolean eliminar(int id) {
        try {
            facade.getServicioCultivo().eliminar(id);
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
