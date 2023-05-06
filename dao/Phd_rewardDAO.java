package kcsj.dao;

import kcsj.SearchCriteria;
import kcsj.domain.Phd_reward;

import java.util.List;

public interface Phd_rewardDAO {
    void addPhd_reward(Phd_reward phd_reward, String no, String pwd);
    void updatePhd_reward(Phd_reward phd_reward, String no, String pwd);
    void deletePhd_reward(String reward_no, String no, String pwd);
    Phd_reward getPhd_reward(String reward_no, String no, String pwd);
    List<Phd_reward> findPhd_rewards(SearchCriteria searchCriteria);
}
