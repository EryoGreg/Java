package main.webapp.manager;

import main.webapp.model.Client;
import main.webapp.model.Compte;
import org.hibernate.HibernateException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;


public class ClientManager extends BaseManager {
    public static boolean saveClient(Client client){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
            return true;
        } catch(HibernateException h ){
            h.printStackTrace();
            return false;
        }

    }

    public static Client loadClientById(Integer clientID){
        EntityManager em = getEntityManager();
        return em.find(Client.class, clientID);
    }


    public static Client loadClientByLoginAndPassword(String login, String password) {
        try {
            EntityManager em = getEntityManager();
            TypedQuery<Client> query = em.createQuery(
                    "SELECT c FROM Client c WHERE c.login='" + login + "'and c.password='" + password + "'", Client.class);
            Client cli = query.getSingleResult();
            return cli;
        } catch (NoResultException nre){
            return null;
        }

    }

    public static void updatePassword(Client client, String password){
        EntityManager em = getEntityManager();
        Client cpt = em.find(Client.class, client.getId());
        cpt.setPassword(password);
        em.getTransaction().begin();
        em.persist(cpt);
        em.getTransaction().commit();
    }


    public static void purgeTable(){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete from Transaction").executeUpdate();
        em.createQuery("delete from Compte ").executeUpdate();
        em.createQuery("delete from Client ").executeUpdate();
        em.getTransaction().commit();
    }

    public static void deleteClient(Client cli) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(cli);
        em.getTransaction().commit();
    }
}
