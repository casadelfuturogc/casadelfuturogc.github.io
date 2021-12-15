package cdf.web.entidades;

import java.util.Date;
import java.util.List;

public class Proyecto {

    private Date fechaInicio;
    private Date fechaFin;
    private String introduccion;
    private String descripcion;
    private Foto imagen;
    private List<Foto> imagenesComplementarias;
    private List<Comentario> comentarios;
    private List<Usuario> profesores;
    private Contacto formularioInscripcion;
    private List<Usuario> usuariosAnotados;

    public Proyecto() {
    }

    public Proyecto(Date fechaInicio, Date fechaFin, String introduccion, String descripcion, Foto imagen, List<Foto> imagenesComplementarias, List<Comentario> comentarios, List<Usuario> profesores, Contacto formularioInscripcion, List<Usuario> usuariosAnotados) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.introduccion = introduccion;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.imagenesComplementarias = imagenesComplementarias;
        this.comentarios = comentarios;
        this.profesores = profesores;
        this.formularioInscripcion = formularioInscripcion;
        this.usuariosAnotados = usuariosAnotados;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getIntroduccion() {
        return introduccion;
    }

    public void setIntroduccion(String introduccion) {
        this.introduccion = introduccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Foto getImagen() {
        return imagen;
    }

    public void setImagen(Foto imagen) {
        this.imagen = imagen;
    }

    public List<Foto> getImagenesComplementarias() {
        return imagenesComplementarias;
    }

    public void setImagenesComplementarias(List<Foto> imagenesComplementarias) {
        this.imagenesComplementarias = imagenesComplementarias;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Usuario> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Usuario> profesores) {
        this.profesores = profesores;
    }

    public Contacto getFormularioInscripcion() {
        return formularioInscripcion;
    }

    public void setFormularioInscripcion(Contacto formularioInscripcion) {
        this.formularioInscripcion = formularioInscripcion;
    }

    public List<Usuario> getUsuariosAnotados() {
        return usuariosAnotados;
    }

    public void setUsuariosAnotados(List<Usuario> usuariosAnotados) {
        this.usuariosAnotados = usuariosAnotados;
    }

}
