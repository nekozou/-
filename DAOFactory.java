package kcsj;

import kcsj.dao.*;
import kcsj.dao.Impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    static {
        daoFactory = new DAOFactory();
    }
    private DAOFactory(){
    }

    public static DAOFactory getInstance(){
        return daoFactory;
    }

    public phd_achievementDAO getPhd_achievementDAO(){
        return new phd_achievementDAOImpl();
    }

    public Mas_achievementDAO getMas_achievementDAO(){
        return new Mas_achievementDAOImpl();
    }

    public ThesisDAO getThesisDAO(){
        return new ThesisDAOImpl();
    }

    public Phd_rewardDAO getPhd_rewardDAO() { return new Phd_rewardDAOImpl(); }
    public StandardDAO getStandardDAO() { return new StandardDAOImpl(); }

    public mas_bookDAO getmas_bookDAO() { return new mas_bookDAOImpl(); }

    public mas_patentDAO getmas_patentDAO() { return new mas_patentDAOImpl(); }

    public mas_reportDAO getmas_reportDAO() { return new mas_reportDAOImpl(); }

    public mas_soft_hardDAO getmas_soft_hardDAO() { return new mas_soft_hardDAOImpl(); }

    public phd_otherDAO getphd_otherDAO() { return new phd_otherDAOImpl(); }

    public TeacherDAO getteacherDAO(){
        return new TeacherDaoImpl();
    }

    public ProjectsDAO getprojectsDAO(){
        return new ProjectsDAOImpl();
    }

    public AceDAO getaceDAO() { return new AceDAOImpl();}

    public AssistDaO getAssistDAO(){return new assistDAOimpl();}

    public GraDAO getgraDAO(){return new GraDAOImpl();}

    public CourseDAO getcourseDAO(){return new CourseDaoImpl();}
    public ManagerDAO getmanagerDAO(){return new ManagerDAOImpl();}
}
