package main.connecteur;

import javax.persistence.*;

public class BaseManager {

    private static final String UNIT_NAME = "MaBanque";
    private static EntityManagerFactory factory;

    protected static EntityManagerFactory getEntityManagerFactory(){
        if (factory == null){
            factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        }
        return factory;
    }


    public static void shutdown(){
        if (factory != null) {
            factory.close();
        }
    }


    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = getEntityManagerFactory();
        return factory.createEntityManager();
    }
}