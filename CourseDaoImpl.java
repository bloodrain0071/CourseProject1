package az.orient.course.dao;

import az.orient.course.model.AdvancedSearch;
import az.orient.course.model.Lesson;
import az.orient.course.model.Student;
import az.orient.course.model.Teacher;
import az.orient.course.util.JdbcUtility;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 3/11/17
 * Time: 5:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class CourseDaoImpl implements CourseDao {


    @Override
    public List<Student> getStudentList() throws Exception {
        List<Student> studentList = new ArrayList<Student>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,S.ID,S.NAME STUDENT_NAME,S.SURNAME STUDENT_SURNAME,S.ADDRESS,S.DOB , T.NAME TEACHER_NAME\n" +
                ",T.SURNAME TEACHER_SURNAME FROM STUDENT S \n" +
                "INNER JOIN TEACHER T ON S.TEACHER_ID = T.ID\n" +
                "WHERE S.ACTIVE = 1";
        try {
           c = DBHelper.getConnection();
            if (c != null) {
                 ps = c.prepareStatement(sql);
                 rs = ps.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setR(rs.getLong("r"));
                    student.setId(rs.getLong("ID"));
                    student.setName(rs.getString("STUDENT_NAME"));
                    student.setSurname(rs.getString("STUDENT_SURNAME"));
                    student.setAddress(rs.getString("ADDRESS"));
                    student.setDob(rs.getDate("DOB"));
                    student.setTeacherName(rs.getString("TEACHER_NAME"));
                    student.setTeacherSurname(rs.getString("TEACHER_SURNAME"));
                    studentList.add(student);
                }
            } else {
                System.out.println("Connection is null!");
            }
        }  catch (Exception ex) {
            ex.printStackTrace();
        }  finally {
            JdbcUtility.close(c,ps,rs);
        }
        return studentList;
    }

    @Override
    public List<Teacher> getTeacherList() throws Exception {
        List<Teacher> teacherList = new ArrayList<Teacher>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ID,NAME,SURNAME,ADDRESS,DOB FROM TEACHER WHERE ACTIVE = 1";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Teacher teacher = new Teacher();
                    teacher.setId(rs.getLong("ID"));
                    teacher.setName(rs.getString("NAME"));
                    teacher.setSurname(rs.getString("SURNAME"));
                    teacher.setAddress(rs.getString("ADDRESS"));
                    teacher.setDob(rs.getDate("DOB"));

                    teacherList.add(teacher);
                }
            } else {
                System.out.println("Connection is null!");
            }
        }  catch (Exception ex) {
            ex.printStackTrace();
        }  finally {
            JdbcUtility.close(c,ps,rs);
        }
        return teacherList;
    }

    @Override
    public void addStudent(Student student) throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO STUDENT(ID,NAME,SURNAME,DOB,ADDRESS,TEACHER_ID)\n" +
                " VALUES(STUDENT_SEQ.NEXTVAL,?,?,?,?,?) ";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
               ps = c.prepareStatement(sql);
               ps.setString(1,student.getName());
               ps.setString(2,student.getSurname());
               ps.setDate(3, new Date(student.getDob().getTime()));
               ps.setString(4,student.getAddress());
               ps.setLong(5,student.getTeacherId());
               ps.execute();

            }   else {
                System.out.println("Connection is null!");
            }


        }  catch (Exception ex) {
            ex.printStackTrace();
        }  finally {
            c.commit();
            JdbcUtility.close(c,ps,null);
        }

    }

    @Override
    public void deleteStudent(long studentId) throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE STUDENT SET ACTIVE = 0 WHERE ID = ?";
        try {
             c = DBHelper.getConnection();
            if (c != null) {
                   ps = c.prepareStatement(sql);
                   ps.setLong(1,studentId);
                   ps.executeUpdate();
            }  else {
                System.out.println("Connection is null!!!");
            }
        }   catch (Exception ex) {
              ex.printStackTrace();
        }   finally {
            c.commit();
            JdbcUtility.close(c,ps,null);
        }

    }

    @Override
    public Student getStudentById(long studentId) throws Exception {
        Student student = new Student();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT S.ID,S.NAME STUDENT_NAME,S.SURNAME STUDENT_SURNAME,S.ADDRESS,S.DOB , T.ID TEACHER_ID , T.NAME TEACHER_NAME\n" +
                ",T.SURNAME TEACHER_SURNAME FROM STUDENT S \n" +
                "INNER JOIN TEACHER T ON S.TEACHER_ID = T.ID\n" +
                "WHERE S.ACTIVE = 1 AND S.ID = ? ";
        try {

            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1,studentId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    student.setId(rs.getLong("ID"));
                    student.setName(rs.getString("STUDENT_NAME"));
                    student.setSurname(rs.getString("STUDENT_SURNAME"));
                    student.setAddress(rs.getString("ADDRESS"));
                    student.setDob(rs.getDate("DOB"));
                    student.setTeacherId(rs.getLong("TEACHER_ID"));
                    student.setTeacherName(rs.getString("TEACHER_NAME"));
                    student.setTeacherSurname(rs.getString("TEACHER_SURNAME"));
                }
            }   else {
                System.out.println("Connection is null!");
            }


        }  catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c,ps,rs);
        }
        return student;
    }

    @Override
    public void updateStudent(Student student, long studentId) throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE STUDENT SET NAME = ?,SURNAME = ?,DOB = ?,ADDRESS = ?,TEACHER_ID = ?\n" +
                " WHERE ID = ? ";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
               ps = c.prepareStatement(sql);
               ps.setString(1,student.getName());
               ps.setString(2,student.getSurname());
               ps.setDate(3,new Date(student.getDob().getTime()));
               ps.setString(4,student.getAddress());
               ps.setLong(5,student.getTeacherId());
               ps.setLong(6,studentId);
               ps.executeUpdate();
            }   else {
                System.out.println("Connection is null!!!");
            }


        }  catch (Exception ex) {
            ex.printStackTrace();
        }  finally {
            c.commit();
            JdbcUtility.close(c,ps,null);
        }
    }

    @Override
    public List<Student> searchStudentData(String keyword) throws Exception {
        List<Student> studentList = new ArrayList<Student>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,S.ID,S.NAME STUDENT_NAME,S.SURNAME STUDENT_SURNAME,S.ADDRESS,S.DOB , T.NAME TEACHER_NAME\n" +
                ",T.SURNAME TEACHER_SURNAME FROM STUDENT S \n" +
                "INNER JOIN TEACHER T ON S.TEACHER_ID = T.ID\n" +
                "WHERE S.ACTIVE = 1 AND (LOWER(S.NAME) LIKE LOWER('%"+keyword+"%')  OR LOWER(S.SURNAME) LIKE LOWER('%"+keyword+"%') OR LOWER(S.ADDRESS) LIKE LOWER('%"+keyword+"%')\n" +
                " OR LOWER(T.NAME) LIKE LOWER('%"+keyword+"%') OR LOWER(T.SURNAME) LIKE LOWER('%"+keyword+"%')  )";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setR(rs.getLong("r"));
                    student.setId(rs.getLong("ID"));
                    student.setName(rs.getString("STUDENT_NAME"));
                    student.setSurname(rs.getString("STUDENT_SURNAME"));
                    student.setAddress(rs.getString("ADDRESS"));
                    student.setDob(rs.getDate("DOB"));
                    student.setTeacherName(rs.getString("TEACHER_NAME"));
                    student.setTeacherSurname(rs.getString("TEACHER_SURNAME"));
                    studentList.add(student);
                }
            } else {
                System.out.println("Connection is null!");
            }
        }  catch (Exception ex) {
            ex.printStackTrace();
        }  finally {
            JdbcUtility.close(c,ps,rs);
        }
        return studentList;
    }

    @Override
    public List<Lesson> getLessonList() throws Exception {
        List<Lesson> lessonList = new ArrayList<Lesson>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ID,LESSON_NAME,TIME,PRICE FROM LESSON\n" +
                "WHERE ACTIVE = 1";
        try {
             c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Lesson lesson = new Lesson();
                    lesson.setId(rs.getLong("ID"));
                    lesson.setLessonName(rs.getString("LESSON_NAME"));
                    lesson.setPeriod(rs.getInt("TIME"));
                    lesson.setPrice(rs.getDouble("PRICE"));
                    lessonList.add(lesson);
                }
            }   else {
                System.out.println("Connection is null!");
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }  finally {
            JdbcUtility.close(c,ps,rs);
        }

        return lessonList;
    }

    @Override
    public List<Teacher> getTeacherComboByLessonId(int lessonId) throws Exception {
        List<Teacher> teacherList = new ArrayList<Teacher>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT T.ID,T.NAME,T.SURNAME FROM TEACHER T \n" +
                "INNER JOIN LESSON L ON L.ID = T.LESSON_ID\n" +
                "WHERE T.ACTIVE = 1 AND L.ID = ?";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1,lessonId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Teacher teacher = new Teacher();
                    teacher.setId(rs.getLong("ID"));
                    teacher.setName(rs.getString("NAME"));
                    teacher.setSurname(rs.getString("SURNAME"));


                    teacherList.add(teacher);
                }
            } else {
                System.out.println("Connection is null!");
            }
        }  catch (Exception ex) {
            ex.printStackTrace();
        }  finally {
            JdbcUtility.close(c,ps,rs);
        }
        return teacherList;
    }

    @Override
    public List<Student> advancedSearchStudent(AdvancedSearch advancedSearch) throws Exception {

        List<Student> studentList = new ArrayList<Student>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,S.ID,S.NAME STUDENT_NAME,S.SURNAME STUDENT_SURNAME,S.ADDRESS,S.DOB , \n" +
                "T.NAME TEACHER_NAME ,T.SURNAME TEACHER_SURNAME \n" +
                "FROM SCHEDULE SH\n" +
                "INNER JOIN STUDENT S ON S.ID=SH.S_ID\n" +
                "INNER JOIN TEACHER T ON T.ID=SH.T_ID\n" +
                "INNER JOIN LESSON L ON L.ID=SH.L_ID\n" +
                "WHERE S.ACTIVE=1  ";
        try {
            c = DBHelper.getConnection();
            if (c != null) {

                if (advancedSearch.getLessonId() != 0) {
                    sql+=" AND L.ID = "+advancedSearch.getLessonId();
                }
                if (advancedSearch.getTeacherId() != 0) {
                    sql+= " AND T.ID = "+advancedSearch.getTeacherId();
                }
                if (advancedSearch.getBeginDate() != null && !advancedSearch.getBeginDate().isEmpty()) {
                  sql+= "AND S.DOB >= TO_DATE('"+new java.sql.Date(df.parse(advancedSearch.getBeginDate()).getTime())+"','YYYY-MM-DD')";
                }
                if (advancedSearch.getEndDate() != null && !advancedSearch.getEndDate().isEmpty()) {
                  sql+= "AND S.DOB < TO_DATE('"+new java.sql.Date(df.parse(advancedSearch.getEndDate()).getTime())+"','YYYY-MM-DD')";
                }

                System.out.println(sql);
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setR(rs.getLong("r"));
                    student.setId(rs.getLong("ID"));
                    student.setName(rs.getString("STUDENT_NAME"));
                    student.setSurname(rs.getString("STUDENT_SURNAME"));
                    student.setAddress(rs.getString("ADDRESS"));
                    student.setDob(rs.getDate("DOB"));
                    student.setTeacherName(rs.getString("TEACHER_NAME"));
                    student.setTeacherSurname(rs.getString("TEACHER_SURNAME"));
                    studentList.add(student);
                }
            } else {
                System.out.println("Connection is null!");
            }
        }  catch (Exception ex) {
            ex.printStackTrace();
        }  finally {
            JdbcUtility.close(c,ps,rs);
        }
        return studentList;

    }
}
