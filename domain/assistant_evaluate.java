package kcsj.domain;

public class assistant_evaluate {
    private String ae_no;//评定表编号
    private String gra_id;//研究生id
    private String crs_no;//课程编号
    private int stu_num;//授课人数
    private int crs_nat;//课程性质
    private int crs_stu;//授课对象
    private String tea_id;//授课教师id
    private String ass_time;//授课时间
    private String self_eva;//助教工作自述
    private String tea_eva;//授课教师评价
    private int ae_res;//授课教师评价
    private String ae_time;//评定时间

    public assistant_evaluate(){}

    public assistant_evaluate(String ae_no, String gra_id, String crs_no, int stu_num, int crs_nat, int crs_stu, String tea_id, String ass_time, String self_eva, String tea_eva, int ae_res, String ae_time) {
        this.ae_no = ae_no;
        this.gra_id = gra_id;
        this.crs_no = crs_no;
        this.stu_num = stu_num;
        this.crs_nat = crs_nat;
        this.crs_stu = crs_stu;
        this.tea_id = tea_id;
        this.ass_time = ass_time;
        this.self_eva = self_eva;
        this.tea_eva = tea_eva;
        this.ae_res = ae_res;
        this.ae_time = ae_time;
    }

    public String getAe_no() {
        return ae_no;
    }

    public void setAe_no(String ae_no) {
        this.ae_no = ae_no;
    }

    public String getGra_id() {
        return gra_id;
    }

    public void setGra_id(String gra_id) {
        this.gra_id = gra_id;
    }

    public String getCrs_no() {
        return crs_no;
    }

    public void setCrs_no(String crs_no) {
        this.crs_no = crs_no;
    }

    public int getStu_num() {
        return stu_num;
    }

    public void setStu_num(int stu_num) {
        this.stu_num = stu_num;
    }

    public int getCrs_nat() {
        return crs_nat;
    }

    public void setCrs_nat(int crs_nat) {
        this.crs_nat = crs_nat;
    }

    public int getCrs_stu() {
        return crs_stu;
    }

    public void setCrs_stu(int crs_stu) {
        this.crs_stu = crs_stu;
    }

    public String getTea_id() {
        return tea_id;
    }

    public void setTea_id(String tea_id) {
        this.tea_id = tea_id;
    }

    public String getAss_time() {
        return ass_time;
    }

    public void setAss_time(String ass_time) {
        this.ass_time = ass_time;
    }

    public String getSelf_eva() {
        return self_eva;
    }

    public void setSelf_eva(String self_eva) {
        this.self_eva = self_eva;
    }

    public String getTea_eva() {
        return tea_eva;
    }

    public void setTea_eva(String tea_eva) {
        this.tea_eva = tea_eva;
    }

    public int getAe_res() {
        return ae_res;
    }

    public void setAe_res(int ae_res) {
        this.ae_res = ae_res;
    }

    public String getAe_time() {
        return ae_time;
    }

    public void setAe_time(String ae_time) {
        this.ae_time = ae_time;
    }

    @Override
    public String toString() {
        return "助教评定表{" +
                "评定表编号='" + ae_no + '\'' +
                ", 研究生id='" + gra_id + '\'' +
                ", 课程编号='" + crs_no + '\'' +
                ", 授课人数=" + stu_num +
                ", 课程性质(1必修,2选修)=" + crs_nat +
                ", 授课对象(1本科,2研究生)=" + crs_stu +
                ", 授课教师id='" + tea_id + '\'' +
                ", 授课时间='" + ass_time + '\'' +
                ", 助教工作自述='" + self_eva + '\'' +
                ", 助教教师评价='" + tea_eva + '\'' +
                ", 评定结果(1合格,2不合格)=" + ae_res +
                ", 评定时间='" + ae_time + '\'' +
                '}';
    }

}
