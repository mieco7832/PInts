package com.pints.ejb;

import com.pints.util.AbstractFacade;
import com.pints.entity.Pintura;
import com.pints.util.Repositorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "pintura")
public class PinturaFacade extends AbstractFacade<Pintura> implements Repositorio<Pintura> {

    @PersistenceContext(unitName = "sourcePints")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PinturaFacade() {
        super(Pintura.class);
    }
}
