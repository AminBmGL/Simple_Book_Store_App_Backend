package livre.applivre.controller;

import livre.applivre.domain.Categorie;
import livre.applivre.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @GetMapping ("/verifStock/{id}/{nbr}")
    public Categorie verifStock(@PathVariable("id")int id, @PathVariable("nbr") int nbr)

    {
        return categorieService.verifStock(id,nbr);

    }
}
