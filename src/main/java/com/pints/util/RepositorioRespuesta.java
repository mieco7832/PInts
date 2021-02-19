
package com.pints.util;

import com.pints.entity.RespuestaSolicitud;
import com.pints.entity.SolicitudProducto;
import java.util.List;
import javax.ejb.LocalBean;

@LocalBean
public interface RepositorioRespuesta<T> {

    void create(T c);

    void edit(T c);

    void remove(T c);

    T find(Object id);

    List<T> findAll();
    
    RespuestaSolicitud whereIdSolictud(SolicitudProducto id);
    
}
