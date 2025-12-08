package Modelo.Mappers;

import Modelo.Dtos.AlmacenamientoDTO;
import Modelo.Objetos.Almacenamientos.Almacenamiento;

/**
 *
 * @author Ricardo Chaves
 */

public class AlmacenamientoMapper {
    public AlmacenamientoDTO toDTO(Almacenamiento almacenamiento){
        Integer id = almacenamiento.getId() == 0 ? null : almacenamiento.getId();
        AlmacenamientoDTO almacenDTO = new AlmacenamientoDTO(id, almacenamiento.getCultivo(), almacenamiento.getCantidad(), almacenamiento.getFechaIngreso(), almacenamiento.getFechaSalida());
        return almacenDTO;
    }
    
    public Almacenamiento toEntity(AlmacenamientoDTO almacenamientodto){
        Almacenamiento almacenamiento = new Almacenamiento(almacenamientodto.getId(), almacenamientodto.getCultivo(), almacenamientodto.getCantidad(), almacenamientodto.getFechaIngreso(), almacenamientodto.getFechaSalida());
        return almacenamiento;
    }
}
