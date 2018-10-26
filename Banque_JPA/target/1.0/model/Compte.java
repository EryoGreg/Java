package main.webapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;
    private float solde;
    private Date date_creation;
    private int type_compte;

    @OneToMany(mappedBy = "compte_source", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Transaction> transactions = new LinkedHashSet<Transaction>();

    @OneToMany(mappedBy = "compte_destination", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Transaction> credited_by = new LinkedHashSet<Transaction>();

    @ManyToOne
    @JoinColumn(name="owner")
    private Client owner;

    public Compte(float solde, Date date_creation, String libelle, int type_compte) {
        this.libelle = libelle;
        this.solde = solde;
        this.date_creation = date_creation;
        this.type_compte = type_compte;
    }

    public Compte(String libelle){
        this.libelle = libelle;
        this.solde = 0;
        this.date_creation = new Date();
    }

    public Compte() {}

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
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

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public Set<Transaction> getCredited_by() {
        return credited_by;
    }

    public Client getOwner() {
        return owner;
    }

    public void addTransaction(String libelle, float montant, Compte destination){
        Transaction tr = new Transaction(libelle, montant, this, destination );
        transactions.add(tr);
    }

    public int getType_compte() {
        return type_compte;
    }

    public void setType_compte(int type_compte) {
        this.type_compte = type_compte;
    }
    }
