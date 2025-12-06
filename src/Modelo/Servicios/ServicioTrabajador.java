package Modelo.Servicios;

import Modelo.Dtos.TrabajadorDTO;
import Modelo.Factory.DAOFactory;
import Modelo.Interfaces.ITrabajadorDAO;
import Modelo.Mappers.TrabajadorMapper;
import Modelo.Objetos.Trabajadores.Trabajador;
import java.util.List;

/**
 *
 * @author MARISOL
 */

public class ServicioTrabajador {
    private final ITrabajadorDAO trabajadorDAO;
    private final TrabajadorMapper mapper;

    public ServicioTrabajador(ITrabajadorDAO trabajadorDAO, TrabajadorMapper mapper) {
        this.trabajadorDAO = DAOFactory.crearTrabajadorDAO();
        this.mapper = new TrabajadorMapper();
    }
    
    public void crear(int cedula, String nombre, String telefono, String correo, String puesto, String horario, double salario)throws Exception{
       
        if(trabajadorDAO.buscarPorCedula(cedula) != null){
            throw new Exception("Ya existe un trabajador con esta cedula");
    }
    
    Trabajador trabajador = new Trabajador(cedula, nombre, telefono, correo, puesto, horario, salario);
    TrabajadorDTO dto = mapper.toDTO(trabajador);
    trabajadorDAO.crear(dto);
    }
    
    public List<TrabajadorDTO> listar(){
       return trabajadorDAO.listar();
    }
    
    public TrabajadorDTO buscarPorCedula(Integer cedula){
        return trabajadorDAO.buscarPorCedula(cedula);
    }
    
    public List<TrabajadorDTO> buscarPorNombre(String nombre){
        return trabajadorDAO.buscarPorNombre(nombre);
    }
    
    public List<TrabajadorDTO> buscarPorPuesto(String puesto){
        return trabajadorDAO.buscarPorPuesto(puesto);
    }
    
    public void actualizar(TrabajadorDTO dto)throws Exception{
        if(dto == null || dto.getCedula() == null){
            throw new Exception("Datos invalidos para actualizar");
        }
        
        if(trabajadorDAO.buscarPorCedula(dto.getCedula()) == null){
            throw new Exception("No existe trabajador con esa cedula");
        }
    
        Trabajador trabajador = mapper.toEntity(dto);
        TrabajadorDTO actualizado = mapper.toDTO(trabajador);
        trabajadorDAO.actualizar(actualizado);
    }
    
    public void eliminar(Integer cedula)throws Exception{
        if(cedula == null)
            throw new Exception("Cedula invalida");
        if(trabajadorDAO.buscarPorCedula(cedula) == null){
            throw new Exception("No existe trabajador con esa cedula");
        }
        trabajadorDAO.eliminar(cedula);
    }
}

