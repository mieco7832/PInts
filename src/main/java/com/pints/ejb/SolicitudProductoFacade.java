
package com.pints.ejb;

import com.pints.util.AbstractFacade;
import com.pints.entity.SolicitudProducto;
import com.pints.util.Repositorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "solicitudProducto")
public class SolicitudProductoFacade extends AbstractFacade<SolicitudProducto> implements Repositorio<SolicitudProducto> {

    @PersistenceContext(unitName = "sourcePints")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudProductoFacade() {
        super(SolicitudProducto.class);
    }
}
