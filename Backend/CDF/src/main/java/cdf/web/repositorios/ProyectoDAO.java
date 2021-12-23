package cdf.web.repositorios;

import cdf.web.entidades.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProyectoDAO extends JpaRepository<Proyecto, String> {

    @Query("select p from Proyecto p where p.nombre like :nombre")
    public Proyecto buscarProyectoNombre(@Param("nombre") String nombre);

}
