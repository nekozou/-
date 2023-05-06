package kcsj.dao.Impl;

import kcsj.dao.GraDAO;
import kcsj.domain.Gra_info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GraDAOImpl extends DAOBase implements GraDAO {

    public String checkSnoAndPwd(String no,String pwd,String type) {//YGT
        Connection con = null;
        try {
            con =getConnection(no,pwd);
            String QUERY_PWD_SQL = "select gra_name,gra_type from graduate_info where usr=? and pwd=?";
            PreparedStatement pst = con.prepareStatement(QUERY_PWD_SQL);
            pst.setString(1, no);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            int i;
            if(rs.next()){
                if(type == "1"){
                    i = rs.getInt("gra_type");
                    if(i==1){
                        return rs.getString("gra_name");
                    }
                    else
                        System.out.println("您选择的角色与用户信息不匹配");
                }
                else if(type == "2"){
                    i = rs.getInt("gra_type");
                    if(i==2){
                        return rs.getString("gra_name");
                    }
                    else
                        System.out.println("您选择的角色与用户信息不匹配");
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
    private static final String GRA_INSERT_SQL = "insert into graduate_info(gra_id,gra_type,gra_name,gra_coll,dept,tea_id,usr,pwd) values(?,?,?,?,?,?,?,?);";

    @Override
    public void addGra(String no,String pwd,Gra_info gra_info) {
        Connection con = null;
        PreparedStatement ps = null;
        int rs;
        try
        {
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(GRA_INSERT_SQL);
            psmt.setString(1,gra_info.getGra_id());
            psmt.setString(2,gra_info.getGra_type());
            psmt.setString(3,gra_info.getGra_name());
            psmt.setString(4,gra_info.getGra_coll());
            psmt.setString(5,gra_info.getDept());
            psmt.setString(6,gra_info.getTea_id());
            psmt.setString(7,gra_info.getUsr());
            psmt.setString(8,gra_info.getPwd());
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

    private static final String GRA_UPDATE_SQL = "UPDATE graduate_info SET gra_id=?,gra_type=?,gra_name=?,gra_coll=?,dept=?,tea_id=?,usr=?,pwd=? where gra_id=?";
    @Override
    public void updateGra(String no,String pwd,Gra_info gra_info) {
        Connection con = null;
        int rs;
        try{
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(GRA_UPDATE_SQL);
            psmt.setString(1,gra_info.getGra_id());
            psmt.setString(2,gra_info.getGra_type());
            psmt.setString(3,gra_info.getGra_name());
            psmt.setString(4,gra_info.getGra_coll());
            psmt.setString(5,gra_info.getDept());
            psmt.setString(6,gra_info.getTea_id());
            psmt.setString(7,gra_info.getUsr());
            psmt.setString(8,gra_info.getPwd());
            psmt.setString(9,gra_info.getGra_id());
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

    private static final String GRA_DELETE_SQL = "DELETE FROM graduate_info WHERE gra_id= ?";
    @Override
    public void deleteGra(String no,String pwd,String gra_no) {
        Connection con = null;
        int rs;
        try{
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(GRA_DELETE_SQL);
            psmt.setString(1,gra_no);
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
    private static final String GRA_SELECT_SQL = "SELECT gra_id,gra_type,gra_name,gra_coll,dept,tea_id,usr,pwd FROM graduate_info WHERE gra_id=?";
    @Override
    public Gra_info getGra(String no,String pwd,String gra_id) {
        Connection con = null;
        Gra_info gra_info = new Gra_info();
        try{
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(GRA_SELECT_SQL);
            psmt.setString(1, gra_id);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                gra_info.setGra_id(rs.getString("gra_id"));
                gra_info.setGra_type(rs.getString("gra_type"));
                gra_info.setGra_name(rs.getString("gra_name"));
                gra_info.setGra_coll(rs.getString("gra_coll"));
                gra_info.setDept(rs.getString("dept"));
                gra_info.setTea_id(rs.getString("tea_id"));
                gra_info.setUsr(rs.getString("usr"));
                gra_info.setPwd(rs.getString("pwd"));
            }
            gra_info.toString();
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
        return gra_info;
    }
}
