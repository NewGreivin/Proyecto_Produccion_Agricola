package Modelo.Mappers;

import Modelo.Dtos.ProduccionDTO;
import Modelo.Objetos.Produccion.Produccion;

/**
 *
 * @author Greivin
 */

public class ProduccionMapper {
    public ProduccionDTO toDTO(Produccion cosecha){
        ProduccionDTO coseDTO = new ProduccionDTO(cosecha.getId(),cosecha.getFecha(),cosecha.getCantidadRecolectada(),
            cosecha.getCalidad(),cosecha.getDestino(),cosecha.getIdCultivo());
        return coseDTO;
    }
    
    public Produccion toEntity(ProduccionDTO dto) throws Exception{
        Produccion cose = new Produccion(dto.getId(), dto.getFecha(),dto.getCantidadRecolectada(),dto.getCalidad(),
                dto.getDestino(),dto.getIdCultivo());
        return cose;
    }
}
