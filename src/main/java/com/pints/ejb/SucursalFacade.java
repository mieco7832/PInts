package com.pints.ejb;

import com.pints.entity.Sucursal;
import com.pints.util.AbstractFacade;
import com.pints.util.Repositorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "sucursal")
public class SucursalFacade extends AbstractFacade<Sucursal> implements Repositorio<Sucursal> {

    @PersistenceContext(unitName = "sourcePints")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SucursalFacade() {
        super(Sucursal.class);
    }

}
