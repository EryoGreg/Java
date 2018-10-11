package Models;

import java.util.Date;

public class Utilisateur {
    private int Id;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String password;
    private Date date_of_birth;
    private String address;
    private String phone;

    public Utilisateur(String nom, String prenom, String email, String login, String password, Date date_of_birth, String address, String phone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.password = password;
        this.date_of_birth = date_of_birth;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return Id;
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

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}