package kcsj.dao;

import kcsj.domain.Gra_info;

public interface GraDAO {
    public String checkSnoAndPwd(String no,String pwd,String type);

    void addGra(String no,String pwd,Gra_info gra_info);//添加
    void updateGra(String no,String pwd,Gra_info gra_info);//更新
    void deleteGra(String no,String pwd,String gra_id);      //删除
    Gra_info getGra(String no,String pwd,String gra_id);       //查询
}
