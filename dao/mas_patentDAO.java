package kcsj.dao;

import kcsj.SearchCriteria;
import kcsj.domain.mas_patent;

import java.util.List;

public interface mas_patentDAO {
    void addmas_patent(mas_patent mas_patent_add, String no, String pwd);
    void updatemas_patent(mas_patent mas_patent_update, String no, String pwd,int i);
    void deletemas_patent(String patent_no, String no, String pwd);
    mas_patent getmas_patent(String patent_no, String no, String pwd);
    List<mas_patent> findmas_patent(SearchCriteria searchCriteria);
}
