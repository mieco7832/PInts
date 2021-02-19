
package com.pints.ejb;

import com.pints.util.AbstractFacade;
import com.pints.entity.Base;
import com.pints.util.Repositorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "base")
public class BaseFacade extends AbstractFacade<Base> implements Repositorio<Base> {

    @PersistenceContext(unitName = "sourcePints")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BaseFacade() {
        super(Base.class);
    }
    
}
