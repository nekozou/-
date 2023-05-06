//ParticipationProjects
package kcsj.domain;

public class Projects{
    private String pp_no;
    private String gra_id;
    private String tea_id;

    private String proj_id;
    private String proj_class;
    private String proj_name;
    private String proj_begin;
    private String proj_end;
    private String duty_work;
    private String proj_outlay;

    public Projects() {

    }


    @Override
    public String toString() {
        return "参与项目认定{" +
                "编号='" + pp_no + '\'' +
                ", 研究生编号='" + gra_id + '\'' +
                ", 指导教师编号='" + tea_id + '\'' +
                ", 项目编号='" + proj_id + '\'' +
                ", 项目类型='" + proj_class + '\'' +
                ", 项目名称='" + proj_name + '\'' +
                ", 项目开始时间='" + proj_begin + '\'' +
                ", 项目结束时间='" + proj_end + '\'' +
                ", 承担工作='" + duty_work + '\'' +
                ", 折合经费='" + proj_outlay + '\'' +
                '}';
    }

    public String getTea_id() {
        return tea_id;
    }

    public void setTea_id(String tea_id) {
        this.tea_id = tea_id;
    }
    public String getPp_no() {
        return pp_no;
    }

    public void setPp_no(String pp_no) {
        this.pp_no = pp_no;
    }

    public String getGra_id() {
        return gra_id;
    }

    public void setGra_id(String gra_id) {
        this.gra_id = gra_id;
    }

    public String getProj_id() {
        return proj_id;
    }

    public void setProj_id(String proj_id) {
        this.proj_id = proj_id;
    }

    public String getProj_class() {
        return proj_class;
    }

    public void setProj_class(String proj_class) {
        this.proj_class = proj_class;
    }

    public String getProj_name() {
        return proj_name;
    }

    public void setProj_name(String proj_name) {
        this.proj_name = proj_name;
    }

    public String getProj_begin() {
        return proj_begin;
    }

    public void setProj_begin(String proj_begin) {
        this.proj_begin = proj_begin;
    }

    public String getProj_end() {
        return proj_end;
    }

    public void setProj_end(String proj_end) {
        this.proj_end = proj_end;
    }

    public String getDuty_work() {
        return duty_work;
    }

    public void setDuty_work(String duty_work) {
        this.duty_work = duty_work;
    }

    public String getProj_outlay() {
        return proj_outlay;
    }

    public void setProj_outlay(String proj_outlay) {
        this.proj_outlay = proj_outlay;
    }
}