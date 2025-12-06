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
    
    public boolean crearTrabajador(Integer cedula, String nombre, String telefono, String correo, String puesto, String horario, double salario)throws Exception{
        try{
            facade.getServicioTrabajador().crear(cedula, nombre, telefono, correo, puesto, horario, salario);
            return true;
        } catch(Exception e){
            throw new Exception(e.getMessage(), e);
        }
    }
    
    public List<TrabajadorDTO> obtenerTodosTrabajadores()throws Exception{
        try{
            return facade.getServicioTrabajador().listar();
        }catch(Exception e){
            throw new Exception(e.getMessage(), e);
        }
    }
    
    public TrabajadorDTO buscarPorCedula(Integer cedula)throws Exception{
        try{
            return facade.getServicioTrabajador().buscarPorCedula(cedula);
        }catch (Exception e){
            throw new Exception(e.getMessage(),e);
        }
    }
    
    public List<TrabajadorDTO> buscarPorNombre(String nombre)throws Exception{
        try{
            return facade.getServicioTrabajador().buscarPorNombre(nombre);
        }catch(Exception e){
            throw new Exception(e.getMessage(), e);
        }
    }
    
    public List<TrabajadorDTO> buscarPorPuesto(String puesto)throws Exception{
        try{
            return facade.getServicioTrabajador().buscarPorPuesto(puesto);
        }catch(Exception e){
            throw new Exception(e.getMessage(), e);
        }
    }
    
   public boolean actualizarTrabajador(TrabajadorDTO dto)throws Exception{
        try{
            facade.getServicioTrabajador().actualizar(dto);
            return true;
        }catch(Exception e){
            throw new Exception(e.getMessage(), e);
        }
    }
    public boolean eliminarTrabajador(Integer cedula)throws Exception{
        try{
            facade.getServicioTrabajador().eliminar(cedula);
            return true;
        }catch (Exception e){
            throw new Exception(e.getMessage(), e);
        }
    }
    
    public String obtenerResumenTrabajador(TrabajadorDTO dto)throws Exception{
        try{
            if(dto == null)
                throw new Exception("Trabajador no disponible");
            return String.format("Cedula: %s | Nombre: %s | Telefono: %s | Correo: %s | Puesto: %s | Horario: %s | Salario: %.2f", dto.getCedula(),dto.getNombre(),dto.getTelefono(),dto.getCorreo(),dto.getPuesto(),dto.getHorario(),dto.getSalario());
        }catch(Exception e){
            throw new Exception(e.getMessage(), e);
        }
    }
}
