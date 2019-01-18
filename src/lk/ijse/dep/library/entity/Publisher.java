package lk.ijse.dep.library.entity;

public class Publisher extends SuperEntity{
    private String publishid;
    private String publishname;

    public Publisher() {
    }

    public Publisher(String publishid, String publishname) {
        this.setPublishid(publishid);
        this.setPublishname(publishname);
    }

    public String getPublishid() {
        return publishid;
    }

    public void setPublishid(String publishid) {
        this.publishid = publishid;
    }

    public String getPublishname() {
        return publishname;
    }

    public void setPublishname(String publishname) {
        this.publishname = publishname;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publishid='" + publishid + '\'' +
                ", publishname='" + publishname + '\'' +
                '}';
    }
}
