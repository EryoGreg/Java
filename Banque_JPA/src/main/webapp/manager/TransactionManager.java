package main.webapp.manager;

import main.webapp.model.Client;
import main.webapp.model.Transaction;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;

public class TransactionManager extends BaseManager {
    public static boolean saveTransaction(Transaction transaction){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(transaction);
            em.getTransaction().commit();
            return true;
        } catch(HibernateException h ){
            h.printStackTrace();
            return false;
        }

    }
}
