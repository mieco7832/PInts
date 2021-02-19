package com.pints.dominio;

import com.pints.modelo.SolicitudModelo;
import com.pints.modelo.ProductoModelo;
import com.pints.modelo.RespuestaModelo;
import com.pints.entity.DetalleSolicitud;
import com.pints.entity.Pintura;
import com.pints.entity.RespuestaSolicitud;
import com.pints.entity.SolicitudProducto;
import com.pints.entity.Usuario;
import com.pints.util.Repositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Vendedor {

    @EJB(beanName = "pintura")
    private Repositorio repoPintura;
    @EJB(beanName = "detalleSolicitud")
    private Repositorio repoDetalleSolicitud;
    @EJB(beanName = "solicitudProducto")
    private Repositorio repoSolicitud;
    @EJB(beanName = "respuestaSolicitud")
    private Repositorio repoRespuesta;

    private Date fecha = new Date();

    //Catalogo
    public List<ProductoModelo> catalogo() {
        List<ProductoModelo> lista = new ArrayList<>();
        ProductoModelo productoModelo = null;
        try {
            List<Pintura> pinturas = repoPintura.findAll();
            for (Pintura p : pinturas) {
                productoModelo = new ProductoModelo(p.getIdPintura(),
                        p.getIdColor().getNombreColor(), p.getIdColor().getCodigoColor(),
                        p.getIdBase().getNombreBase(), p.getIdPresentacion().getNombrePresentacion(),
                        p.getIdMarca().getNombreMarca(), p.getPrecio());
                lista.add(productoModelo);
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Selecionar Producto
    public ProductoModelo selecionarProducto(int i) {
        List<Pintura> p = repoPintura.findAll();
        ProductoModelo pm = null;
        for (Pintura pi : p) {
            if (pi.getIdPintura() == i) {
                pm = new ProductoModelo(pi.getIdPintura(), pi.getIdColor().getNombreColor(), pi.getIdColor().getCodigoColor(),
                        pi.getIdBase().getNombreBase(), pi.getIdPresentacion().getNombrePresentacion(), pi.getIdMarca().getNombreMarca(), pi.getPrecio());
            }
        }
        return pm;
    }

    //containts Listas
    //Crear Solicitudes
    public SolicitudModelo crearSolicitudVacia(String us) {
        List<SolicitudProducto> solicitudes = repoSolicitud.findAll();
        SolicitudProducto solicitudProducto = new SolicitudProducto();
        SolicitudProducto solicitud = new SolicitudProducto();
        Usuario usuario = new Usuario();
        SolicitudModelo sm = null;
        String nombre = "";
        String cor = "0001";
        try {
            if (solicitudes.size() > 0) {
                if (solicitudes.get(solicitudes.size() - 1).getEstado().equals("Activa")) {
                    cor = this.correlativo(Integer.parseInt(solicitudes.get(solicitudes.size() - 1).getCorrelativods()));
                    nombre = solicitudes.get(solicitudes.size() - 1).getIdUsuario().getNombrePersona() + " " + solicitudes.get(solicitudes.size() - 1).getIdUsuario().getApellidoPersona();
                    SolicitudModelo solicitudModelo = new SolicitudModelo(0, solicitudes.get(solicitudes.size() - 1).getIdSolicitudProducto(),
                            cor, 0,
                            "", "", "", "",
                            0, 0, 0, 0.0,
                            solicitudes.get(solicitudes.size() - 1).getComentario(), nombre, solicitudes.get(solicitudes.size() - 1).getEstado(), solicitudes.get(solicitudes.size() - 1).getFechaSoli());
                    sm = solicitudModelo;
                } else {
                    cor = this.correlativo(Integer.parseInt(solicitudes.get(solicitudes.size() - 1).getCorrelativods()));
                    solicitudProducto.setCorrelativods(cor);
                    this.parametros(solicitudProducto, usuario, us);
                    repoSolicitud.create(solicitudProducto);
                    solicitudes = repoSolicitud.findAll();
                    for (SolicitudProducto sp : solicitudes) {
                        if (sp.getEstado().equals("Activa")) {
                            solicitud = sp;
                        }
                    }
                    nombre = solicitud.getIdUsuario().getNombrePersona() + " " + solicitud.getIdUsuario().getApellidoPersona();
                    SolicitudModelo solicitudModelo = new SolicitudModelo(0, solicitud.getIdSolicitudProducto(),
                            cor, 0,
                            "", "", "", "",
                            0, 0, 0, 0.0,
                            solicitud.getComentario(), nombre, solicitud.getEstado(), solicitud.getFechaSoli());
                    sm = solicitudModelo;
                }
            } else {
                solicitudProducto.setCorrelativods(cor);
                this.parametros(solicitudProducto, usuario, us);
                repoSolicitud.create(solicitudProducto);
                solicitudes = repoSolicitud.findAll();
                for (SolicitudProducto sp : solicitudes) {
                    if (sp.getEstado().equals("Activa")) {
                        solicitud = sp;
                    }
                }
                nombre = solicitud.getIdUsuario().getNombrePersona() + " " + solicitud.getIdUsuario().getApellidoPersona();
                SolicitudModelo solicitudModelo = new SolicitudModelo(0, solicitud.getIdSolicitudProducto(),
                        cor, 0,
                        "", "", "", "",
                        0, 0, 0, 0.0,
                        solicitud.getComentario(), nombre, solicitud.getEstado(), solicitud.getFechaSoli());
                sm = solicitudModelo;
            }
            return sm;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Parametros para crear Solicitud
    public SolicitudProducto parametros(SolicitudProducto solicitudProducto, Usuario usuario, String us) {
        solicitudProducto.setComentario("");
        solicitudProducto.setEstado("Activa");
        solicitudProducto.setFechaSoli(this.fecha);
        usuario.setDoc(us);
        solicitudProducto.setIdUsuario(usuario);
        return solicitudProducto;
    }

    //Llenar Solicitudes
    public void crearSolicitudesDetalle(ProductoModelo pm, SolicitudModelo solicitud, int i) {
        Pintura pintura = new Pintura();
        SolicitudProducto solicitudProducto = new SolicitudProducto();
        DetalleSolicitud detalleSolicitud = new DetalleSolicitud();
        try {
            pintura.setIdPintura(pm.getId());
            solicitudProducto.setIdSolicitudProducto(solicitud.getIdSolicitud());
            detalleSolicitud.setCantidadSoli(i);
            detalleSolicitud.setIdPintura(pintura);
            detalleSolicitud.setIdSolicitudProducto(solicitudProducto);
            repoDetalleSolicitud.create(detalleSolicitud);
        } catch (Exception e) {
            System.out.println("Error... " + e.getMessage());
            e.printStackTrace();
        }
    }

    //llenar Solicitudes
    public List<SolicitudModelo> llenarSolicitudes() {
        try {
            List<DetalleSolicitud> detalles = repoDetalleSolicitud.findAll();
            List<SolicitudModelo> lista = new ArrayList<>();
            SolicitudModelo solicitudModelo = null;
            for (DetalleSolicitud p : detalles) {
                if (p.getIdSolicitudProducto().getEstado().equals("Activa")) {
                    String nombreEmpleado = p.getIdSolicitudProducto().getIdUsuario().getNombrePersona() + " " + p.getIdSolicitudProducto().getIdUsuario().getApellidoPersona();
                    solicitudModelo = new SolicitudModelo(p.getIdDetalleSolicitud(), p.getIdSolicitudProducto().getIdSolicitudProducto(),
                            p.getIdSolicitudProducto().getCorrelativods(), p.getCantidadSoli(),
                            p.getIdPintura().getIdColor().getNombreColor(), p.getIdPintura().getIdBase().getNombreBase(),
                            p.getIdPintura().getIdPresentacion().getNombrePresentacion(), p.getIdPintura().getIdMarca().getNombreMarca(), p.getIdPintura().getIdPintura(),
                            p.getIdPintura().getCantidadMaxima(), p.getIdPintura().getStock(), p.getIdPintura().getPrecio(),
                            p.getIdSolicitudProducto().getComentario(), nombreEmpleado,
                            p.getIdSolicitudProducto().getEstado(), p.getIdSolicitudProducto().getFechaSoli());
                    lista.add(solicitudModelo);
                }
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error... " + e.getMessage());
            return null;
        }
    }

    public String correlativo(int i) {
        try {
            String correlativo;
            Formatter fmt = new Formatter();
            if (i == 9999) {
                i = 1;
            } else {
                i++;
            }
            fmt.format("%04d", i);
            correlativo = fmt.toString();
            return correlativo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Eliminar Solicitudes
    public void eliminarSolicitudes(SolicitudModelo sm) {
        SolicitudProducto solicitudProducto = new SolicitudProducto();
        solicitudProducto.setIdSolicitudProducto(sm.getIdSolicitud());
        repoSolicitud.remove(solicitudProducto);
    }

    //Eliminar Detalle
    public void eliminarDetalle(int i) {
        DetalleSolicitud detalleSolicitud = new DetalleSolicitud();
        detalleSolicitud.setIdDetalleSolicitud(i);
        repoDetalleSolicitud.remove(detalleSolicitud);
    }

    //Enviar Solicitudes
    public void enviarSolicitudes(SolicitudModelo sm) {
        SolicitudProducto solicitudProducto = new SolicitudProducto();
        List<SolicitudProducto> sp = repoSolicitud.findAll();
        solicitudProducto = sp.get(sm.getIdSolicitud() - 1);
        solicitudProducto.setEstado("Espera");
        repoSolicitud.edit(solicitudProducto);
    }

    //Listar Solicitudes en Espera
    public List<SolicitudModelo> listarSolicitudes() {
        try {
            List<SolicitudProducto> detalles = repoSolicitud.findAll();
            List<SolicitudModelo> lista = new ArrayList<>();
            SolicitudModelo solicitudModelo = null;
            for (SolicitudProducto p : detalles) {
                if (!p.getEstado().equals("Espera") || !p.getEstado().equals("Activa")) {
                    String nombreEmpleado = p.getIdUsuario().getNombrePersona() + " " + p.getIdUsuario().getApellidoPersona();
                    solicitudModelo = new SolicitudModelo(0, p.getIdSolicitudProducto(),
                            p.getCorrelativods(), 0,
                            "", "", "", "",
                            0, 0, 0, 0,
                            p.getComentario(), nombreEmpleado,
                            p.getEstado(), p.getFechaSoli());
                    lista.add(solicitudModelo);
                }
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error... " + e.getMessage());
            return null;
        }
    }

    //Ver Detalle de Respuesta
    public RespuestaModelo respuesta(SolicitudModelo sm) {
        List<SolicitudProducto> solicitudes = repoSolicitud.findAll();
        List<RespuestaSolicitud> respuestas = repoRespuesta.findAll();
        RespuestaModelo rm = null;
        SolicitudProducto solicitudProducto = new SolicitudProducto();
        for (SolicitudProducto sp : solicitudes) {
            if (sp.getIdSolicitudProducto() == sm.getIdSolicitud()) {
                solicitudProducto = sp;
            }
        }
        for (RespuestaSolicitud rs : respuestas) {
            if (rs.getIdSolicitudProducto().getIdSolicitudProducto() == solicitudProducto.getIdSolicitudProducto()) {
                String nombre = rs.getIdUsuario().getNombrePersona() + " " + rs.getIdUsuario().getApellidoPersona();
                rm = new RespuestaModelo(rs.getComentarioRespuesta(), rs.getFechaRespuesta(), nombre,
                        rs.getIdSolicitudProducto().getCorrelativods(), rs.getIdRespuestaSolicitud(), rs.getIdSolicitudProducto().getIdSolicitudProducto());
            }
        }
        return rm;
    }
}
