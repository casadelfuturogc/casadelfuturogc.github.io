package cdf.web.repositorios;

import cdf.web.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoDAO extends JpaRepository<Curso, String> {

}
