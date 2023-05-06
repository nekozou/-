package kcsj.dao;

import kcsj.SearchCriteria;
import kcsj.domain.mas_soft_hard;

import java.util.List;

public interface mas_soft_hardDAO {
    void addmas_soft_hard(mas_soft_hard mas_soft_hard_add, String no, String pwd);
    void updatemas_soft_hard(mas_soft_hard mas_soft_hard_update, String no, String pwd,int i);
    void deletemas_soft_hard(String soft_hard_no, String no, String pwd);
    mas_soft_hard getmas_soft_hard(String soft_hard_no, String no, String pwd);
    List<mas_soft_hard> findmas_soft_hard(SearchCriteria searchCriteria);
}
