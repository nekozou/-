package kcsj.dao.Impl;
import kcsj.dao.CourseDAO;
import kcsj.domain.Course;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CourseDaoImpl extends DAOBase implements CourseDAO {
    private static final String COURSE_INSERT_SQL = "INSERT INTO course_info(crs_no,crs_name,crs_num,crs_time,crs_score) VALUES(?,?,?,?,?) ";
    @Override
    public void addCourse(String no,String pwd,Course course) {
        Connection con = null;
        PreparedStatement ps = null;
        int rs;
        try{
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(COURSE_INSERT_SQL);
            psmt.setString(1, course.getCrs_no());
            psmt.setString(2, course.getCrs_name());
            psmt.setInt(3, course.getCrs_num());
            psmt.setInt(4, course.getCrs_time());
            psmt.setDouble(5, course.getCrs_score());
            rs=psmt.executeUpdate();
            System.out.println("成功添加了"+rs+"行数据!");
            psmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }

    private static final String COURSE_UPDATE_SQL = "UPDATE course_info SET VALUES(?,?,?,?,?) WHERE crs_no = ?";
    @Override
    public void updateCourse(String no,String pwd,Course course) {
        Connection con = null;
        int rs;
        try {
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(COURSE_INSERT_SQL);//获取sql语句
            //按问号的个数依次填入所需字段信息
            psmt.setString(1, course.getCrs_no());
            psmt.setString(2, course.getCrs_name());
            psmt.setInt(3, course.getCrs_num());
            psmt.setInt(4, course.getCrs_time());
            psmt.setDouble(5, course.getCrs_score());
            rs = psmt.executeUpdate();//执行SQL语句的操作
            System.out.println("成功更新了" + rs + "行数据!");
            psmt.close();//关闭接口
        } catch (Exception e) {//出错提示
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {//出错提示
                e.printStackTrace();
            }
        }
    }

    private static final String COURSE_UPDATE_SQL_DHY = "UPDATE course_info SET crs_num=?,crs_time=?,crs_score=?,crs_pri=?,gra_id=? WHERE crs_no=?";
    @Override
    public void updateCourse_DHY(String no,String pwd,Course course) {
        Connection con = null;
        int rs;
        try {
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(COURSE_UPDATE_SQL_DHY);//获取sql语句
            //按问号的个数依次填入所需字段信息
            psmt.setInt(1, course.getCrs_num());
            psmt.setInt(2, course.getCrs_time());
            psmt.setDouble(3, course.getCrs_score());
            psmt.setDouble(4, course.getCrs_pri());
            psmt.setString(5, course.getGra_id());
            psmt.setString(6, course.getCrs_no());
            rs = psmt.executeUpdate();//执行SQL语句的操作
            System.out.println("成功更新了" + rs + "行数据!");
            psmt.close();//关闭接口
        } catch (Exception e) {//出错提示
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {//出错提示
                e.printStackTrace();
            }
        }
    }

    private static final String COURSE_DELETE_SQL = "DELETE FROM course_info WHERE crs_no= ?";
    @Override
    public void deleteCourse(String no,String pwd,String crs_no) {
        Connection con = null;
        int rs;
        try{
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(COURSE_DELETE_SQL);
            psmt.setString(1,crs_no);
            rs = psmt.executeUpdate();
            System.out.println("成功删除了"+rs+"行数据!");
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static final String COURSE_SELECT_SQL = "SELECT crs_no,crs_name,crs_num,crs_time,crs_score FROM course_info WHERE crs_no=?";
    @Override
    public Course getCourse(String no,String pwd,String crs_no) {
        Connection con = null;
        Course course = new Course();
        try{
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(COURSE_SELECT_SQL);
            psmt.setString(1, crs_no);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                course.setCrs_no(rs.getString("crs_no"));
                course.setCrs_name(rs.getString("crs_name"));
                course.setCrs_num(rs.getInt("crs_num"));
                course.setCrs_time(rs.getInt("crs_time"));
                course.setCrs_score(rs.getDouble("crs_score"));
            }
            psmt.close();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return course;
    }
}
