package az.orient.course.web;

import az.orient.course.dao.LoginDao;
import az.orient.course.dao.LoginDaoImpl;
import az.orient.course.model.Login;
import az.orient.course.service.LoginService;
import az.orient.course.service.LoginServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 4/20/17
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = null;
        try {
        LoginDao loginDao = new LoginDaoImpl();
        LoginService loginService = new LoginServiceImpl(loginDao);
        if (username != null && !username.isEmpty()
                && password != null && !password.isEmpty()) {
           Login login = loginService.login(username, password);
            if (login != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("login",login);
               address = "index.jsp";
            }    else {
                request.setAttribute("invalid","Username or password is invalid!");
                address = "login.jsp";
            }

        }   else {
            request.setAttribute("invalid","Username or password is empty!");
            address = "login.jsp";
        }
            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


}
