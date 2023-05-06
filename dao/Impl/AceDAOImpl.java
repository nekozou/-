package kcsj.dao.Impl;
import kcsj.SearchCriteria;
import kcsj.dao.AceDAO;
import kcsj.domain.Academic_exchange;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class AceDAOImpl extends DAOBase implements AceDAO {
    private static final String ACE_INSERT_SQL = "insert into academic_exchange(ace_no,gra_id,ace_name,ace_place,ace_date,ace_CHname,ace_ENname,ace_pic,ace_note) values(?,?,?,?,?,?,?,?,?);";
    @Override
    public void addAce(String no,String pwd,Academic_exchange ace) {
        Connection con = null;
        PreparedStatement ps = null;
        int rs;
        try
        {
            con = getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(ACE_INSERT_SQL);
            psmt.setString(1,ace.getAce_no());
            psmt.setString(2,ace.getGra_id());
            psmt.setString(3,ace.getAce_name());
            psmt.setString(4,ace.getAce_place());
            psmt.setString(5,ace.getAce_date());
            psmt.setString(6,ace.getAce_CHname());
            psmt.setString(7,ace.getAce_ENname());
            psmt.setBytes(8,ace.getAce_pic());
            psmt.setString(9,ace.getAce_note());
            rs = psmt.executeUpdate();           //执行sql语句
            System.out.println("成功添加了"+rs+"行数据!");
            psmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally
        {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private static final String ACE_UPDATE_SQL = "UPDATE academic_exchange SET ace_effective=? WHERE ace_no = ?";
    @Override
    public void updateAce(String no,String pwd,Academic_exchange ace) {
        Connection con = null;
        int rs;
        try{
            con = getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(ACE_UPDATE_SQL);
            psmt.setString(1,ace.getAce_effective());
            psmt.setString(2,ace.getAce_no());
            rs = psmt.executeUpdate();      //执行SQL语句
            System.out.println("成功更新了"+rs+"行数据!");
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
    private static final String ACE_DELETE_SQL = "DELETE FROM academic_exchange WHERE ace_no= ?";
    @Override
    public void deleteAce(String no,String pwd,String ace_no) {
        Connection con = null;
        int rs;
        try{
            con = getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(ACE_DELETE_SQL);
            psmt.setString(1,ace_no);
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
    private static final String ACE_SELECT_SQL = "SELECT ace_no,gra_id,ace_name,ace_place,ace_date,ace_CHname,ace_ENname,ace_pic,ace_note FROM academic_exchange WHERE ace_no=?";
    @Override
    public Academic_exchange getAce(String no,String pwd,String ace_no) {
        Connection con = null;
        Academic_exchange ace = new Academic_exchange();
        try{
            con = getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(ACE_SELECT_SQL);
            psmt.setString(1, ace_no);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                ace.setAce_no(rs.getString("ace_no"));
                ace.setGra_id(rs.getString("gra_id"));
                ace.setAce_name(rs.getString("ace_name"));
                ace.setAce_place(rs.getString("ace_place"));
                ace.setAce_date((rs.getString("ace_date")));
                ace.setAce_CHname(rs.getString("ace_CHname"));
                ace.setAce_ENname(rs.getString("ace_ENname"));
                ace.setAce_pic(rs.getBytes("ace_pic"));
                ace.setAce_note(rs.getString("ace_note"));
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
        return ace;
    }

    @Override
    public List<Academic_exchange> findAce(String no, String pwd, SearchCriteria searchCriteria)
    {
        Connection con = null;
        List<Academic_exchange> list = new ArrayList<>();
        try{
            con =getConnection(no,pwd);
            //用字符串拼接
            String COURSE_SELECT_SQL_pre = null;     //定义查询语句
            COURSE_SELECT_SQL_pre = "SELECT ace_no,gra_id,ace_name,ace_place,ace_date,ace_CHname,ace_ENname,ace_pic,ace_note FROM academic_exchange WHERE ";
            String  STUDENT_SELECT_SQL = COURSE_SELECT_SQL_pre + searchCriteria.getKey()+searchCriteria.getOperation()+searchCriteria.getValue()+";";
            PreparedStatement psmt = con.prepareStatement(STUDENT_SELECT_SQL);
            //System.out.println("查询语句："+STUDENT_SELECT_SQL);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){  //遍历查询结果并加入数组
                Academic_exchange ace = new Academic_exchange();        //这里必须每次都初始化，否则数组的元素将是同一个
                ace.setAce_no(rs.getString("ace_no"));
                ace.setGra_id(rs.getString("gra_id"));
                ace.setAce_name(rs.getString("ace_name"));
                ace.setAce_place(rs.getString("ace_place"));
                ace.setAce_date(rs.getString("ace_date"));
                ace.setAce_CHname(rs.getString("ace_CHname"));
                ace.setAce_ENname(rs.getString("ace_ENname"));
                ace.setAce_pic(rs.getBytes("ace_pic"));
                ace.setAce_note(rs.getString("ace_note"));
                list.add(ace);
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