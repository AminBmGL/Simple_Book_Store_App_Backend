package livre.applivre.controller;

import livre.applivre.domain.Panier;
import livre.applivre.domain.PanierCategorie;
import livre.applivre.service.PanierCategorieService;
import livre.applivre.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PanierController {
    @Autowired
  private  PanierService panierService;
    @Autowired
    PanierCategorieService panierCategorieService;
@PostMapping("/newPanier")
        public Panier newPanier(@RequestBody Panier panier)
{
    return panierService.addPanier(panier);

}
    @PostMapping("/newPanierCategorie/{id1}/{id2}/{nbr}")
    public PanierCategorie addCategorieToPanier(@PathVariable("id1")Integer id1, @PathVariable("id2")Integer id2, @PathVariable("nbr") int nbr)


    {
        return panierCategorieService.addPanierCategorie(id1,id2,nbr);

    }


    @DeleteMapping("/deletePanierCategorie/{id}")
            public void deletePanier(@PathVariable("id")int id)
    {
               panierService.deletePanier(id);
    }


}
