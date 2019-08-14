package livre.applivre.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "categories")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String nom;
    private String genre;
    private int stock;
    private float prix;
    @OneToMany(mappedBy = "categorie")
    private Set<Livre> livres;
    @ManyToMany
    @JoinTable
            (name = "promotion_categorie",
                    joinColumns = @JoinColumn(
                            name = "categorie_id", referencedColumnName = "id"),
                    inverseJoinColumns = @JoinColumn(
                            name = "promotion_id", referencedColumnName = "id"))
    private Set<Promotion> promotions = new HashSet<>();
    @OneToMany(mappedBy = "categorie")
    private Set<PanierCategorie> panierCategorie = new HashSet<>();

    public Categorie() {
    }

    public Categorie(String nom, String genre, int stock, float prix) {
        this.nom = nom;
        this.genre = genre;
        this.stock = stock;
        this.prix = prix;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}