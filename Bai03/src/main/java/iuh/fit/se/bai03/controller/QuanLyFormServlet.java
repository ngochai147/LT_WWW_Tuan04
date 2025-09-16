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

@WebServlet(name = "quanLyController",urlPatterns = {"/quan-ly"})
public class QuanLyFormServlet extends HttpServlet {
    private DanhSachTinTucQuanLy danhSachTinTucQuanLy;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maTT= Integer.parseInt(req.getParameter("maTT"));
        HttpSession session=req.getSession();
        danhSachTinTucQuanLy.xoaTinTuc(maTT);
        session.setAttribute("dsTinTuc",danhSachTinTucQuanLy.getAllTinTuc());
        req.getRequestDispatcher("/views/form/QuanLyForm.jsp")
                .forward(req,resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        danhSachTinTucQuanLy=new DanhSachTinTucQuanLyImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dsTinTuc",danhSachTinTucQuanLy.getAllTinTuc());
        req.getRequestDispatcher("/views/form/QuanLyForm.jsp")
                .forward(req,resp);
    }
}
