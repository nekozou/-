package kcsj;
import kcsj.domain.*;
import javax.xml.stream.FactoryConfigurationError;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import kcsj.dao.*;
//我改动的表：Assist---im,dao，DAOfactory,CourseDAO,teacher,teacherdaoimpl,
//ace----改了tostring,去掉了图片 aceimpl 改了find，update,,,projectsdaoimpl的update
public class Main
{
    public static void main(String[] args) throws SQLException, IOException {
        while (true) {
            System.out.println("----------------------");
            System.out.println("欢迎访问研究生毕业管理系统！");
            System.out.println("请选择你的身份：");
            System.out.println("0.管理员");
            System.out.println("1.学科负责人");
            System.out.println("2.授课教师");
            System.out.println("3.导师");
            System.out.println("4.硕士研究生");
            System.out.println("5.博士研究生");
            System.out.println("6.退出系统");
            System.out.println("请选择：(输入序号数字)");
            Scanner sc = new Scanner(System.in);
            int ch0 = 6;
            try {
                ch0 = sc.nextInt();
            } catch (Exception e) {
                System.out.println("请输入正确的数字序号！");
            }
            if (ch0 == 6) break;
            System.out.println("请输入您的账号（学号/工号）：");
            String no = sc.next();
            System.out.println("请输入您的密码：");
            String pwd = sc.next();
            if (ch0 == 0) {       //sa 123456shujuku.
                //助教子系统、学术交流活动子系统、项目贡献子系统和成果认定子系统
                String name = kcsj.DAOFactory.getInstance().getmanagerDAO().checkSnoAndPwd(no,pwd);
                if(name != null) {
                    System.out.println(name + " " + "管理员您好，您已成功登录系统");
                    while (true) {
                        System.out.println("----------------------");
                        System.out.println("1.建立学科负责人/授课教师/导师的基本信息和登录信息");
                        System.out.println("2.建立学生登录账号");
                        System.out.println("3.录入导师的项目情况");
                        System.out.println("4.终审成果认定");
                        System.out.println("5.返回上一级");
                        System.out.println("请选择：(输入序号数字)");
                        int ch1 = 5;
                        try {
                            ch1 = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("请输入正确的数字序号！");
                        }
                        if (ch1 == 1) {
                            Teacher tea = new Teacher();
                            System.out.println("请输入教师编号:");
                            tea.setTea_id(sc.next());
                            System.out.println("请输入教师名字:");
                            tea.setTea_name(sc.next());
                            System.out.println("请输入教师学院:");
                            tea.setCollege(sc.next());
                            System.out.println("请输入教师专业:");
                            tea.setDept(sc.next());
                            System.out.println("请输入教师职称（助教、讲师、副教授、教授）:");
                            tea.setTitle(sc.next());
                            int cht;
                            System.out.println("该教师是否为学科负责人？(1是/0否)");
                            cht = sc.nextInt();
                            if (cht == 1)
                                tea.setIs_duty("1");
                            else tea.setIs_duty("0");
                            System.out.println("该教师是否为授课教师？(1是/0否)");
                            cht = sc.nextInt();
                            if (cht == 1)
                                tea.setIs_tutor("1");
                            else tea.setIs_tutor("0");
                            System.out.println("该教师是否为导师？(1是/0否)");
                            cht = sc.nextInt();
                            if (cht == 1)
                                tea.setIs_lecture("1");
                            else tea.setIs_lecture("0");
                            System.out.println("请输入教师账户用户名:");
                            tea.setUser(sc.next());
                            System.out.println("请输入教师账户密码:");
                            tea.setPwd(sc.next());
                            kcsj.DAOFactory.getInstance().getteacherDAO().addTeacher(no, pwd, tea);
                        }
                        else if (ch1 == 2) {
                            Gra_info gra = new Gra_info();
                            System.out.println("请输入学生编号:");
                            gra.setGra_id(sc.next());
                            System.out.println("请输入学生姓名:");
                            gra.setGra_name(sc.next());
                            System.out.println("该学生是 1.硕士研究生 2.博士研究生：");
                            int cht = sc.nextInt();
                            if (cht == 1)
                                gra.setGra_type("1");
                            else
                                gra.setGra_type("2");
                            System.out.println("请输入学生学院:");
                            gra.setGra_coll(sc.next());
                            System.out.println("请输入学生专业:");
                            gra.setDept(sc.next());
                            System.out.println("请输入学生的导师编号:");
                            gra.setTea_id(sc.next());
                            System.out.println("请输入学生用户名:");
                            gra.setUsr(sc.next());
                            System.out.println("请输入学生密码:");
                            gra.setPwd(sc.next());
                            kcsj.DAOFactory.getInstance().getgraDAO().addGra(no, pwd, gra);
                        }
                        else if (ch1 == 3) {
                            Projects pro = new Projects();
                            System.out.println("请输入项目认定表编号:");
                            pro.setPp_no(sc.next());
                            System.out.println("请输入指导教师编号:");
                            pro.setTea_id(sc.next());
                            System.out.println("请输入学生编号:");
                            pro.setGra_id(sc.next());
                            System.out.println("请输入项目编号:");
                            pro.setProj_id(sc.next());
                            System.out.println("请输入项目类型：");
                            pro.setProj_class(sc.next());
                            System.out.println("请输入项目名称：");
                            pro.setProj_name(sc.next());
                            System.out.println("请输入项目开始时间:");
                            pro.setProj_begin(sc.next());
                            System.out.println("请输入项目结束时间:");
                            pro.setProj_end(sc.next());
                            System.out.println("请输入承担工作:");
                            pro.setDuty_work(sc.next());
                            System.out.println("请输入折合经费:");
                            pro.setProj_outlay(sc.next());
                            kcsj.DAOFactory.getInstance().getprojectsDAO().addProjects(no, pwd, pro);
                        }
                        else if (ch1 == 4)//终审成果情况
                        {
                            System.out.println("请输入学生学号:");
                            String gra_id = sc.next();
                            System.out.println("请输入该学生为 1.硕士研究生/2.博士研究生");
                            int ch = sc.nextInt();
                            if (ch == 2) {
                                phd_achievement phd = new phd_achievement();
                                phd = kcsj.DAOFactory.getInstance().getPhd_achievementDAO().getPhd_achievement(no, pwd, gra_id);
                                //System.out.println(phd.toString());
                                while (true) {
                                    System.out.println("对成果进行终审：");
                                    System.out.println("1.审核论文");
                                    System.out.println("2.审核奖励");
                                    System.out.println("3.审核标准");
                                    System.out.println("4.审核其他成果");
                                    System.out.println("5.返回上一级");
                                    System.out.println("请选择：(输入序号)");
                                    int cht = sc.nextInt();
                                    if (cht == 5)
                                        break;
                                    switch (cht) {
                                        case 1: {
                                            if (phd.getThesis_no() != null) {
                                                Thesis thes = kcsj.DAOFactory.getInstance().getThesisDAO().getThesis(no, pwd, phd.getThesis_no());
                                                System.out.println(thes.toString());
                                                System.out.println("终审是否通过？（1通过/2不通过）");
                                                int ch2 = sc.nextInt();
                                                if (ch2 == 1) {
                                                    thes.setThesis_last("通过");
                                                } else thes.setThesis_last("不通过");
                                                kcsj.DAOFactory.getInstance().getThesisDAO().updateThesis(no, pwd, thes, 2);
                                                thes = kcsj.DAOFactory.getInstance().getThesisDAO().getThesis(no, pwd, phd.getThesis_no());
                                                System.out.println(thes.toString());
                                            }
                                            break;
                                        }
                                        case 2:
                                        case 3: {
                                            Thesis thes = kcsj.DAOFactory.getInstance().getThesisDAO().getThesis(no, pwd, phd.getThesis_no());
                                            System.out.println(thes.toString());
                                            System.out.println("终审是否通过？（1通过/2不通过）");
                                            int ch2 = sc.nextInt();
                                            if (ch2 == 1) {
                                                thes.setThesis_last("通过");
                                            } else thes.setThesis_last("不通过");
                                            kcsj.DAOFactory.getInstance().getThesisDAO().updateThesis(no, pwd, thes, 2);
                                            thes = kcsj.DAOFactory.getInstance().getThesisDAO().getThesis(no, pwd, phd.getThesis_no());
                                            System.out.println(thes.toString());
                                            break;
                                        }
                                        case 4: {
                                            phd_other phdo = kcsj.DAOFactory.getInstance().getphd_otherDAO().getphd_other(phd.getOther_no(), no, pwd);
                                            System.out.println(phdo.toString());
                                            System.out.println("终审是否通过？（1通过/2不通过）");
                                            int ch2 = sc.nextInt();
                                            if (ch2 == 1)
                                            {
                                                phdo.setOther_last("通过");
                                            } else phdo.setOther_last("不通过");
                                            kcsj.DAOFactory.getInstance().getphd_otherDAO().updatephd_other(phdo, no, pwd, 2);
                                            phdo = kcsj.DAOFactory.getInstance().getphd_otherDAO().getphd_other(phd.getOther_no(), no, pwd);
                                            System.out.println(phdo.toString());
                                            break;
                                        }
                                        default:
                                            break;
                                    }
                                }
                            } else {
                                Mas_achievement mas = new Mas_achievement();
                                mas = kcsj.DAOFactory.getInstance().getMas_achievementDAO().getMas_achievement(no, pwd, gra_id);
                                //System.out.println(mas.toString());
                                while (true) {
                                    System.out.println("对成果进行初审：");
                                    System.out.println("1.审核论文");
                                    System.out.println("2.审核教材");
                                    System.out.println("3.审核标准");
                                    System.out.println("4.审核专利");
                                    System.out.println("5.审核报告");
                                    System.out.println("6.审核软硬件平台开发证明");
                                    System.out.println("7.返回上一级");
                                    System.out.println("请选择：(输入序号)");
                                    int cht = sc.nextInt();
                                    if (cht == 7)
                                        break;
                                    switch (cht) {
                                        case 1://论文
                                        {
                                            if (mas.getThesis_no() != null) {
                                                Thesis thes = kcsj.DAOFactory.getInstance().getThesisDAO().getThesis(no, pwd, mas.getThesis_no());
                                                System.out.println(thes.toString());
                                                System.out.println("终审是否通过？（1通过/2不通过）");
                                                int ch2 = sc.nextInt();
                                                if (ch2 == 1) {
                                                    thes.setThesis_last("通过");
                                                } else thes.setThesis_last("不通过");
                                                kcsj.DAOFactory.getInstance().getThesisDAO().updateThesis(no, pwd, thes, 2);
                                                thes = kcsj.DAOFactory.getInstance().getThesisDAO().getThesis(no, pwd, mas.getThesis_no());
                                                System.out.println(thes.toString());
                                            }
                                            break;
                                        }
                                        case 2://教材
                                        {
                                            if (mas.getBook_no() != null) {
                                                mas_book masb = kcsj.DAOFactory.getInstance().getmas_bookDAO().getmas_book(mas.getBook_no(), no, pwd);
                                                System.out.println(masb.toString());
                                                System.out.println("终审是否通过？（1通过/2不通过）");
                                                int ch2 = sc.nextInt();
                                                if (ch2 == 1) {
                                                    masb.setBook_last("通过");
                                                } else masb.setBook_last("不通过");
                                                kcsj.DAOFactory.getInstance().getmas_bookDAO().updatemas_book(masb, no, pwd, 2);
                                                masb = kcsj.DAOFactory.getInstance().getmas_bookDAO().getmas_book(mas.getBook_no(), no, pwd);
                                                System.out.println(masb.toString());
                                            }
                                            break;
                                        }//标准
                                        case 3:
                                        case 4://专利
                                        {
                                            mas_patent masp = kcsj.DAOFactory.getInstance().getmas_patentDAO().getmas_patent(mas.getPatent_no(), no, pwd);
                                            System.out.println(masp.toString());
                                            System.out.println("终审是否通过？（1通过/2不通过）");
                                            int ch2 = sc.nextInt();
                                            if (ch2 == 1) {
                                                masp.setPatent_last("通过");
                                            } else masp.setPatent_last("不通过");
                                            kcsj.DAOFactory.getInstance().getmas_patentDAO().updatemas_patent(masp, no, pwd, 2);
                                            masp = kcsj.DAOFactory.getInstance().getmas_patentDAO().getmas_patent(mas.getPatent_no(), no, pwd);
                                            System.out.println(masp.toString());
                                            break;
                                        }//报告
                                        case 5: {
                                            mas_report masr = kcsj.DAOFactory.getInstance().getmas_reportDAO().getmas_report(mas.getReport_no(), no, pwd);
                                            System.out.println(masr.toString());
                                            System.out.println("终审是否通过？（1通过/2不通过）");
                                            int ch2 = sc.nextInt();
                                            if (ch2 == 1) {
                                                masr.setReport_second("通过");
                                            } else masr.setReport_second("不通过");
                                            kcsj.DAOFactory.getInstance().getmas_reportDAO().updatemas_report(masr, no, pwd, 2);
                                            masr = kcsj.DAOFactory.getInstance().getmas_reportDAO().getmas_report(mas.getReport_no(), no, pwd);
                                            System.out.println(masr.toString());
                                            break;
                                        }
                                        case 6://软硬件平台开发证明
                                        {
                                            mas_soft_hard mass = kcsj.DAOFactory.getInstance().getmas_soft_hardDAO().getmas_soft_hard(mas.getSoft_hard_no(), no, pwd);
                                            System.out.println(mass.toString());
                                            System.out.println("终审是否通过？（1通过/2不通过）");
                                            int ch2 = sc.nextInt();
                                            if (ch2 == 1) {
                                                mass.setSoft_hard_last("通过");
                                            } else mass.setSoft_hard_last("不通过");
                                            kcsj.DAOFactory.getInstance().getmas_soft_hardDAO().updatemas_soft_hard(mass, no, pwd, 2);
                                            mass = kcsj.DAOFactory.getInstance().getmas_soft_hardDAO().getmas_soft_hard(mas.getSoft_hard_no(), no, pwd);
                                            System.out.println(mass.toString());
                                            break;
                                        }
                                        default:
                                            break;
                                    }
                                }
                            }
                        } else if (ch1 == 5) break;
                        else System.out.println("请输入正确的数字序号！");
                    }
                }
            }
            else if(ch0 == 1){
                //确认账号密码，并确定是否是学科负责人 is_duty=1
                String name = kcsj.DAOFactory.getInstance().getteacherDAO().checkSnoAndPwd(no, pwd,"1","0","0");
                if(name != null){
                    System.out.println(name+" "+"老师您好，您已成功登录系统");
                    //各自学科有关助教课程优先级、助教可选志愿数量、参与项目经费要求、学术交流次数等毕业条件的配置信息。
                    //学科负责人可查看学科下的导师信息以及研究生培养情况。
                    while (true){
                        System.out.println("----------------------");
                        System.out.println("1.查看/修改研究生助教志愿信息");
                        System.out.println("2.查看/修改研究生参与项目信息");
                        System.out.println("3.查看本学科导师信息");
                        System.out.println("4.查看研究生成果认定信息");
                        System.out.println("5.返回上一级");
                        System.out.println("请选择：(输入序号数字)");
                        int ch1 = 3;
                        try{
                            ch1 = sc.nextInt();
                        }catch (Exception e) {
                            System.out.println("请输入正确的数字序号！");
                        }
                        if(ch1 == 1){
                            //查询志愿信息
                            List<assistant_evaluate> list = new ArrayList<>();
                            list = kcsj.DAOFactory.getInstance().getAssistDAO().findAssist(no,pwd);
                            Iterator<assistant_evaluate> iterate = list.iterator();
                            System.out.print("查询结果：\n");
                            //使用Iterator的方法访问元素
                            while (iterate.hasNext()){
                                System.out.print(iterate.next().toString() + "\n");
                            }
                            System.out.print("是否需要删除？（1是/2否）：\n");
                            int ch2 = sc.nextInt();
                            if(ch2==1)
                            {
                                System.out.print("请输入助教志愿编号：\n");
                                String ae_no = sc.next();
                                DAOFactory.getInstance().getAssistDAO().deleteAssist(no,pwd,ae_no);
                            }
                        }
                        else if (ch1 == 2)
                        {
                            System.out.println("请输入学生学号:");
                            String gra_id = sc.next();
                            SearchCriteria c1 = new SearchCriteria();
                            c1.setKey("gra_id");
                            c1.setOperation("=");
                            c1.setValue("'"+gra_id+"'");
                            List<Projects> t = new ArrayList<>();
                            t = kcsj.DAOFactory.getInstance().getprojectsDAO().findProjects(no,pwd,c1);
                            Iterator<Projects> iterate = t.iterator();
                            System.out.print("该学生的参与项目情况：\n");
                            //使用Iterator的方法访问元素
                            while (iterate.hasNext()) {
                                System.out.print(iterate.next().toString() + "\n");
                            }
                            System.out.print("是否对填报该学生参与项目所折合的经费数量？（1是/2否）");
                            int cht = sc.nextInt();
                            if(cht ==1) {
                                Projects pro = new Projects();
                                System.out.print("请输入项目编号：");
                                pro.setPp_no(sc.next());
                                System.out.print("请输入经费：");
                                pro.setProj_outlay(sc.next());
                                kcsj.DAOFactory.getInstance().getprojectsDAO().updateProjects(no,pwd,pro);
                            }
                        }
                        else if (ch1 == 3)
                        {//查看该学科的导师信息。
                            SearchCriteria c1 = new SearchCriteria();
                            c1.setKey("dept");
                            c1.setOperation("=");
                            Teacher duty= kcsj.DAOFactory.getInstance().getteacherDAO().getTeacher(no,pwd,no);
                            c1.setValue("'"+duty.getDept()+"'");
                            List<Teacher> t1 = new ArrayList<>();
                            t1 = kcsj.DAOFactory.getInstance().getteacherDAO().findTeacher(no,pwd,c1);
                            Iterator<Teacher> iterate1 = t1.iterator();
                            System.out.print("查询结果：\n");
                            //使用Iterator的方法访问元素
                            while (iterate1.hasNext()) {
                                System.out.print(iterate1.next().toString() + "\n");
                            }
                        }
                        else if (ch1==4)
                        { //查看研究生成果认定
                            System.out.println("请输入您想要查询的研究生学号：");
                            String gra_id = sc.next();
                            System.out.println("请输入该学生为 1.硕士研究生/2.博士研究生");
                            int ch = sc.nextInt();
                            if (ch == 1) {
                                Mas_achievement mas = kcsj.DAOFactory.getInstance().getMas_achievementDAO().getMas_achievement(no, pwd, gra_id);
                            }
                            else {
                                phd_achievement phd = new phd_achievement();
                                phd = kcsj.DAOFactory.getInstance().getPhd_achievementDAO().getPhd_achievement(no, pwd, gra_id);
                            }
                        }
                        else if (ch1==5)break;
                        else {System.out.println("请输入正确的数字序号！");}
                    }
                }else System.out.println("账号或密码错误，登录失败！");
            }
            else if (ch0 == 2) {
                //确认账号密码，并确定是否是授课教师 is_tutor=1
                String name = DAOFactory.getInstance().getteacherDAO().checkSnoAndPwd(no, pwd, "0", "1", "0");
                if (name != null) {
                    System.out.println("\n\n" + name + "老师您好，您已成功登录系统");
                    while (true) {
                        System.out.println("----------------------");
                        System.out.println("1.录入研究生助教课程信息");
                        System.out.println("2.录入研究生助教工作评价");
                        System.out.println("3.删除研究生助教认定");
                        System.out.println("4.查看研究生助教认定表(展示所有助教认定)");
                        System.out.println("5.完善课程表信息");
                        System.out.println("6.返回上一级");
                        System.out.println("请选择：(输入序号数字)");
                        int ch1 = 1;
                        try {
                            ch1 = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("请输入正确的数字序号！");
                        }
                        if (ch1 == 1) {//1.录入助教课程信息
                            assistant_evaluate ass_add = new assistant_evaluate();
                            System.out.println("请输入助教认定表编号：");
                            String ass_add_no = sc.next();
                            System.out.println("请输入助教id：(研究生id)");
                            String ass_add_gra_id = sc.next();
                            System.out.println("请输入课程编号：");
                            String ass_add_crs_no = sc.next();
                            System.out.println("请输入授课人数：");
                            int ass_add_stu_num = sc.nextInt();
                            System.out.println("请输入课程性质：");
                            int ass_add_crs_nat = sc.nextInt();
                            System.out.println("请输入授课对象：");
                            int ass_add_crs_stu = sc.nextInt();
                            System.out.println("请输入授课教师id：(教师id)");
                            String ass_add_tea_id = sc.next();
                            System.out.println("请输入授课时间：");
                            String ass_add_ass_time = sc.next();
                            ass_add.setAe_no(ass_add_no);
                            ass_add.setGra_id(ass_add_gra_id);
                            ass_add.setCrs_no(ass_add_crs_no);
                            ass_add.setStu_num(ass_add_stu_num);
                            ass_add.setCrs_nat(ass_add_crs_nat);
                            ass_add.setCrs_stu(ass_add_crs_stu);
                            ass_add.setTea_id(ass_add_tea_id);
                            ass_add.setAss_time(ass_add_ass_time);
                            kcsj.DAOFactory.getInstance().getAssistDAO().addAssist_DHY(no, pwd, ass_add);
                        } else if (ch1 == 2) {//2.录入助教工作评价
                            System.out.println("请输入待认定的助教认定表编号：(评定表编号)");
                            assistant_evaluate ass_update = new assistant_evaluate();
                            String ass_update_ae_id = sc.next();
                            System.out.println("请输入授课教师评价：");
                            String ass_update_tea_eva = sc.next();
                            System.out.println("请输入评定结果：");
                            int ass_update_ae_res = sc.nextInt();
                            System.out.println("请输入评定时间：");
                            String ass_update_ae_time = sc.next();
                            ass_update.setAe_no(ass_update_ae_id);
                            ass_update.setTea_eva(ass_update_tea_eva);
                            ass_update.setAe_res(ass_update_ae_res);
                            ass_update.setAe_time(ass_update_ae_time);
                            DAOFactory.getInstance().getAssistDAO().updateAssist_DHY(no, pwd, ass_update);
                        } else if (ch1 == 3) {//删除研究生助教认定
                            System.out.println("请输入需要删除的研究生助教认定编号：(助教认定编号)");
                            String ass_delete_ae_no = sc.next();
                            DAOFactory.getInstance().getAssistDAO().deleteAssist(no, pwd, ass_delete_ae_no);
                        } else if (ch1 == 4) {//4.查看研究生助教认定表
                            DAOFactory.getInstance().getAssistDAO().getAssist_DHY(no, pwd);
                        } else if (ch1 == 5) {//完善课程表信息
                            Course crs_update = new Course();
                            System.out.println("请输入您要完善的课程编号：(课程编号)");
                            String crs_update_no = sc.next();
                            System.out.println("请输入您要完善的选课人数");
                            int crs_update_num = sc.nextInt();
                            System.out.println("请输入您要完善的课时量设置：");
                            int crs_update_time = sc.nextInt();
                            System.out.println("请输入您要完善的学分：");
                            Double crs_update_score = sc.nextDouble();
                            System.out.println("请输入您要完善的课程优先级：");
                            double crs_update_pri = sc.nextDouble();
                            System.out.println("请输入您要完善的课程助教：");
                            String crs_update_gra_id = sc.next();
                            crs_update.setCrs_no(crs_update_no);
                            crs_update.setCrs_num(crs_update_num);
                            crs_update.setCrs_time(crs_update_time);
                            crs_update.setCrs_score(crs_update_score);
                            crs_update.setCrs_pri(crs_update_pri);
                            crs_update.setGra_id(crs_update_gra_id);
                            DAOFactory.getInstance().getcourseDAO().updateCourse_DHY(no, pwd, crs_update);
                        } else if (ch1 == 6) break;
                        else{
                            System.out.println("请输入正确的数字序号！");
                        }
                    }
                } else System.out.println("账号或密码错误，登录失败！");
            }
            else if (ch0 == 3)
            {
                String name = DAOFactory.getInstance().getteacherDAO().checkSnoAndPwd(no, pwd,"0","1","0");
                if(name != null){
                    System.out.println(name+" "+"老师您好，您已成功登录系统");
                    while (true) {
                        System.out.println("----------------------");
                        System.out.println("1.审核学生的学术交流情况");
                        System.out.println("2.填报学生参与项目所折合的经费数量");
                        System.out.println("3.进行成果的初审认定");
                        System.out.println("4.返回上一级");
                        System.out.println("请选择：(输入序号)");
                        int ch1 = 4;
                        try {
                            ch1 = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("请输入正确的序号！");
                        }
                        if (ch1 == 1) {
                            Academic_exchange ace = new Academic_exchange();
                            System.out.println("请输入学生学号:");
                            String gra_id = sc.next();
                            SearchCriteria c1 = new SearchCriteria();
                            c1.setKey("gra_id");
                            c1.setOperation("=");
                            c1.setValue("'" + gra_id + "'");
                            List<Academic_exchange> t1 = new ArrayList<>();
                            t1 = kcsj.DAOFactory.getInstance().getaceDAO().findAce(no, pwd, c1);
                            Iterator<Academic_exchange> iterate1 = t1.iterator();
                            System.out.print("该学生的学术交流情况：\n");
                            //使用Iterator的方法访问元素
                            while (iterate1.hasNext()) {
                                System.out.print(iterate1.next().toString() + "\n");
                            }
                            System.out.print("是否对该学生的学术交流情况进行评价？（1是/2否）");
                            int cht = sc.nextInt();
                            if (cht == 1) {
                                System.out.print("请输入要并评价的学术交流编号：");
                                ace.setAce_no(sc.next());
                                System.out.print("该学术交流是否有效？（1是/2否）");
                                int chh = sc.nextInt();
                                if (chh == 1)
                                    ace.setAce_effective("是");
                                else ace.setAce_effective("否");
                                kcsj.DAOFactory.getInstance().getaceDAO().updateAce(no, pwd, ace);
                            }
                        }
                        else if (ch1 == 2) {
                            System.out.println("请输入学生学号:");
                            String gra_id = sc.next();
                            SearchCriteria c1 = new SearchCriteria();
                            c1.setKey("gra_id");
                            c1.setOperation("=");
                            c1.setValue("'" + gra_id + "'");
                            List<Projects> t = new ArrayList<>();
                            t = kcsj.DAOFactory.getInstance().getprojectsDAO().findProjects(no, pwd, c1);
                            Iterator<Projects> iterate = t.iterator();
                            System.out.print("该学生的参与项目情况：\n");
                            //使用Iterator的方法访问元素
                            while (iterate.hasNext()) {
                                System.out.print(iterate.next().toString() + "\n");
                            }
                            System.out.print("是否对填报该学生参与项目所折合的经费数量？（1是/2否）");
                            int cht = sc.nextInt();
                            if (cht == 1) {
                                Projects pro = new Projects();
                                System.out.print("请输入项目编号：");
                                pro.setPp_no(sc.next());
                                System.out.print("请输入经费：");
                                pro.setProj_outlay(sc.next());
                                kcsj.DAOFactory.getInstance().getprojectsDAO().updateProjects(no, pwd, pro);
                            }
                        }
                        else if (ch1 == 3)//对于成果的初审认定
                        {
                            System.out.println("请输入学生学号:");
                            String gra_id = sc.next();
                            //获取type
//                            Gra_info gra=new Gra_info();
//                            gra=kcsj.DAOFactory.getInstance().getgraDAO().getGra(no,pwd,gra_id);
                            System.out.println("请输入该学生为 1.硕士研究生/2.博士研究生");
                            int ch = sc.nextInt();
                            if (ch == 2) {
                                phd_achievement phd = new phd_achievement();
                                phd = kcsj.DAOFactory.getInstance().getPhd_achievementDAO().getPhd_achievement(no, pwd, gra_id);
                                System.out.println(phd.toString());
                                while (true) {
                                    System.out.println("对成果进行初审：");
                                    System.out.println("1.审核论文");
                                    System.out.println("2.审核奖励");
                                    System.out.println("3.审核标准");
                                    System.out.println("4.审核其他成果");
                                    System.out.println("5.返回上一级");
                                    System.out.println("请选择：(输入序号)");
                                    int cht = sc.nextInt();
                                    if (cht == 5)
                                        break;
                                    switch (cht) {
                                        case 1: {
                                            if (phd.getThesis_no() != null) {
                                                Thesis thes = kcsj.DAOFactory.getInstance().getThesisDAO().getThesis(no, pwd, phd.getThesis_no());
                                                System.out.println(thes.toString());
                                                System.out.println("初审是否通过？（1通过/2不通过）");
                                                int ch2 = sc.nextInt();
                                                if (ch2 == 1) {
                                                    thes.setThesis_first("通过");
                                                } else thes.setThesis_first("不通过");
                                                kcsj.DAOFactory.getInstance().getThesisDAO().updateThesis(no, pwd, thes, 1);
                                                thes = kcsj.DAOFactory.getInstance().getThesisDAO().getThesis(no, pwd, phd.getThesis_no());
                                                System.out.println(thes.toString());
                                            }
                                            break;
                                        }
                                        case 2:
                                        case 3: {
                                            Thesis thes = kcsj.DAOFactory.getInstance().getThesisDAO().getThesis(no, pwd, phd.getThesis_no());
                                            System.out.println(thes.toString());
                                            System.out.println("初审是否通过？（1通过/2不通过）");
                                            int ch2 = sc.nextInt();
                                            if (ch2 == 1) {
                                                thes.setThesis_first("通过");
                                            } else thes.setThesis_first("不通过");
                                            kcsj.DAOFactory.getInstance().getThesisDAO().updateThesis(no, pwd, thes, 1);
                                            thes = kcsj.DAOFactory.getInstance().getThesisDAO().getThesis(no, pwd, phd.getThesis_no());
                                            System.out.println(thes.toString());
                                            break;
                                        }
                                        case 4: {
                                            phd_other phdo = kcsj.DAOFactory.getInstance().getphd_otherDAO().getphd_other(phd.getOther_no(), no, pwd);
                                            System.out.println(phdo.toString());
                                            System.out.println("初审是否通过？（1通过/2不通过）");
                                            int ch2 = sc.nextInt();
                                            if (ch2 == 1) {
                                                phdo.setOther_first("通过");
                                            } else phdo.setOther_first("不通过");
                                            kcsj.DAOFactory.getInstance().getphd_otherDAO().updatephd_other(phdo, no, pwd, 1);
                                            phdo = kcsj.DAOFactory.getInstance().getphd_otherDAO().getphd_other(phd.getPhd_id(), no, pwd);
                                            System.out.println(phdo.toString());
                                            break;
                                        }
                                        default:
                                            break;
                                    }
                                }
                            } else {
                                Mas_achievement mas = new Mas_achievement();
                                mas = kcsj.DAOFactory.getInstance().getMas_achievementDAO().getMas_achievement(no, pwd, gra_id);
                                System.out.println(mas.toString());
                                while (true) {
                                    System.out.println("对成果进行初审：");
                                    System.out.println("1.审核论文");
                                    System.out.println("2.审核教材");
                                    System.out.println("3.审核标准");
                                    System.out.println("4.审核专利");
                                    System.out.println("5.审核报告");
                                    System.out.println("6.审核软硬件平台开发证明");
                                    System.out.println("7.返回上一级");
                                    System.out.println("请选择：(输入序号)");
                                    int cht = sc.nextInt();
                                    if (cht == 7)
                                        break;
                                    switch (cht) {
                                        case 1://论文
                                        {
                                            if (mas.getThesis_no() != null) {
                                                Thesis thes = kcsj.DAOFactory.getInstance().getThesisDAO().getThesis(no, pwd, mas.getThesis_no());
                                                System.out.println(thes.toString());
                                                System.out.println("初审是否通过？（1通过/2不通过）");
                                                int ch2 = sc.nextInt();
                                                if (ch2 == 1) {
                                                    thes.setThesis_first("通过");
                                                } else thes.setThesis_first("不通过");
                                                kcsj.DAOFactory.getInstance().getThesisDAO().updateThesis(no, pwd, thes, 1);
                                                thes = kcsj.DAOFactory.getInstance().getThesisDAO().getThesis(no, pwd, mas.getThesis_no());
                                                System.out.println(thes.toString());
                                            }
                                            break;
                                        }
                                        case 2://教材
                                        {
                                            if (mas.getBook_no() != null) {
                                                mas_book masb = kcsj.DAOFactory.getInstance().getmas_bookDAO().getmas_book(mas.getBook_no(), no, pwd);
                                                System.out.println(masb.toString());
                                                System.out.println("初审是否通过？（1通过/2不通过）");
                                                int ch2 = sc.nextInt();
                                                if (ch2 == 1) {
                                                    masb.setBook_first("通过");
                                                } else masb.setBook_first("不通过");
                                                kcsj.DAOFactory.getInstance().getmas_bookDAO().updatemas_book(masb, no, pwd, 1);
                                                masb = kcsj.DAOFactory.getInstance().getmas_bookDAO().getmas_book(mas.getBook_no(), no, pwd);
                                                System.out.println(masb.toString());
                                            }
                                            break;
                                        }//标准
                                        case 3:
                                        case 4://专利
                                        {
                                            mas_patent masp = kcsj.DAOFactory.getInstance().getmas_patentDAO().getmas_patent(mas.getPatent_no(), no, pwd);
                                            System.out.println(masp.toString());
                                            System.out.println("初审是否通过？（1通过/2不通过）");
                                            int ch2 = sc.nextInt();
                                            if (ch2 == 1) {
                                                masp.setPatent_first("通过");
                                            } else masp.setPatent_first("不通过");
                                            kcsj.DAOFactory.getInstance().getmas_patentDAO().updatemas_patent(masp, no, pwd, 1);
                                            masp = kcsj.DAOFactory.getInstance().getmas_patentDAO().getmas_patent(mas.getPatent_no(), no, pwd);
                                            System.out.println(masp.toString());
                                            break;
                                        }//报告
                                        case 5: {
                                            mas_report masr = kcsj.DAOFactory.getInstance().getmas_reportDAO().getmas_report(mas.getReport_no(), no, pwd);
                                            System.out.println(masr.toString());
                                            System.out.println("初审是否通过？（1通过/2不通过）");
                                            int ch2 = sc.nextInt();
                                            if (ch2 == 1) {
                                                masr.setReport_first("通过");
                                            } else masr.setReport_first("不通过");
                                            kcsj.DAOFactory.getInstance().getmas_reportDAO().updatemas_report(masr, no, pwd, 1);
                                            masr = kcsj.DAOFactory.getInstance().getmas_reportDAO().getmas_report(mas.getReport_no(), no, pwd);
                                            System.out.println(masr.toString());
                                            break;
                                        }
                                        case 6://软硬件平台开发证明
                                        {
                                            mas_soft_hard mass = kcsj.DAOFactory.getInstance().getmas_soft_hardDAO().getmas_soft_hard(mas.getSoft_hard_no(), no, pwd);
                                            System.out.println(mass.toString());
                                            System.out.println("初审是否通过？（1通过/2不通过）");
                                            int ch2 = sc.nextInt();
                                            if (ch2 == 1) {
                                                mass.setSoft_hard_first("通过");
                                            } else mass.setSoft_hard_first("不通过");
                                            kcsj.DAOFactory.getInstance().getmas_soft_hardDAO().updatemas_soft_hard(mass, no, pwd, 1);
                                            mass = kcsj.DAOFactory.getInstance().getmas_soft_hardDAO().getmas_soft_hard(mas.getSoft_hard_no(), no, pwd);
                                            System.out.println(mass.toString());
                                            break;
                                        }
                                        default:
                                            break;
                                    }
                                }
                            }
                        }
                        else if(ch1==4)
                            break;
                    }

                }
                else System.out.println("账号或密码错误，登录失败！");
            }
            else if (ch0 == 4) {
                //验证用户名密码，并确认用户是否为硕士研究生
                String name = DAOFactory.getInstance().getgraDAO().checkSnoAndPwd(no, pwd, "1");
                if (name != null) {
                    System.out.println(name + " " + "同学您好，您已成功登录系统");
                    //在学术交流后，填报个人学术交流情况，填报内容涵盖《研究生学术交流统计表》（简称统计表），提交导师审核。
                    //按助教管理要求，进入系统，从助教课程列表中选自指定数量的候选课程。
                    //提供满足毕业成果认定标准的成果及佐证材料
                    while (true) {
                        System.out.println("----------------------");
                        System.out.println("1.填报学术交流活动");
                        System.out.println("2.查看我的学术交流活动");
                        System.out.println("3.填报助教认定信息");
                        System.out.println("4.查看研究生成果认定信息");
                        System.out.println("5.提交论文认定");
                        System.out.println("6.提交标准认定");
                        System.out.println("7.提交教材认定");
                        System.out.println("8.提交专利认定");
                        System.out.println("9.提交报告认定");
                        System.out.println("10.提交软硬件平台认定");
                        System.out.println("11.返回上一级");
                        System.out.println("请选择：(输入序号数字)");
                        int ch4 = 3;
                        try {
                            ch4 = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("请输入正确的数字序号！");
                            sc = new Scanner(System.in);
                            continue;
                        }
                        if (ch4 == 1) {
                            Academic_exchange academic_exchange = new Academic_exchange();
                            System.out.println("请输入活动编号:");
                            academic_exchange.setAce_no(sc.next());
                            System.out.println("请输入学号:");
                            academic_exchange.setGra_id(sc.next());
                            System.out.println("请输入活动名称:");
                            academic_exchange.setAce_name(sc.next());
                            System.out.println("请输入活动地点:");
                            academic_exchange.setAce_place(sc.next());
                            System.out.println("请输入活动时间:");
                            academic_exchange.setAce_date(sc.next());
                            System.out.println("请输入报告名（中文）:");
                            academic_exchange.setAce_CHname(sc.next());
                            System.out.println("请输入报告名（英文）:");
                            sc = new Scanner(System.in);
                            academic_exchange.setAce_ENname(sc.nextLine());
                            System.out.println("请输入证明材料url:");
                            sc = new Scanner(System.in);
                            InputStream input = new FileInputStream(sc.next()); //这里可以添加本地数据
                            academic_exchange.setAce_pic(input.readAllBytes());
                            System.out.println("请输入备注信息:");
                            sc = new Scanner(System.in);
                            academic_exchange.setAce_note(sc.next());
                            DAOFactory.getInstance().getaceDAO().addAce(no, pwd, academic_exchange);
                        } else if (ch4 == 2) {
                            Academic_exchange academic_exchange = new Academic_exchange();
                            List<Academic_exchange> list = new ArrayList<>();
                            SearchCriteria se = new SearchCriteria();
                            se.setKey("gra_id");
                            se.setOperation("=");
                            se.setValue("'"+no+"'");
                            list=DAOFactory.getInstance().getaceDAO().findAce(no,pwd,se);
                            Iterator<Academic_exchange> iterate1 = list.iterator();
                            System.out.print("学术交流查询结果：\n");
                            //使用Iterator的方法访问元素
                            while (iterate1.hasNext()) {
                                System.out.print(iterate1.next().toString() + "\n");
                            }
                        } else if (ch4 == 3) {
                            assistant_evaluate assistant_evaluate = new assistant_evaluate();
                            System.out.println("请输入评定表编号:");
                            assistant_evaluate.setAe_no(sc.next());
                            System.out.println("请输入学号:");
                            assistant_evaluate.setGra_id(sc.next());
                            System.out.println("请输入课程编号:");
                            assistant_evaluate.setCrs_no(sc.next());
                            System.out.println("请输入授课人数:");
                            assistant_evaluate.setStu_num(sc.nextInt());
                            System.out.println("请输入课程性质（1必修，2选修）:");
                            assistant_evaluate.setCrs_nat(sc.nextInt());
                            System.out.println("请输入授课对象（1本科，2研究生）:");
                            assistant_evaluate.setCrs_stu(sc.nextInt());
                            System.out.println("请输入授课教师ID:");
                            assistant_evaluate.setTea_id(sc.next());
                            System.out.println("请输入授课时间:");
                            assistant_evaluate.setAss_time(sc.next());
                            System.out.println("请输入工作自述:");
                            assistant_evaluate.setSelf_eva(sc.next());
                            DAOFactory.getInstance().getAssistDAO().addAssist(no, pwd, assistant_evaluate);
                        } else if (ch4 == 4) {
                            Mas_achievement mas_achievement = new Mas_achievement();
                            mas_achievement.setMas_id(no);
                            DAOFactory.getInstance().getMas_achievementDAO().getMas_achievement( no, pwd, mas_achievement.getMas_id());
                        } else if (ch4 == 5) {
                            Thesis thesis = new Thesis();
                            System.out.println("请输入论文表编号：");
                            thesis.setThesis_no(sc.next());
                            System.out.println("请输入论文标题：");
                            thesis.setThesis_name(sc.next());
                            System.out.println("请输入论文刊物：");
                            thesis.setThesis_pub(sc.next());
                            System.out.println("请输入论文状态(未发表为0，录用为1，已发表2)：");
                            thesis.setThesis_state(sc.next());
                            System.out.println("请输入发表时间：");
                            thesis.setThesis_date(sc.next());
                            System.out.println("请输入索引类型：");
                            thesis.setThesis_index(sc.next());
                            System.out.println("请输入论文归属库：");
                            thesis.setThesis_bel(sc.next());
                            System.out.println("请提交论文扫描图片：");
                            sc = new Scanner(System.in);
                            InputStream input = new FileInputStream(sc.next()); //这里可以添加本地数据
                            thesis.setThesis_scan(input.readAllBytes());
//                            System.out.println("请提交论文：");
//                            sc = new Scanner(System.in);
//                            input = new FileInputStream(sc.next()); //这里可以添加本地数据
//                            thesis.setThesis_pdf(input.readAllBytes());
                            DAOFactory.getInstance().getThesisDAO().addThesis(no, pwd, thesis);
                        } else if (ch4 == 6) {
                            Standard standard = new Standard();
                            System.out.println("请输入标准表编号：");
                            standard.setStandard_no(sc.next());
                            System.out.println("请输入标准名称：");
                            standard.setStandard_name(sc.next());
                            System.out.println("请输入标准级别：");
                            standard.setStandard_rank(sc.next());
                            System.out.println("请输入标准发布时间：");
                            standard.setStandard_date(sc.next());
//                            System.out.println("请提交标准佐证材料：");
//                            sc = new Scanner(System.in);
//                            InputStream input = new FileInputStream(sc.next()); //这里可以添加本地数据
//                            standard.setStandard_identity(input.readAllBytes());
                            DAOFactory.getInstance().getStandardDAO().addStandard(no, pwd, standard);
                        } else if (ch4 == 7) {
                            mas_book mas_book = new mas_book();
                            System.out.println("请输入教材编号：");
                            mas_book.setBook_no(sc.next());
                            System.out.println("请输入教材名称：");
                            mas_book.setBook_name(sc.next());
                            System.out.println("请输入教材出版社：");
                            mas_book.setBook_publisher(sc.next());
                            System.out.println("请输入教材出版时间：");
                            mas_book.setBook_date(sc.next());
                            System.out.println("请输入教材贡献度：");
                            mas_book.setBook_distribute(sc.nextInt());
//                            System.out.println("请提交佐证材料：");
//                            sc = new Scanner(System.in);
//                            InputStream input = new FileInputStream(sc.next()); //这里可以添加本地数据
//                            mas_book.setBook_identity(input.readAllBytes());
                            DAOFactory.getInstance().getmas_bookDAO().addmas_book(mas_book, no, pwd);
                        } else if (ch4 == 8) {
                            mas_patent mas_patent = new mas_patent();
                            System.out.println("请输入专利表编号：");
                            mas_patent.setPatent_no(sc.next());
                            System.out.println("请输入专利名称：");
                            mas_patent.setPatent_name(sc.next());
                            System.out.println("请输入专利类型：");
                            mas_patent.setPatent_type(sc.next());
                            System.out.println("请输入专利状态(未发表为0，录用为1，已发表2)：");
                            mas_patent.setPatent_state(sc.nextInt());
                            System.out.println("请输入发表时间：");
                            mas_patent.setPatent_time(sc.next());
                            System.out.println("请输入专利贡献度：");
                            mas_patent.setPatent_con(sc.nextInt());
//                            System.out.println("请提交证明材料：");
//                            sc = new Scanner(System.in);
//                            InputStream input = new FileInputStream(sc.next()); //这里可以添加本地数据
//                            mas_patent.setPatent_identity(input.readAllBytes());
                            DAOFactory.getInstance().getmas_patentDAO().addmas_patent(mas_patent, no, pwd);
                        } else if (ch4 == 9) {
                            mas_report mas_report = new mas_report();
                            System.out.println("请输入报告表编号：");
                            mas_report.setReport_no(sc.next());
                            System.out.println("请输入报告名称：");
                            mas_report.setReport_name(sc.next());
                            System.out.println("请输入报告类型：");
                            mas_report.setReport_type(sc.next());
                            System.out.println("请输入报告服务单位：");
                            mas_report.setReport_unit(sc.next());
                            System.out.println("请输入报告时间：");
                            mas_report.setReport_date(sc.next());
                            System.out.println("请输入报告贡献度：");
                            mas_report.setReport_con(sc.nextInt());
//                            System.out.println("请提交证明材料：");
//                            sc = new Scanner(System.in);
//                            InputStream input = new FileInputStream(sc.next()); //这里可以添加本地数据
//                            mas_report.setReport_identity(input.readAllBytes());
                            DAOFactory.getInstance().getmas_reportDAO().addmas_report(mas_report, no, pwd);
                        } else if (ch4 == 10) {
                            mas_soft_hard mas_soft_hard = new mas_soft_hard();
                            System.out.println("请输入平台表编号：");
                            mas_soft_hard.setSoft_hard_no(sc.next());
                            System.out.println("请输入平台名称：");
                            mas_soft_hard.setSoft_hard_name(sc.next());
                            System.out.println("请输入平台服务单位：");
                            mas_soft_hard.setSoft_hard_unit(sc.next());
                            System.out.println("请输入平台上线时间：");
                            mas_soft_hard.setSoft_hard_date(sc.next());
                            System.out.println("请输入平台贡献度：");
                            mas_soft_hard.setSoft_hard_con(sc.nextInt());
//                            System.out.println("请提交证明材料：");
//                            sc = new Scanner(System.in);
//                            InputStream input = new FileInputStream(sc.next()); //这里可以添加本地数据
//                            mas_soft_hard.setSoft_hard_identity(input.readAllBytes());
                            DAOFactory.getInstance().getmas_soft_hardDAO().addmas_soft_hard(mas_soft_hard, no, pwd);
                        } else
                            break;
                    }
                }
            }
            else if(ch0==5) {
                //验证用户名密码，并确认用户是否为硕士研究生
                String name = DAOFactory.getInstance().getgraDAO().checkSnoAndPwd(no, pwd, "2");
                if (name != null) {
                    System.out.println(name + " " + "同学您好，您已成功登录系统");

                    //在学术交流后，填报个人学术交流情况，填报内容涵盖《研究生学术交流统计表》（简称统计表），提交导师审核。
                    //按助教管理要求，进入系统，从助教课程列表中选自指定数量的候选课程。
                    //提供满足毕业成果认定标准的成果及佐证材料
                    while (true) {
                        System.out.println("----------------------");
                        System.out.println("1.填报学术交流活动");
                        System.out.println("2.查看我的学术交流活动");
                        System.out.println("3.填报助教认定信息");
                        System.out.println("4.查看研究生成果认定信息");
                        System.out.println("5.提交论文认定");
                        System.out.println("6.提交奖励认定");
                        System.out.println("7.提交标准认定");
                        System.out.println("8.提交其他成果认定");
                        System.out.println("9.返回上一级");
                        System.out.println("请选择：(输入序号数字)");
                        int ch5 = 3;
                        try {
                            ch5 = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("请输入正确的数字序号！");
                            sc = new Scanner(System.in);
                            continue;
                        }
                        if (ch5 == 1) {
                            Academic_exchange academic_exchange = new Academic_exchange();
                            System.out.println("请输入活动编号:");
                            academic_exchange.setAce_no(sc.next());
                            System.out.println("请输入学号:");
                            academic_exchange.setGra_id(sc.next());
                            System.out.println("请输入活动名称:");
                            academic_exchange.setAce_name(sc.next());
                            System.out.println("请输入活动地点:");
                            academic_exchange.setAce_place(sc.next());
                            System.out.println("请输入活动时间:");
                            academic_exchange.setAce_date(sc.next());
                            System.out.println("请输入报告名（中文）:");
                            academic_exchange.setAce_CHname(sc.next());
                            System.out.println("请输入报告名（英文）:");
                            sc = new Scanner(System.in);
                            academic_exchange.setAce_ENname(sc.nextLine());
//                            System.out.println("请输入证明材料url:");
//                            sc = new Scanner(System.in);
//                            InputStream input = new FileInputStream(sc.next()); //这里可以添加本地数据
//                            academic_exchange.setAce_pic(input.readAllBytes());
                            System.out.println("请输入备注信息:");
                            sc = new Scanner(System.in);
                            academic_exchange.setAce_note(sc.next());
                            DAOFactory.getInstance().getaceDAO().addAce(no, pwd, academic_exchange);
                        } else if (ch5 == 2)
                        {
                            Academic_exchange academic_exchange = new Academic_exchange();
                            List<Academic_exchange> list = new ArrayList<>();
                            SearchCriteria se = new SearchCriteria();
                            se.setKey("gra_id");
                            se.setOperation("=");
                            se.setValue("'"+no+"'");
                            list=DAOFactory.getInstance().getaceDAO().findAce(no,pwd,se);
                            Iterator<Academic_exchange> iterate1 = list.iterator();
                            System.out.print("学术交流查询结果：\n");
                            //使用Iterator的方法访问元素
                            while (iterate1.hasNext()) {
                                System.out.print(iterate1.next().toString() + "\n");
                            }
                        } else if (ch5 == 3) {
                            assistant_evaluate assistant_evaluate = new assistant_evaluate();
                            System.out.println("请输入评定表编号:");
                            assistant_evaluate.setAe_no(sc.next());
                            System.out.println("请输入学号:");
                            assistant_evaluate.setGra_id(sc.next());
                            System.out.println("请输入课程编号:");
                            assistant_evaluate.setCrs_no(sc.next());
                            System.out.println("请输入授课人数:");
                            assistant_evaluate.setStu_num(sc.nextInt());
                            System.out.println("请输入课程性质（1必修，2选修）:");
                            assistant_evaluate.setCrs_nat(sc.nextInt());
                            System.out.println("请输入授课对象（1本科，2研究生）:");
                            assistant_evaluate.setCrs_stu(sc.nextInt());
                            System.out.println("请输入授课教师ID:");
                            assistant_evaluate.setTea_id(sc.next());
                            System.out.println("请输入授课时间:");
                            assistant_evaluate.setAss_time(sc.next());
                            System.out.println("请输入工作自述:");
                            assistant_evaluate.setSelf_eva(sc.next());
                            DAOFactory.getInstance().getAssistDAO().addAssist(no, pwd, assistant_evaluate);
                        } else if (ch5 == 4) {
                            phd_achievement phd_achievement = new phd_achievement();
                            phd_achievement.setPhd_id(no);
                            DAOFactory.getInstance().getPhd_achievementDAO().getPhd_achievement(no, pwd,phd_achievement.getPhd_id());
                        } else if (ch5 == 5) {
                            Thesis thesis = new Thesis();
                            System.out.println("请输入论文表编号：");
                            thesis.setThesis_no(sc.next());
                            System.out.println("请输入论文标题：");
                            thesis.setThesis_name(sc.next());
                            System.out.println("请输入论文刊物：");
                            thesis.setThesis_pub(sc.next());
                            System.out.println("请输入论文状态(未发表为0，录用为1，已发表2)：");
                            thesis.setThesis_state(sc.next());
                            System.out.println("请输入发表时间：");
                            thesis.setThesis_date(sc.next());
                            System.out.println("请输入索引类型：");
                            thesis.setThesis_index(sc.next());
                            System.out.println("请输入论文归属库：");
                            thesis.setThesis_bel(sc.next());
                            System.out.println("请提交论文扫描图片(本地url)：");
                            sc = new Scanner(System.in);
                            InputStream input = new FileInputStream(sc.next()); //这里可以添加本地数据
                            thesis.setThesis_scan(input.readAllBytes());
//                            System.out.println("请提交论文：");
//                            sc = new Scanner(System.in);
//                            input = new FileInputStream(sc.next()); //这里可以添加本地数据
//                            thesis.setThesis_pdf(input.readAllBytes());
                            DAOFactory.getInstance().getThesisDAO().addThesis(no, pwd, thesis);
                        } else if (ch5 == 6) {
                            Phd_reward phd_reward = new Phd_reward();
                            System.out.println("请输入奖励表编号：");
                            phd_reward.setReward_no(sc.next());
                            System.out.println("请输入奖励名称：");
                            phd_reward.setReward_name(sc.next());
                            System.out.println("请输入奖励级别：");
                            phd_reward.setReward_rank(sc.next());
                            System.out.println("请输入获奖等级：");
                            phd_reward.setReward_score(sc.next());
                            System.out.println("请输入获奖排名：");
                            phd_reward.setReward_order(sc.next());
                            System.out.println("请输入获奖时间：");
                            phd_reward.setReward_date(sc.next());
//                            System.out.println("请提交证明材料：");
//                            sc = new Scanner(System.in);
//                            InputStream input = new FileInputStream(sc.next()); //这里可以添加本地数据
//                            phd_reward.setReward_identity(input.readAllBytes());
                            DAOFactory.getInstance().getPhd_rewardDAO().addPhd_reward(phd_reward, no, pwd);
                        } else if (ch5 == 7) {
                            Standard standard = new Standard();
                            System.out.println("请输入标准表编号：");
                            standard.setStandard_no(sc.next());
                            System.out.println("请输入标准名称：");
                            standard.setStandard_name(sc.next());
                            System.out.println("请输入标准级别：");
                            standard.setStandard_rank(sc.next());
                            System.out.println("请输入标准发布时间：");
                            standard.setStandard_date(sc.next());
//                            System.out.println("请提交标准佐证材料：");
//                            sc = new Scanner(System.in);
//                            InputStream input = new FileInputStream(sc.next()); //这里可以添加本地数据
//                            standard.setStandard_identity(input.readAllBytes());
                            DAOFactory.getInstance().getStandardDAO().addStandard(no, pwd, standard);
                        } else if (ch5 == 8) {
                            phd_other phd_other = new phd_other();
                            System.out.println("请输入其他成果编号：");
                            phd_other.setOther_no(sc.next());
                            System.out.println("请输入其他成果名称：");
                            phd_other.setOther_name(sc.next());
                            System.out.println("请输入其他成果级别：");
                            phd_other.setOther_rank(sc.next());
                            System.out.println("请输入其他成果发布时间：");
                            phd_other.setOther_date(sc.next());
//                            System.out.println("请提交证明材料：");
//                            sc = new Scanner(System.in);
//                            InputStream input = new FileInputStream(sc.next()); //这里可以添加本地数据
//                            phd_other.setOther_identity(input.readAllBytes());
                            DAOFactory.getInstance().getphd_otherDAO().addphd_other(phd_other,no,pwd);
                        } else
                            break;
                    }
                }
            }
            else break;
        }
    }
}