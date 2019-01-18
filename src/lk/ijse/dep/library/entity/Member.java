package lk.ijse.dep.library.entity;

import java.util.Date;

public class Member extends SuperEntity{
    private String memberid;
    private String member_name;
    private String membertype;
    private String memberdate;

    public Member() {
    }

    public Member(String memberid, String member_name, String membertype, String memberdate) {
        this.memberid = memberid;
        this.member_name = member_name;
        this.membertype = membertype;
        this.memberdate = memberdate;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMembertype() {
        return membertype;
    }

    public void setMembertype(String membertype) {
        this.membertype = membertype;
    }

    public String getMemberdate() {
        return memberdate;
    }

    public void setMemberdate(String memberdate) {
        this.memberdate = memberdate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberid='" + memberid + '\'' +
                ", member_name='" + member_name + '\'' +
                ", membertype='" + membertype + '\'' +
                ", memberdate='" + memberdate + '\'' +
                '}';
    }
}
