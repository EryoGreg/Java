package main.maBanqueApp;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="Type_Compte")
public class Type_Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int Id;
    private String libelle;
    private float taux;

    //Compte
    @OneToMany(mappedBy="berta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Compte> Compte = new LinkedHashSet<Compte>();

    @Override
    public String toString(){
        return Id + " " + libelle + " " + taux;
    }

    public int getId() {
        return Id;
    }

    public String getLibelle() {
        return libelle;
    }

    public float getTaux() {
        return taux;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }
}