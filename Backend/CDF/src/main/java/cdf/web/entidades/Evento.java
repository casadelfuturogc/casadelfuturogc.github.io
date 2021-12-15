package cdf.web.entidades;

import java.util.Date;
import java.util.List;

public class Evento {

    private Date fecha;
    private String introduccion;
    private String descripcion;
    private Foto imagen;
    private List<Foto> imagenesComplementarias;
    private List<Comentario> comentarios;
    private List<Usuario> usuariosAnotados;

    public Evento() {
    }

    public Evento(Date fecha, String introduccion, String descripcion, Foto imagen, List<Foto> imagenesComplementarias, List<Comentario> comentarios, List<Usuario> usuariosAnotados) {
        this.fecha = fecha;
        this.introduccion = introduccion;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.imagenesComplementarias = imagenesComplementarias;
        this.comentarios = comentarios;
        this.usuariosAnotados = usuariosAnotados;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public List<Usuario> getUsuariosAnotados() {
        return usuariosAnotados;
    }

    public void setUsuariosAnotados(List<Usuario> usuariosAnotados) {
        this.usuariosAnotados = usuariosAnotados;
    }

}
