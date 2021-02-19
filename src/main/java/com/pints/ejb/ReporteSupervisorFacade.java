package com.pints.ejb;

import com.pints.entity.ReporteSupervisor;
import com.pints.util.AbstractFacade;
import com.pints.util.Repositorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "reporteSupervisor")
public class ReporteSupervisorFacade extends AbstractFacade<ReporteSupervisor> implements Repositorio<ReporteSupervisor> {

    @PersistenceContext(unitName = "sourcePints")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReporteSupervisorFacade() {
        super(ReporteSupervisor.class);
    }
    
}
