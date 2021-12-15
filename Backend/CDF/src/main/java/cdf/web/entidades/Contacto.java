package cdf.web.entidades;

public class Contacto {

    private String nombreCompleto;
    private String email;
    private String mensaje;

    public Contacto() {
    }

    public Contacto(String nombreCompleto, String email, String mensaje) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.mensaje = mensaje;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
