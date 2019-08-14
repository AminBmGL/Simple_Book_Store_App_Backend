package livre.applivre.repository;
import livre.applivre.domain.Panier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepository  extends CrudRepository<Panier, Integer>{
    Panier findById(int id);
}
