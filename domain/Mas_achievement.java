package kcsj.domain;

public class Mas_achievement {
    private String mas_id;
    private String mas_type;
    private String thesis_no;
    private String book_no;
    private String standard_no;
    private String report_no;
    private String patent_no;
    private String soft_hard_no;

    public Mas_achievement(String mas_id, String mas_type, String thesis_no, String book_no, String standard_no, String report_no, String patent_no, String soft_hard_no){
        this.mas_id = mas_id;
        this.mas_type = mas_type;
        this.thesis_no = thesis_no;
        this.book_no = book_no;
        this.standard_no = standard_no;
        this.report_no = report_no;
        this.patent_no = patent_no;
        this.soft_hard_no = soft_hard_no;
    }

    public Mas_achievement() {

    }

    public String getMas_id(){return mas_id;}
    public String getMas_type(){return mas_type;}
    public String getThesis_no(){return thesis_no;}
    public String getBook_no(){return book_no;}
    public String getStandard_no(){return standard_no;}
    public String getReport_no(){return report_no;}
    public String getPatent_no(){return patent_no;}
    public String getSoft_hard_no(){return soft_hard_no;}

    public void setMas_id(String mas_id){this.mas_id = mas_id;}
    public void setMas_type(String mas_type){this.mas_type = mas_type;}
    public void setThesis_no(String thesis_no){this.thesis_no = thesis_no;}
    public void setBook_no(String book_no){this.book_no = book_no;}
    public void setStandard_no(String standard_no){this.standard_no = standard_no;}
    public void setReport_no(String report_no){this.report_no = report_no;}
    public void setPatent_no(String patent_no){this.patent_no = patent_no;}
    public void setSoft_hard_no(String soft_hard_no){this.soft_hard_no = soft_hard_no;}

    @Override
    public String toString() {
        return "硕士研究生成果认定{" +
                " 学号='" + mas_id + '\'' +
                ", 论文编号='" + thesis_no + '\'' +
                ", 教材编号='" + book_no + '\'' +
                ", 标准编号='" + standard_no + '\'' +
                ", 报告编号='" + report_no + '\'' +
                ", 专利编号='" + patent_no + '\'' +
                ", 软硬件开发平台编号='" + soft_hard_no + '\'' +
                '}';
    }
}
