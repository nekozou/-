package kcsj.domain;

import java.util.Arrays;

public class Academic_exchange {
    private String ace_no;
    private String gra_id;
    private String ace_name;
    private String ace_place;
    private String ace_date;
    private String ace_CHname;
    private String ace_ENname;
    private byte[] ace_pic;

    public String getAce_effective() {
        return ace_effective;
    }

    public void setAce_effective(String ace_effective) {
        this.ace_effective = ace_effective;
    }

    private String ace_note;

    private String ace_effective;
    public Academic_exchange() {
    }

    @Override
    public String toString() {
        return "学术交流{" +
                "学术交流表编号='" + ace_no + '\'' +
                ",研究生编号='" + gra_id + '\'' +
                ",学术交流活动名称='" + ace_name + '\'' +
                ",活动地点='" + ace_place + '\'' +
                ",活动时间='" + ace_date + '\'' +
                ",报告中文名='" + ace_CHname + '\'' +
                ",报告英文名='" + ace_ENname + '\'' +
                ",备注信息='" + ace_note + '\'' +
                ",是否有效='" + ace_effective + '\'' +
                '}';
    }

    public String getAce_no() {
        return ace_no;
    }

    public void setAce_no(String ace_no) {
        this.ace_no = ace_no;
    }

    public String getGra_id() {return gra_id;}

    public void setGra_id(String gra_id) {
        this.gra_id = gra_id;
    }

    public String getAce_name() {
        return ace_name;
    }

    public void setAce_name(String ace_name) {
        this.ace_name = ace_name;
    }

    public String getAce_place() {
        return ace_place;
    }

    public void setAce_place(String ace_place) {
        this.ace_place = ace_place;
    }

    public String getAce_date() {
        return ace_date;
    }

    public void setAce_date(String ace_date) {
        this.ace_date = ace_date;
    }

    public String getAce_CHname() {
        return ace_CHname;
    }

    public void setAce_CHname(String ace_CHname) {
        this.ace_CHname = ace_CHname;
    }

    public String getAce_ENname() {
        return ace_ENname;
    }

    public void setAce_ENname(String ace_ENname) {
        this.ace_ENname = ace_ENname;
    }

    public byte[] getAce_pic() {
        return ace_pic;
    }

    public void setAce_pic(byte[] ace_pic) {
        this.ace_pic = ace_pic;
    }
    public String getAce_note() {
        return ace_note;
    }

    public void setAce_note(String ace_note) {
        this.ace_note = ace_note;
    }
}
