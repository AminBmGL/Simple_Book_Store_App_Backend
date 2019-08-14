package livre.applivre.service;

import livre.applivre.domain.Categorie;
import livre.applivre.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {
    @Autowired
    CategorieRepository categorieRepository;
    public List<Categorie> getAll()
    {
        return categorieRepository.findAll();

    }
    public List<Categorie> getDispo()
    {
        return categorieRepository.findByStockIsGreaterThan(0);

    }
    public Categorie findById(int id)
    {
        return categorieRepository.findById(id);
    }
    public Categorie verifStock(int id,int nbr)
    {
        return  categorieRepository.findByIdAndStockGreaterThanEqual(id,nbr);
    }
    public void viderPanier(Categorie c, int n)
    {
        c.setStock(c.getStock()+n);
        categorieRepository.save(c);
    }
    public  Categorie findByNom(String nom)
    {return  categorieRepository.findByNom(nom);}
}
