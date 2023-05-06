package kcsj.dao;

import kcsj.SearchCriteria;
import kcsj.domain.Mas_achievement;

import java.util.List;

public interface Mas_achievementDAO {
    void addMas_achievement(Mas_achievement mas_achievement, String no, String pwd);
    void updateMas_achievement(Mas_achievement mas_achievement, String no, String pwd);
    void deleteMas_achievement(String mas_id, String no, String pwd);
    Mas_achievement getMas_achievement(String mas_id, String no, String pwd);
}
