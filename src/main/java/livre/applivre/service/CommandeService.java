package livre.applivre.service;

import livre.applivre.domain.*;
import livre.applivre.repository.CommandeRepository;
import livre.applivre.repository.PanierRepository;
import livre.applivre.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CommandeService {
    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    PanierRepository panierRepository;
    @Autowired
    LivreService livreService;
    public Commande addCommand(int id1,int id2)
    {
       User user= userRepository.findById(id1);
        Panier panier=panierRepository.findById(id2);
        Commande commande=new Commande(user,panier);
     Set<PanierCategorie> panierCategories= panier.getPanierCategorie();
     panierCategories.forEach(panierCategorie -> {
         Categorie c=panierCategorie.getCategorie();
         int n =panierCategorie.getNbr();
         livreService.venteLivre(c,n);
     });

        return commandeRepository.save(commande);


    }
}
