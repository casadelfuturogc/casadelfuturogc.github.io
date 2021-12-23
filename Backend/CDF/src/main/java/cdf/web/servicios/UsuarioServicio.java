package cdf.web.servicios;

import cdf.web.entidades.Foto;
import cdf.web.entidades.Usuario;
import cdf.web.excepciones.ErrorServicio;
import cdf.web.repositorios.UsuarioDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    UsuarioDAO udao;

    @Autowired
    FotoServicio fs;

    @Transactional
    public Usuario registrarUsuario(String nombre, String apellido, String documento, String clave, String claveValidacion, String telefono, Date fechaNacimiento, String email) throws ErrorServicio {
        Usuario usuario = new Usuario();
        List<String> usuariosRegistrados = new ArrayList<>();
        for (Usuario usuario1 : udao.findAll()) {
            usuariosRegistrados.add(usuario1.getDocumento());
        }
        if (usuariosRegistrados.contains(documento)) {
            throw new ErrorServicio("El usuario ya se encuentra registrado");

        }
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        String criptada = new BCryptPasswordEncoder().encode(clave);
        usuario.setClave(criptada);
        usuario.setClaveValidacion(criptada);
        usuario.setDocumento(documento);
        usuario.setEmail(email);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setTelefono(telefono);
//        Foto imagen = fs.guardar(archivo);
//        usuario.setImagen(imagen);
        return udao.save(usuario);
    }

    @Transactional
    public Usuario buscarUsuarioDocumento(String documento) {
        return udao.buscarUsuarioDocumento(documento);
    }

    @Transactional
    public void editarUsuario(MultipartFile archivo, String nombre, String apellido, String documento, String clave, String claveValidacion, String telefono, Date fechaNacimiento, String email) {
        Usuario usuario = udao.findById(documento).get();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setClave(clave);
        usuario.setClaveValidacion(claveValidacion);
        usuario.setDocumento(documento);
        usuario.setEmail(email);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setTelefono(telefono);
        String idFoto = null;
        if (usuario.getImagen() != null) {
            idFoto = usuario.getImagen().getId();
        }
        Foto imagen = fs.actualizar(archivo, idFoto);
        usuario.setImagen(imagen);
        udao.save(usuario);
    }

    @Transactional
    public List<Usuario> listarUsuarios() {
        return udao.findAll();
    }

    @Transactional
    public void bajaUsuario(String documento) {
        Usuario usuario = udao.findById(documento).get();
        udao.delete(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String documento) throws UsernameNotFoundException {
        Usuario usuario = udao.buscarUsuarioDocumento(documento);

        if (usuario != null) {
            return new User(usuario.getDocumento(), usuario.getClave(), Arrays.asList(new SimpleGrantedAuthority("USER")));

        } else {
            throw new UsernameNotFoundException("The usuario wasn't found on the database");
        }
    }
}
