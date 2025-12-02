package Modelo.Interfaces;

import java.util.List;

/**
 *
 * @author Ricardo Chaves
 */

public interface ICRUD <T> {
    void crear(T t);
    List<T> listar();
    void actualizar(T t);
    void eliminar(int t);
}
