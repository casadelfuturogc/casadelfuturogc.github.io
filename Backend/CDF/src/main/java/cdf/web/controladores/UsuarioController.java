package cdf.web.controladores;

import cdf.web.entidades.Usuario;
import cdf.web.servicios.UsuarioServicio;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioServicio us;

    public String editProfile(@RequestParam String documento, ModelMap modelo) {
        Usuario usuario = us.buscarUsuarioDocumento(documento);
        modelo.put("perfil", usuario);
        return "editarpefil.html";
    }

    public String actualizarPefil(ModelMap modelo, MultipartFile archivo, String nombre, String apellido, String documento, String clave, String claveValidacion, String telefono, Date fechaNacimiento, String email) {

        Usuario usuario = us.buscarUsuarioDocumento(documento);
        if (usuario == null) {
            modelo.put("perfil", usuario);
            modelo.put("error", "Ocurrió un error");
            return "editperfil.html";
        }
        us.editarUsuario(archivo, nombre, apellido, documento, clave, claveValidacion, telefono, fechaNacimiento, email);

        return "redirect:/index";
    }

}
