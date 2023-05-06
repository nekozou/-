package kcsj.domain;

public class Gra_info {
    private String gra_id;
    private String gra_name;
    private String gra_type;
    private String gra_coll;
    private String dept;
    private String tea_id;
    private String usr;
    private String pwd;
    public Gra_info() {
    }

    public Gra_info(String gra_id, String gra_name, String gra_type, String gra_coll, String dept, String tea_id, String usr, String pwd) {
        this.gra_id = gra_id;
        this.gra_name = gra_name;
        this.gra_type = gra_type;
        this.gra_coll = gra_coll;
        this.dept = dept;
        this.tea_id = tea_id;
        this.usr = usr;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "研究生表{" +
                "研究生编号'" + gra_id + '\'' +
                ",研究生姓名='" + gra_name + '\'' +
                ",研究生类型（1硕士研究生，2博士研究生）='" + gra_type + '\'' +
                ",研究生所属学院='" + gra_coll + '\'' +
                ",研究生专业='" + dept + '\'' +
                ",研究生导师='" + tea_id + '\'' +
                '}';
    }

    public String getGra_id() {
        return gra_id;
    }

    public void setGra_id(String gra_id) {
        this.gra_id = gra_id;
    }

    public String getGra_name() {
        return gra_name;
    }

    public void setGra_name(String gra_name) {
        this.gra_name = gra_name;
    }

    public String getGra_type() {
        return gra_type;
    }

    public void setGra_type(String gra_type) {
        this.gra_type = gra_type;
    }

    public String getGra_coll() {
        return gra_coll;
    }

    public void setGra_coll(String gra_coll) {
        this.gra_coll = gra_coll;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getTea_id() {
        return tea_id;
    }

    public void setTea_id(String tea_id) {
        this.tea_id = tea_id;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
