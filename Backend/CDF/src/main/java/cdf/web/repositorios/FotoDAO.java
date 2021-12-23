
package cdf.web.repositorios;

import cdf.web.entidades.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotoDAO extends JpaRepository<Foto, String>{
    
}
