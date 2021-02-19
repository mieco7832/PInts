package com.pints.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
@Table(name = "detalleSolicitud")
public class DetalleSolicitud implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleSolicitud;
    @JoinColumn(name = "idSolicitudProducto", referencedColumnName = "idSolicitudProducto")
    @ManyToOne
    private SolicitudProducto idSolicitudProducto;
    @JoinColumn(name = "idPintura", referencedColumnName = "idPintura")
    @ManyToOne
    private Pintura idPintura;
    @Column(name = "cantidadSoli")
    private int cantidadSoli;

    public int getIdDetalleSolicitud() {
        return idDetalleSolicitud;
    }

    public void setIdDetalleSolicitud(int idDetalleSolicitud) {
        this.idDetalleSolicitud = idDetalleSolicitud;
    }

    public SolicitudProducto getIdSolicitudProducto() {
        return idSolicitudProducto;
    }

    public void setIdSolicitudProducto(SolicitudProducto idSolicitudProducto) {
        this.idSolicitudProducto = idSolicitudProducto;
    }

    public Pintura getIdPintura() {
        return idPintura;
    }

    public void setIdPintura(Pintura idPintura) {
        this.idPintura = idPintura;
    }

    public int getCantidadSoli() {
        return cantidadSoli;
    }

    public void setCantidadSoli(int cantidadSoli) {
        this.cantidadSoli = cantidadSoli;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idDetalleSolicitud);
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
        final DetalleSolicitud other = (DetalleSolicitud) obj;
        if (!Objects.equals(this.idDetalleSolicitud, other.idDetalleSolicitud)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleSolicitud{" + "idDetalleSolicitud=" + idDetalleSolicitud + '}';
    }

    public DetalleSolicitud() {
    }
}
