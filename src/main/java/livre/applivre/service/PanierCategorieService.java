package livre.applivre.service;

import livre.applivre.domain.Categorie;
import livre.applivre.domain.Panier;
import livre.applivre.domain.PanierCategorie;
import livre.applivre.repository.CategorieRepository;
import livre.applivre.repository.PanierCategorieRepository;
import livre.applivre.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PanierCategorieService {
    @Autowired
    PanierCategorieRepository panierCategorieRepository;
    @Autowired
    PanierRepository panierRepository;
    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
  CategorieService categorieService;
    public PanierCategorie addPanierCategorie(Integer id1, Integer id2,int nbr)
    {  Panier panier=panierRepository.findById(id1).orElse(null);
    Categorie categorie=categorieRepository.findById(id2).orElse(null);
    categorie.setStock(categorie.getStock()-nbr);
    categorieRepository.save(categorie);

    PanierCategorie panierCategorie=new PanierCategorie(categorie,panier,nbr);
        return panierCategorieRepository.save(panierCategorie);
    }

}
