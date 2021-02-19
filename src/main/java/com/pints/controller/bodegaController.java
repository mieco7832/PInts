package com.pints.controller;

import com.pints.dominio.Bodeguero;
import com.pints.modelo.SolicitudModelo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "bodega")
@ViewScoped
public class bodegaController implements Serializable {

    @Inject
    private Bodeguero bodeguero;
    private SolicitudModelo solicitudModelo;
    private List<SolicitudModelo> listaSolictudes;
    private List<SolicitudModelo> listaDetalles;
    private String comentario, estado;

    //Listar Solicitudes de Producto Activas
    public void obtenerSolicitudes() {
        this.listaSolictudes = bodeguero.listaSoliPro();
    }

    //Vizualizar Detalles de Solicitud ById
    public void solicitudById(SolicitudModelo p) {
        this.listaDetalles = bodeguero.listarDetallesById(p);
        this.solicitudModelo = p;
    }

    //Crear Respuesas de las Solicitudes de Pedido
    public void responder(String user) {
        this.bodeguero.respuestaSolicitudes(this.comentario, this.estado, solicitudModelo.getIdSolicitud(), user);
    }

    //Getter and Setter de Bodega
    public List<SolicitudModelo> getListaSolictudes() {
        this.listaSolictudes = bodeguero.listaSoliPro();
        return listaSolictudes;
    }

    public List<SolicitudModelo> getListaDetalles() {
        return listaDetalles;
    }

    public Bodeguero getBodeguero() {
        return bodeguero;
    }

    public void setBodeguero(Bodeguero bodeguero) {
        this.bodeguero = bodeguero;
    }

    public SolicitudModelo getSolicitudModelo() {
        return solicitudModelo;
    }

    public void setSolicitudModelo(SolicitudModelo solicitudModelo) {
        this.solicitudModelo = solicitudModelo;
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

    @PostConstruct
    public void init() {
        this.listaDetalles = bodeguero.listarDetalles();
        this.comentario = new String();
        this.estado = new String();
    }
}
