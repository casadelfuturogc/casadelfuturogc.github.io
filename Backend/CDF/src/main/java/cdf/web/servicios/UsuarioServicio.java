package cdf.web.servicios;

import cdf.web.entidades.Usuario;
import cdf.web.repositorios.UsuarioDAO;
import java.util.Date;
import java.util.List;

public class UsuarioServicio {

    UsuarioDAO udao;

    public Usuario registrarUsuario(String nombre, String apellido, String documento, String contraseña, String contraseñaValidacion, String telefono, Date fechaNacimiento, String email) {
        Usuario usuario = udao.findById(email).get();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setContraseña(contraseña);
        usuario.setContraseñaValidacion(contraseñaValidacion);
        usuario.setDocumento(documento);
        usuario.setEmail(email);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setTelefono(telefono);
        return udao.save(usuario);
    }

    public void editarUsuario(String nombre, String apellido, String documento, String contraseña, String contraseñaValidacion, String telefono, Date fechaNacimiento, String email) {
        Usuario usuario = udao.findById(documento).get();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setContraseña(contraseña);
        usuario.setContraseñaValidacion(contraseñaValidacion);
        usuario.setDocumento(documento);
        usuario.setEmail(email);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setTelefono(telefono);
        udao.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return udao.findAll();
    }

    public void bajaUsuario(String documento) {
        Usuario usuario = udao.findById(documento).get();
        udao.delete(usuario);
    }
}
