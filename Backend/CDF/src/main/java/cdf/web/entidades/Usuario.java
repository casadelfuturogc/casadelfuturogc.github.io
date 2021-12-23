package cdf.web.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario implements Serializable {

    @Id
    private String documento;
    private String nombre;
    private String apellido;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    private String telefono;
    private String clave;
    @OneToOne
    private Foto imagen;
    private String claveValidacion;
    @ManyToMany(mappedBy = "profesores")
    private List<Proyecto> proyectos;

    public Usuario() {
    }

    public Usuario(String documento, String nombre, String apellido, String email, Date fechaNacimiento, String telefono, String clave, Foto imagen, String claveValidacion, List<Proyecto> proyectos) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.clave = clave;
        this.imagen = imagen;
        this.claveValidacion = claveValidacion;
        this.proyectos = proyectos;
    }

    public Foto getImagen() {
        return imagen;
    }

    public void setImagen(Foto imagen) {
        this.imagen = imagen;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClaveValidacion() {
        return claveValidacion;
    }

    public void setClaveValidacion(String claveValidacion) {
        this.claveValidacion = claveValidacion;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

}
