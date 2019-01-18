package lk.ijse.dep.library.business.costom;

import lk.ijse.dep.library.business.SuperBO;
import lk.ijse.dep.library.dto.BookDTO;
import lk.ijse.dep.library.dto.MemberDTO;

import java.sql.SQLException;
import java.util.List;

public interface BookManageBO extends SuperBO {

    List<BookDTO> getBook () throws Exception;
    boolean createBook (BookDTO dto) throws Exception;
    boolean updateupdate (BookDTO dto) throws Exception;
    boolean deleteBook (String bookID) throws SQLException, Exception;
    BookDTO findBook (String id) throws SQLException, Exception;



}
