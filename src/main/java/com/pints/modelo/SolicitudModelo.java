package com.pints.modelo;

import java.io.Serializable;
import java.util.Date;

public class SolicitudModelo implements Serializable {

    private int id; //Id Detalle
    private int idSolicitud; // Id Solicitud

    //Tabla de Solicitudes
    private String correlativo; //Detalle de Solicitud
    private int cantidadSoli; // Detalle de Solicitud

    //Caracteristicas del Producto 
    private String codigo; // Color
    private String base; // Base
    private String presentacion; // Presentación
    private String marca; // Marca

    //Estado del Producto
    private int idProducto; // Pintura
    private int cantidadMax; // pintura
    private int stock; // pintura
    private double precio; // Pintura

    //Mas Detalles
    private String comentario; // solicitud
    private String empleado; // usuario

    //Funciones
    private String estadoSoli; // solicitud
    private Date fechaSoli; // solicitud

    //Constructor
    public SolicitudModelo(int id, int idSolicitud, String correlativo, int cantidadSoli, String codigo, String base, String presentacion, String marca, int idProducto, int cantidadMax, int stock, double precio, String comentario, String empleado, String estadoSoli, Date fechaSoli) {
        this.id = id;
        this.idSolicitud = idSolicitud;
        this.correlativo = correlativo;
        this.cantidadSoli = cantidadSoli;
        this.codigo = codigo;
        this.base = base;
        this.presentacion = presentacion;
        this.marca = marca;
        this.idProducto = idProducto;
        this.cantidadMax = cantidadMax;
        this.stock = stock;
        this.precio = precio;
        this.comentario = comentario;
        this.empleado = empleado;
        this.estadoSoli = estadoSoli;
        this.fechaSoli = fechaSoli;
    }

    
    //Getter And Setter

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

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public int getCantidadSoli() {
        return cantidadSoli;
    }

    public void setCantidadSoli(int cantidadSoli) {
        this.cantidadSoli = cantidadSoli;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadMax() {
        return cantidadMax;
    }

    public void setCantidadMax(int cantidadMax) {
        this.cantidadMax = cantidadMax;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getEstadoSoli() {
        return estadoSoli;
    }

    public void setEstadoSoli(String estadoSoli) {
        this.estadoSoli = estadoSoli;
    }

    public Date getFechaSoli() {
        return fechaSoli;
    }

    public void setFechaSoli(Date fechaSoli) {
        this.fechaSoli = fechaSoli;
    }    

}
