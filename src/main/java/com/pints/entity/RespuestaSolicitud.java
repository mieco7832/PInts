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
@Table(name = "respuestaSolicitud")
public class RespuestaSolicitud implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuestaSolicitud;
    @Column(name = "comentarioRespuesta")
    private String comentarioRespuesta;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaRespuesta")
    private Date fechaRespuesta;
    @JoinColumn(name = "idUsuario", referencedColumnName = "doc")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "idSolicitudProducto", referencedColumnName = "idSolicitudProducto")
    @ManyToOne
    private SolicitudProducto idSolicitudProducto;

    public int getIdRespuestaSolicitud() {
        return idRespuestaSolicitud;
    }

    public void setIdRespuestaSolicitud(int idRespuestaSolicitud) {
        this.idRespuestaSolicitud = idRespuestaSolicitud;
    }

    public String getComentarioRespuesta() {
        return comentarioRespuesta;
    }

    public void setComentarioRespuesta(String comentarioRespuesta) {
        this.comentarioRespuesta = comentarioRespuesta;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public SolicitudProducto getIdSolicitudProducto() {
        return idSolicitudProducto;
    }

    public void setIdSolicitudProducto(SolicitudProducto idSolicitudProducto) {
        this.idSolicitudProducto = idSolicitudProducto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.idRespuestaSolicitud;
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
        final RespuestaSolicitud other = (RespuestaSolicitud) obj;
        if (this.idRespuestaSolicitud != other.idRespuestaSolicitud) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RespuestaSolicitud{" + "idRespuestaSolicitud=" + idRespuestaSolicitud + '}';
    }

    public RespuestaSolicitud() {
    }

}
