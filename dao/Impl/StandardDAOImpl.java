package kcsj.dao.Impl;

import kcsj.SearchCriteria;
import kcsj.dao.StandardDAO;
import kcsj.domain.Standard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class StandardDAOImpl extends DAOBase implements StandardDAO {
    private static final String STANDARD_INSERT_SQL = "INSERT INTO standard(standard_no,standard_name,standard_rank,standard_date) VALUES(?,?,?,?)";

    @Override
    public void addStandard(String no,String pwd,Standard standard) {
        Connection con = null;
        try{
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(STANDARD_INSERT_SQL);
            psmt.setString(1, standard.getStandard_no());
            psmt.setString(2, standard.getStandard_name());
            psmt.setString(3, standard.getStandard_rank());
            psmt.setString(4, standard.getStandard_date());
            int rs;
            rs=psmt.executeUpdate();
            System.out.println("成功插入"+rs+"行");
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
    }

    private static final String STANDARD_UPDATE_SQL = "update standard set standard_name = '关于深空通信的技术指标' where standard_no = ?";

    @Override
    public void updateStandard(String no,String pwd,Standard standard) {
        Connection con = null;
        try {
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(STANDARD_UPDATE_SQL);
            psmt.setString(1,standard.getStandard_no());
            psmt.executeUpdate();
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
    }

    private static final String STANDARD_DELETE_SQL = "delete from standard where standard_no = ?;";

    @Override
    public void deleteStandard(String no,String pwd,String standard_no) {
        Connection con = null;
        try {
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(STANDARD_DELETE_SQL);
            psmt.setString(1,standard_no);
            psmt.executeUpdate();
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
    }

    private static final String STANDARD_SELECT_SQL = "SELECT standard_no,standard_name,standard_rank,standard_date,standard_identity FROM standard WHERE standard_no=?";

    @Override
    public Standard getStandard(String no,String pwd,String standard_no) {
        Connection con = null;
        Standard standard = new Standard();
        try{
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(STANDARD_SELECT_SQL);
            psmt.setString(1, standard_no);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                standard.setStandard_no(rs.getString("standard_no"));
                standard.setStandard_name(rs.getString("standard_name"));
                standard.setStandard_rank(rs.getString("standard_rank"));
                standard.setStandard_date(rs.getString("standard_date"));
                standard.setStandard_identity(rs.getBytes("standard_identity"));
               // System.out.println(standard.toString());
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
        return standard;
    }

    @Override
    public List<Standard> findStandards(String no,String pwd,SearchCriteria searchCriteria) {
        return null;
    }
}
