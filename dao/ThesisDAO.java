package kcsj.dao;

import kcsj.SearchCriteria;
import kcsj.domain.Thesis;

import java.util.List;

public interface ThesisDAO {
    void addThesis(String no,String pwd,Thesis thesis);
    void updateThesis(String no,String pwd,Thesis thesis,int i);
    void deleteThesis(String no,String pwd,String thesis_no);
    Thesis getThesis(String no,String pwd,String thesis_no);
    List<Thesis> findThesis(String no,String pwd,SearchCriteria searchCriteria);
}
