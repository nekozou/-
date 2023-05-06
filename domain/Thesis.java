package kcsj.domain;

public class Thesis {
    private String thesis_no;
    private String thesis_name;
    private String thesis_pub;
    private String thesis_state;
    private String thesis_date;
    private String thesis_index;
    private String thesis_bel;
    private byte[] thesis_scan;//YGT
    private byte[] thesis_pdf;
    private String thesis_first;

    public void setThesis_scan(byte[] thesis_scan) {
        this.thesis_scan = thesis_scan;
    }

    public byte[] getThesis_scan() {
        return thesis_scan;
    }

    public byte[] getThesis_pdf() {
        return thesis_pdf;
    }

    public void setThesis_pdf(byte[] thesis_pdf) {
        this.thesis_pdf = thesis_pdf;
    }

    public String getThesis_first() {
        return thesis_first;
    }

    public void setThesis_first(String thesis_first) {
        this.thesis_first = thesis_first;
    }

    public String getThesis_last() {
        return thesis_last;
    }

    public void setThesis_last(String thesis_last) {
        this.thesis_last = thesis_last;
    }

    private String thesis_last;

    public Thesis() {

    }

    public String getThesis_no(){return thesis_no;}
    public String getThesis_name(){return thesis_name;}
    public String getThesis_pub(){return thesis_pub;}
    public String getThesis_state(){return thesis_state;}
    public String getThesis_date(){return thesis_date;}
    public String getThesis_index(){return thesis_index;}
    public String getThesis_bel(){return thesis_bel;}

    public void setThesis_no(String thesis_no){this.thesis_no = thesis_no;}
    public void setThesis_name(String thesis_name){this.thesis_name = thesis_name;}
    public void setThesis_pub(String thesis_pub){this.thesis_pub = thesis_pub;}
    public void setThesis_state(String thesis_state){this.thesis_state = thesis_state;}
    public void setThesis_date(String thesis_date){this.thesis_date = thesis_date;}
    public void setThesis_index(String thesis_index){this.thesis_index = thesis_index;}
    public void setThesis_bel(String thesis_bel){this.thesis_bel = thesis_bel;}
    @Override
    public String toString() {
        return "论文表{" +
                "论文编号='" + thesis_no + '\'' +
                ", 论文名称='" + thesis_name + '\'' +
                ", 论文刊物名称='" + thesis_pub + '\'' +
                ", 论文状态（0未发表，1录用，2已发表)）='" + thesis_state + '\'' +
                ", 发表时间='" + thesis_date + '\'' +
                ", 索引类型='" + thesis_index + '\'' +
                ", 论文归属库='" + thesis_bel + '\'' +
                ", 初审结果='" + thesis_first + '\'' +
                ", 终审结果='" + thesis_last + '\'' +
                '}';
    }
}
