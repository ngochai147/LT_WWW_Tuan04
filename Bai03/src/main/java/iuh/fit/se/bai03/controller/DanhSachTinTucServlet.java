package iuh.fit.se.bai03.controller;

import iuh.fit.se.bai03.dao.DanhSachTinTucQuanLyImpl;
import iuh.fit.se.bai03.dao.implement.DanhSachTinTucQuanLy;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "controllerTinTuc",urlPatterns = {"/tin-tuc"})
public class DanhSachTinTucServlet extends HttpServlet {
    private DanhSachTinTucQuanLy danhSachTinTucQuanLy;
    @Override
    public void init(ServletConfig config) throws ServletException {
        danhSachTinTucQuanLy=new DanhSachTinTucQuanLyImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       HttpSession session=req.getSession();
       session.setAttribute("maDanhMuc",1);
        req.setAttribute("dsTinTuc",danhSachTinTucQuanLy.getTinTucTheoDanhMuc(1));
        req.getRequestDispatcher("/views/tintuc/DanhSachTinTuc.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        int maDM= Integer.parseInt(req.getParameter("maDM"));
        session.setAttribute("maDanhMuc",maDM);
        req.setAttribute("dsTinTuc",danhSachTinTucQuanLy.getTinTucTheoDanhMuc(maDM));
        req.getRequestDispatcher("/views/tintuc/DanhSachTinTuc.jsp")
                .forward(req,resp);
    }
}
