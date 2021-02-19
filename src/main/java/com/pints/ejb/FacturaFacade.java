package com.pints.ejb;

import com.pints.util.AbstractFacade;
import com.pints.entity.Factura;
import com.pints.util.Repositorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "factura")
public class FacturaFacade extends AbstractFacade<Factura> implements Repositorio<Factura> {

    @PersistenceContext(unitName = "sourcePints")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaFacade() {
        super(Factura.class);
    }
    
}
