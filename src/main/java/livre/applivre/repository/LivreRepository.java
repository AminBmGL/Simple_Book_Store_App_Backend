package livre.applivre.repository;
import livre.applivre.domain.Categorie;
import livre.applivre.domain.Livre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreRepository extends CrudRepository<Livre, Integer> {
    List<Livre> findByCategorieAndVendu(Categorie categorie, Boolean v);
}
