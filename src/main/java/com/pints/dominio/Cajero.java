package com.pints.dominio;

import com.pints.modelo.SolicitudModelo;
import com.pints.modelo.RespuestaModelo;
import com.pints.entity.DetalleSolicitud;
import com.pints.entity.RespuestaSolicitud;
import com.pints.entity.SolicitudProducto;
import com.pints.util.Repositorio;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Cajero {

    @EJB(beanName = "respuestaSolicitud")
    private Repositorio repoRespuesta;
    @EJB(beanName = "detalleSolicitud")
    private Repositorio repoDetalles;
    @EJB(beanName = "solicitudProducto")
    private Repositorio repoSolicitudes;

    //Listar respuestas
    public List<SolicitudModelo> listarRespuestas() {
        List<SolicitudProducto> lista = repoSolicitudes.findAll();
        List<SolicitudModelo> solicitudes = new ArrayList<>();
        for (SolicitudProducto sp : lista) {
            if (sp.getEstado().equals("Disponible")) {
                String nombre = sp.getIdUsuario().getNombrePersona() + " " + sp.getIdUsuario().getApellidoPersona();
                SolicitudModelo sm = new SolicitudModelo(0, sp.getIdSolicitudProducto(),
                        sp.getCorrelativods(), 0,
                        "", "", "", "",
                        0, 0, 0, 0,
                        sp.getComentario(), nombre,
                        sp.getEstado(), sp.getFechaSoli());
                solicitudes.add(sm);
            }
        }
        return solicitudes;
    }

    //Obtener Solicitudes
    public List<SolicitudModelo> obtenerDetalles(SolicitudModelo solicitudModelo) {
        List<DetalleSolicitud> lista = repoDetalles.findAll();
        List<SolicitudModelo> solicitudes = new ArrayList<>();
        for (DetalleSolicitud ds : lista) {
            if (ds.getIdSolicitudProducto().getIdSolicitudProducto() == solicitudModelo.getIdSolicitud()) {
                String nombre = ds.getIdSolicitudProducto().getIdUsuario().getNombrePersona() + " " + ds.getIdSolicitudProducto().getIdUsuario().getApellidoPersona();
                SolicitudModelo sm = new SolicitudModelo(ds.getIdDetalleSolicitud(), ds.getIdSolicitudProducto().getIdSolicitudProducto(),
                        ds.getIdSolicitudProducto().getCorrelativods(), ds.getCantidadSoli(),
                        ds.getIdPintura().getIdColor().getCodigoColor(), ds.getIdPintura().getIdBase().getNombreBase(), ds.getIdPintura().getIdPresentacion().getNombrePresentacion(), ds.getIdPintura().getIdMarca().getNombreMarca(),
                        ds.getIdPintura().getIdPintura(), ds.getIdPintura().getCantidadMaxima(), ds.getIdPintura().getStock(), ds.getIdPintura().getPrecio(),
                        ds.getIdSolicitudProducto().getComentario(), nombre, ds.getIdSolicitudProducto().getEstado(), ds.getIdSolicitudProducto().getFechaSoli());
                solicitudes.add(sm);
            }
        }
        return solicitudes;
    }
}
