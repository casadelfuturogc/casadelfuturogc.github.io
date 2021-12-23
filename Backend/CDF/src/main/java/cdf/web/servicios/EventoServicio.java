package cdf.web.servicios;

import cdf.web.entidades.Comentario;
import cdf.web.entidades.Evento;
import cdf.web.entidades.Foto;
import cdf.web.entidades.Usuario;
import cdf.web.repositorios.EventoDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EventoServicio {

    @Autowired
    EventoDAO edao;

    @Autowired
    FotoServicio fs;

    @Transactional
    public Evento registrarEvento(String nombre, MultipartFile archivo, List<MultipartFile> archivos, List<Comentario> comentarios, String descripcion, String introduccion, List<Usuario> usuariosAnotados, Date fecha) {
        Evento evento = new Evento();
        evento.setNombre(nombre);
        evento.setComentarios(comentarios);
        evento.setDescripcion(descripcion);
        evento.setFecha(fecha);
        evento.setIntroduccion(introduccion);

        Foto imagen = fs.guardar(archivo);
        evento.setImagen(imagen);
//        List<Foto> imagenesComplementarias = new ArrayList();
//        for (MultipartFile archivo1 : archivos) {
//            imagenesComplementarias.add(fs.guardar(archivo1));
//        }
//        evento.setImagenesComplementarias(imagenesComplementarias);
        return edao.save(evento);
    }

    @Transactional
    public void eliminarEvento(String id) {
        Evento evento = edao.findById(id).get();
        edao.delete(evento);
    }

    @Transactional
    public List<Evento> listarEventos() {
        return edao.findAll();
    }

    @Transactional
    public Evento editarEvento(String nombre, MultipartFile archivo, List<MultipartFile> archivos, String id, List<Comentario> comentarios, String descripcion, String introduccion, List<Usuario> usuariosAnotados, Date fecha) {
        Evento evento = edao.findById(id).get();
        evento.setNombre(nombre);
        evento.setComentarios(comentarios);
        evento.setDescripcion(descripcion);
        evento.setFecha(fecha);
        evento.setIntroduccion(introduccion);

        String idFoto = null;
        if (evento.getImagen() != null) {
            idFoto = evento.getImagen().getId();
        }
        Foto imagen = fs.actualizar(archivo, idFoto);
        evento.setImagen(imagen);

//        List<Foto> imagenesComplementarias = new ArrayList();
//        for (MultipartFile archivo1 : archivos) {
//            String idFotos = null;
//            if (evento.getImagen() != null) {
//                idFotos = evento.getImagen().getId();
//            }
//            Foto imagenes = fs.actualizar(archivo1, idFotos);
//            imagenesComplementarias.add(imagenes);
//        }
//        evento.setImagenesComplementarias(imagenesComplementarias);s
        return edao.save(evento);
    }

    @Transactional
    public Evento buscarEventoId(String id) {
        return edao.findById(id).get();
    }

    public Evento buscarEventoNombre(String nombre) {
        return edao.buscarEventoNombre(nombre);
    }

       @Transactional
    public Evento agregarComentario(String id, Comentario comentario) {
        Evento evento = edao.findById(id).get();
        evento.getComentarios().add(comentario);
        return edao.save(evento);
    }

}
