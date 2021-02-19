package com.pints.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "reporteSupervisor")
public class ReporteSupervisor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReporteSupervisor;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaReporteSupervisor")
    private Date fechaReporteSupervisor;
    @JoinColumn(name = "idReporteGerente", referencedColumnName = "idReporteGerente")
    @ManyToOne
    private ReporteGerente idReporteGerente;
    @JoinColumn(name = "idUsuario", referencedColumnName = "doc")
    @ManyToOne
    private Usuario idUsuario;

    public int getIdReporteSupervisor() {
        return idReporteSupervisor;
    }

    public void setIdReporteSupervisor(int idReporteSupervisor) {
        this.idReporteSupervisor = idReporteSupervisor;
    }

    public Date getFechaReporteSupervisor() {
        return fechaReporteSupervisor;
    }

    public void setFechaReporteSupervisor(Date fechaReporteSupervisor) {
        this.fechaReporteSupervisor = fechaReporteSupervisor;
    }

    public ReporteGerente getIdReporteGerente() {
        return idReporteGerente;
    }

    public void setIdReporteGerente(ReporteGerente idReporteGerente) {
        this.idReporteGerente = idReporteGerente;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idReporteSupervisor;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReporteSupervisor other = (ReporteSupervisor) obj;
        if (this.idReporteSupervisor != other.idReporteSupervisor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReporteSupervisor{" + "idReporteSupervisor=" + idReporteSupervisor + '}';
    }

    public ReporteSupervisor() {
    }

}
