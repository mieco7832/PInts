package com.pints.dominio;

import com.pints.modelo.SolicitudModelo;
import com.pints.entity.DetalleSolicitud;
import com.pints.entity.RespuestaSolicitud;
import com.pints.entity.SolicitudProducto;
import com.pints.entity.Usuario;
import com.pints.util.Repositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Bodeguero {

    @EJB(beanName = "detalleSolicitud")
    private Repositorio repoDetalles;
    @EJB(beanName = "solicitudProducto")
    private Repositorio repoSolicitud;
    @EJB(beanName = "respuestaSolicitud")
    private Repositorio repoRespuesta;

    //Listar Solicitudes
    public List<SolicitudModelo> listaSoliPro() {
        try {
            //Se guarda la lista en la Entidad Mapeado
            List<SolicitudProducto> solicitudProductos = repoSolicitud.findAll();
            //Se crea una lista para la Entidad Espejo
            List<SolicitudModelo> lista = new ArrayList<>();
            //Se llena los registros de la Entidad Mapeada a la Entidad Espejo
            for (SolicitudProducto sp : solicitudProductos) {
                if (sp.getEstado().equals("Espera")) {
                    String nombreEmpleado = sp.getIdUsuario().getNombrePersona() + " " + sp.getIdUsuario().getApellidoPersona();
                    //Se crea un constructor de la Entidad Espajo para Gusradar temporalmente
                    SolicitudModelo solicitudModelo = new SolicitudModelo(0, sp.getIdSolicitudProducto(),
                            sp.getCorrelativods(), 0,
                            "", "", "", "",
                            0, 0, 0, 0,
                            sp.getComentario(), nombreEmpleado,
                            sp.getEstado(), sp.getFechaSoli());
                    //Se agrega la Entidad con los datos temporales en la lista de su Entidad Espejo
                    lista.add(solicitudModelo);
                }
            }
            //Devuelve una Lista de la Entidad Espejo
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Listar Detalles de solicitudes
    public List<SolicitudModelo> listarDetalles() {
        try {
            //Se guarda la lista en la Entidad Mapeado
            List<DetalleSolicitud> detalleSolicitudes = repoDetalles.findAll();
            //Se crea una lista para la Entidad Espejo
            List<SolicitudModelo> lista = new ArrayList<>();
            //Se llena los registros de la Entidad Mapeada a la Entidad Espejo
            for (DetalleSolicitud p : detalleSolicitudes) {
                String nombreEmpleado = p.getIdSolicitudProducto().getIdUsuario().getNombrePersona() + " " + p.getIdSolicitudProducto().getIdUsuario().getApellidoPersona();
                //Se crea un constructor de la Entidad Espajo para Gusradar temporalmente
                SolicitudModelo solicitudModelo = new SolicitudModelo(p.getIdDetalleSolicitud(), p.getIdSolicitudProducto().getIdSolicitudProducto(),
                        p.getIdSolicitudProducto().getCorrelativods(), p.getCantidadSoli(),
                        p.getIdPintura().getIdColor().getCodigoColor(), p.getIdPintura().getIdBase().getNombreBase(),
                        p.getIdPintura().getIdPresentacion().getNombrePresentacion(), p.getIdPintura().getIdMarca().getNombreMarca(), p.getIdPintura().getIdPintura(),
                        p.getIdPintura().getCantidadMaxima(), p.getIdPintura().getStock(), p.getIdPintura().getPrecio(),
                        p.getIdSolicitudProducto().getComentario(), nombreEmpleado,
                        p.getIdSolicitudProducto().getEstado(), p.getIdSolicitudProducto().getFechaSoli());
                //Se agrega la Entidad con los datos temporales en la lista de su Entidad Espejo
                lista.add(solicitudModelo);
            }
            //Devuelve una Lista de la Entidad Espejo
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Listar Detalles de solicitudes
    public List<SolicitudModelo> listarDetallesById(SolicitudModelo pm) {
        try {
            List<DetalleSolicitud> detalleSolicitudes = repoDetalles.findAll();
            List<SolicitudModelo> lista = new ArrayList<>();
            for (DetalleSolicitud p : detalleSolicitudes) {
                if (p.getIdSolicitudProducto().getIdSolicitudProducto() == pm.getIdSolicitud()) {
                    String nombreEmpleado = p.getIdSolicitudProducto().getIdUsuario().getNombrePersona() + " " + p.getIdSolicitudProducto().getIdUsuario().getApellidoPersona();
                    SolicitudModelo solicitudModelo = new SolicitudModelo(p.getIdDetalleSolicitud(), p.getIdSolicitudProducto().getIdSolicitudProducto(),
                            p.getIdSolicitudProducto().getCorrelativods(), p.getCantidadSoli(),
                            p.getIdPintura().getIdColor().getCodigoColor(), p.getIdPintura().getIdBase().getNombreBase(),
                            p.getIdPintura().getIdPresentacion().getNombrePresentacion(), p.getIdPintura().getIdMarca().getNombreMarca(), p.getIdPintura().getIdPintura(),
                            p.getIdPintura().getCantidadMaxima(), p.getIdPintura().getStock(), p.getIdPintura().getPrecio(),
                            p.getIdSolicitudProducto().getComentario(), nombreEmpleado,
                            p.getIdSolicitudProducto().getEstado(), p.getIdSolicitudProducto().getFechaSoli());
                    lista.add(solicitudModelo);
                }
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Responder Solicitudes
    public void respuestaSolicitudes(String comentario, String estado, int idSolicitud, String user) {
        try {
            // inicialización de Variables 
            Usuario usuario = new Usuario();
            SolicitudProducto solicitudProducto = new SolicitudProducto();
            RespuestaSolicitud respuestaSolicitud = new RespuestaSolicitud();
            Date fecha = new Date(); // Agregamos La Fecha Y Hora Actual Del Sistema
            usuario.setDoc(user); // Se implementa la informacion personal
            List<SolicitudProducto> lista = repoSolicitud.findAll();
            for (SolicitudProducto sp : lista) {
                if (sp.getIdSolicitudProducto() == idSolicitud) {
                    solicitudProducto = sp;
                }
            }
            respuestaSolicitud.setComentarioRespuesta(comentario); // Comentario 
            respuestaSolicitud.setFechaRespuesta(fecha); // Feha
            respuestaSolicitud.setIdSolicitudProducto(solicitudProducto); // Solicitud
            respuestaSolicitud.setIdUsuario(usuario); // Usuario
            repoRespuesta.create(respuestaSolicitud); // Se crea el registro
            solicitudProducto.setEstado(estado);
            repoSolicitud.edit(solicitudProducto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
