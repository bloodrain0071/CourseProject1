package az.orient.course.service;

import az.orient.course.dao.CourseDao;
import az.orient.course.model.AdvancedSearch;
import az.orient.course.model.Lesson;
import az.orient.course.model.Student;
import az.orient.course.model.Teacher;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 3/11/17
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class CourseServiceImpl implements CourseService {

     private CourseDao courseDao;

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Student> getStudentList() throws Exception {
        return courseDao.getStudentList();
    }

    @Override
    public List<Teacher> getTeacherList() throws Exception {
        return courseDao.getTeacherList();
    }

    @Override
    public void addStudent(Student student) throws Exception {
           courseDao.addStudent(student);
    }

    @Override
    public void deleteStudent(long studentId) throws Exception {
        courseDao.deleteStudent(studentId);
    }

    @Override
    public Student getStudentById(long studentId) throws Exception {
        return courseDao.getStudentById(studentId);
    }

    @Override
    public void updateStudent(Student student, long studentId) throws Exception {
        courseDao.updateStudent(student,studentId);

    }

    @Override
    public List<Student> searchStudentData(String keyword) throws Exception {
        return courseDao.searchStudentData(keyword);
    }

    @Override
    public List<Lesson> getLessonList() throws Exception {
        return courseDao.getLessonList();
    }

    @Override
    public List<Teacher> getTeacherComboByLessonId(int lessonId) throws Exception {
        return courseDao.getTeacherComboByLessonId(lessonId);
    }

    @Override
    public List<Student> advancedSearchStudent(AdvancedSearch advancedSearch) throws Exception {
        return courseDao.advancedSearchStudent(advancedSearch);
    }
}
