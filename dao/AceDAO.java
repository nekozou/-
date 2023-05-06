package kcsj.dao;

import kcsj.SearchCriteria;
import kcsj.domain.Academic_exchange;

import java.util.List;

public interface AceDAO {
    void addAce(String no,String pwd,Academic_exchange ace);//添加
    void updateAce(String no,String pwd,Academic_exchange ace);//更新
    void deleteAce(String no,String pwd,String ace_no);      //删除
    Academic_exchange getAce(String no,String pwd,String ace_no);       //查询

    List<Academic_exchange> findAce(String no, String pwd, SearchCriteria searchCriteria);
}
