package Controlador;

import Modelo.Dtos.TrabajadorDTO;
import Modelo.Facade.ServicioFacade;
import java.util.List;

/**
 *
 * @author MARISOL
 */

public class ControladorTrabajador {
  private final ServicioFacade facade;

    public ControladorTrabajador() {
        this.facade = ServicioFacade.getInstancia();
    }
    
    public boolean crearTrabajador(Integer cedula, String nombre, String telefono, String correo, String puesto, String horario, double salario) throws Exception {
        facade.getServicioTrabajador().crear(cedula, nombre, telefono, correo, puesto, horario, salario);
        return true;
    }
    
    public List<TrabajadorDTO> obtenerTodosTrabajadores() throws Exception {
        return facade.getServicioTrabajador().listar();
    }
    
    public TrabajadorDTO buscarPorCedula(Integer cedula) throws Exception {
        return facade.getServicioTrabajador().buscarPorCedula(cedula);
    }
    
    public List<TrabajadorDTO> buscarPorNombre(String nombre) throws Exception {
        return facade.getServicioTrabajador().buscarPorNombre(nombre);
    }
    
    public List<TrabajadorDTO> buscarPorPuesto(String puesto) throws Exception {
        return facade.getServicioTrabajador().buscarPorPuesto(puesto);
    }
    
   public boolean actualizarTrabajador(TrabajadorDTO dto) throws Exception {
        facade.getServicioTrabajador().actualizar(dto);
        return true;
    }
    public boolean eliminarTrabajador(Integer cedula) throws Exception {
        facade.getServicioTrabajador().eliminar(cedula);
        return true;
    }
    
    public String obtenerResumenTrabajador(TrabajadorDTO dto) throws Exception {
        if(dto == null)
            throw new Exception("Trabajador no disponible");
        return String.format("Cedula: %s | Nombre: %s | Telefono: %s | Correo: %s | Puesto: %s | Horario: %s | Salario: %.2f",
                dto.getCedula(),dto.getNombre(),dto.getTelefono(),dto.getCorreo(),dto.getPuesto(),dto.getHorario(),dto.getSalario());
    }
}
