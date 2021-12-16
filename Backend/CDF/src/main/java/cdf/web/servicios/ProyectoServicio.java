package cdf.web.servicios;

import cdf.web.entidades.Comentario;
import cdf.web.entidades.Contacto;
import cdf.web.entidades.Foto;
import cdf.web.entidades.Proyecto;
import cdf.web.entidades.Usuario;
import cdf.web.repositorios.ProyectoDAO;
import java.util.Date;
import java.util.List;

public class ProyectoServicio {

    ProyectoDAO pdao;

    public Proyecto registrarProyecto(List<Comentario> comentarios, String introduccion, String descripcion, Date fechaFin, Date fechaInicio, Contacto formularioInscripcion, Foto imagen, List<Foto> imagenesComplementarias, List<Usuario> profesores, List<Usuario> usuariosAnotados) {
        Proyecto proyecto = new Proyecto();
        proyecto.setComentarios(comentarios);
        proyecto.setDescripcion(descripcion);
        proyecto.setFechaFin(fechaFin);
        proyecto.setFechaInicio(fechaInicio);
        proyecto.setFormularioInscripcion(formularioInscripcion);
        proyecto.setImagen(imagen);
        proyecto.setImagenesComplementarias(imagenesComplementarias);
        proyecto.setIntroduccion(introduccion);
        proyecto.setProfesores(profesores);
        proyecto.setUsuariosAnotados(usuariosAnotados);
        return pdao.save(proyecto);

    }

    public List<Proyecto> listarProyectos() {
        return pdao.findAll();
    }

    public void eliminarProyecto(String id) {
        Proyecto proyecto = pdao.findById(id).get();
        pdao.delete(proyecto);
    }

    public Proyecto editarProyecto(String id, List<Comentario> comentarios, String introduccion, String descripcion, Date fechaFin, Date fechaInicio, Contacto formularioInscripcion, Foto imagen, List<Foto> imagenesComplementarias, List<Usuario> profesores, List<Usuario> usuariosAnotados) {
        Proyecto proyecto = pdao.findById(id).get();
        proyecto.setComentarios(comentarios);
        proyecto.setDescripcion(descripcion);
        proyecto.setFechaFin(fechaFin);
        proyecto.setFechaInicio(fechaInicio);
        proyecto.setFormularioInscripcion(formularioInscripcion);
        proyecto.setImagen(imagen);
        proyecto.setImagenesComplementarias(imagenesComplementarias);
        proyecto.setIntroduccion(introduccion);
        proyecto.setProfesores(profesores);
        proyecto.setUsuariosAnotados(usuariosAnotados);
        return pdao.save(proyecto);
    }

}
