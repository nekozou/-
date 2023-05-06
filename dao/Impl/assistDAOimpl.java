package kcsj.dao.Impl;

import kcsj.SearchCriteria;
import kcsj.dao.AssistDaO;
import kcsj.domain.Teacher;
import kcsj.domain.assistant_evaluate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class assistDAOimpl extends DAOBase implements AssistDaO {


    private static final String ASSIST_SELECT_SQL_DHY="SELECT * FROM assistant_evaluate";
    @Override
    public assistant_evaluate getAssist_DHY(String no,String pwd) {
        Connection con=null;
        assistant_evaluate assist=new assistant_evaluate();
        try{
            con =getConnection(no,pwd);
            PreparedStatement psmt=con.prepareStatement(ASSIST_SELECT_SQL_DHY);
            ResultSet rs =psmt.executeQuery();
            while (rs.next()){
                assist.setAe_no(rs.getString("ae_no"));
                assist.setGra_id(rs.getString("gra_id"));
                assist.setCrs_no(rs.getString("crs_no"));
                assist.setStu_num(rs.getInt("stu_num"));
                assist.setCrs_nat(rs.getInt("crs_nat"));
                assist.setTea_id(rs.getString("tea_id"));
                assist.setAss_time(rs.getString("ass_time"));
                assist.setSelf_eva(rs.getString("self_eva"));
                assist.setTea_eva(rs.getString("tea_eva"));
                assist.setAe_res(rs.getInt("ae_res"));
                assist.setAe_time(rs.getString("ae_time"));
                System.out.println(assist.toString());
            }
            psmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return assist;
    }
        private static final String ASSIST_INSERT_SQL_D ="INSERT INTO assistant_evaluate(ae_no,gra_id,crs_no,stu_num,crs_nat," +
                "crs_stu,tea_id,ass_time) values(?,?,?,?,?,?,?,?);";

        @Override
        public void addAssist_DHY(String no,String pwd,assistant_evaluate assist) {
            Connection con=null;
            int rs;
            try {
                con = getConnection(no,pwd);
                PreparedStatement psmt=con.prepareStatement(ASSIST_INSERT_SQL_D);
                psmt.setString(1,assist.getAe_no());
                psmt.setString(2,assist.getGra_id());
                psmt.setString(3,assist.getCrs_no());
                psmt.setInt(4,assist.getStu_num());
                psmt.setInt(5,assist.getCrs_nat());
                psmt.setInt(6,assist.getCrs_stu());
                psmt.setString(7,assist.getTea_id());
                psmt.setString(8,assist.getAss_time());
                rs=psmt.executeUpdate();
                System.out.println("成功添加了"+rs+"行数据！");
                psmt.close();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try{
                    con.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        private static  final String ASSIST_UPDATE_SQL_D="UPDATE assistant_evaluate SET " +
                "tea_eva=?,ae_res=?,ae_time=? WHERE ae_no=?";

        @Override
        public void updateAssist_DHY(String no,String pwd,assistant_evaluate assist) {
            Connection con=null;
            int rs;
            try {
                con =getConnection(no,pwd);
                PreparedStatement psmt=con.prepareStatement(ASSIST_UPDATE_SQL_D);
                psmt.setString(1,assist.getTea_eva());
                psmt.setInt(2,assist.getAe_res());
                psmt.setString(3,assist.getAe_time());
                psmt.setString(4,assist.getAe_no());
                rs=psmt.executeUpdate();
                System.out.println("成功更新了"+ rs +"行数据！");
                psmt.close();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try{
                    con.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    private static final String ASSIST_INSERT_SQL ="INSERT INTO assistant_evaluate(ae_no,gra_id,crs_no,stu_num,crs_nat," +
            "crs_stu,tea_id,ass_time,self_eva,tea_eva,ae_res,ae_time) values(?,?,?,?,?,?,?,?,?,?,?,?);";

    @Override
    public void addAssist(String no,String pwd,assistant_evaluate assist) {
            Connection con=null;
            int rs;
        try {
            con = getConnection(no,pwd);
            PreparedStatement psmt=con.prepareStatement(ASSIST_INSERT_SQL);
            psmt.setString(1,assist.getAe_no());
            psmt.setString(2,assist.getGra_id());
            psmt.setString(3,assist.getCrs_no());
            psmt.setInt(4,assist.getStu_num());
            psmt.setInt(5,assist.getCrs_nat());
            psmt.setInt(6,assist.getCrs_stu());
            psmt.setString(7,assist.getTea_id());
            psmt.setString(8,assist.getAss_time());
            psmt.setString(9,assist.getSelf_eva());
            psmt.setString(10,assist.getTea_eva());
            psmt.setInt(11,assist.getAe_res());
            psmt.setString(12,assist.getAe_time());
            rs=psmt.executeUpdate();
            System.out.println("成功添加了"+rs+"行数据！");
            psmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static  final String ASSIST_UPDATE_SQL="UPDATE assistant_evaluate SET gra_id=?,crs_no=?,stu_num=?,crs_nat=?," +
            "crs_stu=?,tea_id=?,ass_time=?,self_eva=?,tea_eva=?,ae_res=?,ae_time=? WHERE ae_no=?";

    @Override
    public void updateAssist(String no,String pwd,assistant_evaluate assist) {
        Connection con=null;
        int rs;
        try {
            con =getConnection(no,pwd);
            PreparedStatement psmt=con.prepareStatement(ASSIST_UPDATE_SQL);
            psmt.setString(1,assist.getAe_no());
            psmt.setString(2,assist.getGra_id());
            psmt.setString(3,assist.getCrs_no());
            psmt.setInt(4,assist.getStu_num());
            psmt.setInt(5,assist.getCrs_nat());
            psmt.setInt(6,assist.getCrs_stu());
            psmt.setString(7,assist.getTea_id());
            psmt.setString(8,assist.getAss_time());
            psmt.setString(9,assist.getSelf_eva());
            psmt.setString(10,assist.getSelf_eva());
            psmt.setString(11,assist.getTea_eva());
            psmt.setInt(12,assist.getAe_res());
            psmt.setString(13,assist.getAss_time());
            rs=psmt.executeUpdate();
            System.out.println("成功更新了"+rs+"行数据！");
            psmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static  final String ASSIST_DELETE_SQL="DELETE FROM assistant_evaluate WHERE ae_no=?";
    @Override
    public void deleteAssist(String no,String pwd,String ae_no) {
        Connection con=null;
        int rs;
        try {
            con =getConnection(no,pwd);
            PreparedStatement psmt=con.prepareStatement(ASSIST_DELETE_SQL);
            psmt.setString(1,ae_no);
            rs=psmt.executeUpdate();
            System.out.println("成功删除了"+rs+"行数据！");
            psmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private static final String ASSIST_SELECT_SQL="SELECT ae_no,gra_id,crs_no,stu_num,crs_nat,crs_stu," +
            "tea_id,ass_time,self_eva,tea_eva,ae_res,ae_time FROM assistant_evaluate WHERE ae_no=?";
    @Override
    public assistant_evaluate getAssist(String no,String pwd,String ae_no) {
        Connection con=null;
        assistant_evaluate assist=new assistant_evaluate();
        try{
            con =getConnection(no,pwd);
            PreparedStatement psmt=con.prepareStatement(ASSIST_SELECT_SQL);
            psmt.setString(1,ae_no);
            ResultSet rs =psmt.executeQuery();
            while (rs.next()){
                assist.setAe_no(rs.getString("ae_no"));
                assist.setGra_id(rs.getString("gra_id"));
                assist.setCrs_no(rs.getString("crs_no"));
                assist.setStu_num(rs.getInt("stu_num"));
                assist.setCrs_nat(rs.getInt("crs_nat"));
                assist.setTea_id(rs.getString("tea_id"));
                assist.setAss_time(rs.getString("ass_time"));
                assist.setSelf_eva(rs.getString("self_eva"));
                assist.setTea_eva(rs.getString("tea_eva"));
                assist.setAe_res(rs.getInt("ae_res"));
                assist.setAe_time(rs.getString("ae_time"));
            }
            psmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return assist;
    }
    public List<assistant_evaluate> findAssist(String no, String pwd) {
        Connection con = null;
        List<assistant_evaluate> list = new ArrayList<>();
        try{
            con =getConnection(no,pwd);
            //用字符串拼接
            String SELECT_SQL_pre = null;     //定义查询语句
            SELECT_SQL_pre = "SELECT ae_no,gra_id,crs_no,stu_num,crs_nat,crs_stu,tea_id,ass_time,self_eva,tea_eva,ae_res,ae_time FROM assistant_evaluate";
            //String  STUDENT_SELECT_SQL = SELECT_SQL_pre + searchCriteria.getKey()+searchCriteria.getOperation()+searchCriteria.getValue()+";";
            PreparedStatement psmt = con.prepareStatement(SELECT_SQL_pre);
            //System.out.println("查询语句："+STUDENT_SELECT_SQL);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){  //遍历查询结果并加入数组
                assistant_evaluate assist = new assistant_evaluate();        //这里必须每次都初始化，否则数组的元素将是同一个
                assist.setAe_no(rs.getString("ae_no"));
                assist.setGra_id(rs.getString("gra_id"));
                assist.setCrs_no(rs.getString("crs_no"));
                assist.setStu_num(rs.getInt("stu_num"));
                assist.setCrs_nat(rs.getInt("crs_nat"));
                assist.setTea_id(rs.getString("tea_id"));
                assist.setAss_time(rs.getString("ass_time"));
                assist.setSelf_eva(rs.getString("self_eva"));
                assist.setTea_eva(rs.getString("tea_eva"));
                assist.setAe_res(rs.getInt("ae_res"));
                assist.setAe_time(rs.getString("ae_time"));
                list.add(assist);
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
        return list;
    }
}
