package com.pints.ejb;

import com.pints.entity.RespuestaSolicitud;
import com.pints.util.AbstractFacade;
import com.pints.util.Repositorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "respuestaSolicitud")
public class RespuestaSolicitudFacade extends AbstractFacade<RespuestaSolicitud> implements Repositorio<RespuestaSolicitud> {

    @PersistenceContext(unitName = "sourcePints")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RespuestaSolicitudFacade() {
        super(RespuestaSolicitud.class);
    }

}
