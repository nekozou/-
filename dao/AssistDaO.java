package kcsj.dao;
import kcsj.SearchCriteria;
import kcsj.domain.Teacher;
import kcsj.domain.assistant_evaluate;

import java.util.List;

public interface AssistDaO  {

    void addAssist_DHY(String no,String pwd,assistant_evaluate assist);//添加
    void updateAssist_DHY(String no,String pwd,assistant_evaluate assist);//更新
    void addAssist(String no,String pwd,assistant_evaluate assist);//添加
    void updateAssist(String no,String pwd,assistant_evaluate assist);//更新
    void deleteAssist(String no,String pwd,String ae_no);//删除
    assistant_evaluate getAssist(String no,String pwd,String ae_no);//查询

    public List<assistant_evaluate> findAssist(String no, String pwd);

    assistant_evaluate getAssist_DHY(String no,String pwd);//查询
}
