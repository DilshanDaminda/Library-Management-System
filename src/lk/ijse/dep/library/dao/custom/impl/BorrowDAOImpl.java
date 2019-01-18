package lk.ijse.dep.library.dao.custom.impl;

import lk.ijse.dep.library.dao.CrudUtill;
import lk.ijse.dep.library.dao.custom.BorrowDAO;
import lk.ijse.dep.library.entity.Borrow;
import lk.ijse.dep.library.entity.BorrowPK;
import lk.ijse.dep.library.entity.Member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class BorrowDAOImpl  {


//    @Override
//    public Borrow Save(Borrow entity) throws Exception {
//        PreparedStatement pstm = CrudUtill.getPreparedStatement("INSERT INTO borrow VALUES (?,?,?,?)",
//                entity.getBorrowPK().getBook_id(),entity.getBorrowPK().getMem_id(), entity.getIssuedate(), entity.getExpidate());
//        int affectedRows = pstm.executeUpdate();
//        if (affectedRows > 0) {
//            ResultSet rst = pstm.getGeneratedKeys();
//            if (rst.next()) {
//                return new Borrow(entity.getBorrowPK().getBook_id(), entity.getBorrowPK().getMem_id(), entity.getIssuedate(), entity.getExpidate());
//            } else {
//                throw new RuntimeException("id cant");
//            }
//
//        }
//        return null;
//
//    }
//
//    @Override
//    public boolean update(Borrow entity) throws Exception {
//        return false;
//    }
//
//    @Override
//    public boolean delete(BorrowPK key) throws Exception {
//        return false;
//    }
//
//    @Override
//    public Borrow find(BorrowPK key) throws Exception {
//        return null;
//    }
//
//    @Override
//    public List<Borrow> findAll() throws Exception {
//        return null;
//    }
}
