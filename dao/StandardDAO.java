package kcsj.dao;

import kcsj.SearchCriteria;
import kcsj.domain.Standard;

import java.util.List;

public interface StandardDAO {
    void addStandard(String no,String pwd,Standard standard);
    void updateStandard(String no,String pwd,Standard standard);
    void deleteStandard(String no,String pwd,String standard_no);
    Standard getStandard(String no,String pwd,String standard_no);
    List<Standard> findStandards(String no,String pwd,SearchCriteria searchCriteria);
}
