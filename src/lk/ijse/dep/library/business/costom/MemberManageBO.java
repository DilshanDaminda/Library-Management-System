package lk.ijse.dep.library.business.costom;

import lk.ijse.dep.library.business.SuperBO;
import lk.ijse.dep.library.dto.MemberDTO;

import java.sql.SQLException;
import java.util.List;

public interface MemberManageBO extends SuperBO {


    List<MemberDTO> getMember() throws Exception;
  //  boolean getMember () throws Exception;

    boolean createMember (MemberDTO dto) throws Exception;

    boolean updateMember (MemberDTO dto) throws  Exception;

    boolean deleteMember (String  memberID) throws SQLException,  Exception;

    MemberDTO findMember (String id) throws SQLException ,Exception;


/*
    List<BookDTO> getBook() throws SQLException;

    boolean createBook(BookDTO dto) throws SQLException;

    boolean updateBook(BookDTO dto) throws SQLException;

    boolean deleteBook(String authorID) throws SQLException;

    BookDTO findBook(String id) throws SQLException;*/

}
