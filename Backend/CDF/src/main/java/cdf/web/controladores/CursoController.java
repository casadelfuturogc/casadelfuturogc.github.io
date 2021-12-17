package cdf.web.controladores;

import cdf.web.entidades.Comentario;
import cdf.web.entidades.Curso;
import cdf.web.entidades.Foto;
import cdf.web.entidades.Usuario;
import cdf.web.servicios.CursoServicio;
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

@RequestMapping("/cursos")
@Controller
public class CursoController {
    
    @Autowired
    CursoServicio cs;

    @GetMapping("")
    public String cursos(ModelMap modelo) {
        List<Curso> cursos = cs.listarCursos();
        modelo.put("cursos", cursos);
        return "cursos.html";
    }

    @GetMapping("/{nombre}")
    public String curso(@PathVariable String nombre, ModelMap modelo) {
        Curso curso = cs.buscarCursoNombre(nombre);
        modelo.put("curso", curso);
        return "curso.html";
    }

    @GetMapping("/editar-curso")
    public String editarCurso(@RequestParam String id, ModelMap modelo, String accion) {
        if (accion == null) {
            accion = "Crear";
        }
        Curso curso = new Curso();
        if (id != null) {
            curso = cs.buscarCursoId(id);
            modelo.put("curso", curso);
            modelo.put("accion", "Actualizar");
        }
        modelo.put("accion", accion);
        modelo.put("curso", curso);
        return "editarcurso.html";
    }

    @PostMapping("/actualizar-curso")
    public String actualizarCurso(String id, String nombre, List<Comentario> comentarios, String fechaFin, String fechaInicio, Foto foto, List<Foto> imagenesComplementarias, List<Usuario> usuariosAnotados) {
        Curso curso = cs.buscarCursoId(id);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            if (id == null) {
                cs.agregarCurso(comentarios, nombre, format.parse(fechaFin), format.parse(fechaInicio), nombre, foto, imagenesComplementarias, usuariosAnotados, nombre);
            } else {
                cs.editarCurso(id, comentarios, nombre, format.parse(fechaFin), format.parse(fechaInicio), nombre, foto, imagenesComplementarias, usuariosAnotados, nombre);
            }
            return "redirect:/";
        } catch (Exception e) {
            return "editarcurso.html";
        }

    }

    @PostMapping("/eliminar-curso")
    public String eliminarCurso(String id) {
        cs.eliminarCurso(id);
        return "redirect:/";
    }

}
