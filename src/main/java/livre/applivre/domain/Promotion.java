package livre.applivre.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity(name = "promotions")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")

public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToMany
    @JoinTable
            (name = "promotion_categorie",
            joinColumns = @JoinColumn(
                    name = "promotion_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "categorie_id", referencedColumnName = "id"))
    private Set<Categorie> categories=new HashSet<>();

    public Promotion(Set<Categorie> categories) {
        this.categories = categories;
    }
}
