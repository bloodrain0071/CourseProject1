package az.orient.course.web;

import az.orient.course.dao.CourseDao;
import az.orient.course.dao.CourseDaoImpl;
import az.orient.course.model.AdvancedSearch;
import az.orient.course.model.Lesson;
import az.orient.course.model.Student;
import az.orient.course.model.Teacher;
import az.orient.course.service.CourseService;
import az.orient.course.service.CourseServiceImpl;
import az.orient.course.util.Constants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 3/4/17
 * Time: 5:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              processRequest(request,response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = "";
        String address = "";
        try {

            PrintWriter pw = response.getWriter();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            CourseDao courseDao = new CourseDaoImpl();
            CourseService courseService = new CourseServiceImpl(courseDao);


            if (request.getParameter("action") != null) {
                  action = request.getParameter("action");
            }


            if (action.equalsIgnoreCase(Constants.GET_STUDENT_LIST))  {
                List<Student> studentList =  courseService.getStudentList();
                request.setAttribute("studentList", studentList);
                address = "WEB-INF/parseJsp/studentListParse.jsp";

            }  else if (action.equalsIgnoreCase(Constants.GET_TEACHER_LIST)) {
                List<Teacher> teacherList = courseService.getTeacherList();
                request.setAttribute("teacherList",teacherList);
                address = "WEB-INF/parseJsp/teacherListParse.jsp";
            }   else if (action.equalsIgnoreCase("getTeacherCombo")) {
                List<Teacher> teacherList = courseService.getTeacherList();
                request.setAttribute("teacherComboList",teacherList);
                address = "WEB-INF/parseJsp/teacherComboParse.jsp";
            }   else if (action.equalsIgnoreCase("addStudent")) {
                   String name = request.getParameter("name");
                   String surname = request.getParameter("surname");
                   Date dob = df.parse(request.getParameter("dob"));
                   String adress = request.getParameter("address");
                   long teacherId = Long.parseLong(request.getParameter("teacherCombo"));
                   Student student = new Student();
                   student.setName(name);
                   student.setSurname(surname);
                   student.setDob(dob);
                   student.setAddress(adress);
                   student.setTeacherId(teacherId);
                   courseService.addStudent(student);


            }  else if (action.equalsIgnoreCase("deleteStudent")) {
                long studentId = Long.parseLong(request.getParameter("studentId"));
                courseService.deleteStudent(studentId);
            }  else if (action.equalsIgnoreCase("getStudentById")) {
                 long studentId = Long.parseLong(request.getParameter("studentId"));
                 Student student = courseService.getStudentById(studentId);
                 request.setAttribute("student",student);
                 address = "WEB-INF/parseJsp/editStudent.jsp";
            }   else if (action.equalsIgnoreCase("updateStudent")) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                Date dob = df.parse(request.getParameter("dob"));
                String adress = request.getParameter("address");
                long teacherId = Long.parseLong(request.getParameter("teacherCombo"));
                long studentId = Long.parseLong(request.getParameter("studentId"));
                Student student = new Student();
                student.setName(name);
                student.setSurname(surname);
                student.setDob(dob);
                student.setAddress(adress);
                student.setTeacherId(teacherId);
                courseService.updateStudent(student,studentId);
            }   else if (action.equalsIgnoreCase("searchStudentData")) {
                String keyword = request.getParameter("keyword");
                List<Student> studentList = courseService.searchStudentData(keyword);
                request.setAttribute("studentList", studentList);
                address = "WEB-INF/parseJsp/studentListParse.jsp";
            }    else if (action.equalsIgnoreCase("getLessonCombo")) {
                 List<Lesson> lessonList = courseService.getLessonList();
                 request.setAttribute("lessonList",lessonList);
                address = "WEB-INF/parseJsp/lessonComboParse.jsp";
            }   else if (action.equalsIgnoreCase("getTeacherComboByLessonId")) {
                 int lessonId = Integer.parseInt(request.getParameter("lessonId"));
                 List<Teacher> teacherList =  courseService.getTeacherComboByLessonId(lessonId);
                request.setAttribute("teacherComboList",teacherList);
                address = "WEB-INF/parseJsp/teacherComboParse.jsp";
            }   else if (action.equalsIgnoreCase(Constants.ADVANCED_SEARCH_STUDENT)) {
                   int lessonCombo = Integer.parseInt(request.getParameter("lessonCombo"));
                   long teacherCombo = Long.parseLong(request.getParameter("teacherCombo"));
                   String beginDate = request.getParameter("beginDate");
                   String endDate = request.getParameter("endDate");
                AdvancedSearch advancedSearch = new AdvancedSearch();
                advancedSearch.setLessonId(lessonCombo);
                advancedSearch.setTeacherId(teacherCombo);
                advancedSearch.setBeginDate(beginDate);
                advancedSearch.setEndDate(endDate);
                List<Student> studentList = courseService.advancedSearchStudent(advancedSearch);
                request.setAttribute("studentList", studentList);
                address = "WEB-INF/parseJsp/studentDataParse.jsp";
            }


        }   catch (Exception ex) {
            ex.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request,response);

    }

}
