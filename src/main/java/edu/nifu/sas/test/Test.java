package edu.nifu.sas.test;

import com.google.gson.Gson;
import edu.nifu.sas.dao.UserDao;
import edu.nifu.sas.dao.impl.StudentDaoImpl;
import edu.nifu.sas.dao.impl.StudentDaoImpl2;
import edu.nifu.sas.model.Student;
import edu.nifu.sas.model.User;
import edu.nifu.sas.util.C3p0Util;
import edu.nifu.sas.util.DbcpUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class Test {

    public static void main(String[] args) throws IOException, SQLException {
        //System.out.println(new StudentDaoImpl().getAllStudent());
        //Student ssdf=new Student("1101","ssdf");
//        Gson gson = new Gson();
//        //对象转为json
//        String jsonStr = gson.toJson(new StudentDaoImpl().getAllStudent());
//        System.out.println(jsonStr);

//        Properties properties=new Properties();
//        InputStream in = new Test().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
//        properties.load(in);
//
//        System.out.println(properties.getProperty("url"));
        //properties.setProperty("username2","123456");
        //System.out.println(properties.getProperty("username2"));

//        System.out.println(DbcpUtil.getDataSource()==null);
//
//        System.out.println(DbcpUtil.getDataSource().getConnection() == null);
//        System.out.println(C3p0Util.getConnection().getConnection() == null);
          //System.out.println(new StudentDaoImpl2().getAllStudent());
          System.out.println(new StudentDaoImpl2().totalRecords());
        Student student = new Student("110","xy");
        System.out.println(new StudentDaoImpl().deleteStudent(student));
        //System.out.println(new StudentDaoImpl().getStudentByName("刘"));
//        System.out.println(calc(10));
//
//        UserDao dao = new UserDao();
//        User u=new User("zhangsan2","123456");
//        System.out.println(dao.checkLogin(u));


    }
//    public static int calc(int n){
//        for(int i=0;i<n;i++){
//            return i;
//        }
//        return -1;
//    }

}
