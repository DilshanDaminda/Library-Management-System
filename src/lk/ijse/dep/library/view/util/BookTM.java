package lk.ijse.dep.library.view.util;

public class BookTM {
    private String bookid;
    private String title;
    private String author;
    private String pubid;
    private String availability;

    public BookTM() {
    }

    public BookTM(String bookid, String title, String author, String pubid, String availability) {
        this.setBookid(bookid);
        this.setTitle(title);
        this.setAuthor(author);
        this.setPubid(pubid);
        this.setAvailability(availability);
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubid() {
        return pubid;
    }

    public void setPubid(String pubid) {
        this.pubid = pubid;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "BookTM{" +
                "bookid='" + bookid + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pubid='" + pubid + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }
}
