package az.orient.course.service;

import az.orient.course.model.Login;

/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 4/20/17
 * Time: 9:23 PM
 * To change this template use File | Settings | File Templates.
 */
public interface LoginService {

    public Login login(String username,String password) throws Exception;
}
