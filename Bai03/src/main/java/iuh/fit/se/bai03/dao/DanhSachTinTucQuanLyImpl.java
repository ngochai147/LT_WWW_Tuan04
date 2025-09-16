package iuh.fit.se.bai03.dao;

import iuh.fit.se.bai03.dao.implement.DanhSachTinTucQuanLy;
import iuh.fit.se.bai03.model.DanhMuc;
import iuh.fit.se.bai03.model.TinTuc;
import iuh.fit.se.bai03.utils.EntityManageFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transaction;

import java.util.List;

public class DanhSachTinTucQuanLyImpl implements DanhSachTinTucQuanLy {
    @Override
    public List<DanhMuc> getAllDanhMuc() {
        try(EntityManager em=EntityManageFactoryUtil.getEntityManager()) {
            return em.createQuery("from DanhMuc ",DanhMuc.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TinTuc> getAllTinTuc() {
        try(EntityManager em=EntityManageFactoryUtil.getEntityManager()) {
            return em.createQuery("from TinTuc ", TinTuc.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TinTuc> getTinTucTheoDanhMuc(int maDM) {
        try(EntityManager em= EntityManageFactoryUtil.getEntityManager()) {
            return em.createQuery("from TinTuc where maDM=:maDM",TinTuc.class)
                    .setParameter("maDM",maDM)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void themTinTuc(TinTuc tinTuc) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = EntityManageFactoryUtil.getEntityManager();
            tx = em.getTransaction();
            tx.begin();

            em.persist(tinTuc);

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    @Override
    public boolean xoaTinTuc(int maTT) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = EntityManageFactoryUtil.getEntityManager();
            tx = em.getTransaction();
            tx.begin();
            TinTuc tinTuc = em.find(TinTuc.class, maTT);
            if (tinTuc != null) {
                em.remove(tinTuc);
                tx.commit();
                return true;
            }
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
}
