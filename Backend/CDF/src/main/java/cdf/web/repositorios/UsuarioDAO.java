package cdf.web.repositorios;

import cdf.web.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioDAO extends JpaRepository<Usuario, String> {

    @Query("select u from Usuario u where u.documento like :documento")
    public Usuario buscarUsuarioDocumento(@Param("documento") String documento);

}
