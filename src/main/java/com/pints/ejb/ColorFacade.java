package com.pints.ejb;

import com.pints.util.AbstractFacade;
import com.pints.entity.Color;
import com.pints.util.Repositorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "color")
public class ColorFacade extends AbstractFacade<Color> implements Repositorio<Color> {

    @PersistenceContext(unitName = "sourcePints")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ColorFacade() {
        super(Color.class);
    }
    
}
