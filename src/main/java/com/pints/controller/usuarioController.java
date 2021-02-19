package com.pints.controller;

import com.pints.dominio.Usuarios;
import com.pints.dominio.UsuarioModelo;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "sesion")
@ViewScoped
public class usuarioController implements Serializable {

    @Inject
    private Usuarios cu;
    private UsuarioModelo um;
    private String usuario;
    private String clave;
    private String inicio;

    // Login
    public void login() throws IOException {
        this.um = cu.iniciarSesion(usuario, clave);
        if (um != null) {
            this.inicio = "inicio";
            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/view/inicio.xhtml");
        } else {
            this.inicio = "error";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Credenciales no Validas", ""));
        }
    }

    public void logout() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/../../index.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Obtener Actual Usuario
    public UsuarioModelo obtenerUsuario(UsuarioModelo u) {
        return u;
    }

    //Getter and Setter
    public Usuarios getCu() {
        return cu;
    }

    public void setCu(Usuarios cu) {
        this.cu = cu;
    }

    public UsuarioModelo getUm() {
        return um;
    }

    public void setUm(UsuarioModelo um) {
        this.um = um;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }
}
