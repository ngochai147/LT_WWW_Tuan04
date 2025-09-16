package iuh.fit.se.bai03.controller;

import iuh.fit.se.bai03.dao.DanhSachTinTucQuanLyImpl;
import iuh.fit.se.bai03.dao.implement.DanhSachTinTucQuanLy;
import iuh.fit.se.bai03.model.TinTuc;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "tinTucFormController",urlPatterns = {"/form-tin"})
public class TinTucFormServlet extends HttpServlet {
    private DanhSachTinTucQuanLy danhSachTinTucQuanLy;
    @Override
    public void init(ServletConfig config) throws ServletException {
        danhSachTinTucQuanLy=new DanhSachTinTucQuanLyImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listDanhMuc",danhSachTinTucQuanLy.getAllDanhMuc()); ;
        req.getRequestDispatcher("/views/form/TinTucForm.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        String maTT=req.getParameter("maTT");
        String tieuDe=req.getParameter("tieuDe");
        String noiDung=req.getParameter("noiDungTT");
        String lienKet=req.getParameter("lienKet");
        int maDM= Integer.parseInt(req.getParameter("maDM"));

        TinTuc tinTuc=new TinTuc();
        tinTuc.setMaTT(maTT);
        tinTuc.setTieuDe(tieuDe);
        tinTuc.setNoiDungTT(noiDung);
        tinTuc.setLienKet(lienKet);
        tinTuc.setMaDM(maDM);
        System.out.println(tinTuc);
        danhSachTinTucQuanLy.themTinTuc(tinTuc);
        session.setAttribute("maDanhMuc",maDM);
        req.setAttribute("dsTinTuc",danhSachTinTucQuanLy.getTinTucTheoDanhMuc(maDM));
        req.getRequestDispatcher("/views/tintuc/DanhSachTinTuc.jsp")
                .forward(req,resp);
    }
}
