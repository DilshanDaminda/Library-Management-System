package lk.ijse.dep.library.dao.custom.impl;

import lk.ijse.dep.library.dao.CrudUtill;
import lk.ijse.dep.library.dao.custom.ReturnbookDAO;
import lk.ijse.dep.library.entity.Member;
import lk.ijse.dep.library.entity.Returnbook;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RreturnbookDAOImpl implements ReturnbookDAO {
    @Override
    public Optional<Returnbook> find(String key) throws Exception {
        ResultSet rst = CrudUtill.execute("SELECT * FROM Returnbook WHERE returnid=?", key);
        Returnbook c = null;
        if (rst.next()) {
            c= new Returnbook(rst.getString("returnid"),
                    rst.getDate("returndate"),
                    rst.getString("books_id"),
                    rst.getString("memb_id")
            );
        }
        return Optional.ofNullable(c);
    }

    @Override
    public Optional<List<Returnbook>> findAll() throws Exception {
      ArrayList<Returnbook> alreturn = new ArrayList<>();
      ResultSet rst = CrudUtill.<ResultSet>execute("SELECT * FROM returnbook");
      while (rst.next()){
          String retrnid = rst.getString(1);
          Date date = rst.getDate(2);
          String bookid = rst.getString(3);
          String membid = rst.getString(4);

          Returnbook returnbook = new Returnbook(retrnid,date,bookid,membid);
           alreturn.add(returnbook);
      }
              return Optional.ofNullable(alreturn);
    }

    @Override
    public boolean save(Returnbook entity) throws Exception {
        return CrudUtill.<Integer>execute("INSERT INTO returnbook VALUES (?,?,?,?)",
                entity.getReturnid(), entity.getReturndate(), entity.getBooks_id(),  entity.getMemb_id()) > 0;
    }

    @Override
    public boolean update(Returnbook entity) throws Exception {
        return CrudUtill.<Integer>execute("UPDATE Returnbook SET returndate=?,books_id=?,memb_id WHERE returnid=?",
                entity.getReturndate(), entity.getBooks_id(), entity.getMemb_id(),entity.getReturnid()) > 0;
    }


    @Override
    public boolean delete(String key) throws SQLException, Exception {
        return CrudUtill.<Integer>execute("DELETE FROM Returnbook WHERE returnid=?", key)> 0;
    }

//    @Override
//    public Returnbook Save(Returnbook entity) throws Exception {
//        PreparedStatement pstm = CrudUtill.getPreparedStatement("INSERT INTO returnbook VALUES (?,?,?,?)",
//                entity.getReturnid(),entity.getReturndate(), entity.getBooks_id(), entity.getBooks_id());
//        int affectedRows = pstm.executeUpdate();
//        if (affectedRows > 0) {
//            ResultSet rst = pstm.getGeneratedKeys();
//            if (rst.next()) {
//                return new Returnbook(entity.getReturnid(), entity.getReturndate(), entity.getBooks_id(), entity.getMemb_id());
//            } else {
//                throw new RuntimeException("id cant");
//            }
//
//        }
//        return null;
//    }
//
//
//
//    @Override
//    public boolean update(Returnbook entity) throws Exception {
//        PreparedStatement ppsm = CrudUtill.getPreparedStatement("UPDATE  returnbook SET  returndate=? , books_id=?,memb_id=?  WHERE returnid=?",
//                entity.getReturndate(), entity.getBooks_id(), entity.getMemb_id() );
//        return ppsm.executeUpdate()>0;
//    }
//
//    @Override
//    public boolean delete(Integer key) throws Exception {
//        PreparedStatement pstm = CrudUtill.getPreparedStatement("DELETE FROM returnbook WHERE returnid=?",key) ;
//        return pstm.executeUpdate() >0;
//    }
//
//    @Override
//    public Returnbook find(Integer key) throws Exception {
//        PreparedStatement pstm = CrudUtill.getPreparedStatement("SELECT * FROM returnbook WHERE returnid=? ", key);
//        ResultSet rst = pstm.executeQuery();
//
//        Returnbook returnbook = null;
//        if(rst.next()){
//            returnbook = new Returnbook(rst.getInt("returnid"),
//                    rst.getDate("returndate"),
//                    rst.getInt("books_id"),
//                    rst.getInt("memb_id")
//
//            );
//
//
//
//        }
//        return returnbook;
//    }
//
//    @Override
//    public List<Returnbook> findAll() throws Exception {
//
//        List<Returnbook> alIreturn= new ArrayList<>();
//        PreparedStatement pstm = CrudUtill.getPreparedStatement("SELECT * FROM Retturnbook");
//        ResultSet rst = pstm.executeQuery();
//        while (rst.next()){
//            int returnid = rst.getInt("returnid");
//
//            Date returndate = rst.getDate( "returndate");
//            int books_id = rst.getInt("books_id");
//
//            int memb_id = rst.getInt("memb_id");
//
//
//            Returnbook returnbook = new Returnbook(returnid,returndate,memb_id,books_id);
//            alIreturn.add(returnbook);
//
//
//        }
//        return alIreturn;
//    }
}