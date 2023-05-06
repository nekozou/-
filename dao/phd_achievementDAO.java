package kcsj.dao;

import kcsj.SearchCriteria;
import kcsj.domain.phd_achievement;

import java.util.List;

public interface phd_achievementDAO {
    void addPhd_achievement(phd_achievement phd_achievement, String no, String pwd);
    void updatePhd_achievement(phd_achievement phd_achievement, String no, String pwd);
    void deletePhd_achievement(String phd_id, String no, String pwd);
    phd_achievement getPhd_achievement(String phd_id, String no, String pwd);
}
