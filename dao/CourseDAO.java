package kcsj.dao;
import kcsj.domain.Course;

public interface CourseDAO {
    void addCourse(String no,String pwd,Course course);//添加
    void deleteCourse(String no,String pwd,String crs_no);//删除
    void updateCourse(String no,String pwd,Course course);//更新
    void updateCourse_DHY(String no,String pwd,Course course);//更新
    Course getCourse(String no,String pwd,String crs_no);//查询
}
