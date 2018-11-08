package main.webapp.manager;


import main.webapp.model.Compte;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

public class CompteManager extends BaseManager {

    public static void saveCompte(Compte compte) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(compte);
        em.getTransaction().commit();
    }

    public static Compte getCompteById(Integer compteID){
        EntityManager em = getEntityManager();
        return em.find(Compte.class, compteID);
    }

    public static List<Object[]> loadComptes(){
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery ("SELECT * from compte");
        query.getResultList().toArray();
        return query.getResultList();
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


