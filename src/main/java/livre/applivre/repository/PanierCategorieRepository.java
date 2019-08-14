package livre.applivre.repository;

import livre.applivre.domain.PanierCategorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierCategorieRepository extends CrudRepository<PanierCategorie,Integer> {
}
