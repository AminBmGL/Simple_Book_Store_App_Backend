package livre.applivre.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="paniers")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")

public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "panier")
    private Set<PanierCategorie> panierCategorie=new HashSet<>();

    public Panier(Set<PanierCategorie> panierCategorie) {
        this.panierCategorie = panierCategorie;
    }

    public Panier() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<PanierCategorie> getPanierCategorie() {
        return panierCategorie;
    }

    public void setPanierCategorie(Set<PanierCategorie> panierCategorie) {
        this.panierCategorie = panierCategorie;
    }
}
