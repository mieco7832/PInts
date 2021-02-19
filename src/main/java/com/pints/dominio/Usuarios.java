package com.pints.dominio;

import com.pints.entity.Usuario;
import com.pints.util.RepositorioUsuario;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ApplicationScoped
public class Usuarios {

    @EJB(beanName = "usuario")
    private RepositorioUsuario repoUsuario;
    private Usuario usuario;
    private UsuarioModelo um;
    private ExternalContext ec;

    // Iniciar Sesión
    public UsuarioModelo iniciarSesion(String userin, String clave) {
        try {
            this.usuario = repoUsuario.login(userin, clave);
            String nombre = usuario.getNombrePersona() + " " + usuario.getApellidoPersona();
            this.um = new UsuarioModelo(usuario.getDoc(), usuario.getCargoUsuario(), nombre);
            this.ec = FacesContext.getCurrentInstance().getExternalContext();
            this.ec.getSessionMap().put("usval", um.getNombre());
            this.ec.getSessionMap().put("cargo", um.getCargo());
            this.ec.getSessionMap().put("doc", um.getDocumento());
            return um;
        } catch (Exception e) {
            return null;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioModelo getUm() {
        return um;
    }

    public void setUm(UsuarioModelo um) {
        this.um = um;
    }

    public ExternalContext getEc() {
        return ec;
    }

    public void setEc(ExternalContext ec) {
        this.ec = ec;
    }

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
    }
}
