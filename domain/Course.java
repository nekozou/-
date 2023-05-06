package kcsj.domain;

public class Course {
    private String crs_no;
    private String crs_name;
    private int crs_num;
    private int crs_time;
    private double crs_score;

    private double crs_pri;

    private String gra_id;

    public String getCrs_no() {
        return crs_no;
    }

    public void setCrs_no(String crs_no) {
        this.crs_no = crs_no;
    }

    public String getCrs_name() {
        return crs_name;
    }

    public void setCrs_name(String crs_name) {
        this.crs_name = crs_name;
    }

    public int getCrs_num() {
        return crs_num;
    }

    public void setCrs_num(int crs_num) {
        this.crs_num = crs_num;
    }

    public int getCrs_time() {
        return crs_time;
    }

    public void setCrs_time(int crs_time) {
        this.crs_time = crs_time;
    }

    public double getCrs_score() {
        return crs_score;
    }

    public void setCrs_score(double crs_score) {
        this.crs_score = crs_score;
    }

    public double getCrs_pri() {
        return crs_pri;
    }

    public void setCrs_pri(double crs_pri) {
        this.crs_pri = crs_pri;
    }

    public String getGra_id() {
        return gra_id;
    }

    public void setGra_id(String gra_id) {
        this.gra_id = gra_id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "crs_no='" + crs_no + '\'' +
                ", crs_name='" + crs_name + '\'' +
                ", crs_num=" + crs_num +
                ", crs_time=" + crs_time +
                ", crs_score=" + crs_score +
                ", crs_pri=" + crs_pri +
                ", gra_id=" + gra_id + '\'' +
                '}';
    }
}
