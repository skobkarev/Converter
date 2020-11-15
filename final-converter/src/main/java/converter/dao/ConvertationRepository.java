package converter.dao;

import converter.entity.Convertation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvertationRepository extends JpaRepository<Convertation, Integer> {

}
