package cdf.web.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Curso {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private Foto imagen;
    private List<Foto> imagenesComplementarias;
    private String introduccion;
    private String descripcion;
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @OneToMany
    private List<Comentario> comentarios;
    @OneToMany
    private List<Usuario> usuariosAnotados;

    public Curso() {
    }

    public Curso(String id, Foto imagen, List<Foto> imagenesComplementarias, String introduccion, String descripcion, Date fechaInicio, Date fechaFin, List<Comentario> comentarios, List<Usuario> usuariosAnotados) {
        this.id = id;
        this.imagen = imagen;
        this.imagenesComplementarias = imagenesComplementarias;
        this.introduccion = introduccion;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.comentarios = comentarios;
        this.usuariosAnotados = usuariosAnotados;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Usuario> getUsuariosAnotados() {
        return usuariosAnotados;
    }

    public void setUsuariosAnotados(List<Usuario> usuariosAnotados) {
        this.usuariosAnotados = usuariosAnotados;
    }

}
