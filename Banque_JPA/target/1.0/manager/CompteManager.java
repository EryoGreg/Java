package main.webapp.manager;

import main.webapp.model.Client;
import main.webapp.model.Compte;
import org.hibernate.HibernateException;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class CompteManager extends BaseManager {

    public static void saveCompte(Compte compte) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(compte);
        em.getTransaction().commit();
    }

    public static void updateCompte(Compte compte) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(compte);
        em.getTransaction().commit();
    }

    @Transactional
    public boolean deleteCompte(int id){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete from Compte where id = :id")
                .setParameter("id", id)
                .executeUpdate();
        em.getTransaction().commit();
        return true;

    }

    public static Compte getCompteById(Integer compteID){
        EntityManager em = getEntityManager();
        return em.find(Compte.class, compteID);
    }

    public static void updateAccountAmount(Compte compte, float value) {
        EntityManager em = getEntityManager();
        Compte cpt = em.find(Compte.class, compte.getId());
        float tmpAmount = cpt.getSolde() + value;
        cpt.setSolde(tmpAmount);
        em.getTransaction().begin();
        em.persist(cpt);
        em.getTransaction().commit();
    }
}


