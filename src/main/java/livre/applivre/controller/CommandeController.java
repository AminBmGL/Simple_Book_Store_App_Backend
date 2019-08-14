package livre.applivre.controller;

import livre.applivre.domain.Commande;
import livre.applivre.domain.Panier;
import livre.applivre.domain.User;
import livre.applivre.repository.PanierRepository;
import livre.applivre.repository.UserRepository;
import livre.applivre.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CommandeController {
    @Autowired
    CommandeService commandeService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PanierRepository panierRepository;
    @PostMapping("/addCommande/{id1}/{id2}")
    public Commande addCommande(@PathVariable("id1")int id1, @PathVariable("id2")int id2)
    {
 return  commandeService.addCommand(id1,id2);
    }



}
