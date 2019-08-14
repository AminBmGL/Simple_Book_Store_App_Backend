package livre.applivre;

import static org.assertj.core.api.Assertions.assertThat;


import livre.applivre.domain.Categorie;
import livre.applivre.repository.CategorieRepository;
import livre.applivre.service.CategorieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CategorieServiceTest {
 @TestConfiguration
    static class CategorieServiceImplTestContextConfiguration {
      @Bean
        public CategorieService categorieService() {
            return new CategorieService();
        }
    }
 @Autowired
    private CategorieService categorieService;
@MockBean
    private CategorieRepository categorieRepository;
 @Before
    public void setUp() {
       Categorie categorie = new Categorie("genre1","categorie1",15,20);

        Mockito.when(categorieRepository.findByNom(categorie.getNom()))
                .thenReturn(categorie); }
    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
Categorie found = categorieService.findByNom("genre1");
assertThat(found.getNom())
                .isEqualTo("genre1"); }}