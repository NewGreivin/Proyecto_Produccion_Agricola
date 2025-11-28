package Modelo.Factory;

import Modelo.Daos.AlmacenamientoMysqlDAO;
import Modelo.Daos.UsuarioMysqlDAO;
import Modelo.Interfaces.IAlmacenamientoDAO;
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
}
