package cdf.web.servicios;

import cdf.web.entidades.Comentario;
import cdf.web.entidades.Foto;
import cdf.web.entidades.Curso;
import cdf.web.entidades.Usuario;
import cdf.web.repositorios.CursoDAO;
import java.util.Date;
import java.util.List;

public class CursoServicio {

    CursoDAO cdao;

    public List<Curso> listarCursos() {
        return cdao.findAll();
    }

    public Curso agregarCurso(List<Comentario> comentarios, String descripcion, Date fechaFin, Date fechaInicio, String formularioInscripcion, Foto foto, List<Foto> imagenesComplementarias, List<Usuario> usuariosAnotados, String introduccion) {
        Curso curso = new Curso();
        curso.setComentarios(comentarios);
        curso.setDescripcion(descripcion);
        curso.setFechaFin(fechaFin);
        curso.setFechaInicio(fechaInicio);
        curso.setImagen(foto);
        curso.setImagenesComplementarias(imagenesComplementarias);
        curso.setIntroduccion(introduccion);
        curso.setUsuariosAnotados(usuariosAnotados);
        return cdao.save(curso);

    }

    public void eliminarCurso(String id) {
        Curso curso = cdao.findById(id).get();
        cdao.delete(curso);
    }

    public Curso editarCurso(String id, List<Comentario> comentarios, String descripcion, Date fechaFin, Date fechaInicio, String formularioInscripcion, Foto foto, List<Foto> imagenesComplementarias, List<Usuario> usuariosAnotados, String introduccion) {
        Curso curso = cdao.findById(id).get();
        curso.setComentarios(comentarios);
        curso.setDescripcion(descripcion);
        curso.setFechaFin(fechaFin);
        curso.setFechaInicio(fechaInicio);
        curso.setImagen(foto);
        curso.setImagenesComplementarias(imagenesComplementarias);
        curso.setIntroduccion(introduccion);
        curso.setUsuariosAnotados(usuariosAnotados);
        cdao.save(curso);
        return curso;
    }

    public Curso buscarCursoId(String id) {
        return cdao.findById(id).get();
    }

    public Curso buscarCursoNombre(String nombre) {
        return cdao.buscarCursoNombre(nombre);
    }
}
