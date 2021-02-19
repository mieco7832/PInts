
package com.pints.util;

import java.util.List;
import javax.ejb.LocalBean;

@LocalBean
public interface RepositorioDetalleSolicitud<T> {
    
    List<T> listaGrupBySolicitudProducto();
    
    List<T> listaWhereID(Object id);
    
    void create(T c);

    void edit(T c);

    void remove(T c);

    T find(Object id);

    List<T> findAll();
}
