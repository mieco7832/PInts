package com.pints.ejb;

import com.pints.entity.ReporteGerente;
import com.pints.util.AbstractFacade;
import com.pints.util.Repositorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "reporteGerente")
public class ReporteGerenteFacade extends AbstractFacade<ReporteGerente> implements Repositorio<ReporteGerente> {

    @PersistenceContext(unitName = "sourcePints")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReporteGerenteFacade() {
        super(ReporteGerente.class);
    }
}
