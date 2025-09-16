package iuh.fit.se.bai02.controller;

import iuh.fit.se.bai02.dao.ProductDaoImpl;
import iuh.fit.se.bai02.dao.implement.ProductDao;
import iuh.fit.se.bai02.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "productController", urlPatterns = "/list-product")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDao=new ProductDaoImpl();
        List<Product> products= productDao.getAllProduct();
        req.setAttribute("products",products);
        req.getRequestDispatcher("/views/product/index.jsp")
                .forward(req,resp);
    }
}
