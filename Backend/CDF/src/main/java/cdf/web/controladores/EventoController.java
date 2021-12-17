package cdf.web.controladores;

import cdf.web.entidades.Comentario;
import cdf.web.entidades.Evento;
import cdf.web.entidades.Foto;
import cdf.web.entidades.Usuario;
import cdf.web.servicios.EventoServicio;
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
    public String evento(@PathVariable String id, ModelMap modelo) {
        Evento evento = es.buscarEventoId(id);
        modelo.put("evento", evento);
        return "evento.html";
    }

    @GetMapping("/editar-evento")
    public String editarEvento(@RequestParam String id, ModelMap modelo, String accion) {
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
    public String actualizarEvento(String id, String nombre, List<Comentario> comentarios, String fecha, Foto imagen, List<Foto> imagenesComplementarias, List<Usuario> usuariosAnotados) {
        Evento evento = es.buscarEventoId(id);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (id == null) {
                es.registrarEvento(comentarios, fecha, nombre, usuariosAnotados, imagenesComplementarias, imagen, format.parse(fecha));
            } else {
                es.editarEvento(id, comentarios, fecha, nombre, usuariosAnotados, imagenesComplementarias, imagen, format.parse(fecha));
            }
            return "redirect:/";
        } catch (Exception e) {
            return "editarevento.html";
        }
    }

    @PostMapping("/eliminar-evento")
    public String eliminarEvento(String id) {
        es.eliminarEvento(id);
        return "redirect:/";
    }

}
