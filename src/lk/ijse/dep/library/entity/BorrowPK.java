package lk.ijse.dep.library.entity;

public class BorrowPK {
    private String book_id;
    private String mem_id;

    public BorrowPK() {
    }

    public BorrowPK(String book_id, String mem_id) {
        this.setBook_id(book_id);
        this.setMem_id(mem_id);
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getMem_id() {
        return mem_id;
    }

    public void setMem_id(String mem_id) {
        this.mem_id = mem_id;
    }

    @Override
    public String toString() {
        return "BorrowPK{" +
                "book_id='" + book_id + '\'' +
                ", mem_id='" + mem_id + '\'' +
                '}';
    }
}
