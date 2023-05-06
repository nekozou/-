package kcsj.domain;

public class mas_report {
    private String report_no;
    private String report_name;
    private String report_type;
    private String report_unit;
    private String report_date;
    private int report_con;

    public byte[] getReport_identity() {
        return report_identity;
    }

    public void setReport_identity(byte[] report_identity) {
        this.report_identity = report_identity;
    }

    private byte[] report_identity;
    private String report_first;

    private String report_second;

    public mas_report(){//无参构造器
    }

    public String getReport_first() {
        return report_first;
    }

    public void setReport_first(String report_first) {
        this.report_first = report_first;
    }

    public String getReport_second() {
        return report_second;
    }

    public void setReport_second(String report_second) {
        this.report_second = report_second;
    }

    public String getReport_no() {
        return report_no;
    }

    public void setReport_no(String report_no) {
        this.report_no = report_no;
    }

    public String getReport_name() {
        return report_name;
    }

    public void setReport_name(String report_name) {
        this.report_name = report_name;
    }

    public String getReport_type() {
        return report_type;
    }

    public void setReport_type(String report_type) {
        this.report_type = report_type;
    }

    public String getReport_unit() {
        return report_unit;
    }

    public void setReport_unit(String report_unit) {
        this.report_unit = report_unit;
    }

    public String getReport_date() {
        return report_date;
    }

    public void setReport_date(String report_date) {
        this.report_date = report_date;
    }

    public int getReport_con() {
        return report_con;
    }

    public void setReport_con(int report_con) {
        this.report_con = report_con;
    }

    @Override
    public String toString() {
        return "报告表{" +
                "报告编号='" + report_no + '\'' +
                ", 报告名称='" + report_name + '\'' +
                ", 报告类型='" + report_type + '\'' +
                ", 报告服务单位='" + report_unit + '\'' +
                ", 报告时间='" + report_date + '\'' +
                ", 报告贡献度=" + report_con +
                ", 初审结果='" + report_first + '\'' +
                ", 终审结果='" + report_second + '\'' +
                '}';
    }
}
