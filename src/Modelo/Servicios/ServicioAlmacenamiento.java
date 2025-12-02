package Modelo.Servicios;

import Modelo.Dtos.AlmacenamientoDTO;
import Modelo.Factory.DAOFactory;
import Modelo.Interfaces.IAlmacenamientoDAO;
import Modelo.Mappers.AlmacenamientoMapper;
import Modelo.Objetos.Almacenamientos.Almacenamiento;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Ricardo Chaves
 */

public class ServicioAlmacenamiento {
    
    private final IAlmacenamientoDAO almacenamientoDao;
    private final AlmacenamientoMapper almacenamientoMapper;

    public ServicioAlmacenamiento() {
        this.almacenamientoDao = DAOFactory.crearAlmacenamientoDAO();
        this.almacenamientoMapper = new AlmacenamientoMapper();
    }
    
    public List<AlmacenamientoDTO> buscarPorProducto(String nombre){
        return almacenamientoDao.buscarPorProducto(nombre);
    }
    
    public List<AlmacenamientoDTO> buscarPorFechaIngreso(LocalDate fecha){
        return almacenamientoDao.buscarPorFechaIngreso(fecha);
    }
    
    public List<AlmacenamientoDTO> buscarPorProductosVencidos(){
        return almacenamientoDao.productoVencidos();
    }
    
    public List<AlmacenamientoDTO> productosSinSalida() {
        return almacenamientoDao.productosSinSalida();
    }
    
    public void crear(String producto, double cantidad, LocalDate fechaIngreso, LocalDate fechaSalida) throws Exception {
        Almacenamiento almacenamiento = new Almacenamiento(producto, cantidad, fechaIngreso, fechaSalida);
        AlmacenamientoDTO adto = almacenamientoMapper.toDTO(almacenamiento);
        almacenamientoDao.crear(adto);
    }
    
    public List<AlmacenamientoDTO> listar(){
        return almacenamientoDao.listar();
    }
    
    public void actualizar(int id, LocalDate fechaSalida) throws Exception {
        List<AlmacenamientoDTO> almacenamiento = listar();
        AlmacenamientoDTO almacenamientoExistente = null;
        for (int i = 0; i < almacenamiento.size(); i++) {
            if (almacenamiento.get(i).getId().equals(id)) {
                almacenamientoExistente = almacenamiento.get(i);
                break;
            }
        }
        Almacenamiento almacenamientos = almacenamientoMapper.toEntity(almacenamientoExistente);
        almacenamientos.setFechaSalida(fechaSalida);
        AlmacenamientoDTO adto = almacenamientoMapper.toDTO(almacenamientos);
        almacenamientoDao.actualizar(adto);
    }
    
    public void eliminar(int id) throws Exception{
        almacenamientoDao.eliminar(id);
    }
}
