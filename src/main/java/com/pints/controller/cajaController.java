package com.pints.controller;

import com.pints.dominio.Cajero;
import com.pints.modelo.RespuestaModelo;
import com.pints.modelo.SolicitudModelo;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "caja")
@ViewScoped
public class cajaController implements Serializable {

    @Inject
    private Cajero cajero;
    private List<SolicitudModelo> listaRespuestas;
    private List<SolicitudModelo> listaSolicitud;
    private double total = new Double(0);
    
    public void obtenerSolictud(SolicitudModelo solicitudModelo) {
        this.listaSolicitud = cajero.obtenerDetalles(solicitudModelo);
        for(SolicitudModelo sm:listaSolicitud){
            this.total+= (sm.getCantidadSoli() * sm.getPrecio());
        }
    }
    
    public void limpiarTotal(){
        total = 0;
    }
    
    //Getter And Setter
    public Cajero getCajero() {
        return cajero;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }

    public List<SolicitudModelo> getListaRespuestas() {
        this.listaRespuestas = cajero.listarRespuestas();
        return listaRespuestas;
    }

    public List<SolicitudModelo> getListaSolicitud() {
        return listaSolicitud;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
