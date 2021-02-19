package com.pints.ejb;

import com.pints.util.AbstractFacade;
import com.pints.entity.Presentacion;
import com.pints.util.Repositorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "presentacion")
public class PresentacionFacade extends AbstractFacade<Presentacion> implements Repositorio<Presentacion> {

    @PersistenceContext(unitName = "sourcePints")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresentacionFacade() {
        super(Presentacion.class);
    }
    
}
