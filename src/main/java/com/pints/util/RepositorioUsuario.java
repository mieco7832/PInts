
package com.pints.util;

import com.pints.entity.Usuario;
import java.util.List;
import javax.ejb.LocalBean;

@LocalBean
public interface RepositorioUsuario<T> {

    void create(T c);

    void edit(T c);

    void remove(T c);

    T find(Object id);

    List<T> findAll();
    
    Usuario login(String usuario, String clave);
}
