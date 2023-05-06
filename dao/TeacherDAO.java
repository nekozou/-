package kcsj.dao;
import kcsj.SearchCriteria;
import kcsj.domain.Teacher;

import java.util.List;

public interface TeacherDAO {
    public String checkSnoAndPwd(String no, String pwd,String duty,String tutor,String lecture);
    void addTeacher(String no,String pwd,Teacher teacher);//添加
    void deleteTeacher(String no,String pwd,String tea_id);//删除
    void updateTeacher(String no,String pwd,Teacher teacher);//更新
    Teacher getTeacher(String no,String pwd,String usr);//查询

    public List<Teacher> findTeacher(String no,String pwd,SearchCriteria searchCriteria);
}
