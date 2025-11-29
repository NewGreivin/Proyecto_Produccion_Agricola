package Modelo.Mappers;

import Modelo.Dtos.CosechaDTO;
import Modelo.Objetos.Cosechas.Cosecha;

/**
 *
 * @author Greivin
 */

public class CosechaMapper {
    public CosechaDTO toDTO(Cosecha cosecha){
        CosechaDTO coseDTO = new CosechaDTO();
        return coseDTO;
    }
    
    public Cosecha toEntity(CosechaDTO dto){
        Cosecha cose = new Cosecha();
        return cose;
    }
}
