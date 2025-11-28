package Modelo.Mappers;

import Modelo.Dtos.AlmacenamientoDTO;
import Modelo.Objetos.Almacenamientos.Almacenamiento;

/**
 *
 * @author Ricardo Chaves
 */

public class AlmacenamientoMapper {
    public AlmacenamientoDTO toDTO(Almacenamiento almacenamiento){
        AlmacenamientoDTO almacenDTO = new AlmacenamientoDTO(almacenamiento.getId(), almacenamiento.getProducto(), almacenamiento.getCantidad(), almacenamiento.getFechaIngreso(), almacenamiento.getFechaSalida());
        return almacenDTO;
    }
    
    public Almacenamiento toEntity(AlmacenamientoDTO almacenamientodto){
        Almacenamiento almacenamiento = new Almacenamiento(almacenamientodto.getId(), almacenamientodto.getProducto(), almacenamientodto.getCantidad(), almacenamientodto.getFechaIngreso(), almacenamientodto.getFechaSalida());
        return almacenamiento;
    }
}
