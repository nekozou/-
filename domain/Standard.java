package kcsj.domain;

public class Standard {
    private String standard_no;
    private String standard_name;
    private String standard_rank;
    private String standard_date;
    private byte[] standard_identity;

    public String getStandard_first() {
        return standard_first;
    }

    public void setStandard_first(String standard_first) {
        this.standard_first = standard_first;
    }

    public String getStandard_last() {
        return standard_last;
    }

    public void setStandard_last(String standard_last) {
        this.standard_last = standard_last;
    }

    private String standard_first;
    private String standard_last;

    public Standard() {

    }

    public String getStandard_no() {
        return standard_no;
    }

    public void setStandard_no(String standard_no) {
        this.standard_no = standard_no;
    }

    public String getStandard_name() {
        return standard_name;
    }

    public void setStandard_name(String standard_name) {
        this.standard_name = standard_name;
    }

    public String getStandard_rank() {
        return standard_rank;
    }

    public void setStandard_rank(String standard_rank) {
        this.standard_rank = standard_rank;
    }

    public String getStandard_date() {
        return standard_date;
    }

    public void setStandard_date(String standard_date) {
        this.standard_date = standard_date;
    }

    public byte[] getStandard_identity() {
        return standard_identity;
    }

    public void setStandard_identity(byte[] standard_identity) {
        this.standard_identity = standard_identity;
    }

    @Override
    public String toString() {
        return "标准表{" +
                "标准编号='" + standard_no + '\'' +
                ", 标准名称='" + standard_name + '\'' +
                ", 标准级别='" + standard_rank + '\'' +
                ", 标准发布时间='" + standard_date + '\'' +
                ", 初审结果='" + standard_first + '\'' +
                ", 终审结果='" + standard_last + '\'' +
                '}';
    }
}
