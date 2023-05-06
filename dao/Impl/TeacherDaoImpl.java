package kcsj.dao.Impl;
import kcsj.SearchCriteria;
import kcsj.dao.TeacherDAO;
import kcsj.domain.Teacher;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl extends DAOBase implements TeacherDAO {


    private static final String TEACHER_INSERT_SQL = "INSERT INTO teacher_info(tea_id,tea_name,college,dept,title,is_duty,is_tutor,is_lecture,usr,pwd) VALUES(?,?,?,?,?,?,?,?,?,?) ";

    @Override
    public String checkSnoAndPwd(String no, String pwd,String duty,String tutor,String lecture) {
        Connection con = null;
        try {
            con = getConnection(no,pwd);
            String QUERY_PWD_SQL = "select tea_name,is_duty,is_tutor,is_lecture from teacher_info where usr=? and pwd=?";
            PreparedStatement pst = con.prepareStatement(QUERY_PWD_SQL);
            pst.setString(1, no);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            int i;
            if(rs.next()){
                //System.out.println(rs.getString("tea_name")+rs.getString("is_duty")+rs.getString("is_tutor")+rs.getString("is_lecture"));
                if(duty=="1"){
                    i = rs.getInt("is_duty");
                    if(i==1){
                       // System.out.println("name"+rs.getString("tea_name"));
                        return rs.getString("tea_name");
                    }
                    //else System.out.println("name");
                }
                else if(tutor=="1")
                {
                    i = rs.getInt("is_tutor");
                    if(i==1){
                        return rs.getString("tea_name");
                    }
                }
                else if(lecture=="1")
                {
                    i = rs.getInt("is_lecture");
                    if(i==1){
                        return rs.getString("tea_name");
                    }
                }
            }else return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                assert con != null;
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void addTeacher(String no,String pwd,Teacher teacher) {
        Connection con = null;
        PreparedStatement ps = null;
        int rs;
        try {
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(TEACHER_INSERT_SQL);
            psmt.setString(1, teacher.getTea_id());
            psmt.setString(2, teacher.getTea_name());
            psmt.setString(3, teacher.getCollege());
            psmt.setString(4, teacher.getDept());
            psmt.setString(5, teacher.getTitle());
            psmt.setString(6, teacher.getIs_duty());
            psmt.setString(7, teacher.getIs_tutor());
            psmt.setString(8, teacher.getIs_lecture());
            psmt.setString(9, teacher.getUser());
            psmt.setString(10, teacher.getPwd());
            rs = psmt.executeUpdate();
            System.out.println("成功添加了" + rs + "行数据!");
            psmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    private static final String TEACHER_UPDATE_SQL = "UPDATE teacher_info SET VALUES(?,?,?,?,?,?,?,?,?,?) WHERE tea_id = ?";

    @Override
    public void updateTeacher(String no,String pwd,Teacher teacher) {
        Connection con = null;
        int rs;
        try {
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(TEACHER_INSERT_SQL);//获取sql语句
            //按问号的个数依次填入所需字段信息
            psmt.setString(1, teacher.getTea_id());
            psmt.setString(2, teacher.getTea_name());
            psmt.setString(3, teacher.getCollege());
            psmt.setString(4, teacher.getDept());
            psmt.setString(5, teacher.getTitle());
            psmt.setString(6, teacher.getIs_duty());
            psmt.setString(7, teacher.getIs_tutor());
            psmt.setString(8, teacher.getIs_lecture());
            psmt.setString(9, teacher.getUser());
            psmt.setString(9, teacher.getPwd());
            psmt.setString(10, teacher.getTea_id());
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

    private static final String TEACHER_DELETE_SQL = "DELETE FROM teacher_info WHERE tea_id= ?";

    @Override
    public void deleteTeacher(String no,String pwd,String tea_id) {
        Connection con = null;
        int rs;
        try {
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(TEACHER_DELETE_SQL);
            psmt.setString(1, tea_id);
            rs = psmt.executeUpdate();
            System.out.println("成功删除了" + rs + "行数据!");
            psmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
        private static final String TEACHER_SELECT_SQL = "SELECT tea_id,tea_name,college,dept,title,is_duty,is_tutor,is_lecture,usr,pwd FROM teacher_info WHERE usr=?";
        @Override
        public Teacher getTeacher(String no,String pwd,String usr) {
            Connection con = null;
            Teacher teacher = new Teacher();
            try{
                con =getConnection(no,pwd);
                PreparedStatement psmt = con.prepareStatement(TEACHER_SELECT_SQL);
                psmt.setString(1, usr);
                ResultSet rs = psmt.executeQuery();
                while (rs.next()){
                    teacher.setTea_id(rs.getString("tea_id"));
                    teacher.setTea_name(rs.getString("tea_name"));
                    teacher.setCollege(rs.getString("college"));
                    teacher.setDept(rs.getString("dept"));
                    teacher.setTitle(rs.getString("title"));
                    teacher.setIs_duty(rs.getString("is_duty"));
                    teacher.setIs_tutor(rs.getString("is_tutor"));
                    teacher.setIs_lecture(rs.getString("is_lecture"));
                    teacher.setUser(rs.getString("usr"));
                    teacher.setPwd(rs.getString("pwd"));
                }
                psmt.close();
                //System.out.println(teacher.toString());
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                try{
                    con.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return teacher;
        }

    @Override
    public List<Teacher> findTeacher(String no,String pwd,SearchCriteria searchCriteria) {
        Connection con = null;
        List<Teacher> list = new ArrayList<>();
        try{
            con =getConnection(no,pwd);
            //用字符串拼接
            String COURSE_SELECT_SQL_pre = null;     //定义查询语句
            COURSE_SELECT_SQL_pre = "SELECT tea_id,tea_name,college,dept,title FROM teacher_info WHERE ";
            String  STUDENT_SELECT_SQL = COURSE_SELECT_SQL_pre + searchCriteria.getKey()+searchCriteria.getOperation()+searchCriteria.getValue()+";";
            PreparedStatement psmt = con.prepareStatement(STUDENT_SELECT_SQL);
            //System.out.println("查询语句："+STUDENT_SELECT_SQL);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){  //遍历查询结果并加入数组
                Teacher tea = new Teacher();        //这里必须每次都初始化，否则数组的元素将是同一个
                tea.setTea_id(rs.getString("tea_id"));
                tea.setTea_name(rs.getString("tea_name"));
                tea.setCollege(rs.getString("college"));
                tea.setDept(rs.getString("dept"));
                tea.setTitle(rs.getString("title"));
                list.add(tea);
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
        return list;
    }
}
