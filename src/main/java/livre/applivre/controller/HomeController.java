package livre.applivre.controller;

import livre.applivre.domain.Categorie;
import livre.applivre.domain.Livre;
import livre.applivre.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {
    @Autowired
    CategorieService categorieService;
    @GetMapping("/all" )
    public List<Categorie> findAll() {
        return categorieService.getAll();
    }
    @GetMapping( "/{id}" )
    public Categorie findById(@PathVariable("id") int id) {

        return categorieService.findById(id);

    }
    @GetMapping("/" )
    public List<Categorie> getDispo() {
        return categorieService.getDispo();
    }

}
