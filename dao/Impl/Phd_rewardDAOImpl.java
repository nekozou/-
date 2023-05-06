package kcsj.dao.Impl;

import kcsj.SearchCriteria;
import kcsj.dao.Phd_rewardDAO;
import kcsj.domain.Phd_reward;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Phd_rewardDAOImpl extends DAOBase implements Phd_rewardDAO {
    private static final String PHD_REWARD_INSERT_SQL = "INSERT INTO phd_reward(reward_no,reward_name,reward_rank,reward_score,reward_order,reward_date) VALUES(?,?,?,?,?,?)";

    @Override
    public void addPhd_reward(Phd_reward phd_reward, String no, String pwd) {
        Connection con = null;
        try{
            con = getConnection(no, pwd);
            PreparedStatement psmt = con.prepareStatement(PHD_REWARD_INSERT_SQL);
            psmt.setString(1, phd_reward.getReward_no());
            psmt.setString(2, phd_reward.getReward_name());
            psmt.setString(3, phd_reward.getReward_rank());
            psmt.setString(4, phd_reward.getReward_score());
            psmt.setString(5, phd_reward.getReward_order());
            psmt.setString(6, phd_reward.getReward_date());
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

    private static final String PHD_REWARD_UPDATE_SQL = "update phd_reward set reward_name = '北京市级十佳创新奖' where reward_no = ?";

    @Override
    public void updatePhd_reward(Phd_reward phd_reward, String no, String pwd) {
        Connection con = null;
        try {
            con = getConnection(no, pwd);
            PreparedStatement psmt = con.prepareStatement(PHD_REWARD_UPDATE_SQL);
            psmt.setString(1,phd_reward.getReward_no());
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

    private static final String PHD_REWARD_DELETE_SQL = "delete from phd_reward where reward_no = ?;";

    @Override
    public void deletePhd_reward(String reward_no, String no, String pwd) {
        Connection con = null;
        try {
            con = getConnection(no, pwd);
            PreparedStatement psmt = con.prepareStatement(PHD_REWARD_DELETE_SQL);
            psmt.setString(1,reward_no);
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

    private static final String PHD_ACHIEVEMENT_SELECT_SQL = "SELECT reward_no,reward_name,reward_rank,reward_score,reward_order,reward_date,reward_identity FROM phd_reward WHERE reward_no=?";

    @Override
    public Phd_reward getPhd_reward(String reward_no, String no, String pwd) {
        Connection con = null;
        Phd_reward phd_reward = new Phd_reward();
        try{
            con = getConnection(no, pwd);
            PreparedStatement psmt = con.prepareStatement(PHD_ACHIEVEMENT_SELECT_SQL);
            psmt.setString(1, reward_no);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                phd_reward.setReward_no(rs.getString("reward_no"));
                phd_reward.setReward_name(rs.getString("reward_name"));
                phd_reward.setReward_rank(rs.getString("reward_rank"));
                phd_reward.setReward_score(rs.getString("reward_score"));
                phd_reward.setReward_order(rs.getString("reward_order"));
                phd_reward.setReward_date(rs.getString("reward_date"));
                phd_reward.setReward_identity(rs.getBytes("reward_identity"));
               // System.out.println(phd_reward.toString());
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
        return phd_reward;
    }

    @Override
    public List<Phd_reward> findPhd_rewards(SearchCriteria searchCriteria) {
        return null;
    }
}
