package lk.ijse.dep.library.business.costom.impl;

import lk.ijse.dep.library.business.Converter;
import lk.ijse.dep.library.business.costom.BookManageBO;
import lk.ijse.dep.library.dao.DAOFactory;
import lk.ijse.dep.library.dao.custom.BookDAO;
import lk.ijse.dep.library.dto.BookDTO;

import java.sql.SQLException;
import java.util.List;

public class BookManageBOImpl implements BookManageBO {

    public BookDAO bookDAO;

    public BookManageBOImpl() {
        bookDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOK);
    }

    @Override
    public List<BookDTO> getBook() throws Exception {
        return bookDAO.findAll().map(Converter::<BookDTO> getDTOList).get();
    }

    @Override
    public boolean createBook(BookDTO dto) throws Exception {
        return bookDAO.save(Converter.getEntity(dto));
    }

    @Override
    public boolean updateupdate(BookDTO dto) throws Exception {
        return bookDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteBook(String bookID) throws SQLException, Exception {
        return  bookDAO.delete(bookID);
    }

    @Override
    public BookDTO findBook(String id) throws SQLException, Exception {
        return bookDAO.find(id).map(Converter::<BookDTO>getDTO).orElse(null);
    }

//    public List<BookDTO> getBook() throws Exception {
//        return bookDAO.findAll().map(Converter::<BookDTO>getDTOList).get();
//    }
//
//
//    public boolean createBook(BookDTO dto) throws Exception {
//        return bookDAO.save(Converter.getEntity(dto));
//    }
//
//
//    public boolean updateupdate(BookDTO dto) throws Exception {
//        return bookDAO.update(Converter.getEntity(dto));
//    }
//
//
//    public boolean deleteBook(String bookID) throws Exception {
//        return bookDAO.delete(bookID);
//    }
//
//
//    public BookDTO findBook(int id) throws Exception {
//        return bookDAO.find(id).map(Converter::<BookDTO>getDTO).orElse(null);
//    }
//

}
