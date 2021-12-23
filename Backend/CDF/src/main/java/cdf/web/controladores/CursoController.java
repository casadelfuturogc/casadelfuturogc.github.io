package cdf.web.controladores;

import cdf.web.entidades.Comentario;
import cdf.web.entidades.Curso;
import cdf.web.entidades.Foto;
import cdf.web.entidades.Usuario;
import cdf.web.servicios.ComentarioServicio;
import cdf.web.servicios.CursoServicio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/cursos")
@Controller
public class CursoController {

    @Autowired
    CursoServicio cs;

    @Autowired
    ComentarioServicio cms;

    @GetMapping("")
    public String cursos(ModelMap modelo) {
        List<Curso> cursos = cs.listarCursos();
        modelo.put("cursos", cursos);
        return "cursos.html";
    }

//    @RequestMapping(value = "/{nombre}", method = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping("{nombre}")
    public String curso(@PathVariable String nombre, ModelMap modelo, String comentario, HttpSession session) {
        Curso curso = cs.buscarCursoNombre(nombre);
        Usuario login = (Usuario) session.getAttribute("usuariosession");

        if (comentario != null) {
            Comentario comentarioPublicado = new Comentario();
            comentarioPublicado.setComentario(comentario);
            comentarioPublicado.setFecha(new Date());
            comentarioPublicado.setUsuario(null);
            cs.agregarComentario(curso.getId(), comentarioPublicado);
            List<Comentario> comentarios = curso.getComentarios();
            modelo.put("comentarios", comentarios);
            modelo.put("curso", curso);
            return "redirect:/cursos/{nombre}";

        }

        comentario = null;
        List<Comentario> comentarios = curso.getComentarios();
        modelo.put("comentarios", comentarios);
        modelo.put("curso", curso);
        return "curso.html";
    }

    @GetMapping("/editar-curso")
    public String editarCurso(@RequestParam(required = false) String id, ModelMap modelo, String accion) {
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
    public String actualizarCurso(@RequestParam(required = false) String nombre, @RequestParam(required = false) MultipartFile archivo, @RequestParam(required = false) List<MultipartFile> archivos, @RequestParam(required = false) String id, @RequestParam(required = false) List<Comentario> comentarios, @RequestParam(required = false) String descripcion, @RequestParam(required = false) String fechaFin, @RequestParam(required = false) String fechaInicio, @RequestParam(required = false) String formularioInscripcion, @RequestParam(required = false) List<Usuario> usuariosAnotados, @RequestParam(required = false) String introduccion) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        // format.parse(fechaFin), format.parse(fechaInicio)
        try {
            if (id == null) {
                cs.agregarCurso(nombre, archivo, archivos, comentarios, descripcion, format.parse(fechaFin), format.parse(fechaInicio), formularioInscripcion, usuariosAnotados, introduccion);
            } else {                
                cs.editarCurso(nombre, archivo, archivos, id, comentarios, descripcion, format.parse(fechaFin), format.parse(fechaInicio), formularioInscripcion, usuariosAnotados, introduccion);
            }
            return "redirect:/cursos";
        } catch (ParseException e) {
            return "editarcurso.html";
        }

    }

    @PostMapping("/eliminar-curso")
    public String eliminarCurso(@RequestParam String id) {
        cs.eliminarCurso(id);
        return "redirect:/cursos";
    }

}
