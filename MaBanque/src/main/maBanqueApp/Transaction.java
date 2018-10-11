package main.maBanqueApp;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private float montant;
    private int compte_source;
    private int compte_destination;
    private Date date;
    private String libelle;

    //Compte
    @ManyToOne
    @JoinColumn(name = "Transaction_Id")
    private Transaction transaction;

    public Transaction() {
    }

    @Override
    public String toString(){
        return Id + " " + montant + " " + compte_source + " " + compte_destination + " " + date + " " + libelle;
    }
    public Transaction getTransaction(){
        return transaction;
    }

    public int getId() {
        return Id;
    }

    public float getMontant() {
        return montant;
    }

    public float getCompte_source() {
        return compte_source;
    }

    public float getCompte_destination() {
        return compte_destination;
    }

    public Date getDate() {
        return date;
    }

    public String getLibelle(){
        return libelle;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public void setCompte_source(int compte_source) {
        this.compte_source = compte_source;
    }

    public void setCompte_destination(int compte_destination) {
        this.compte_destination = compte_destination;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}