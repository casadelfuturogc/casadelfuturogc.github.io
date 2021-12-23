package cdf.web.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Evento implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private String introduccion;
    private String descripcion;
    private String nombre;
    @OneToOne
    private Foto imagen;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Foto> imagenesComplementarias;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Comentario> comentarios;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Usuario> usuariosAnotados;

    public Evento() {
    }

    public Evento(String id, Date fecha, String introduccion, String descripcion, String nombre, Foto imagen, List<Foto> imagenesComplementarias, List<Comentario> comentarios, List<Usuario> usuariosAnotados) {
        this.id = id;
        this.fecha = fecha;
        this.introduccion = introduccion;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.imagen = imagen;
        this.imagenesComplementarias = imagenesComplementarias;
        this.comentarios = comentarios;
        this.usuariosAnotados = usuariosAnotados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
