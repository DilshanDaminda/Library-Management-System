package lk.ijse.dep.library.dao.custom.impl;

import lk.ijse.dep.library.dao.CrudUtill;
import lk.ijse.dep.library.dao.custom.MemberDAO;
import lk.ijse.dep.library.entity.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberDAOImpl implements MemberDAO {
    @Override
    public Optional<Member> find(String key) throws Exception {
        ResultSet rst = (ResultSet) CrudUtill.execute("SELECT * FROM Member WHERE memberid=? ", key);
        Member m = null;

        if (rst.next()) {
            new Member (rst.getString("memberid"), rst.getString("member_name"), rst.getString("membertype"),
                    rst.getString("memberdate"));
        }
        return Optional.ofNullable(m);}

    @Override
    public Optional<List<Member>> findAll() throws Exception {

        ArrayList<Member> almember = new ArrayList<>();
        ResultSet rst = (ResultSet) CrudUtill.execute("SELECT * FROM Member");
        while (rst.next()) {
            String memberid = rst.getString(1);
            String member_name = rst.getString(2);
            String membertype = rst.getString(3);
            String memberdate = rst.getString(4);

            Member member = new Member(memberid,member_name, membertype, memberdate);
            almember.add(member);
        }

        return Optional.ofNullable(almember);

    }
    @Override
    public boolean save(Member entity) throws Exception {
        return CrudUtill.<Integer>execute("INSERT INTO Member VALUES (?,?,?,?)",
                entity.getMemberid(), entity.getMember_name(), entity.getMembertype(), entity.getMemberdate()  ) > 0;
    }
    @Override
    public boolean update(Member entity) throws Exception {
        return CrudUtill.<Integer>execute("UPDATE  Member SET  member_name=? , membertype=?, memberdate=?,  WHERE memberid=?",
                entity.getMember_name(), entity.getMembertype(), entity.getMemberdate(), entity.getMemberid()) > 0;
    }


    @Override
    public boolean delete(String key) throws SQLException, Exception {
        {

            return CrudUtill.<Integer>execute("DELETE FROM Member WHERE memberid=?", key) > 0;
        }

    }
//
//    @Override
//    public Member Save(Member entity) throws Exception {
//        PreparedStatement pstm = CrudUtill.getPreparedStatement("INSERT INTO Member VALUES (?,?,?,?)",
//                entity.getMemberid(),entity.getMember_name(), entity.getMembertype(), entity.getMemberdate());
//        int affectedRows = pstm.executeUpdate();
//        if (affectedRows > 0) {
//            ResultSet rst = pstm.getGeneratedKeys();
//            if (rst.next()) {
//                return new Member(entity.getMemberid(), entity.getMember_name(), entity.getMembertype(), entity.getMemberdate());
//            } else {
//                throw new RuntimeException("id cant");
//            }
//
//        }
//        return null;
//    }
//
//    @Override
//    public boolean update(Member entity) throws Exception {
//        PreparedStatement ppsm = CrudUtill.getPreparedStatement("UPDATE  Member SET  member_name=? , membertype=?,memberdate=?  WHERE memberid=?", entity.getMember_name(), entity.getMembertype(), entity.getMemberdate(), entity.getMemberid());
//        return ppsm.executeUpdate()>0;
//    }
//
//  @Override
//    public boolean delete(Integer key) throws Exception {
//        PreparedStatement pstm = CrudUtill.getPreparedStatement("DELETE FROM Member WHERE memberid=?",key) ;
//    return pstm.executeUpdate() >0;
//    }
//
//    @Override
//    public Member find(Integer key) throws Exception {
//        PreparedStatement pstm = CrudUtill.getPreparedStatement("SELECT * FROM Member WHERE memberid=? ", key);
//        ResultSet rst = pstm.executeQuery();
//
//        Member member = null;
//        if(rst.next()){
//            member = new Member(rst.getInt("memberid"),
//                                rst.getString("member_name"),
//                                rst.getString("membertype"),
//                                 rst.getDate("memberdate")
//
//                    );
//
//
//
//        }
//return member;
//    }
//
//    @Override
//    public  List<Member> findAll() throws Exception {
//    List<Member> alIMember= new ArrayList<>();
//       PreparedStatement pstm = CrudUtill.getPreparedStatement("SELECT * FROM Member");
//       ResultSet rst = pstm.executeQuery();
//       while (rst.next()){
//           int memberID = rst.getInt("memberid");
//           String memname = rst.getString("member_name");
//           String  memtype = rst.getString("membertype");
//           Date membdate = rst.getDate( "memberdate");
//
//           Member member = new Member(memberID,memname,memtype,membdate);
//           alIMember.add(member);
//
//
//       }
//       return alIMember;
//}
}

