package kcsj.domain;

public class Teacher {
    private String tea_id;
    private String tea_name;
    private String college;
    private String dept;
    private String title;
    private String is_duty;
    private String is_tutor;
    private String is_lecture;
    private String user;
    private String pwd;

    public Teacher() {

    }

    @Override
    public String toString() {
        return "教师表{" +
                "教师编号='" + tea_id + '\'' +
                ", 教师名称='" + tea_name + '\'' +
                ", 教师所属学院='" + college + '\'' +
                ", 教师所属专业='" + dept + '\'' +
                ", 教师职称='" + title + '\'' +
                '}';
    }

    public String getTea_id() {
        return tea_id;
    }

    public void setTea_id(String tea_id) {
        this.tea_id = tea_id;
    }

    public String getTea_name() {
        return tea_name;
    }

    public void setTea_name(String tea_name) {
        this.tea_name = tea_name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIs_duty() {
        return is_duty;
    }

    public void setIs_duty(String is_duty) {
        this.is_duty = is_duty;
    }

    public String getIs_tutor() {
        return is_tutor;
    }

    public void setIs_tutor(String is_tutor) {
        this.is_tutor = is_tutor;
    }

    public String getIs_lecture() {
        return is_lecture;
    }

    public void setIs_lecture(String is_lecture) {
        this.is_lecture = is_lecture;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
