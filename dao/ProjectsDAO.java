//ProjectsDAO
//package src;
package kcsj.dao;

import kcsj.SearchCriteria;
import kcsj.domain.Projects;

import java.util.List;

public interface ProjectsDAO {
    void addProjects(String no,String pwd,Projects projects);//添加
    void deleteProjects(String no,String pwd,String pp_no);//删除
    void updateProjects(String no,String pwd,Projects projects);//更新
    Projects getProjects(String no,String pwd,String pp_no);//查询
    List<Projects> findProjects(String no, String pwd, SearchCriteria searchCriteria);
}
