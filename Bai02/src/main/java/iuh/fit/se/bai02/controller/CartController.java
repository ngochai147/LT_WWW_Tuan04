package iuh.fit.se.bai02.controller;

import iuh.fit.se.bai02.dao.CartImpl;
import iuh.fit.se.bai02.dao.ProductDaoImpl;
import iuh.fit.se.bai02.dao.implement.Cart;
import iuh.fit.se.bai02.dao.implement.ProductDao;
import iuh.fit.se.bai02.model.CartItem;
import iuh.fit.se.bai02.model.Product;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;

import java.io.IOException;

@WebServlet(name = "cartController",urlPatterns = {"/cart","/cart*"})
public class CartController extends HttpServlet {
    private Cart cart;
    private ProductDao productDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productDao=new ProductDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action=req.getParameter("action");
    if(action==null) action="";
    switch (action){
        case "add":
            handleAddCartItem(req,resp);
            break;
        case "Delete":
            handleDeleteCartItem(req,resp);
            break;
        case "update":
            handleUpdateQuantiTyItem(req,resp);
            break;
    }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/cart/index.jsp").forward(req,resp);
    }

    private void handleAddCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Object object=session.getAttribute("cart");

        if(object!=null){
            cart= (Cart) object;
        }else {
            cart=new CartImpl();
            session.setAttribute("cart",cart);
        }

        String name=request.getParameter("name");
        Product product=productDao.findByName(name);
        int quantity= Integer.parseInt(request.getParameter("quantity"));
        CartItem cartItem=new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setId(cart.getCartItem().size()+1);
        cart.addItem(cartItem);
        cart.totalOrder();
        session.setAttribute("cart",cart);
        request.getRequestDispatcher("/views/cart/index.jsp").forward(request,response);
    }

    private void handleDeleteCartItem(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String index=request.getParameter("index");
        cart.deleteCartItem(index);
        cart.totalOrder();
        session.setAttribute("cart",cart);
        request.getRequestDispatcher("/views/cart/index.jsp").forward(request,response);
    }

    private void handleUpdateQuantiTyItem(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();

        String index=request.getParameter("index");
        int quantity= Integer.parseInt(request.getParameter("quantity"));
        System.out.println(index);
        System.out.println(quantity);
        cart.updateCartItem(index,quantity);
        cart.totalOrder();
        System.out.println(cart.getCartItem());
        session.setAttribute("cart",cart);
        request.getRequestDispatcher("/views/cart/index.jsp").forward(request,response);
    }

}
