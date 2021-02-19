package com.pints.ejb;

import com.pints.util.AbstractFacade;
import com.pints.entity.DetalleFactura;
import com.pints.util.Repositorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "detalleFactura")
public class DetalleFacturaFacade extends AbstractFacade<DetalleFactura> implements Repositorio<DetalleFactura> {

    @PersistenceContext(unitName = "sourcePints")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleFacturaFacade() {
        super(DetalleFactura.class);
    }
    
}
