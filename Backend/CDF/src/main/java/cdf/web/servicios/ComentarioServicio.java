package cdf.web.servicios;

import cdf.web.entidades.Comentario;
import cdf.web.entidades.Usuario;
import cdf.web.repositorios.ComentarioDAO;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentarioServicio {

    @Autowired
    ComentarioDAO cdao;

    @Transactional
    public Comentario crearComentario(Usuario usuario, Date fecha, String texto
    ) {
        Comentario comentario = new Comentario();
        comentario.setComentario(texto);
        comentario.setFecha(fecha);
        comentario.setUsuario(usuario);
        return cdao.save(comentario);
    }

    @Transactional
    public void eliminarComentario(String id) {
        Comentario comentario = cdao.findById(id).get();
        cdao.delete(comentario);
    }

    public List<Comentario> listarComentarios() {
        return cdao.findAll();
    }

}
