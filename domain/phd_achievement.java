package kcsj.domain;

public class phd_achievement {
    private String phd_id;
    private String phd_type;
    private String thesis_no;
    private String reward_no;
    private String standard_no;
    private String other_no;

    public phd_achievement(String phd_id, String phd_type, String thesis_no, String reward_no, String standard_no, String other_no){
        this.phd_id = phd_id;
        this.phd_type = phd_type;
        this.thesis_no = thesis_no;
        this.reward_no = reward_no;
        this.standard_no = standard_no;
        this.other_no = other_no;
    }

    public phd_achievement(){

    }

    public String getPhd_id(){return phd_id;}

    public String getPhd_type(){return phd_type;}

    public String getThesis_no(){return thesis_no;}

    public String getReward_no(){return reward_no;}

    public String getStandard_no(){return standard_no;}

    public String getOther_no(){return other_no;}

    public void setPhd_id(String phd_id){this.phd_id = phd_id;}

    public void setPhd_type(String phd_type){this.phd_type = phd_type;}

    public void setThesis_no(String thesis_no){this.thesis_no = thesis_no;}

    public void setReward_no(String reward_no){this.reward_no = reward_no;}

    public void setStandard_no(String standard_no){this.standard_no = standard_no;}

    public void setOther_no(String other_no){this.other_no = other_no;}

    @Override
    public String toString()
    {
        return "博士研究生成果认定{" +
                "博士研究生学号='" + phd_id + '\'' +
                ", 博士论文编号='" + thesis_no + '\'' +
                ", 博士奖励编号='" + reward_no + '\'' +
                ", 博士标准编号='" + standard_no + '\'' +
                ", 其他成果编号='" + other_no + '\'' +
                '}';
    }
}
