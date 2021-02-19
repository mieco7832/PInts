
package com.pints.util;

import com.pints.entity.SolicitudProducto;
import java.util.List;
import javax.ejb.LocalBean;

@LocalBean
public interface RepositorioSolicitud<T> {

    void create(T c);

    void edit(T c);

    void remove(T c);

    T find(Object id);

    List<T> findAll();
    
    SolicitudProducto obtenerSolictudById(int i);
    
    SolicitudProducto solicitudesActivas();
}
