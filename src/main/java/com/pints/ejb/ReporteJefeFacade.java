
package com.pints.ejb;

import com.pints.util.AbstractFacade;
import com.pints.entity.ReporteJefe;
import com.pints.util.Repositorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "reporteJefe")
public class ReporteJefeFacade extends AbstractFacade<ReporteJefe> implements Repositorio<ReporteJefe> {

    @PersistenceContext(unitName = "sourcePints")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReporteJefeFacade() {
        super(ReporteJefe.class);
    }
    
}
