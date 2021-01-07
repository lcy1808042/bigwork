package edu.nifu.sas.dao;

import edu.nifu.sas.model.User;
import edu.nifu.sas.util.C3p0Util;
import edu.nifu.sas.util.DBHelper;
import edu.nifu.sas.util.Md5Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDao {
    //User对象 的增删改查

    public boolean checkLogin(User user){

        String sql="select count(*) as count from tbl_user where username=? and password=?";
//        //把占位符的值放入list中
//        List<Object> params=new ArrayList<Object>();
//        //Object 是一个map对象
//        params.add(user.getUsername());
//        //把明文转换为密文
//        String encryptPassword= Md5Util.stringToMD5(user.getPassword());
//        params.add(user.getPassword());
//        //创建DBHelper
//        DBHelper deHelper=new DBHelper();
//        List<Object> query = deHelper.query(sql, params);
//        //System.out.println(query);
//        //return true;
        long count=0;
        QueryRunner query = new QueryRunner(C3p0Util.getConnection());
        try {
            Map<String, Object> map = query.query(sql, new MapHandler(), new Object[]{user.getUserName(), user.getPassword()});
            count=(long)map.get("count");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return count>0;
    }

    public boolean saveUser(User u){
        String sql="insert into tbl_user (username,password)values(?,?)";
        //对占位符进行赋值，保存到list
//        List<Object> params=new ArrayList<>();
//        params.add(u.getUserName());
//        params.add(Md5Util.stringToMD5(u.getPassword()));
//        //创建DBHelper
//        DBHelper db = new DBHelper();
//        int result=db.update(sql,params);
        int result=0;
        QueryRunner query = new QueryRunner(C3p0Util.getConnection());

        try {
            result = query.execute(sql, new Object[]{u.getUserName(), u.getPassword()});

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result>0;

    }

    boolean updateStuno(String no){
        return false;
    }

}
