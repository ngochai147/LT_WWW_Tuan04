package iuh.fit.se.bai03.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManageFactoryUtil {
    private static final EntityManagerFactory entitymanagerFactory;
    static {
        entitymanagerFactory= Persistence.createEntityManagerFactory("user-management");
    }

    public static EntityManager getEntityManager(){
        return entitymanagerFactory.createEntityManager();
    }

    public static void close(){
        if(entitymanagerFactory.isOpen()){
            entitymanagerFactory.close();
        }
    }

//    public static void main(String[] args) {
//        getEntityManager();
//    }
}
