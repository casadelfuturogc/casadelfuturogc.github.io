package cdf.web.repositorios;

import cdf.web.entidades.Evento;
import cdf.web.entidades.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventoDAO extends JpaRepository<Evento, String> {

    @Query("select e from Evento e where e.nombre like :nombre")
    public Evento buscarEventoNombre(@Param("nombre") String nombre);



}
