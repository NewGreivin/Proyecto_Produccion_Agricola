package Modelo.Factory;

import Modelo.Daos.UsuarioMysqlDAO;
import Modelo.Interfaces.IUsuarioDAO;

/**
 *
 * @author TODOS
 */

public class DAOFactory {
    public static IUsuarioDAO getUsuarioDAO(){
        return new UsuarioMysqlDAO();
    }
}
