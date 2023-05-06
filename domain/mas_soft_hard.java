package kcsj.domain;

public class mas_soft_hard {
    private String soft_hard_no;
    private String soft_hard_name;
    private String soft_hard_unit;
    private String soft_hard_date;
    private int soft_hard_con;
    private byte[] soft_hard_identity;

    private String soft_hard_first;
    private String soft_hard_last;


    public String getSoft_hard_first() {
        return soft_hard_first;
    }

    public void setSoft_hard_first(String soft_hard_first) {
        this.soft_hard_first = soft_hard_first;
    }

    public String getSoft_hard_last() {
        return soft_hard_last;
    }

    public void setSoft_hard_last(String soft_hard_last) {
        this.soft_hard_last = soft_hard_last;
    }

    public mas_soft_hard(){//无参构造器
    }

    public String getSoft_hard_no() {
        return soft_hard_no;
    }

    public void setSoft_hard_no(String soft_hard_no) {
        this.soft_hard_no = soft_hard_no;
    }

    public String getSoft_hard_name() {
        return soft_hard_name;
    }

    public void setSoft_hard_name(String soft_hard_name) {
        this.soft_hard_name = soft_hard_name;
    }

    public String getSoft_hard_unit() {
        return soft_hard_unit;
    }

    public void setSoft_hard_unit(String soft_hard_unit) {
        this.soft_hard_unit = soft_hard_unit;
    }

    public String getSoft_hard_date() {
        return soft_hard_date;
    }

    public void setSoft_hard_date(String soft_hard_date) {
        this.soft_hard_date = soft_hard_date;
    }

    public int getSoft_hard_con() {
        return soft_hard_con;
    }

    public void setSoft_hard_con(int soft_hard_con) {
        this.soft_hard_con = soft_hard_con;
    }


    public byte[] getSoft_hard_identity() {
        return soft_hard_identity;
    }

    public void setSoft_hard_identity(byte[] soft_hard_identity) {
        this.soft_hard_identity = soft_hard_identity;
    }

    @Override
    public String toString() {
        return "软硬件开发平台表{" +
                "软硬件编号='" + soft_hard_no + '\'' +
                ", 软硬件名称='" + soft_hard_name + '\'' +
                ", 软硬件平台服务单位='" + soft_hard_unit + '\'' +
                ", 平台上线时间='" + soft_hard_date + '\'' +
                ", 贡献度=" + soft_hard_con +
                ", 初审结果='" + soft_hard_first + '\'' +
                ", 终审结果='" + soft_hard_last + '\'' +
                '}';
    }
}
