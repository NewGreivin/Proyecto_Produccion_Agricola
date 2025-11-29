package Modelo.Mappers;

import Modelo.Dtos.CosechaDTO;
import Modelo.Objetos.Cosechas.Cosecha;

/**
 *
 * @author Greivin
 */

public class CosechaMapper {
    public CosechaDTO toDTO(Cosecha cosecha){
        CosechaDTO coseDTO = new CosechaDTO(cosecha.getId(),cosecha.getFecha(),cosecha.getCantidadRecolectada(),
            cosecha.getCalidad(),cosecha.getDestino(),cosecha.getIdCultivo());
        return coseDTO;
    }
    
    public Cosecha toEntity(CosechaDTO dto){
        Cosecha cose = new Cosecha(dto.getFecha(),dto.getCantidadRecolectada(),dto.getCalidad(),
                dto.getDestino(),dto.getIdCultivo());
        return cose;
    }
}
