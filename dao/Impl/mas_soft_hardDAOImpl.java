package kcsj.dao.Impl;

import kcsj.SearchCriteria;
import kcsj.dao.mas_soft_hardDAO;
import kcsj.domain.mas_soft_hard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class mas_soft_hardDAOImpl extends DAOBase implements mas_soft_hardDAO {
    private static final String MAS_SOFT_HARD_INSERT_SQL = "insert into mas_soft_hard(soft_hard_no, " +
            "soft_hard_name, soft_hard_unit, soft_hard_date, soft_hard_con) \n" +
            "values(?, ?, ?, ?, ?)";
    @Override
    public void addmas_soft_hard(mas_soft_hard mas_soft_hard_add, String no, String pwd) {
        Connection con = null;
        try{
            con = getConnection(no, pwd);//建立连接
            PreparedStatement psmt = con.prepareStatement(MAS_SOFT_HARD_INSERT_SQL);//获取SQL模板语句
            //按问号的个数依次填入所需字段信息
            psmt.setString(1,mas_soft_hard_add.getSoft_hard_no());
            psmt.setString(2,mas_soft_hard_add.getSoft_hard_name());
            psmt.setString(3,mas_soft_hard_add.getSoft_hard_unit());
            psmt.setString(4,mas_soft_hard_add.getSoft_hard_date());
            psmt.setInt(5,mas_soft_hard_add.getSoft_hard_con());
            int rs;
            rs=psmt.executeUpdate();
            System.out.println("成功插入"+rs+"行");
            psmt.close();//关闭接口
        }catch(Exception e){//出错提示
            e.printStackTrace();
        }finally {
            try{
                con.close();//关闭连接
            }catch (Exception e){//出错提示
                e.printStackTrace();
            }
        }
    }

    private static final String MAS_SOFT_HARD_UPDATE_SQL = "update mas_soft_hard set soft_hard_first=? where soft_hard_no = ?;";
    private static final String MAS_SOFT_HARD_UPDATE_SQL2 = "update mas_soft_hard set soft_hard_last=? where soft_hard_no = ?;";

    @Override
    public void updatemas_soft_hard(mas_soft_hard mas_soft_hard_update, String no, String pwd,int i) {
        Connection con = null;
        try{
            con = getConnection(no, pwd);//建立连接
            if(i==1)
            {
                PreparedStatement psmt = con.prepareStatement(MAS_SOFT_HARD_UPDATE_SQL);//获取SQL模板语句
                //按问号的个数依次填入所需字段信息
                psmt.setString(1,mas_soft_hard_update.getSoft_hard_first());
                psmt.setString(2,mas_soft_hard_update.getSoft_hard_no());
                psmt.executeUpdate();//执行SQL语句相应功能
                psmt.close();//关闭接口
            }
            else
            {
                PreparedStatement psmt = con.prepareStatement(MAS_SOFT_HARD_UPDATE_SQL2);//获取SQL模板语句
                //按问号的个数依次填入所需字段信息
                psmt.setString(1,mas_soft_hard_update.getSoft_hard_last());
                psmt.setString(2,mas_soft_hard_update.getSoft_hard_no());
                psmt.executeUpdate();//执行SQL语句相应功能
                psmt.close();//关闭接口
            }
        }catch(Exception e){//出错提示
            e.printStackTrace();
        }finally {
            try{
                con.close();//关闭连接
            }catch (Exception e){//出错提示
                e.printStackTrace();
            }
        }
    }

    private static final String MAS_SOFT_HARD_DELETE_SQL = "delete from mas_soft_hard\n" +
            "where mas_soft_hard.soft_hard_no = ?";
    @Override
    public void deletemas_soft_hard(String soft_hard_no, String no, String pwd) {
        Connection con = null;
        try{
            con = getConnection(no, pwd);//建立连接
            PreparedStatement psmt = con.prepareStatement(MAS_SOFT_HARD_DELETE_SQL);//获取SQL模板语句
            //按问号的个数依次填入所需字段信息
            psmt.setString(1,soft_hard_no);
            psmt.executeUpdate();//执行SQL语句相应功能
            psmt.close();//关闭接口
        }catch(Exception e){//出错提示
            e.printStackTrace();
        }finally {
            try{
                con.close();//关闭连接
            }catch (Exception e){//出错提示
                e.printStackTrace();
            }
        }
    }

    private static final String MAS_SOFT_HARD_SELECT_SQL = "select * from mas_soft_hard\n" +
            "where mas_soft_hard.soft_hard_no = ?";
    @Override
    public mas_soft_hard getmas_soft_hard(String soft_hard_no, String no, String pwd) {
        mas_soft_hard mas_soft_hard_select = new mas_soft_hard();
        Connection con = null;
        try {
            con = getConnection(no, pwd);
            PreparedStatement psmt = con.prepareStatement(MAS_SOFT_HARD_SELECT_SQL);
            psmt.setString(1,soft_hard_no);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                mas_soft_hard_select.setSoft_hard_no(rs.getString("soft_hard_no"));
                mas_soft_hard_select.setSoft_hard_name(rs.getString("soft_hard_name"));
                mas_soft_hard_select.setSoft_hard_unit(rs.getString("soft_hard_unit"));
                mas_soft_hard_select.setSoft_hard_date(rs.getString("soft_hard_date"));
                mas_soft_hard_select.setSoft_hard_con(rs.getInt("soft_hard_con"));
                mas_soft_hard_select.setSoft_hard_identity(rs.getBytes("soft_hard_identity"));
                mas_soft_hard_select.setSoft_hard_first(rs.getString("soft_hard_first"));
                mas_soft_hard_select.setSoft_hard_last(rs.getString("soft_hard_last"));
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
        return mas_soft_hard_select;
    }

    @Override
    public List<mas_soft_hard> findmas_soft_hard(SearchCriteria searchCriteria) {
        return null;
    }
}
