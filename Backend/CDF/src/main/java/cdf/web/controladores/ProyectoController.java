package cdf.web.controladores;

import cdf.web.entidades.Comentario;
import cdf.web.entidades.Foto;
import cdf.web.entidades.Proyecto;
import cdf.web.entidades.Usuario;
import cdf.web.servicios.ProyectoServicio;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/proyectos")
@Controller
public class ProyectoController {

    @Autowired
    ProyectoServicio ps;

    @GetMapping("")
    public String proyectos(ModelMap modelo) {
        List<Proyecto> proyectos = ps.listarProyectos();
        modelo.put("proyectos", proyectos);
        return "proyectos.html";
    }

    @GetMapping("/{nombre}")
    public String proyecto(@PathVariable String nombre, ModelMap modelo, String comentario) {
        Proyecto proyecto = ps.buscarProyectoNombre(nombre);

        if (comentario != null) {
            Comentario comentarioPublicado = new Comentario();
            comentarioPublicado.setComentario(comentario);
            comentarioPublicado.setFecha(new Date());
            comentarioPublicado.setUsuario(null);
            ps.agregarComentario(proyecto.getId(), comentarioPublicado);
            List<Comentario> comentarios = proyecto.getComentarios();
            modelo.put("comentarios", comentarios);
            modelo.put("proyecto", proyecto);
            return "redirect:/proyectos/{nombre}";

        }

        comentario = null;
        List<Comentario> comentarios = proyecto.getComentarios();
        modelo.put("comentarios", comentarios);

        modelo.put("proyecto", proyecto);
        return "proyecto.html";
    }

    @GetMapping("/editar-proyecto")
    public String editarProyecto(@RequestParam(required = false) String id, ModelMap modelo, String accion) {
        if (accion == null) {
            accion = "Crear";
        }
        Proyecto proyecto = new Proyecto();
        if (id != null) {
            proyecto = ps.buscarProyectoId(id);
            modelo.put("proyecto", proyecto);
            modelo.put("accion", "Actualizar");
        }
        modelo.put("accion", accion);
        modelo.put("proyecto", proyecto);
        return "editarproyecto.html";
    }

    @PostMapping("/actualizar-proyecto")
    public String actualizarProyecto(@RequestParam(required = false) String nombre, @RequestParam(required = false) MultipartFile archivo, @RequestParam(required = false) List<MultipartFile> archivos, @RequestParam(required = false) String id, @RequestParam(required = false) List<Comentario> comentarios, @RequestParam(required = false) String introduccion, @RequestParam(required = false) String descripcion, @RequestParam(required = false) String fechaFin, @RequestParam(required = false) String fechaInicio, @RequestParam(required = false) List<Usuario> profesores, @RequestParam(required = false) List<Usuario> usuariosAnotados) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("HASTA ACA LLEGO");
        try {
            if (id == null) {
                ps.registrarProyecto(nombre, archivo, archivos, comentarios, introduccion, descripcion, format.parse(fechaFin), format.parse(fechaInicio), profesores, usuariosAnotados);
            } else {
                ps.editarProyecto(nombre, archivo, archivos, id, comentarios, introduccion, descripcion, format.parse(fechaFin), format.parse(fechaInicio), profesores, usuariosAnotados);
            }
            return "redirect:/proyectos";
        } catch (Exception e) {
            return "editarproyecto.html";
        }
    }

    @PostMapping("/eliminar-proyecto")
    public String eliminarProyecto(String id) {
        ps.eliminarProyecto(id);
        return "redirect:/proyectos";
    }

}
