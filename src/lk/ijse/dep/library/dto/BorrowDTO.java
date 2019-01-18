package lk.ijse.dep.library.dto;

public class BorrowDTO extends SuperDTO {

    private String book_id;
    private String mem_id;
    private String issuedate;
    private String expidate;

    public BorrowDTO() {
    }

    public BorrowDTO(String book_id, String mem_id, String issuedate, String expidate) {
        this.setBook_id(book_id);
        this.setMem_id(mem_id);
        this.setIssuedate(issuedate);
        this.setExpidate(expidate);
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

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    public String getExpidate() {
        return expidate;
    }

    public void setExpidate(String expidate) {
        this.expidate = expidate;
    }

    @Override
    public String toString() {
        return "BorrowDTO{" +
                "book_id='" + book_id + '\'' +
                ", mem_id='" + mem_id + '\'' +
                ", issuedate='" + issuedate + '\'' +
                ", expidate='" + expidate + '\'' +
                '}';
    }
}