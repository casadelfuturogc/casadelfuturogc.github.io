package cdf.web.servicios;

import cdf.web.entidades.Comentario;
import cdf.web.entidades.Evento;
import cdf.web.entidades.Foto;
import cdf.web.entidades.Usuario;
import cdf.web.repositorios.EventoDAO;
import java.util.Date;
import java.util.List;

public class EventoServicio {

    EventoDAO edao;

    public Evento registrarEvento(List<Comentario> comentarios, String descripcion, String introduccion, List<Usuario> usuariosAnotados, List<Foto> imagenesComplementarias, Foto imagen, Date fecha) {
        Evento evento = new Evento();
        evento.setComentarios(comentarios);
        evento.setDescripcion(descripcion);
        evento.setFecha(fecha);
        evento.setImagen(imagen);
        evento.setIntroduccion(introduccion);
        evento.setUsuariosAnotados(usuariosAnotados);
        evento.setImagenesComplementarias(imagenesComplementarias);
        return edao.save(evento);
    }

    public void eliminarEvento(String id) {
        Evento evento = edao.findById(id).get();
        edao.delete(evento);
    }

    public List<Evento> listarEventos() {
        return edao.findAll();
    }

    public Evento editarEvento(String id, List<Comentario> comentarios, String descripcion, String introduccion, List<Usuario> usuariosAnotados, List<Foto> imagenesComplementarias, Foto imagen, Date fecha) {
        Evento evento = edao.findById(id).get();
        evento.setComentarios(comentarios);
        evento.setDescripcion(descripcion);
        evento.setFecha(fecha);
        evento.setImagen(imagen);
        evento.setIntroduccion(introduccion);
        evento.setUsuariosAnotados(usuariosAnotados);
        evento.setImagenesComplementarias(imagenesComplementarias);
        return edao.save(evento);
    }

    public Evento buscarEventoId(String id) {
        return edao.findById(id).get();
    }
    

}
