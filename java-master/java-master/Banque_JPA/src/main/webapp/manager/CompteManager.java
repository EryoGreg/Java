package main.webapp.manager;

import main.webapp.model.Compte;
import javax.persistence.EntityManager;

public class CompteManager extends BaseManager{
    public static Compte loadCompteById(Integer CompteID){
        EntityManager em = getEntityManager();
        return em.find(Compte.class, CompteID);
    }
}
