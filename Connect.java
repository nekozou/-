//package kcsj;
//
//import kcsj.domain.Standard;
//
//import java.sql.*;
////研究生毕业管理系统
//public class Connect {
//    public static void main(String[] args) throws SQLException {
////        Connection con = null;
////        Statement statement = null;
////        Connection conn = null;
////        try {
////            String strSql = "select * from graduate_info";  //sql语句
//////            String insertSql1 = "INSERT INTO S VALUES ('0593','王强','男','计算机04','1988-05-13','13212581234')";
//////            String insertSql2 = "INSERT INTO S VALUES ('0594','赵烨','男','计算机04','1989-01-10','18236495863')";
////            String url = "jdbc:sqlserver://101.43.245.192:1433; DatabaseName=keshe;user=sa;password=123456shujuku."; //连接数据库的地址、数据库、用户名和密码
////            try {
////                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //驱动类名称
////            } catch (ClassNotFoundException e) {
////                System.out.println("无法找到驱动类");
////            }
////            conn = DriverManager.getConnection(url); //基于url进行数据库的连接
////            statement = conn.createStatement();
//////            statement.executeUpdate(insertSql1); //执行sql插入语句1
//////            statement.executeUpdate(insertSql2); //执行sql插入语句2
////            ResultSet rs = statement.executeQuery(strSql); //执行sql查询语句
////            while(rs.next()){
////                String gra_id = rs.getString("gra_id");
////                String gra_name = rs.getString("gra_name");
////                System.out.println(gra_id + ", " +gra_name);
////            }
////        } catch (SQLException sqlE) {
////            sqlE.printStackTrace();
////        } finally {
////            if(conn != null){
////                conn.close(); //关闭数据库的连接
////            }
////
////        }
//        //查询博士生成果认定信息
//        /*硕士研究生教材表*/
//
//        //增加研究生教材表
//        /*mas_book mas_book_add = new mas_book();
//            mas_book_add.setBook_no("book002");
//            mas_book_add.setBook_name("《交换与路由之实际开发》");
//            mas_book_add.setBook_publisher("中国科学院出版社");
//            mas_book_add.setBook_date("1988-1-1");
//            mas_book_add.setBook_distribute(100);
//            mas_book_add.setBook_identity(null);
//        DAOFactory.getInstance().getmas_bookDAO().addmas_book(mas_book_add);*/
//
//        //删除硕士研究生教材表
//        /*mas_book mas_book_delete = new mas_book();
//            mas_book_delete.setBook_no("book002");
//        DAOFactory.getInstance().getmas_bookDAO().deletemas_book(mas_book_delete.getBook_no());*/
//
//        //查看研究生教材表
//        /*mas_book mas_book_select = new mas_book();
//            mas_book_select.setBook_no("book001");
//        DAOFactory.getInstance().getmas_bookDAO().getmas_book(mas_book_select.getBook_no());*/
//
//        //更新研究生教材表
//        /*mas_book mas_book_update = new mas_book();
//            mas_book_update.setBook_no("book002");
//        DAOFactory.getInstance().getmas_bookDAO().updatemas_book(mas_book_update);*/
//
//        /*硕士研究生专利表*/
//
//        //增加研究生专利表
//        /*mas_patent mas_patent_add = new mas_patent();
//            mas_patent_add.setPatent_no("patent002");
//            mas_patent_add.setPatent_name("关于使用LaTex的数学公式检索");
//            mas_patent_add.setPatent_type("发明专利");
//            mas_patent_add.setPatent_state(2);
//            mas_patent_add.setPatent_time("2020-1-1");
//            mas_patent_add.setPatent_con(20);
//            mas_patent_add.setPatent_identity(null);
//        DAOFactory.getInstance().getmas_patentDAO().addmas_patent(mas_patent_add);*/
//
//        //删除研究生专利表
//        /*mas_patent mas_patent_delete = new mas_patent();
//            mas_patent_delete.setPatent_no("patent002");
//        DAOFactory.getInstance().getmas_patentDAO().deletemas_patent(mas_patent_delete.getPatent_no());*/
//
//        //查看研究生专利表
//        /*mas_patent mas_patent_select = new mas_patent();
//        mas_patent_select.setPatent_no("patent001");
//        DAOFactory.getInstance().getmas_patentDAO().getmas_patent(mas_patent_select.getPatent_no());*/
//
//        //更新研究生专利表
//        /*mas_patent mas_patent_update = new mas_patent();
//            mas_patent_update.setPatent_no("patent002");
//        DAOFactory.getInstance().getmas_patentDAO().updatemas_patent(mas_patent_update);*/
//
//        /*硕士研究生报告表*/
//
//        //增加研究生报告表
//        /*mas_report mas_report_add = new mas_report();
//            mas_report_add.setReport_no("report002");
//            mas_report_add.setReport_name("中国web前端发展初探报告");
//            mas_report_add.setReport_type("省部级");
//            mas_report_add.setReport_unit("中国标准报告协会");
//            mas_report_add.setReport_date("2019-1-1");
//            mas_report_add.setReport_con(20);
//            mas_report_add.setReport_identity(null);
//        DAOFactory.getInstance().getmas_reportDAO().addmas_report(mas_report_add);*/
//
//        //删除研究生报告表
//        /*mas_report mas_report_delete = new mas_report();
//            mas_report_delete.setReport_no("report002");
//        DAOFactory.getInstance().getmas_reportDAO().deletemas_report(mas_report_delete.getReport_no());*/
//
//        //查看研究生报告表
//        /*mas_report mas_report_select = new mas_report();
//            mas_report_select.setReport_no("report001");
//        DAOFactory.getInstance().getmas_reportDAO().getmas_report(mas_report_select.getReport_no());*/
//
//        //更新研究生专利表
//        /*mas_report mas_report_update = new mas_report();
//            mas_report_update.setReport_no("report002");
//        DAOFactory.getInstance().getmas_reportDAO().updatemas_report(mas_report_update);*/
//
//        /*硕士研究生软硬件平台表*/
//
//        //增加研究生软硬件平台
//        /*mas_soft_hard mas_soft_hard_add = new mas_soft_hard();
//            mas_soft_hard_add.setSoft_hard_no("sf002");
//            mas_soft_hard_add.setSoft_hard_name("基于计算机视觉的学习平台");
//            mas_soft_hard_add.setSoft_hard_unit("计算机视觉协会");
//            mas_soft_hard_add.setSoft_hard_date("2019-1-1");
//            mas_soft_hard_add.setSoft_hard_con(20);
//            mas_soft_hard_add.setSoft_hard_identity(null);
//        DAOFactory.getInstance().getmas_soft_hardDAO().addmas_soft_hard(mas_soft_hard_add);*/
//
//        //删除研究生软硬件表
//        /*mas_soft_hard mas_soft_hard_delete = new mas_soft_hard();
//            mas_soft_hard_delete.setSoft_hard_no("sf002");
//        DAOFactory.getInstance().getmas_soft_hardDAO().deletemas_soft_hard(mas_soft_hard_delete.getSoft_hard_no());*/
//
//        //查看研究生软硬件表
//        /*mas_soft_hard mas_soft_hard_select = new mas_soft_hard();
//            mas_soft_hard_select.setSoft_hard_no("sf001");
//        DAOFactory.getInstance().getmas_soft_hardDAO().getmas_soft_hard(mas_soft_hard_select.getSoft_hard_no());*/
//
//        //更新研究生软硬件表
//        /*mas_soft_hard mas_soft_hard_update = new mas_soft_hard();
//            mas_soft_hard_update.setSoft_hard_no("sf002");
//        DAOFactory.getInstance().getmas_soft_hardDAO().updatemas_soft_hard(mas_soft_hard_update);*/
//
//        /*博士研究生其他成果表*/
//
//        //增加博士研究生其他成果表
//        /*phd_other phd_other_add = new phd_other();
//            phd_other_add.setOther_no("other003");
//            phd_other_add.setOther_name("百度云实习优秀生成果");
//            phd_other_add.setOther_rank("团队标准");
//            phd_other_add.setOther_date("2018-1-1");
//            phd_other_add.setOther_identity(null);
//        DAOFactory.getInstance().getphd_otherDAO().addphd_other(phd_other_add);*/
//
//        //删除博士研究生其他成果表
//        /*phd_other phd_other_delete = new phd_other();
//            phd_other_delete.setOther_no("other003");
//        DAOFactory.getInstance().getphd_otherDAO().deletephd_other(phd_other_delete.getOther_no());*/
//
//        //查看博士研究生其他成果表
//        /*phd_other phd_other_select = new phd_other();
//            phd_other_select.setOther_no("other002");
//        DAOFactory.getInstance().getphd_otherDAO().getphd_other(phd_other_select.getOther_no());*/
//
//        //更新博士研究生其他成果表
//        /*phd_other phd_other_update = new phd_other();
//            phd_other_update.setOther_no("other003");
//        DAOFactory.getInstance().getphd_otherDAO().updatephd_other(phd_other_update);*/
//
//        /*博士研究生成果认定表*/
//        //增
//        /*phd_achievement phd_achievement = new phd_achievement();
//        phd_achievement.setPhd_id("gra004");
//        phd_achievement.setPhd_type("2");
//        phd_achievement.setThesis_no("thesis003");
//        phd_achievement.setReward_no("reward003");
//        phd_achievement.setOther_no("other003");
//        phd_achievement.setStandard_no("std003");
//        DAOFactory.getInstance().getPhd_achievementDAO().addPhd_achievement(phd_achievement);*/
//
//        //删
//        /*phd_achievement phd_achievement = new phd_achievement();
//        phd_achievement.setPhd_id("gra004");
//        DAOFactory.getInstance().getPhd_achievementDAO().deletePhd_achievement(phd_achievement.getPhd_id());*/
//
//        //改
//        /*phd_achievement phd_achievement = new phd_achievement();
//        phd_achievement.setPhd_id("gra004");
//        DAOFactory.getInstance().getPhd_achievementDAO().updatePhd_achievement(phd_achievement);*/
//
//        //查
//        /*phd_achievement phd_achievement = new phd_achievement();
//        phd_achievement.setPhd_id("gra002");
//        DAOFactory.getInstance().getPhd_achievementDAO().getPhd_achievement(phd_achievement.getPhd_id());*/
//
//        /*硕士研究生成果认定表*/
//        //增
//        /*Mas_achievement mas_achievement = new Mas_achievement();
//        mas_achievement.setMas_id("gra003");
//        mas_achievement.setMas_type("1");
//        mas_achievement.setThesis_no("thesis004");
//        mas_achievement.setBook_no("book002");
//        mas_achievement.setStandard_no("std004");
//        mas_achievement.setPatent_no("patent002");
//        mas_achievement.setReport_no("report002");
//        mas_achievement.setSoft_hard_no("sf002");
//        DAOFactory.getInstance().getMas_achievementDAO().addMas_achievement(mas_achievement);*/
//
//        //删
//        /*Mas_achievement mas_achievement = new Mas_achievement();
//        mas_achievement.setMas_id("gra003");
//        DAOFactory.getInstance().getMas_achievementDAO().deleteMas_achievement(mas_achievement.getMas_id());*/
//
//        //改
//        /*Mas_achievement mas_achievement = new Mas_achievement();
//        mas_achievement.setMas_id("gra003");
//        DAOFactory.getInstance().getMas_achievementDAO().updateMas_achievement(mas_achievement);*/
//
//        //查
//        /*Mas_achievement mas_achievement = new Mas_achievement();
//        mas_achievement.setMas_id("gra001");
//        DAOFactory.getInstance().getMas_achievementDAO().getMas_achievement(mas_achievement.getMas_id());*/
//
//        /*研究生论文表*/
//        //增
//        /*Thesis thesis = new Thesis();
//        thesis.setThesis_no("thesis003");
//        thesis.setThesis_name("基于人工智能的木马病毒检测");
//        thesis.setThesis_pub("《SCI一区》");
//        thesis.setThesis_state("2");
//        thesis.setThesis_date("2022-09-22");
//        thesis.setThesis_index("SSCI");
//        thesis.setThesis_bel("学院高质量论文库");
//        DAOFactory.getInstance().getThesisDAO().addThesis(thesis);*/
//
//        //删
//        /*Thesis thesis = new Thesis();
//        thesis.setThesis_no("thesis003");
//        DAOFactory.getInstance().getThesisDAO().deleteThesis(thesis.getThesis_no());*/
//
//        //改
//        /*Thesis thesis = new Thesis();
//        thesis.setThesis_no("thesis003");
//        DAOFactory.getInstance().getThesisDAO().updateThesis(thesis);*/
//
//        //查
//        /*Thesis thesis = new Thesis();
//        thesis.setThesis_no("thesis002");
//        DAOFactory.getInstance().getThesisDAO().getThesis(thesis.getThesis_no());*/
//
//        /*博士研究生奖励表*/
//        //增
//        /*Phd_reward phd_reward = new Phd_reward();
//        phd_reward.setReward_no("reward003");
//        phd_reward.setReward_name("国家级励志奖学金");
//        phd_reward.setReward_rank("国家级");
//        phd_reward.setReward_score("一等奖");
//        phd_reward.setReward_order("4");
//        phd_reward.setReward_date("2022-9-16");
//        DAOFactory.getInstance().getPhd_rewardDAO().addPhd_reward(phd_reward);*/
//
//        //删
//        /*Phd_reward phd_reward = new Phd_reward();
//        phd_reward.setReward_no("reward003");
//        DAOFactory.getInstance().getPhd_rewardDAO().deletePhd_reward(phd_reward.getReward_no());*/
//
//        //改
//        /*Phd_reward phd_reward = new Phd_reward();
//        phd_reward.setReward_no("reward003");
//        DAOFactory.getInstance().getPhd_rewardDAO().updatePhd_reward(phd_reward);*/
//
//        //查
//        /*Phd_reward phd_reward = new Phd_reward();
//        phd_reward.setReward_no("reward001");
//        DAOFactory.getInstance().getPhd_rewardDAO().getPhd_reward(phd_reward.getReward_no());*/
//
//        /*研究生标准表*/
//        //增
//        /*Standard standard = new Standard();
//        standard.setStandard_no("std003");
//        standard.setStandard_name("关于网络中病毒威胁性的标准");
//        standard.setStandard_rank("行业标准");
//        standard.setStandard_date("2021-11-13");
//        DAOFactory.getInstance().getStandardDAO().addStandard(standard);*/
//
//        //删
//        /*Standard standard = new Standard();
//        standard.setStandard_no("std003");
//        DAOFactory.getInstance().getStandardDAO().deleteStandard(standard.getStandard_no());*/
//
//        //改
//        /*Standard standard = new Standard();
//        standard.setStandard_no("std003");
//        DAOFactory.getInstance().getStandardDAO().updateStandard(standard);*/
//
//        //查
//        Standard standard = new Standard();
//        standard.setStandard_no("std002");
//        DAOFactory.getInstance().getStandardDAO().getStandard(standard.getStandard_no());
//    }
//}
