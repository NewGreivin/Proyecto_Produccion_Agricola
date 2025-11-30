package Modelo.Factory;

import Modelo.Daos.AlmacenamientoMysqlDAO;
import Modelo.Daos.CultivoMysqlDAO;
import Modelo.Daos.ProduccionMysqlDAO;
import Modelo.Daos.TrabajadorMysqlDAO;
import Modelo.Daos.UsuarioMysqlDAO;
import Modelo.Interfaces.IAlmacenamientoDAO;
import Modelo.Interfaces.ICultivoDAO;
import Modelo.Interfaces.IProduccionDAO;
import Modelo.Interfaces.ITrabajadorDAO;
import Modelo.Interfaces.IUsuarioDAO;

/**
 *
 * @author TODOS
 */

public class DAOFactory {
    public static IUsuarioDAO crearUsuarioDAO(){ return new UsuarioMysqlDAO(); }
    public static IAlmacenamientoDAO crearAlmacenamientoDAO(){ return new AlmacenamientoMysqlDAO(); }
    public static IProduccionDAO crearProduccionDAO(){ return new ProduccionMysqlDAO(); }  
    public static ICultivoDAO crearCultivoDAO(){ return new CultivoMysqlDAO(); }
    public static ITrabajadorDAO crearTrabajadorDAO(){ return new TrabajadorMysqlDAO();  }
}
