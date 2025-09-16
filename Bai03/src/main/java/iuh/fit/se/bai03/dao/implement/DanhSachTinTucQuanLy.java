package iuh.fit.se.bai03.dao.implement;

import iuh.fit.se.bai03.model.DanhMuc;
import iuh.fit.se.bai03.model.TinTuc;

import java.util.List;

public interface DanhSachTinTucQuanLy {
    List<DanhMuc> getAllDanhMuc();
    List<TinTuc> getAllTinTuc();
    List<TinTuc> getTinTucTheoDanhMuc(int maDM);
    void themTinTuc(TinTuc tinTuc);
    boolean xoaTinTuc(int maTT);
}
