package com.pints.ejb;

import com.pints.entity.Usuario;
import com.pints.util.AbstractFacade;
import com.pints.util.RepositorioUsuario;
import java.sql.ResultSet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "usuario")
public class UsuarioFacade extends AbstractFacade<Usuario> implements RepositorioUsuario<Usuario> {

    @PersistenceContext(unitName = "sourcePints")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario login(String usuario, String clave) {
        String sql;
        try {
            sql = "SELECT * FROM usuario u WHERE u.nombreUsuario = BINARY '" + usuario + "' AND u.claveUsuario = BINARY '" + clave + "';";
            Query query = em.createNativeQuery(sql);
            List<Usuario> user = query.getResultList();
            if (!user.isEmpty()) {
                Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = ?1 AND u.claveUsuario = ?2");
                q.setParameter(1, usuario);
                q.setParameter(2, clave);
                user = q.getResultList();
            } else {
                return null;
            }
            return user.get(0);
        } catch (Exception e) {
            return null;
        }
    }
}
