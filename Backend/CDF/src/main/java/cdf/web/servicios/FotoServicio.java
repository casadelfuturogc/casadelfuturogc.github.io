package cdf.web.servicios;

import cdf.web.entidades.Foto;
import cdf.web.repositorios.FotoDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoServicio {

    @Autowired
    FotoDAO fdao;

    @Transactional
    public Foto guardar(MultipartFile archivo) {
        if (archivo != null) {
            try {
                Foto foto = new Foto();
                foto.setMime(archivo.getContentType());
                foto.setNombre(archivo.getName());
                foto.setContenido(archivo.getBytes());
                
                return fdao.save(foto);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return null;
    }

    @Transactional
    public Foto actualizar(MultipartFile archivo, String id) {
        if (archivo != null) {
            try {
                Foto foto = new Foto();
                if (id != null) {
                    foto = fdao.findById(id).get();
                }

                foto.setMime(archivo.getContentType());
                foto.setNombre(archivo.getName());
                foto.setContenido(archivo.getBytes());
                return fdao.save(foto);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return null;
    }

}
