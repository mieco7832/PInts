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
@Table(name = "solicitudProducto")
public class SolicitudProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSolicitudProducto;
    @Column(name = "correlativods")
    private String correlativods;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "estado")
    private String estado;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaSoli")
    private Date fechaSoli;
    @JoinColumn(name = "idUsuario", referencedColumnName = "doc")
    @ManyToOne
    private Usuario idUsuario;

    public int getIdSolicitudProducto() {
        return idSolicitudProducto;
    }

    public void setIdSolicitudProducto(int idSolicitudProducto) {
        this.idSolicitudProducto = idSolicitudProducto;
    }

    public String getCorrelativods() {
        return correlativods;
    }

    public void setCorrelativods(String correlativods) {
        this.correlativods = correlativods;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaSoli() {
        return fechaSoli;
    }

    public void setFechaSoli(Date fechaSoli) {
        this.fechaSoli = fechaSoli;
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
        hash = 29 * hash + Objects.hashCode(this.idSolicitudProducto);
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
        final SolicitudProducto other = (SolicitudProducto) obj;
        if (!Objects.equals(this.idSolicitudProducto, other.idSolicitudProducto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SolicitudProducto{" + "idSolicitudProducto=" + idSolicitudProducto + '}';
    }

    public SolicitudProducto() {
    }
}
