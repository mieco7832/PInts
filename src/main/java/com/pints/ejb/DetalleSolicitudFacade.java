package com.pints.ejb;

import com.pints.util.AbstractFacade;
import com.pints.entity.DetalleSolicitud;
import com.pints.util.Repositorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "detalleSolicitud")
public class DetalleSolicitudFacade extends AbstractFacade<DetalleSolicitud> implements Repositorio<DetalleSolicitud> {

    @PersistenceContext(unitName = "sourcePints")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleSolicitudFacade() {
        super(DetalleSolicitud.class);
    }
}
