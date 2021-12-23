package cdf.web.servicios;

import cdf.web.entidades.Comentario;
import cdf.web.entidades.Foto;
import cdf.web.entidades.Curso;
import cdf.web.entidades.Usuario;
import cdf.web.repositorios.CursoDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CursoServicio {

    @Autowired
    CursoDAO cdao;

    @Autowired
    FotoServicio fs;

    @Transactional
    public List<Curso> listarCursos() {
        return cdao.findAll();
    }

    @Transactional
    public Curso agregarCurso(String nombre, MultipartFile archivo, List<MultipartFile> archivos, List<Comentario> comentarios, String descripcion, Date fechaFin, Date fechaInicio, String formularioInscripcion, List<Usuario> usuariosAnotados, String introduccion) {
        System.out.println("Voy a agregar, SIRUM");
        Curso curso = new Curso();
        curso.setDescripcion(descripcion);
        curso.setFechaFin(fechaFin);
        curso.setFechaInicio(fechaInicio);
        curso.setIntroduccion(introduccion);
        curso.setNombre(nombre);
        Foto imagen = fs.guardar(archivo);
        curso.setImagen(imagen);
//        List<Foto> imagenesComplementarias = new ArrayList();
//        for (MultipartFile archivo1 : archivos) {
//            imagenesComplementarias.add(fs.guardar(archivo1));
//        }
//        curso.setImagenesComplementarias(imagenesComplementarias);
        return cdao.save(curso);

    }

    @Transactional
    public void eliminarCurso(String id) {        
        Curso curso = cdao.findById(id).get();
        cdao.delete(curso);
    }

    @Transactional
    public Curso editarCurso(String nombre, MultipartFile archivo, List<MultipartFile> archivos, String id, List<Comentario> comentarios, String descripcion, Date fechaFin, Date fechaInicio, String formularioInscripcion, List<Usuario> usuariosAnotados, String introduccion) {
        Curso curso = cdao.findById(id).get();
        curso.setComentarios(comentarios);
        curso.setDescripcion(descripcion);
        curso.setFechaFin(fechaFin);
        curso.setFechaInicio(fechaInicio);
        curso.setIntroduccion(introduccion);
        curso.setUsuariosAnotados(usuariosAnotados);
        curso.setNombre(nombre);

        String idFoto = null;
        if (curso.getImagen() != null) {
            idFoto = curso.getImagen().getId();
        }
        Foto imagen = fs.actualizar(archivo, idFoto);

//        List<Foto> imagenesComplementarias = new ArrayList();
//        for (MultipartFile archivo1 : archivos) {
//            String idFotos = null;
//            if (curso.getImagen() != null) {
//                idFotos = curso.getImagen().getId();
//            }
//            Foto imagenes = fs.actualizar(archivo1, idFotos);
//            imagenesComplementarias.add(imagenes);
//        }
        curso.setImagen(imagen);
//        curso.setImagenesComplementarias(imagenesComplementarias);

        cdao.save(curso);
        return curso;
    }

    @Transactional
    public Curso buscarCursoId(String id) {
        return cdao.findById(id).get();
    }

    @Transactional
    public Curso buscarCursoNombre(String nombre) {
        return cdao.buscarCursoNombre(nombre);
    }

    @Transactional
    public Curso agregarComentario(String id, Comentario comentario) {
        Curso curso = cdao.findById(id).get();
        curso.getComentarios().add(comentario);
        return cdao.save(curso);
    }
}
