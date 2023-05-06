package kcsj.domain;

public class phd_other {
    private String other_no;
    private String other_name;
    private String other_rank;
    private String other_date;
    private byte[] other_identity;

    private String other_first;
    private String other_last;

    public String getOther_first() {
        return other_first;
    }

    public void setOther_first(String other_first) {
        this.other_first = other_first;
    }

    public String getOther_last() {
        return other_last;
    }

    public void setOther_last(String other_last) {
        this.other_last = other_last;
    }

    public String getOther_no() {
        return other_no;
    }

    public void setOther_no(String other_no) {
        this.other_no = other_no;
    }

    public String getOther_name() {
        return other_name;
    }

    public void setOther_name(String other_name) {
        this.other_name = other_name;
    }

    public String getOther_rank() {
        return other_rank;
    }

    public void setOther_rank(String other_rank) {
        this.other_rank = other_rank;
    }

    public String getOther_date() {
        return other_date;
    }

    public void setOther_date(String other_date) {
        this.other_date = other_date;
    }

    public byte[] getOther_identity() {
        return other_identity;
    }

    public void setOther_identity(byte[] other_identity) {
        this.other_identity = other_identity;
    }

    @Override
    public String toString() {
        return "其他成果表{" +
                "其他成果编号='" + other_no + '\'' +
                ", 其他成果名称='" + other_name + '\'' +
                ", 其他成果级别='" + other_rank + '\'' +
                ", 发布时间='" + other_date + '\'' +
                ", 初审结果='" + other_first + '\'' +
                ", 终审结果='" + other_last + '\'' +
                '}';
    }
}
