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
@Table(name = "reporteGerente")
public class ReporteGerente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReporteGerente;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaReporteGerente")
    private Date fechaReporteGerente;
    @JoinColumn(name = "idReporteJefe", referencedColumnName = "idReporteJefe")
    @ManyToOne
    private ReporteJefe idReporteJefe;
    @JoinColumn(name = "idUsuario", referencedColumnName = "doc")
    @ManyToOne
    private Usuario idUsuario;

    public int getIdReporteGerente() {
        return idReporteGerente;
    }

    public void setIdReporteGerente(int idReporteGerente) {
        this.idReporteGerente = idReporteGerente;
    }

    public Date getFechaReporteGerente() {
        return fechaReporteGerente;
    }

    public void setFechaReporteGerente(Date fechaReporteGerente) {
        this.fechaReporteGerente = fechaReporteGerente;
    }

    public ReporteJefe getIdReporteJefe() {
        return idReporteJefe;
    }

    public void setIdReporteJefe(ReporteJefe idReporteJefe) {
        this.idReporteJefe = idReporteJefe;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idReporteGerente;
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
        final ReporteGerente other = (ReporteGerente) obj;
        if (this.idReporteGerente != other.idReporteGerente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReporteGerente{" + "idReporteGerente=" + idReporteGerente + '}';
    }

    public ReporteGerente() {
    }

}
