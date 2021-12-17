package cdf.web.repositorios;

import cdf.web.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CursoDAO extends JpaRepository<Curso, String> {

    @Query("select c from Curso c where c.nombre like :nombre")
    public Curso buscarCursoNombre(@Param("nombre") String nombre);

}
