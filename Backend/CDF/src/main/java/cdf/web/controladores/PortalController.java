package cdf.web.controladores;

import cdf.web.servicios.CursoServicio;
import cdf.web.servicios.EventoServicio;
import cdf.web.servicios.ProyectoServicio;
import cdf.web.servicios.UsuarioServicio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/")
public class PortalController {

    @Autowired
    UsuarioServicio us;

    @Autowired
    EventoServicio es;

    @Autowired
    CursoServicio cs;
    

    @GetMapping
    public String index(ModelMap modelo) {

        modelo.put("cursos", cs.listarCursos());
        modelo.put("eventos", es.listarEventos());

        return "index.html";
    }

    @PreAuthorize("!hasAuthority('USER')")
    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @PostMapping("/registrarUsuario")
    public String registrarusuario(MultipartFile archivo, String nombre, String apellido, String documento, String clave, String claveValidacion, String telefono, String fechaNacimiento, String email) throws Exception {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            us.registrarUsuario(nombre, apellido, documento, clave, claveValidacion, telefono, format.parse(fechaNacimiento), email);
            return "redirect:/";
        } catch (ParseException ex) {
            return "redirect:/login";
        }

    }

}
