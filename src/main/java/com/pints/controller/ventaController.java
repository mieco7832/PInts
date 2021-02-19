package com.pints.controller;

import com.pints.modelo.ProductoModelo;
import com.pints.modelo.RespuestaModelo;
import com.pints.modelo.SolicitudModelo;
import com.pints.dominio.Vendedor;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "ventas")
@ViewScoped
public class ventaController implements Serializable {

    @Inject
    private Vendedor vendedor;
    private ProductoModelo productoModelo;
    private SolicitudModelo solicitudModelo;
    private RespuestaModelo respuestaModelo;
    private List<ProductoModelo> catalogolista;
    private List<SolicitudModelo> listaSolicitudes;
    private List<SolicitudModelo> listaEspera;
    private String correlativo = new String();
    private int cantidad;

    //Catalogo
    public void catalogo() {
        this.catalogolista = vendedor.catalogo();
    }

    //Solicitar Producto
    public void selecionarProducto(int i) {
        this.productoModelo = vendedor.selecionarProducto(i);
    }

    //Limpiar Producto
    public void limpiar() {
        this.productoModelo = null;
        this.cantidad = 0;
    }

    //Crear Solicitud
    public void crearSolicitud(String user) {
        this.solicitudModelo = vendedor.crearSolicitudVacia(user);
        this.correlativo = this.solicitudModelo.getCorrelativo();
    }

    //Cancelar Solicitud
    public void cancelarSolicitud() {
        this.correlativo = new String();
        vendedor.eliminarSolicitudes(this.solicitudModelo);
    }

    //Quitar Detalle
    public void quitarDetalle(int i) {
        vendedor.eliminarDetalle(i);
    }

    //Guardar Solicitud
    public void guardarSolicitud() {
        vendedor.enviarSolicitudes(this.solicitudModelo);
        this.correlativo = new String();
        this.solicitudModelo = null;
    }

    //Agregar Producto
    public void agregarProducto() {
        this.vendedor.crearSolicitudesDetalle(productoModelo, solicitudModelo, cantidad);
        this.listaSolicitudes = vendedor.llenarSolicitudes();
    }

    //Llenar Producto
    public void productos() {
        this.listaSolicitudes = vendedor.llenarSolicitudes();
    }

    //Listar Solicitudes
    public void listarSolicitudes() {
        this.listaEspera = vendedor.listarSolicitudes();
    }

    //Detalle de Respuesta
    public void detallesRespuesta(SolicitudModelo sm) {
        this.respuestaModelo = vendedor.respuesta(sm);
    }

    //Linpiar Respuesta
    public void limpiarRespuestas() {
        this.respuestaModelo = null;
    }

    //Getter and Setter
    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public ProductoModelo getProductoModelo() {
        return productoModelo;
    }

    public void setProductoModelo(ProductoModelo productoModelo) {
        this.productoModelo = productoModelo;
    }

    public RespuestaModelo getRespuestaModelo() {
        return respuestaModelo;
    }

    public void setRespuestaModelo(RespuestaModelo respuestaModelo) {
        this.respuestaModelo = respuestaModelo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public SolicitudModelo getSolicitudModelo() {
        return solicitudModelo;
    }

    public void setSolicitudModelo(SolicitudModelo solicitudModelo) {
        this.solicitudModelo = solicitudModelo;
    }

    public List<SolicitudModelo> getListaSolicitudes() {
        this.listaSolicitudes = vendedor.llenarSolicitudes();
        return listaSolicitudes;
    }

    public List<ProductoModelo> getCatalogolista() {
        this.catalogolista = vendedor.catalogo();
        return catalogolista;
    }

    public List<SolicitudModelo> getListaEspera() {
        this.listaEspera = vendedor.listarSolicitudes();
        return listaEspera;
    }
}
