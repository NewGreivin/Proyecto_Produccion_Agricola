package Modelo.Mappers;

import Modelo.Dtos.TrabajadorDTO;
import Modelo.Objetos.Trabajadores.Trabajador;

/**
 *
 * @author MARISOL
 */

public class TrabajadorMapper {
    public TrabajadorDTO toDTO(Trabajador mp) {
        TrabajadorDTO trab = new TrabajadorDTO(mp.getCedula(),mp.getNombre(),mp.getTelefono(),mp.getCorreo(),mp.getPuesto(),mp.getHorario(),mp.getSalario());
        return trab;
    }

    public Trabajador toEntity(TrabajadorDTO mpdto) throws Exception {
        Trabajador trab = new Trabajador(mpdto.getCedula(),mpdto.getNombre(),mpdto.getTelefono(),mpdto.getCorreo(),mpdto.getPuesto(),mpdto.getHorario(),mpdto.getSalario());
        return trab;
    }
}
