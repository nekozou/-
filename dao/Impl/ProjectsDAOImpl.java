//ParticipationProjectsImpl
package kcsj.dao.Impl;

import kcsj.SearchCriteria;
import kcsj.dao.ProjectsDAO;
import kcsj.domain.Projects;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectsDAOImpl extends DAOBase implements ProjectsDAO
{
    private static final String PROJECTS_INSERT_SQL = "INSERT INTO participation_projects(pp_no,tea_id,gra_id,proj_id,proj_class,proj_name,proj_begin,proj_end,duty_work,proj_outlay) VALUES(?,?,?,?,?,?,?,?,?,?) ";
    @Override
    public void addProjects(String no,String pwd,Projects projects) {
        Connection con = null;
        int rs;
        try{
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(PROJECTS_INSERT_SQL);
            psmt.setString(1, projects.getPp_no());
            psmt.setString(2,projects.getTea_id());
            psmt.setString(3, projects.getGra_id());
            psmt.setString(4, projects.getProj_id());
            psmt.setString(5, projects.getProj_class());
            psmt.setString(6, projects.getProj_name());
            psmt.setString(7, projects.getProj_begin());
            psmt.setString(8, projects.getProj_end());
            psmt.setString(9, projects.getDuty_work());
            psmt.setString(10, projects.getProj_outlay());
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

    private static final String PROJECTS_UPDATE_SQL = "UPDATE participation_projects SET proj_outlay=? WHERE pp_no = ?";
    @Override
    public void updateProjects(String no,String pwd,Projects projects){
        Connection con = null;
        int rs;
        try {
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(PROJECTS_UPDATE_SQL);//获取sql语句
            psmt.setString(1, projects.getProj_outlay());
            psmt.setString(2,projects.getPp_no());
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
        private static final String PROJECTS_DELETE_SQL = "DELETE FROM participation_projects WHERE pp_no= ?";
        @Override
        public void deleteProjects(String no,String pwd,String pp_no){
            Connection con = null;
            int rs;
            try {
                con =getConnection(no,pwd);
                PreparedStatement psmt = con.prepareStatement(PROJECTS_DELETE_SQL);
                psmt.setString(1, pp_no);
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

        private static final String PROJECTS_SELECT_SQL = "SELECT pp_no,tea_id,gra_id,proj_id,proj_class,proj_name,proj_begin,proj_end,duty_work,proj_outlay FROM participation_projects WHERE pp_no=?";
        @Override
        public Projects getProjects(String no,String pwd,String pp_no) {
            Connection con = null;
            Projects projects = new Projects();
            try{
                con =getConnection(no,pwd);
                PreparedStatement psmt = con.prepareStatement(PROJECTS_SELECT_SQL);
                psmt.setString(1, pp_no);
                ResultSet rs = psmt.executeQuery();
                while (rs.next()){
                    projects.setPp_no(rs.getString("pp_no"));
                    projects.setGra_id(rs.getString("tea_id"));
                    projects.setGra_id(rs.getString("gra_id"));
                    projects.setProj_id(rs.getString("proj_id"));
                    projects.setProj_class(rs.getString("proj_class"));
                    projects.setProj_name(rs.getString("proj_name"));
                    projects.setProj_begin(rs.getString("proj_begin"));
                    projects.setProj_end(rs.getString("proj_end"));
                    projects.setDuty_work(rs.getString("duty_work"));
                    projects.setProj_outlay(rs.getString("proj_outlay"));
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
            return projects;
        }
    @Override
    public List<Projects> findProjects(String no, String pwd, SearchCriteria searchCriteria)
    {
        Connection con = null;
        List<Projects> list = new ArrayList<>();
        try{
            con =getConnection(no,pwd);
            //用字符串拼接
            String COURSE_SELECT_SQL_pre = null;     //定义查询语句
            COURSE_SELECT_SQL_pre = "SELECT pp_no,tea_id,gra_id,proj_id,proj_class,proj_name,proj_begin,proj_end,duty_work,proj_outlay FROM participation_projects WHERE ";
            String  STUDENT_SELECT_SQL = COURSE_SELECT_SQL_pre + searchCriteria.getKey()+searchCriteria.getOperation()+searchCriteria.getValue()+";";
            PreparedStatement psmt = con.prepareStatement(STUDENT_SELECT_SQL);
            //System.out.println("查询语句："+STUDENT_SELECT_SQL);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){  //遍历查询结果并加入数组
                Projects projects = new Projects();        //这里必须每次都初始化，否则数组的元素将是同一个
                projects.setPp_no(rs.getString("pp_no"));
                projects.setTea_id(rs.getString("tea_id"));
                projects.setGra_id(rs.getString("gra_id"));
                projects.setProj_id(rs.getString("proj_id"));
                projects.setProj_class(rs.getString("proj_class"));
                projects.setProj_name(rs.getString("proj_name"));
                projects.setProj_begin(rs.getString("proj_begin"));
                projects.setProj_end(rs.getString("proj_end"));
                projects.setDuty_work(rs.getString("duty_work"));
                projects.setProj_outlay(rs.getString("proj_outlay"));
                list.add(projects);
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
