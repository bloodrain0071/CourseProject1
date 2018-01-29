package az.orient.course.dao;

import az.orient.course.model.AdvancedSearch;
import az.orient.course.model.Lesson;
import az.orient.course.model.Student;
import az.orient.course.model.Teacher;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 3/11/17
 * Time: 5:20 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CourseDao {


    public List<Student> getStudentList() throws Exception;
    public List<Teacher> getTeacherList() throws Exception;
    public void addStudent(Student student) throws Exception;
    public void deleteStudent(long studentId) throws Exception;
    public Student getStudentById(long studentId) throws Exception;
    public void updateStudent(Student student,long studentId) throws Exception;
    public List<Student> searchStudentData(String keyword) throws Exception;
    public List<Lesson> getLessonList() throws Exception;
    public List<Teacher> getTeacherComboByLessonId(int lessonId) throws Exception;
    public List<Student> advancedSearchStudent(AdvancedSearch advancedSearch) throws Exception;

}
