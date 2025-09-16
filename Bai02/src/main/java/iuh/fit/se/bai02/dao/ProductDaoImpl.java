package iuh.fit.se.bai02.dao;

import iuh.fit.se.bai02.dao.implement.ProductDao;
import iuh.fit.se.bai02.model.Product;
import iuh.fit.se.bai02.ultis.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> getAllProduct() {
        try(EntityManager em=EntityManagerFactoryUtil.getEntityManager()) {
            return em.createQuery("select p from Product p", Product.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product findByName(String name) {
        try (EntityManager em=EntityManagerFactoryUtil.getEntityManager()){
            return em.createQuery("from Product p where p.name=:name",Product.class)
                    .setParameter("name",name)
                    .getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
