package kcsj.domain;

public class Phd_reward {
    private String reward_no;
    private String reward_name;
    private String reward_rank;
    private String reward_score;
    private String reward_order;
    private String reward_date;
    private byte[] reward_identity;


    public Phd_reward() {

    }

    public String getReward_no() {
        return reward_no;
    }

    public void setReward_no(String reward_no) {
        this.reward_no = reward_no;
    }

    public String getReward_name() {
        return reward_name;
    }

    public void setReward_name(String reward_name) {
        this.reward_name = reward_name;
    }

    public String getReward_rank() {
        return reward_rank;
    }

    public void setReward_rank(String reward_rank) {
        this.reward_rank = reward_rank;
    }

    public String getReward_score() {
        return reward_score;
    }

    public void setReward_score(String reward_score) {
        this.reward_score = reward_score;
    }

    public String getReward_order() {
        return reward_order;
    }

    public void setReward_order(String reward_order) {
        this.reward_order = reward_order;
    }

    public String getReward_date() {
        return reward_date;
    }

    public void setReward_date(String reward_date) {
        this.reward_date = reward_date;
    }

    public byte[] getReward_identity() {
        return reward_identity;
    }

    public void setReward_identity(byte[] reward_identity) {
        this.reward_identity = reward_identity;
    }

    @Override
    public String toString() {
        return " 博士研究生奖励表{" +
                "奖励编号='" + reward_no + '\'' +
                ", 奖励名称='" + reward_name + '\'' +
                ", 奖励等级='" + reward_rank + '\'' +
                ", 获奖等级='" + reward_score + '\'' +
                ", 排名='" + reward_order + '\'' +
                ", 获奖时间='" + reward_date + '\'' +
                '}';
    }
}
