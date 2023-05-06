package kcsj.dao.Impl;

import kcsj.SearchCriteria;
import kcsj.dao.phd_achievementDAO;
import kcsj.domain.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class phd_achievementDAOImpl extends DAOBase implements phd_achievementDAO {
    private static final String PHD_ACHIEVEMENT_INSERT_SQL = "INSERT INTO phd_achievement(phd_id,phd_type,thesis_no,reward_no,standard_no,other_no) VALUES(?,?,?,?,?,?)";

    @Override
    public void addPhd_achievement(phd_achievement phd_achievement, String no, String pwd) {
        Connection con = null;
        try{
            con = getConnection(no, pwd);
            PreparedStatement psmt = con.prepareStatement(PHD_ACHIEVEMENT_INSERT_SQL);
            psmt.setString(1, phd_achievement.getPhd_id());
            psmt.setString(2, phd_achievement.getPhd_type());
            psmt.setString(3, phd_achievement.getThesis_no());
            psmt.setString(4, phd_achievement.getReward_no());
            psmt.setString(5, phd_achievement.getStandard_no());
            psmt.setString(6, phd_achievement.getOther_no());
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

    private static final String PHD_ACHIEVEMENT_UPDATE_SQL = "update phd_achievement set phd_id = 'gra003' where phd_id = ?";

    @Override
    public void updatePhd_achievement(phd_achievement phd_achievement, String no, String pwd) {
        Connection con = null;
        try {
            con = getConnection(no, pwd);
            PreparedStatement psmt = con.prepareStatement(PHD_ACHIEVEMENT_UPDATE_SQL);
            psmt.setString(1,phd_achievement.getPhd_id());
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

    private static final String PHD_ACHIEVEMENT_DELETE_SQL = "delete from phd_achievement where phd_id = ?;";

    @Override
    public void deletePhd_achievement(String phd_id, String no, String pwd) {
        Connection con = null;
        try {
            con = getConnection(no, pwd);
            PreparedStatement psmt = con.prepareStatement(PHD_ACHIEVEMENT_DELETE_SQL);
            psmt.setString(1,phd_id);
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

    private static final String PHD_ACHIEVEMENT_SELECT_SQL = "SELECT phd_id,phd_type,thesis_no,reward_no,standard_no,other_no FROM phd_achievement WHERE phd_id=?";

    @Override
    public phd_achievement getPhd_achievement(String no, String pwd,String phd_id) {
        Connection con = null;
        phd_achievement phd = new phd_achievement();
        try{
            con = getConnection(no, pwd);
            PreparedStatement psmt = con.prepareStatement(PHD_ACHIEVEMENT_SELECT_SQL);
            psmt.setString(1, phd_id);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                phd.setPhd_id(rs.getString("phd_id"));
                phd.setPhd_type(rs.getString("phd_type"));
                phd.setThesis_no(rs.getString("thesis_no"));
                phd.setReward_no(rs.getString("reward_no"));
                phd.setStandard_no(rs.getString("standard_no"));
                phd.setOther_no(rs.getString("other_no"));
                Thesis the = kcsj.DAOFactory.getInstance().getThesisDAO().getThesis(no, pwd, phd.getThesis_no());
                Standard stan = kcsj.DAOFactory.getInstance().getStandardDAO().getStandard(no, pwd, phd.getStandard_no());
                Phd_reward phdr=kcsj.DAOFactory.getInstance().getPhd_rewardDAO().getPhd_reward(phd.getReward_no(),no,pwd);
                phd_other phdo = kcsj.DAOFactory.getInstance().getphd_otherDAO().getphd_other(phd.getOther_no(),no,pwd);
                System.out.println("成果认定信息：\n" + phd.toString());
                System.out.println("论文认定信息：\n" + the.toString());
                System.out.println("标准认定信息：\n" + stan.toString());
                System.out.println("奖励认定信息：\n" + phdr.toString());
                System.out.println("其他认定信息：\n" + phdo.toString());
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
        return phd;
    }
}
