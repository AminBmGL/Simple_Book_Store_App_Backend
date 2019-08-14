package livre.applivre.service;

import livre.applivre.domain.Categorie;
import livre.applivre.domain.Livre;
import livre.applivre.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {
    @Autowired
    LivreRepository livreRepository;
    public void venteLivre(Categorie categorie,int n)
    {
        List<Livre> livres=livreRepository.findByCategorieAndVendu(categorie,false);
        List<Livre>livres1=livres.subList(0, n-1);
        livres1.forEach(livre->
                {
                    livre.setVendu(true);
                }

                );
        livreRepository.saveAll(livres1);
    }
}
