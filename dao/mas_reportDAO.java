package kcsj.dao;

import kcsj.SearchCriteria;
import kcsj.domain.mas_book;
import kcsj.domain.mas_report;

import java.util.List;

public interface mas_reportDAO {
    void addmas_report(mas_report mas_report_add, String no, String pwd);
    void updatemas_report(mas_report mas_report_update, String no, String pwd,int i);
    void deletemas_report(String report_no, String no, String pwd);
    mas_report getmas_report(String report_no, String no, String pwd);
    List<mas_book> findmas_report(SearchCriteria searchCriteria);
}
