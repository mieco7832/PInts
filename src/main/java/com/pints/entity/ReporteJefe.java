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
@Table(name = "reporteJefe")
public class ReporteJefe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReporteJefe;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaReporteJefe")
    private Date fechaReporteJefe;
    @JoinColumn(name = "idReporteOperario", referencedColumnName = "idReporteOperario")
    @ManyToOne
    private ReporteOperario idReporteOperario;
    @JoinColumn(name = "idUsuario", referencedColumnName = "doc")
    @ManyToOne
    private Usuario idUsuario;

    public int getIdReporteJefe() {
        return idReporteJefe;
    }

    public void setIdReporteJefe(int idReporteJefe) {
        this.idReporteJefe = idReporteJefe;
    }

    public Date getFechaReporteJefe() {
        return fechaReporteJefe;
    }

    public void setFechaReporteJefe(Date fechaReporteJefe) {
        this.fechaReporteJefe = fechaReporteJefe;
    }

    public ReporteOperario getIdReporteOperario() {
        return idReporteOperario;
    }

    public void setIdReporteOperario(ReporteOperario idReporteOperario) {
        this.idReporteOperario = idReporteOperario;
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
        hash = 97 * hash + this.idReporteJefe;
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
        final ReporteJefe other = (ReporteJefe) obj;
        if (this.idReporteJefe != other.idReporteJefe) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReporteJefe{" + "idReporteJefe=" + idReporteJefe + '}';
    }

    public ReporteJefe() {
    }
}
