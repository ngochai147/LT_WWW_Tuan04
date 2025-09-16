package iuh.fit.se.bai02.ultis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
    private static final EntityManagerFactory entityManagerFactory;
    static {
        try {
            entityManagerFactory= Persistence.createEntityManagerFactory("user-management");

        }catch (Throwable ex){
            System.err.println("Initial EntityManagerFactory creation failed"+ex);
            throw new RuntimeException(ex);
        }
    }

    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

    public static void close(){
        if(entityManagerFactory.isOpen()){
            entityManagerFactory.close();
        }
    }
}
