package kcsj.dao.Impl;

import kcsj.dao.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAOBase implements DAO {

    @Override
    public Connection getConnection(String no,String pwd) {
        String URL="jdbc:sqlserver://101.42.35.208:1433; DatabaseName=keshe";
        Connection con = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(URL,no,pwd);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return con;
    }

}
