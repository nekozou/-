package kcsj.dao.Impl;

import kcsj.dao.ManagerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerDAOImpl extends DAOBase implements ManagerDAO {

    @Override
    public String checkSnoAndPwd(String no, String pwd) {
        Connection con = null;
        try {
            con =getConnection(no,pwd);
            String QUERY_PWD_SQL = "select man_name from manager_info where usr=? and pwd=?";
            PreparedStatement pst = con.prepareStatement(QUERY_PWD_SQL);
            pst.setString(1, no);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString("man_name");
            }
            else return null;
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
    }
}
