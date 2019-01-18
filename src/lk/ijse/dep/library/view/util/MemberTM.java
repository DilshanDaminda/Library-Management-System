package lk.ijse.dep.library.view.util;

public class MemberTM {
    private String memberid;
    private String member_name;
    private String membertype;
    private String memberdate;

    public MemberTM() {
    }

    public MemberTM(String memberid, String member_name, String membertype, String memberdate) {
        this.setMemberid(memberid);
        this.setMember_name(member_name);
        this.setMembertype(membertype);
        this.setMemberdate(memberdate);
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
        return "MemberTM{" +
                "memberid='" + memberid + '\'' +
                ", member_name='" + member_name + '\'' +
                ", membertype='" + membertype + '\'' +
                ", memberdate='" + memberdate + '\'' +
                '}';
    }
}