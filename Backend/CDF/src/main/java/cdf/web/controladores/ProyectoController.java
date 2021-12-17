package cdf.web.controladores;

import cdf.web.entidades.Comentario;
import cdf.web.entidades.Foto;
import cdf.web.entidades.Proyecto;
import cdf.web.entidades.Usuario;
import cdf.web.servicios.ProyectoServicio;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String proyecto(@PathVariable String id, ModelMap modelo) {
        Proyecto proyecto = ps.buscarProyectoId(id);
        modelo.put("proyecto", proyecto);
        return "proyecto.html";
    }

    @GetMapping("/editar-proyecto")
    public String editarProyecto(@RequestParam String id, ModelMap modelo, String accion) {
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
    public String actualizarProyecto(String id, List<Comentario> comentarios, String introduccion, String descripcion, String fechaFin, String fechaInicio, Foto imagen, List<Foto> imagenesComplementarias, List<Usuario> profesores, List<Usuario> usuariosAnotados) {
        Proyecto proyecto = ps.buscarProyectoId(id);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (id == null) {
                ps.registrarProyecto(comentarios, introduccion, descripcion, format.parse(fechaFin), format.parse(fechaInicio), imagen, imagenesComplementarias, profesores, usuariosAnotados);
            } else {
                ps.editarProyecto(id, comentarios, introduccion, descripcion, format.parse(fechaFin), format.parse(fechaInicio), imagen, imagenesComplementarias, profesores, usuariosAnotados);
            }
            return "redirect:/";
        } catch (Exception e) {
            return "editarproyecto.html";
        }
    }

    @PostMapping("/eliminar-proyecto")
    public String eliminarProyecto(String id) {
        ps.eliminarProyecto(id);
        return "redirect:/";
    }

}
