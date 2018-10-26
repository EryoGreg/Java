package main.webapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float montant;
    private Date date;
    private String libelle;

    @ManyToOne
    @JoinColumn(name="compte_source")
    private Compte compte_source;

    @ManyToOne
    @JoinColumn(name="compte_destination")
    private Compte compte_destination;

    public Transaction(){}

    public int getId() {
        return id;
    }

    public float getMontant() {
        return montant;
    }

    public Date getDate() {
        return date;
    }

    public String getLibelle() {
        return libelle;
    }

    public Compte getCompte_source() {
        return compte_source;
    }

    public Compte getCompte_destination() {
        return compte_destination;
    }

    public Transaction(String libelle, float montant, Compte source, Compte destination){
        this.montant = montant;

        this.date = new Date();
        this.libelle = libelle;
        this.compte_source = source;
        this.compte_destination = destination;
    }
}
