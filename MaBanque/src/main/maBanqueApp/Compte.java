package main.maBanqueApp;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="Compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String type_compte;
    private float solde;
    private Date date_creation;

    //Utilisateur
    @ManyToOne
    @JoinColumn(name = "Utilisateur_Id")
    private Utilisateur robert;


    //Transaction
    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Transaction> transactions = new LinkedHashSet<Transaction>();

    //Type_Compte
    @ManyToOne
    @JoinColumn(name = "Type_Compte_Id")
    private Utilisateur berta;

    public Compte(){
    }

    public Compte(String type_compte, float solde, Date date_creation){
        this.type_compte = type_compte;
        this.solde = solde;
        this.date_creation = date_creation;
    }

    public Utilisateur getRobert(){
        return robert;
    }


    public void setRobert(Utilisateur robert){
        this.robert = robert;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getType_compte() {
        return type_compte;
    }

    public void setType_compte(String type_compte) {
        this.type_compte = type_compte;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }


    public Utilisateur getBerta() {
        return berta;
    }

    public void setBerta(Utilisateur berta) {
        this.berta = berta;
    }
}