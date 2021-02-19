package com.pints.ejb;

import com.pints.util.AbstractFacade;
import com.pints.entity.Marca;
import com.pints.util.Repositorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "marca")
public class MarcaFacade extends AbstractFacade<Marca> implements Repositorio<Marca> {

    @PersistenceContext(unitName = "sourcePints")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarcaFacade() {
        super(Marca.class);
    }
    
}
