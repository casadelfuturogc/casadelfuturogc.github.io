package cdf.web.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String documento;
    private String nombre;
    private String apellido;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    private String telefono;
    private String contraseña;
    private String contraseñaValidacion;
    @ManyToMany(mappedBy = "profesores")
    private List<Proyecto> proyectos;

    public Usuario() {
    }

    public Usuario(String id, String documento, String nombre, String apellido, String email, Date fechaNacimiento, String telefono, String contraseña, String contraseñaValidacion) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.contraseñaValidacion = contraseñaValidacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getContraseñaValidacion() {
        return contraseñaValidacion;
    }

    public void setContraseñaValidacion(String contraseñaValidacion) {
        this.contraseñaValidacion = contraseñaValidacion;
    }

}
