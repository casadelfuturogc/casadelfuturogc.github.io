package cdf.web.servicios;

import cdf.web.entidades.Comentario;
import cdf.web.entidades.Usuario;
import cdf.web.repositorios.ComentarioDAO;
import java.util.Date;

public class ComentarioServicio {

    ComentarioDAO cdao;

    public Comentario crearComentario(Usuario usuario, Date fecha, String texto
    ) {
        Comentario comentario = new Comentario();
        comentario.setComentario(texto);
        comentario.setFecha(fecha);
        comentario.setUsuario(usuario);
        return cdao.save(comentario);
    }
    
    public void eliminarComentario(String id){
        Comentario comentario = cdao.findById(id).get();
        cdao.delete(comentario);
    }

}
