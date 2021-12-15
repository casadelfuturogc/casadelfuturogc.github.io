package cdf.web.entidades;

import java.util.Date;
import java.util.List;

public class Curso {

    private Foto imagen;
    private List<Foto> imagenesComplementarias;
    private String introduccion;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private List<Comentario> comentarios;
    private String formularioInscripcion;
    private List<Usuario> usuariosAnotados;

    public Curso() {
    }

    public Curso(Foto imagen, List<Foto> imagenesComplementarias, String introduccion, String descripcion, Date fechaInicio, Date fechaFin, List<Comentario> comentarios, String formularioInscripcion, List<Usuario> usuariosAnotados) {
        this.imagen = imagen;
        this.imagenesComplementarias = imagenesComplementarias;
        this.introduccion = introduccion;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.comentarios = comentarios;
        this.formularioInscripcion = formularioInscripcion;
        this.usuariosAnotados = usuariosAnotados;
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

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public String getFormularioInscripcion() {
        return formularioInscripcion;
    }

    public void setFormularioInscripcion(String formularioInscripcion) {
        this.formularioInscripcion = formularioInscripcion;
    }

    public List<Usuario> getUsuariosAnotados() {
        return usuariosAnotados;
    }

    public void setUsuariosAnotados(List<Usuario> usuariosAnotados) {
        this.usuariosAnotados = usuariosAnotados;
    }

}
