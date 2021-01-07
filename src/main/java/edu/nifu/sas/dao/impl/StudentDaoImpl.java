package edu.nifu.sas.dao.impl;

import edu.nifu.sas.dao.StudentDao;
import edu.nifu.sas.model.Student;
import edu.nifu.sas.util.DBHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> getAllStudent() {
        String sql="select *from tbl_student";
        DBHelper db=new DBHelper();

        List<Object> result = db.query(sql, null);
        List<Student> students=new ArrayList<>();
        for(Object o:result){
            Map map=(Map)o;
            students.add(
                    new Student(
                            (String)map.get("stuno"),
                            (String)map.get("stuname"),
                            (String)map.get("classes"),
                            (String)map.get("gender"),
                            (String)map.get("department"),
                            (String)map.get("tel"),
                            (String)map.get("dormno"),
                            (String)map.get("photopath")

                    )
            );
        }
        return students;
    }

    @Override
    public List<Student> getStudentByName(String name) {
        String sql="select * from tbl_student where stuname like ?";
        DBHelper db=new DBHelper();
        List<Object> params=new ArrayList<>();
        params.add('%'+name+'%');
        List<Object> result=db.query(sql,params);
        List<Student> students=new ArrayList<>();
        for(Object o:result){
            Map map=(Map)o;
            students.add(
                    new Student(
                            (String)map.get("stuno"),
                            (String)map.get("stuname"),
                            (String)map.get("classes"),
                            (String)map.get("gender"),
                            (String)map.get("department"),
                            (String)map.get("tel"),
                            (String)map.get("dormno"),
                            (String)map.get("photopath")

                    )
            );
        }
        return students;
    }

    @Override
    public boolean saveStudent(Student s) {
        String sql="insert into tbl_student(stuno,stuname,classes,gender,department,tel,dormno,photopath) values(?,?,?,?,?,?,?,?)";
        DBHelper db=new DBHelper();
        List<Object> params=new ArrayList<>();
        params.add(s.getStuNo());
        params.add(s.getStuName());
        params.add(s.getClasses());
        params.add(s.getGender());
        params.add(s.getDepartment());
        params.add(s.getTel());
        params.add(s.getDormNo());
        params.add(s.getPhotoPath());
        int result=db.update(sql,params);
        return result>0;
    }

    public boolean updateStudent(Student s) {
        String sql="update tbl_student set stuname=?,classes=?,gender=?,department=?,tel=?,dormno=?   where stuno='"+s.getStuNo()+"'";
        DBHelper db=new DBHelper();
        List<Object> params=new ArrayList<>();
        // params.add(s.getStuNO());
        params.add(s.getStuName());
        params.add(s.getClasses());
        params.add(s.getGender());
        params.add(s.getDepartment());
        params.add(s.getTel());
        params.add(s.getDormNo());
        int result=db.update(sql,params);
        return result>0;
    }

    @Override
    public boolean deleteStudent(Student s) {
        String sql="delete from tbl_student where stuno='"+s.getStuNo()+"'";
        DBHelper db=new DBHelper();
//        List<Object> params=new ArrayList<>();
//        params.add(s.getStuNo());
        int result=db.update(sql);

        return result>0;
    }

    @Override
    public List<Student> getStudentByPaging(int currentPage, int pageSize) {
        String sql="select * from tbl_student where stuno limit ?,?";
        int start=(currentPage-1)*pageSize;
        DBHelper dbHelper=new DBHelper();
        List<Object> params=new ArrayList<>();
        params.add(start);
        params.add(pageSize);
        List<Object> result = dbHelper.query(sql,params);
        List<Student> students=new ArrayList<>();
        for(Object o:result){
            Map map=(Map)o;
            students.add(
                    new Student(
                            (String)map.get("stuno"),
                            (String)map.get("stuname"),
                            (String)map.get("classes"),
                            (String)map.get("gender"),
                            (String)map.get("department"),
                            (String)map.get("tel"),
                            (String)map.get("dormno"),
                            (String)map.get("photopath")
                    )
            );
        }
        return students;
    }

    @Override
    public long totalRecords() {
        String sql="select count(*) as nums from tbl_student ";
        DBHelper dbHelper=new DBHelper();
        List<Object> query=dbHelper.query(sql,null);
        return (Long)((Map)query.get(0)).get("nums");
    }

    public Student getStudentByNo(String stuno) {
        String sql="select * from tbl_student where stuno='"+stuno+"'";
        List<Object> query=new DBHelper().query(sql,null);
        Map map=(Map)query.get(0);
        return new Student(
                (String)map.get("stuno"),
                (String)map.get("stuname"),
                (String)map.get("classes"),
                (String)map.get("gender"),
                (String)map.get("department"),
                (String)map.get("tel"),
                (String)map.get("dormno"),
                (String)map.get("photopath")
        );
    }
}
