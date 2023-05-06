package kcsj.dao.Impl;

import kcsj.SearchCriteria;
import kcsj.dao.ThesisDAO;
import kcsj.domain.Thesis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ThesisDAOImpl extends DAOBase implements ThesisDAO {
    private static final String THESIS_INSERT_SQL = "INSERT INTO thesis(thesis_no, thesis_name, thesis_pub, thesis_state, thesis_date, thesis_index, thesis_bel, thesis_scan) VALUES(?,?,?,?,?,?,?,?)";

    @Override
    public void addThesis(String no,String pwd,Thesis thesis) {
        Connection con = null;
        int rs;
        try{
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(THESIS_INSERT_SQL);
            psmt.setString(1, thesis.getThesis_no());
            psmt.setString(2, thesis.getThesis_name());
            psmt.setString(3, thesis.getThesis_pub());
            psmt.setString(4, thesis.getThesis_state());
            psmt.setString(5, thesis.getThesis_date());
            psmt.setString(6, thesis.getThesis_index());
            psmt.setString(7, thesis.getThesis_bel());
            psmt.setBytes(8, thesis.getThesis_scan());
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

    private static final String THESIS_UPDATE_SQL = "update thesis set thesis_first=? where thesis_no = ?";
    private static final String THESIS_UPDATE_SQL2 = "update thesis set thesis_last=? where thesis_no = ?";

    @Override
    public void updateThesis(String no,String pwd,Thesis thesis,int i) {
        Connection con = null;
        try {
            con =getConnection(no,pwd);
            if(i==1)
            {
                PreparedStatement psmt = con.prepareStatement(THESIS_UPDATE_SQL);
                psmt.setString(1,thesis.getThesis_first());
                psmt.setString(2,thesis.getThesis_no());
                psmt.executeUpdate();
                psmt.close();
            }
            else
            {
                PreparedStatement psmt = con.prepareStatement(THESIS_UPDATE_SQL2);
                psmt.setString(1,thesis.getThesis_last());
                psmt.setString(2,thesis.getThesis_no());
                psmt.executeUpdate();
                psmt.close();
            }
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

    private static final String THESIS_DELETE_SQL = "delete from thesis where thesis_no = ?;";

    @Override
    public void deleteThesis(String no,String pwd,String thesis_no) {
        Connection con = null;
        try {
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(THESIS_DELETE_SQL);
            psmt.setString(1,thesis_no);
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

    private static final String THESIS_SELECT_SQL = "SELECT thesis_no, thesis_name, thesis_pub, thesis_state, thesis_date, thesis_index, thesis_bel, thesis_scan, thesis_pdf,thesis_first,thesis_last FROM thesis WHERE thesis_no=?";

    @Override
    public Thesis getThesis(String no,String pwd,String thesis_no) {
        Connection con = null;
        Thesis thesis = new Thesis();
        try{
            con =getConnection(no,pwd);
            PreparedStatement psmt = con.prepareStatement(THESIS_SELECT_SQL);
            psmt.setString(1, thesis_no);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                thesis.setThesis_no(rs.getString("thesis_no"));
                thesis.setThesis_name(rs.getString("thesis_name"));
                thesis.setThesis_pub(rs.getString("thesis_pub"));
                thesis.setThesis_state(rs.getString("thesis_state"));
                thesis.setThesis_date(rs.getString("thesis_date"));
                thesis.setThesis_index(rs.getString("thesis_index"));
                thesis.setThesis_bel(rs.getString("thesis_bel"));
                thesis.setThesis_scan(rs.getBytes("thesis_scan"));
                thesis.setThesis_pdf(rs.getBytes("thesis_pdf"));
                thesis.setThesis_first(rs.getString("thesis_first"));
                thesis.setThesis_last(rs.getString("thesis_last"));
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
        return thesis;
    }

    @Override
    public List<Thesis> findThesis(String no,String pwd,SearchCriteria searchCriteria) {
        return null;
    }
}
