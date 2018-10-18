package model;

import java.util.Date;

public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String password;
    private String phone;
    private Date date_of_birth;
    private String address;

    public Utilisateur(int id, String nom, String prenom, String email, String login, String password, String phone, Date date_of_birth, String address) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.date_of_birth = date_of_birth;
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public String getAddress() {
        return address;
    }
}
