package Modelo.Mappers;

import Modelo.Dtos.CultivoDTO;
import Modelo.Objetos.Cultivos.Cultivo;

/**
 *
 * @author MARISOL
 */

public class CultivoMapper {
    public CultivoDTO toDTO(Cultivo mp){
        CultivoDTO cult = new CultivoDTO(mp.getId(),mp.getNombre(),mp.getTipo(),mp.getAreaSembrada(),mp.getEstado(),mp.getFechaSiembra(),mp.getFechaEstimCosecha());
        return cult;
    }

    public Cultivo toEntity(CultivoDTO mpdto) {
        Cultivo cult = new Cultivo(mpdto.getId(),mpdto.getNombre(),mpdto.getTipo(),mpdto.getAreaSembrada(),mpdto.getEstado(),mpdto.getFechaSiembra(),mpdto.getFechaEstimCosecha());

        return cult;
    }
}
