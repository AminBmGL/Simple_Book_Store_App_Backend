package livre.applivre.repository;

import livre.applivre.domain.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {


    List<Categorie> findByStockIsGreaterThan(int v);
    Categorie findByIdAndStockGreaterThanEqual(int id ,int nbr);
    Categorie findById(int id);
Categorie findByNom(String nom);
}