package lk.ijse.dep.library.entity;

public class Borrow extends SuperEntity{
    private String issuedate;
    private String expidate;
    private BorrowPK borrowPK;

    public Borrow() {
    }

    public Borrow(String issuedate, String expidate, BorrowPK borrowPK) {
        this.setIssuedate(issuedate);
        this.setExpidate(expidate);
        this.setBorrowPK(borrowPK);
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

    public BorrowPK getBorrowPK() {
        return borrowPK;
    }

    public void setBorrowPK(BorrowPK borrowPK) {
        this.borrowPK = borrowPK;
    }
    @Override
    public String toString() {
        return "Borrow{" +
                "issuedate='" + getIssuedate() + '\'' +
                ", expidate='" + getExpidate() + '\'' +
                ", borrowPK=" + getBorrowPK() +
                '}';
    }

}
