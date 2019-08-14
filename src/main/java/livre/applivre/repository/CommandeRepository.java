package livre.applivre.repository;
import livre.applivre.domain.Commande;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends CrudRepository <Commande, Integer>{
}
