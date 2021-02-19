package com.pints.modelo;

import java.util.Date;

public class RespuestaModelo {

    private String comentario; //Respuesta de Solicitud
    private Date fechaRespuesta; //respuesta de Solictud
    private String bodeguero; //Usuario
    private String solicitud; //Solicitud 
    private int id; //Respuesta
    private int idSolicitud; //Solicitud

    //Constructor
    public RespuestaModelo(String comentario, Date fechaRespuesta, String bodeguero, String solicitud, int id, int idSolicitud) {
        this.comentario = comentario;
        this.fechaRespuesta = fechaRespuesta;
        this.bodeguero = bodeguero;
        this.solicitud = solicitud;
        this.id = id;
        this.idSolicitud = idSolicitud;
    }

    //Getter And Setter
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public String getBodeguero() {
        return bodeguero;
    }

    public void setBodeguero(String bodeguero) {
        this.bodeguero = bodeguero;
    }

    public String getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(String solicitud) {
        this.solicitud = solicitud;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
}
