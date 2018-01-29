package az.orient.course.service;

import az.orient.course.dao.LoginDao;
import az.orient.course.model.Login;

/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 4/20/17
 * Time: 9:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginServiceImpl implements LoginService {

    private LoginDao loginDao;

    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public Login login(String username, String password) throws Exception{
        return loginDao.login(username,password);
    }
}
