package kcsj.domain;

public class mas_patent {
    private String patent_no;
    private String patent_name;
    private String patent_type;
    private int patent_state;
    private String patent_time;
    private int patent_con;
    private byte[] patent_identity;

    public byte[] getPatent_identity() {
        return patent_identity;
    }

    public void setPatent_identity(byte[] patent_identity) {
        this.patent_identity = patent_identity;
    }

    private String patent_first;
    private String patent_last;

    public String getPatent_first() {
        return patent_first;
    }

    public void setPatent_first(String patent_first) {
        this.patent_first = patent_first;
    }

    public String getPatent_last() {
        return patent_last;
    }

    public void setPatent_last(String patent_last) {
        this.patent_last = patent_last;
    }

    public mas_patent(){//无参构造器
    }

    public String getPatent_no() {
        return patent_no;
    }

    public void setPatent_no(String patent_no) {
        this.patent_no = patent_no;
    }

    public String getPatent_name() {
        return patent_name;
    }

    public void setPatent_name(String patent_name) {
        this.patent_name = patent_name;
    }

    public String getPatent_type() {
        return patent_type;
    }

    public void setPatent_type(String patent_type) {
        this.patent_type = patent_type;
    }

    public int getPatent_state() {
        return patent_state;
    }

    public void setPatent_state(int patent_state) {
        this.patent_state = patent_state;
    }

    public String getPatent_time() {
        return patent_time;
    }

    public void setPatent_time(String patent_time) {
        this.patent_time = patent_time;
    }

    public int getPatent_con() {
        return patent_con;
    }

    public void setPatent_con(int patent_con) {
        this.patent_con = patent_con;
    }


    @Override
    public String toString() {
        return "专利表{" +
                "专利号='" + patent_no + '\'' +
                ", 专利名称='" + patent_name + '\'' +
                ", 专利类型='" + patent_type + '\'' +
                ", 专利状态（0未发表，1录用，2已发表）=" + patent_state +
                ", 发表时间='" + patent_time + '\'' +
                ", 贡献度=" + patent_con +
                ", 佐证材料='" + patent_identity + '\'' +
                ", 初审结果='" + patent_first + '\'' +
                ", 终审结果='" + patent_last + '\'' +
                '}';
    }

}
