package livre.applivre.service;

import livre.applivre.domain.Categorie;
import livre.applivre.domain.Panier;
import livre.applivre.domain.PanierCategorie;
import livre.applivre.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PanierService {
    @Autowired
    PanierRepository panierRepository;
    @Autowired
    CategorieService categorieService;
  public Panier addPanier(Panier panier)
  {
       return  panierRepository.save(panier);

  }
    public void deletePanier(int id)
    { Panier panier=panierRepository.findById(id);
        Set<PanierCategorie> panierCategories= panier.getPanierCategorie();
        panierCategories.forEach(panierCategorie -> {
                    Categorie c=panierCategorie.getCategorie();
                    int n =panierCategorie.getNbr();
                    categorieService.viderPanier(c,n);
                }
        );
        panierRepository.delete(panier);
    }
}
