package kcsj.dao;

import kcsj.SearchCriteria;
import kcsj.domain.phd_other;

import java.util.List;

public interface phd_otherDAO {
    void addphd_other(phd_other phd_other_add, String no, String pwd);
    void updatephd_other(phd_other phd_other_update, String no, String pwd,int i);
    void deletephd_other(String other_no, String no, String pwd);
    phd_other getphd_other(String other_no, String no, String pwd);
    List<phd_other> findphd_other(SearchCriteria searchCriteria);
}
