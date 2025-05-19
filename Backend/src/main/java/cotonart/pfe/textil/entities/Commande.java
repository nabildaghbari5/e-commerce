package cotonart.pfe.textil.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCommande")

    private Integer id;
    private String date;
    private Float total;
    private String description;
    private String etat;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Produit> produits;


    @OneToOne(cascade = CascadeType.ALL)
    private Livraison livraison;

}
