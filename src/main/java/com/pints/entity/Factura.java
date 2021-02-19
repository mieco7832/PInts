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
@Table(name = "factura")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idfactura;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaFactura")
    private Date fechaFactura;
    @JoinColumn(name = "idDetalleFactura", referencedColumnName = "idDetalleFactura")
    @ManyToOne
    private DetalleFactura idDetalleFactura;
    @JoinColumn(name = "idDetalleSolicitud", referencedColumnName = "idDetalleSolicitud")
    @ManyToOne
    private DetalleSolicitud idDetalleSolicitud;

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public DetalleFactura getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(DetalleFactura idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public DetalleSolicitud getIdDetalleSolicitud() {
        return idDetalleSolicitud;
    }

    public void setIdDetalleSolicitud(DetalleSolicitud idDetalleSolicitud) {
        this.idDetalleSolicitud = idDetalleSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idfactura;
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
        final Factura other = (Factura) obj;
        if (this.idfactura != other.idfactura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Factura{" + "idfactura=" + idfactura + '}';
    }

    public Factura() {
    }
}
