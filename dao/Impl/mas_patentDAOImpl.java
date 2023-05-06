package kcsj.dao.Impl;

//加载类
import kcsj.SearchCriteria;
import kcsj.dao.mas_patentDAO;
import kcsj.domain.mas_patent;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class mas_patentDAOImpl extends DAOBase implements mas_patentDAO {

    private static final String MAS_PATENT_INSERT_SQL = "insert into mas_patent(patent_no, patent_name, patent_type, \n" +
            "patent_state, patent_time, patent_con)\n" +
            "values(?, ?, ?, ?, ?, ?);";

    @Override
    public void addmas_patent(mas_patent mas_patent_add, String no, String pwd) {
        Connection con = null;
        try{
            con = getConnection(no, pwd);//建立连接
            PreparedStatement psmt = con.prepareStatement(MAS_PATENT_INSERT_SQL);//获取SQL模板语句
            //按问号的个数依次填入所需字段信息
            psmt.setString(1,mas_patent_add.getPatent_no());
            psmt.setString(2,mas_patent_add.getPatent_name());
            psmt.setString(3,mas_patent_add.getPatent_type());
            psmt.setInt(4,mas_patent_add.getPatent_state());
            psmt.setString(5,mas_patent_add.getPatent_time());
            psmt.setInt(6,mas_patent_add.getPatent_con());
            //psmt.setBytes(7,mas_patent_add.getPatent_identity());
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

    private static final String MAS_PATENT_UPDATE_SQL = "update mas_patent set patent_first=? where patent_no = ?;";
    private static final String MAS_PATENT_UPDATE_SQL2 = "update mas_patent set patent_last=? where patent_no = ?;";

    @Override
    public void updatemas_patent(mas_patent mas_patent_update, String no, String pwd,int i) {
        Connection con = null;
        PreparedStatement psmt;
        try{
            con = getConnection(no, pwd);//建立连接
            if(i==1)
            {
                psmt = con.prepareStatement(MAS_PATENT_UPDATE_SQL);//获取SQL模板语句
                psmt.setString(1,mas_patent_update.getPatent_first());
                psmt.setString(2,mas_patent_update.getPatent_no());
                psmt.executeUpdate();//执行SQL语句相应功能
                psmt.close();//关闭接口
            }
            else
            {
                psmt = con.prepareStatement(MAS_PATENT_UPDATE_SQL2);//获取SQL模板语句
                psmt.setString(1,mas_patent_update.getPatent_last());
                psmt.setString(2,mas_patent_update.getPatent_no());
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

    private static final String MAS_PATENT_DELETE_SQL = "delete from mas_patent\n" +
            "where mas_patent.patent_no = ?";
    @Override
    public void deletemas_patent(String patent_no, String no, String pwd) {
        Connection con = null;
        try{
            con = getConnection(no, pwd);//建立连接
            PreparedStatement psmt = con.prepareStatement(MAS_PATENT_DELETE_SQL);//获取SQL模板语句
            //按问号的个数依次填入所需字段信息
            psmt.setString(1,patent_no);
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

    private static final String MAS_PATENT_SELECT_SQL = "select * from mas_patent\n" +
            "where mas_patent.patent_no = ?";
    @Override
    public mas_patent getmas_patent(String patent_no, String no, String pwd) {
        mas_patent mas_patent_select = new mas_patent();
        Connection con = null;
        try {
            con = getConnection(no, pwd);
            PreparedStatement psmt = con.prepareStatement(MAS_PATENT_SELECT_SQL);
            psmt.setString(1,patent_no);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                mas_patent_select.setPatent_no(rs.getString("patent_no"));
                mas_patent_select.setPatent_name(rs.getString("patent_name"));
                mas_patent_select.setPatent_type(rs.getString("patent_type"));
                mas_patent_select.setPatent_state(rs.getInt("patent_state"));
                mas_patent_select.setPatent_time(rs.getString("patent_time"));
                mas_patent_select.setPatent_con(rs.getInt("patent_con"));
                mas_patent_select.setPatent_identity(rs.getBytes("patent_identity"));
                mas_patent_select.setPatent_first(rs.getString("patent_first"));
                mas_patent_select.setPatent_last(rs.getString("patent_last"));
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
        return mas_patent_select;
    }


    @Override
    public List<mas_patent> findmas_patent(SearchCriteria searchCriteria) {
        return null;
    }
}
