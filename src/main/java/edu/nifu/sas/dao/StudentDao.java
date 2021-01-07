package edu.nifu.sas.dao;

import edu.nifu.sas.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    List<Student>getAllStudent() throws SQLException;
    List<Student> getStudentByName(String name);
    boolean saveStudent(Student s);
    public Student getStudentByNo(String stuno);
    boolean updateStudent(Student s);
    boolean deleteStudent(Student s);
    List<Student> getStudentByPaging(int currentPage,int pageSize);
    long totalRecords() throws SQLException;

}
