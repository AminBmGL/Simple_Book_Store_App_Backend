package livre.applivre.repository;
import livre.applivre.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User, Integer>
{ public User findById(int id);
public User findByUsername(String username);
}
