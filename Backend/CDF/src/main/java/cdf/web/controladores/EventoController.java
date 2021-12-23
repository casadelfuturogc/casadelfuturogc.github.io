package cdf.web.controladores;

import cdf.web.entidades.Comentario;
import cdf.web.entidades.Evento;
import cdf.web.entidades.Foto;
import cdf.web.entidades.Usuario;
import cdf.web.servicios.EventoServicio;
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

@RequestMapping("/eventos")
@Controller
public class EventoController {

    @Autowired
    EventoServicio es;

    @GetMapping("")
    public String eventos(ModelMap modelo) {
        List<Evento> eventos = es.listarEventos();
        modelo.put("eventos", eventos);
        return "eventos.html";
    }

    @GetMapping("/{nombre}")
    public String evento(@PathVariable String nombre, String comentario, ModelMap modelo) {
        Evento evento = es.buscarEventoNombre(nombre);

        if (comentario != null) {
            Comentario comentarioPublicado = new Comentario();
            comentarioPublicado.setComentario(comentario);
            comentarioPublicado.setFecha(new Date());
            comentarioPublicado.setUsuario(null);
            es.agregarComentario(evento.getId(), comentarioPublicado);
            List<Comentario> comentarios = evento.getComentarios();
            modelo.put("comentarios", comentarios);
            modelo.put("evento", evento);
            return "redirect:/eventos/{nombre}";

        }

        comentario = null;
        List<Comentario> comentarios = evento.getComentarios();
        modelo.put("comentarios", comentarios);
        modelo.put("evento", evento);
        return "evento.html";
    }

    @GetMapping("/editar-evento")
    public String editarEvento(@RequestParam(required = false) String id, ModelMap modelo, String accion) {
        if (accion == null) {
            accion = "Crear";
        }
        Evento evento = new Evento();
        if (id != null) {
            evento = es.buscarEventoId(id);
            modelo.put("evento", evento);
            modelo.put("accion", "Actualizar");
        }
        modelo.put("accion", accion);
        modelo.put("evento", evento);
        return "editarevento.html";
    }

    @PostMapping("/actualizar-evento")
    public String actualizarEvento(ModelMap modelo, @RequestParam(required = false) String id, @RequestParam(required = false) String nombre, @RequestParam(required = false) MultipartFile archivo, @RequestParam(required = false) List<MultipartFile> archivos, @RequestParam(required = false) List<Comentario> comentarios, @RequestParam(required = false) String descripcion, @RequestParam(required = false) String introduccion, @RequestParam(required = false) List<Usuario> usuariosAnotados, @RequestParam(required = false) String fecha) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (id == null) {
                es.registrarEvento(nombre, archivo, archivos, comentarios, descripcion, introduccion, usuariosAnotados, format.parse(fecha));
            } else {
                es.editarEvento(nombre, archivo, archivos, id, comentarios, descripcion, introduccion, usuariosAnotados, format.parse(fecha));
            }
            return "redirect:/eventos";
        } catch (Exception e) {
            modelo.put("error", e.getMessage());
            return "editarevento.html";
        }
    }

    @PostMapping("/eliminar-evento")
    public String eliminarEvento(String id) {
        es.eliminarEvento(id);
        return "redirect:/eventos";
    }

}
