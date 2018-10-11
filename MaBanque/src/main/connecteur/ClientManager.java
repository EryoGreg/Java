package main.connecteur;

import main.maBanqueApp.Utilisateur;
import javax.persistence.*;


public class ClientManager extends BaseManager {
    public static void saveClient(Utilisateur Utilisateur) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(Utilisateur);
        em.getTransaction().commit();
    }
    public static Utilisateur loadClientById(Integer Id){
        EntityManager em = getEntityManager();
        Utilisateur cli = em.find(Utilisateur.class, Id);
        return cli;
    }


    public  static void deleteClient(Utilisateur utilisateur){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(utilisateur);
        em.getTransaction().commit();
    }


    public static Utilisateur loadClientByLoginAndPassword(String login, String password) {
        EntityManager em = getEntityManager();
        TypedQuery<Utilisateur> query = em.createQuery(
                "SELECT user FROM Utilisateur user WHERE user.login='" +
                        login + "' and user.password ='" + password + "'", Utilisateur.class);
        Utilisateur user = query.getSingleResult();
        return user;
    }












}