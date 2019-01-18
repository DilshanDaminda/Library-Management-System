package lk.ijse.dep.library.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Returnbook extends SuperEntity {
    private String returnid;
    private LocalDate returndate;
    private String books_id;
    private String memb_id;

    public Returnbook(String returnid, Date returndate, String books_id, String memb_id) {
    }

    public Returnbook(String returnid, LocalDate returndate, String books_id, String memb_id) {
        this.setReturnid(returnid);
        this.setReturndate(returndate);
        this.setBooks_id(books_id);
        this.setMemb_id(memb_id);
    }

    public String getReturnid() {
        return returnid;
    }

    public void setReturnid(String returnid) {
        this.returnid = returnid;
    }

    public LocalDate getReturndate() {
        return returndate;
    }

    public void setReturndate(LocalDate returndate) {
        this.returndate = returndate;
    }

    public String getBooks_id() {
        return books_id;
    }

    public void setBooks_id(String books_id) {
        this.books_id = books_id;
    }

    public String getMemb_id() {
        return memb_id;
    }

    public void setMemb_id(String memb_id) {
        this.memb_id = memb_id;
    }

    @Override
    public String toString() {
        return "Returnbook{" +
                "returnid='" + returnid + '\'' +
                ", returndate=" + returndate +
                ", books_id='" + books_id + '\'' +
                ", memb_id='" + memb_id + '\'' +
                '}';
    }
}