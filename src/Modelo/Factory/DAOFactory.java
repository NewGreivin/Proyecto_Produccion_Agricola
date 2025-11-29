package Modelo.Factory;

import Modelo.Daos.AlmacenamientoMysqlDAO;
import Modelo.Daos.CultivoMysqlDAO;
import Modelo.Daos.TrabajadorMysqlDAO;
import Modelo.Daos.UsuarioMysqlDAO;
import Modelo.Interfaces.IAlmacenamientoDAO;
import Modelo.Interfaces.ICultivoDAO;
import Modelo.Interfaces.ITrabajadorDAO;
import Modelo.Interfaces.IUsuarioDAO;

/**
 *
 * @author TODOS
 */

public class DAOFactory {
    public static IUsuarioDAO getUsuarioDAO(){
        return new UsuarioMysqlDAO();
    }
    
    public static IAlmacenamientoDAO getAlmacenamientoDAO(){
        return new AlmacenamientoMysqlDAO();
    }
    
    public static ICultivoDAO getCultivoDAO(){
        return new CultivoMysqlDAO();
    }
    
    public static ITrabajadorDAO getTrabajadorDAO(){
       return new TrabajadorMysqlDAO(); 
    }
}
