package livre.applivre;


import livre.applivre.domain.Livre;
import livre.applivre.repository.LivreRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LivreRepositoryTest {
  @Autowired
    private LivreRepository livreRepository;



    @Test
    public void whenFindByName_thenReturnEmployee() {
        Livre livre = livreRepository.findById(1).orElse(null);
        assertThat(livre.getCategorie().getNom()).isEqualTo("categorie1");

    }
}