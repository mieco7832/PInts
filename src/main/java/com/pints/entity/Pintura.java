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
@Table(name = "pintura")
public class Pintura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPintura;
    @Column(name = "stock")
    private int stock;
    @Column(name = "cantidadMaxima")
    private int cantidadMaxima;
    @Column(name = "precio")
    private double precio;
    @JoinColumn(name = "idColor", referencedColumnName = "idColor")
    @ManyToOne
    private Color idColor;
    @JoinColumn(name = "idPresentacion",referencedColumnName = "idPresentacion")
    @ManyToOne
    private Presentacion idPresentacion;
    @JoinColumn(name = "idMarca", referencedColumnName = "idMarca")
    @ManyToOne
    private Marca idMarca;
    @JoinColumn(name = "idBase", referencedColumnName = "idBase")
    @ManyToOne
    private Base idBase;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaRegistro")
    private Date fechaRegistro;
    @Column(name = "estado")
    private int estado;

    public int getIdPintura() {
        return idPintura;
    }

    public void setIdPintura(int idPintura) {
        this.idPintura = idPintura;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Color getIdColor() {
        return idColor;
    }

    public void setIdColor(Color idColor) {
        this.idColor = idColor;
    }

    public Presentacion getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(Presentacion idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    public Base getIdBase() {
        return idBase;
    }

    public void setIdBase(Base idBase) {
        this.idBase = idBase;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int isEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.idPintura;
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
        final Pintura other = (Pintura) obj;
        if (this.idPintura != other.idPintura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pintura{" + "idPintura=" + idPintura + '}';
    }

    public Pintura() {
    }
}
