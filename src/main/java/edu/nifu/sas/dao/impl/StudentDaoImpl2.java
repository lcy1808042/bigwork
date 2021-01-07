package edu.nifu.sas.dao.impl;

import edu.nifu.sas.dao.StudentDao;
import edu.nifu.sas.model.Student;
import edu.nifu.sas.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl2 implements StudentDao {

    private QueryRunner queryRunner=null;

    @Override
    public List<Student> getAllStudent() throws SQLException {
        String sql="select *from tbl_student";
        queryRunner = new QueryRunner(C3p0Util.getConnection());
        List<Student> students = queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
        return students;
    }

    @Override
    public List<Student> getStudentByName(String name){
        String sql="select * from tbl_student where stuname like ?";
        queryRunner =new QueryRunner(C3p0Util.getConnection());
        List<Object> params=new ArrayList<>();
        params.add('%'+name+'%');
        try {
            List<Student>students=queryRunner.query(sql,new BeanListHandler<Student>(Student.class),params);
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;

    }

    @Override
    public boolean saveStudent(Student s) {


        return false;
    }

    @Override
    public Student getStudentByNo(String stuno) {
        return null;
    }

    @Override
    public boolean updateStudent(Student s) {
        return false;
    }

    @Override
    public boolean deleteStudent(Student s) {
        return false;
    }

    @Override
    public List<Student> getStudentByPaging(int currentPage, int pageSize) {
        String sql="select *from tbl_student where stuno limit ?,?";
        int start=(currentPage-1)*pageSize;
        /*
        * 如何才能将ResultSet转换位bean
        * 1，java reflect，Student.class动态创建Student对象，动态获方法
        * 2，jdbc meta,获取表的字段名称
        * 3，根据字段名称，来调用Student的Setter方法
        *
        * */
        queryRunner=new QueryRunner(C3p0Util.getConnection());
        try {
            List<Student> students=queryRunner.query(sql,new BeanListHandler<Student>(Student.class),new Object[]{start,pageSize});
            return  students;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long totalRecords(){
        String sql="select count(*) as count from tbl_student";
        queryRunner = new QueryRunner(C3p0Util.getConnection());
        try {
            List<Map<String, Object>> query = queryRunner.query(sql, new MapListHandler());
            return (Long) query.get(0).get("count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
