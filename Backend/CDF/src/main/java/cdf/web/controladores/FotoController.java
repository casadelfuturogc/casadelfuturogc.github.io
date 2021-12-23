package cdf.web.controladores;

import cdf.web.entidades.Curso;
import cdf.web.entidades.Proyecto;
import cdf.web.entidades.Evento;
import org.springframework.http.ResponseEntity;
import cdf.web.entidades.Usuario;
import cdf.web.servicios.CursoServicio;
import cdf.web.servicios.ProyectoServicio;
import cdf.web.servicios.EventoServicio;
import cdf.web.servicios.EventoServicio;
import cdf.web.servicios.FotoServicio;
import cdf.web.servicios.ProyectoServicio;
import cdf.web.servicios.UsuarioServicio;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/foto")
public class FotoController {

    @Autowired
    FotoServicio fs;

    @Autowired
    EventoServicio es;

    @Autowired
    CursoServicio cs;

    @Autowired
    ProyectoServicio ps;

    @GetMapping("/evento")
    public ResponseEntity<byte[]> fotoEvento(@RequestParam String id) throws Exception {
        Evento evento = es.buscarEventoId(id);

        if (evento.getImagen() == null) {
            throw new Exception("El evento no tiene foto");
        }

        byte[] foto = evento.getImagen().getContenido();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(foto, headers, HttpStatus.OK);

    }

    @GetMapping("/proyecto")
    public ResponseEntity<byte[]> fotoProyecto(@RequestParam String id) throws Exception {
        Proyecto proyecto = ps.buscarProyectoId(id);

        if (proyecto.getImagen() == null) {
            throw new Exception("El proyecto no tiene foto");
        }

        byte[] foto = proyecto.getImagen().getContenido();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(foto, headers, HttpStatus.OK);

    }
    
    
      @GetMapping("/curso")
    public ResponseEntity<byte[]> fotoCurso(@RequestParam String id) throws Exception {
        Curso curso = cs.buscarCursoId(id);

        if (curso.getImagen() == null) {
            throw new Exception("El curso no tiene foto");
        }

        byte[] foto = curso.getImagen().getContenido();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(foto, headers, HttpStatus.OK);

    }

}
