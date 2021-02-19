package com.pints.dominio;

public class UsuarioModelo {

    private String documento; // infopersonal
    private String cargo; // usuario
    private String nombre; // informacionpersonal

    public UsuarioModelo(String documento, String cargo, String nombre) {
        this.documento = documento;
        this.cargo = cargo;
        this.nombre = nombre;
    }

    //Getter and Setter
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
