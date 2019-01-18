package lk.ijse.dep.library.dao.custom.impl;

import lk.ijse.dep.library.dao.CrudUtill;
import lk.ijse.dep.library.dao.custom.BookDAO;
import lk.ijse.dep.library.entity.Book;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDAOImpl implements BookDAO {



    public boolean save(Book book) throws Exception {
        return CrudUtill.<Integer>execute("INSERT INTO Book VALUES (?,?,?,?,?)",
                book.getBookid(), book.getTitle(), book.getAuthor(), book.getPubid(), book.getAvailability()) > 0;
    }


    @Override
    public boolean update(Book book) throws Exception {
        return CrudUtill.<Integer>execute("UPDATE  Book SET  title=? , author=?,pubid=?,availability=? WHERE bookid=?",
                book.getTitle(), book.getAuthor(), book.getPubid(), book.getAvailability()) > 0;
    }

    @Override
    public boolean delete(String bookid) throws Exception {

        return CrudUtill.<Integer>execute("DELETE FROM Book WHERE bookid=?", bookid) > 0;
    }


    public Optional<Book> find(String book_id) throws Exception {
        ResultSet rst = (ResultSet) CrudUtill.execute("SELECT * FROM Book WHERE bookid=? ", book_id);
        Book b = null;

        if (rst.next()) {
            new Book(rst.getString("bookid"), rst.getString("title"), rst.getString("author"),
                    rst.getString("pubid"), rst.getString("availability "));
        }
        return Optional.ofNullable(b);
    }


    @Override
    public Optional<List<Book>> findAll() throws Exception {
        ArrayList<Book> alBook = new ArrayList<>();
        ResultSet rst = (ResultSet) CrudUtill.execute("SELECT * FROM Book");
        while (rst.next()) {
            String book_id = rst.getString(1);
            String title = rst.getString(2);
            String author = rst.getString(3);
            String pubid = rst.getString(4);
            String availability = rst.getString(5);
            Book book = new Book(book_id, title, author, pubid, availability);
            alBook.add(book);
        }

        return Optional.ofNullable(alBook);

    }
}



