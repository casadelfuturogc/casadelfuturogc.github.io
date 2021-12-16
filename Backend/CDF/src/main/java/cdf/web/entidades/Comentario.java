package cdf.web.entidades;

import java.util.Date;

public class Comentario {

    private Usuario usuario;
    private String comentario;
    private Date fecha;

    public Comentario() {
    }

    public Comentario(Usuario usuario, String comentario, Date fecha) {
        this.usuario = usuario;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
