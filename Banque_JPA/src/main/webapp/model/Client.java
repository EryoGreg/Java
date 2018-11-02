package main.webapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String email;
    @Column(unique = true)
    private String login;
    private String password;
    private String phone;
    private Date date_of_birth;
    private String address;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Compte> comptes = new LinkedHashSet<Compte>();

    public Client(String nom, String prenom, String email, String login, String password, String phone, Date date_of_birth, String address) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.date_of_birth = date_of_birth;
        this.address = address;
    }

    public Client() {
        this.nom = "Pessiot";
        this.prenom = "Grégoire";
        this.email = "test";
        this.login = "test";
        this.password = "test";
        this.phone = "test";
        this.date_of_birth = new Date();
        this.address = "test";
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setComptes(Compte cpt) {
        cpt.setOwner(this);
        this.comptes.add(cpt);
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public Compte getCompteByID(int id) {
        for (Compte tmpCompte :comptes) {
            if(tmpCompte.getId() == id){
                return tmpCompte;
            }
        }
        return null;
    }

}
