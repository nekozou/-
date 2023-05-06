package kcsj.dao.Impl;

import kcsj.SearchCriteria;
import kcsj.dao.Mas_achievementDAO;
import kcsj.domain.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Mas_achievementDAOImpl extends DAOBase implements Mas_achievementDAO {
    private static final String MAS_ACHIEVEMENT_INSERT_SQL = "INSERT INTO mas_achievement(mas_id,mas_type,thesis_no,book_no,standard_no,report_no,patent_no,soft_hard_no) VALUES(?,?,?,?,?,?,?,?)";

    @Override
    public void addMas_achievement(Mas_achievement mas_achievement, String no, String pwd) {
        Connection con = null;
        try{
            con = getConnection(no, pwd);
            PreparedStatement psmt = con.prepareStatement(MAS_ACHIEVEMENT_INSERT_SQL);
            psmt.setString(1, mas_achievement.getMas_id());
            psmt.setString(2, mas_achievement.getMas_type());
            psmt.setString(3, mas_achievement.getThesis_no());
            psmt.setString(4, mas_achievement.getBook_no());
            psmt.setString(5, mas_achievement.getStandard_no());
            psmt.setString(6, mas_achievement.getReport_no());
            psmt.setString(7, mas_achievement.getPatent_no());
            psmt.setString(8, mas_achievement.getSoft_hard_no());
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

    private static final String MAS_ACHIEVEMENT_UPDATE_SQL = "update mas_achievement set mas_id = 'gra003' where mas_id = ?";

    @Override
    public void updateMas_achievement(Mas_achievement mas_achievement, String no, String pwd) {
        Connection con = null;
        try {
            con = getConnection(no, pwd);
            PreparedStatement psmt = con.prepareStatement(MAS_ACHIEVEMENT_UPDATE_SQL);
            psmt.setString(1,mas_achievement.getMas_id());
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

    private static final String MAS_ACHIEVEMENT_DELETE_SQL = "delete from mas_achievement where mas_id = ?;";

    @Override
    public void deleteMas_achievement(String mas_id, String no, String pwd) {
        Connection con = null;
        try {
            con = getConnection(no, pwd);
            PreparedStatement psmt = con.prepareStatement(MAS_ACHIEVEMENT_DELETE_SQL);
            psmt.setString(1,mas_id);
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

    private static final String MAS_ACHIEVEMENT_SELECT_SQL = "SELECT mas_id,mas_type,thesis_no,book_no,standard_no,report_no,patent_no,soft_hard_no FROM mas_achievement WHERE mas_id=?";

    @Override
    public Mas_achievement getMas_achievement(String no, String pwd,String mas_id) {
        Connection con = null;
        Mas_achievement mas = new Mas_achievement();
        try{
            con = getConnection(no, pwd);
            PreparedStatement psmt = con.prepareStatement(MAS_ACHIEVEMENT_SELECT_SQL);
            psmt.setString(1, mas_id);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                mas.setMas_id(rs.getString("mas_id"));
                mas.setMas_type(rs.getString("mas_type"));
                mas.setThesis_no(rs.getString("thesis_no"));
                mas.setBook_no(rs.getString("book_no"));
                mas.setStandard_no(rs.getString("standard_no"));
                mas.setReport_no(rs.getString("report_no"));
                mas.setPatent_no(rs.getString("patent_no"));
                mas.setSoft_hard_no(rs.getString("soft_hard_no"));

                Thesis the = kcsj.DAOFactory.getInstance().getThesisDAO().getThesis(no, pwd, mas.getThesis_no());
                Standard stan = kcsj.DAOFactory.getInstance().getStandardDAO().getStandard(no, pwd, mas.getStandard_no());
                mas_book masb = kcsj.DAOFactory.getInstance().getmas_bookDAO().getmas_book(mas.getBook_no(), no, pwd);
                mas_report masre = kcsj.DAOFactory.getInstance().getmas_reportDAO().getmas_report(mas.getReport_no(), no, pwd);
                mas_patent maspa = kcsj.DAOFactory.getInstance().getmas_patentDAO().getmas_patent(mas.getPatent_no(), no, pwd);
                mas_soft_hard masso = kcsj.DAOFactory.getInstance().getmas_soft_hardDAO().getmas_soft_hard(mas.getSoft_hard_no(), no, pwd);
                System.out.println("成果认定信息：\n" + mas.toString());
                System.out.println("论文认定信息：\n" + the.toString());
                System.out.println("标准认定信息：\n" + stan.toString());
                System.out.println("教材认定信息：\n" + masb.toString());
                System.out.println("报告认定信息：\n" + masre.toString());
                System.out.println("专利认定信息：\n" + maspa.toString());
                System.out.println("软硬件平台开发证明认定信息：\n" + masso.toString());
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
        return mas;
    }

}
