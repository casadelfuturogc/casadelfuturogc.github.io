package cdf.web.servicios;

import cdf.web.entidades.Comentario;
import cdf.web.entidades.Foto;
import cdf.web.entidades.Proyecto;
import cdf.web.entidades.Usuario;
import cdf.web.repositorios.ProyectoDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProyectoServicio {

    @Autowired
    ProyectoDAO pdao;

    @Autowired
    FotoServicio fs;

    @Transactional
    public Proyecto registrarProyecto(String nombre, MultipartFile archivo, List<MultipartFile> archivos, List<Comentario> comentarios, String introduccion, String descripcion, Date fechaFin, Date fechaInicio, List<Usuario> profesores, List<Usuario> usuariosAnotados) {
        System.out.println("ESTAMOS PORRRRRR REGISTRA");

        Proyecto proyecto = new Proyecto();
        proyecto.setDescripcion(descripcion);
        proyecto.setFechaFin(fechaFin);
        proyecto.setFechaInicio(fechaInicio);
        proyecto.setIntroduccion(introduccion);
        proyecto.setNombre(nombre);

        System.out.println("ESTAMOS REGISTRANDO");

        Foto imagen = fs.guardar(archivo);
        proyecto.setImagen(imagen);
//        List<Foto> imagenesComplementarias = new ArrayList();
//        for (MultipartFile archivo1 : archivos) {
//            imagenesComplementarias.add(fs.guardar(archivo1));
//        }
//        proyecto.setImagenesComplementarias(imagenesComplementarias);

        return pdao.save(proyecto);

    }

    @Transactional
    public List<Proyecto> listarProyectos() {
        return pdao.findAll();
    }

    @Transactional
    public void eliminarProyecto(String id) {
        Proyecto proyecto = pdao.findById(id).get();
        pdao.delete(proyecto);
    }

    @Transactional
    public Proyecto editarProyecto(String nombre, MultipartFile archivo, List<MultipartFile> archivos, String id, List<Comentario> comentarios, String introduccion, String descripcion, Date fechaFin, Date fechaInicio, List<Usuario> profesores, List<Usuario> usuariosAnotados) {
        Proyecto proyecto = pdao.findById(id).get();
        proyecto.setComentarios(comentarios);
        proyecto.setDescripcion(descripcion);
        proyecto.setFechaFin(fechaFin);
        proyecto.setFechaInicio(fechaInicio);
        proyecto.setIntroduccion(introduccion);
        proyecto.setNombre(nombre);

        String idFoto = null;
        if (proyecto.getImagen() != null) {
            idFoto = proyecto.getImagen().getId();
        }
        Foto imagen = fs.actualizar(archivo, idFoto);
        proyecto.setImagen(imagen);

//        List<Foto> imagenesComplementarias = new ArrayList();
//        for (MultipartFile archivo1 : archivos) {
//            String idFotos = null;
//            if (proyecto.getImagen() != null) {
//                idFotos = proyecto.getImagen().getId();
//            }
//            Foto imagenes = fs.actualizar(archivo1, idFotos);
//            imagenesComplementarias.add(imagenes);
//        }
//
//        proyecto.setImagenesComplementarias(imagenesComplementarias);
        return pdao.save(proyecto);
    }

    @Transactional
    public Proyecto buscarProyectoId(String id) {
        return pdao.findById(id).get();
    }

    public Proyecto buscarProyectoNombre(String nombre) {
        return pdao.buscarProyectoNombre(nombre);
    }

    public Proyecto agregarComentario(String id, Comentario comentario) {
        Proyecto proyecto = pdao.findById(id).get();
        proyecto.getComentarios().add(comentario);
        return pdao.save(proyecto);
    }

}
