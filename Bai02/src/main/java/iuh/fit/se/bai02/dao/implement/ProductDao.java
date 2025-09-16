package iuh.fit.se.bai02.dao.implement;

import iuh.fit.se.bai02.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProduct();
    Product findByName(String name);
}
