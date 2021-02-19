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
@Table(name = "reporteOperario")
public class ReporteOperario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReporteOperario;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaReporteOperario")
    private Date fechaReporteOperario;
    @JoinColumn(name = "idDetalleSolicitud", referencedColumnName = "idDetalleSolicitud")
    @ManyToOne
    private DetalleSolicitud idDetalleSolicitud;
    @JoinColumn(name = "idUsuario", referencedColumnName = "doc")
    @ManyToOne
    private Usuario idUsuario;

    public int getIdReporteOperario() {
        return idReporteOperario;
    }

    public void setIdReporteOperario(int idReporteOperario) {
        this.idReporteOperario = idReporteOperario;
    }

    public Date getFechaReporteOperario() {
        return fechaReporteOperario;
    }

    public void setFechaReporteOperario(Date fechaReporteOperario) {
        this.fechaReporteOperario = fechaReporteOperario;
    }

    public DetalleSolicitud getIdDetalleSolicitud() {
        return idDetalleSolicitud;
    }

    public void setIdDetalleSolicitud(DetalleSolicitud idDetalleSolicitud) {
        this.idDetalleSolicitud = idDetalleSolicitud;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.idReporteOperario;
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
        final ReporteOperario other = (ReporteOperario) obj;
        if (this.idReporteOperario != other.idReporteOperario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReporteOperario{" + "idReporteOperario=" + idReporteOperario + '}';
    }

    public ReporteOperario() {
    }
}
