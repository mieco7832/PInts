package com.pints.ejb;

import com.pints.entity.ReporteOperario;
import com.pints.util.AbstractFacade;
import com.pints.util.Repositorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "reporteOperario")
public class ReporteOperarioFacade extends AbstractFacade<ReporteOperario> implements Repositorio<ReporteOperario> {

    @PersistenceContext(unitName = "sourcePints")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReporteOperarioFacade() {
        super(ReporteOperario.class);
    }

}
