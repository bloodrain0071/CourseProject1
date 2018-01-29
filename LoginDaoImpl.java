package az.orient.course.dao;

import az.orient.course.model.Login;
import az.orient.course.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 4/20/17
 * Time: 9:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginDaoImpl implements LoginDao {
    @Override
    public Login login(String username, String password) throws Exception{
        Login login = new Login();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT L.ID,L.USERNAME,L.ROLE,S.NAME,S.SURNAME FROM LOGIN L\n" +
                "INNER JOIN STUDENT S ON L.STUDENT_ID = S.ID\n" +
                "WHERE L.ACTIVE = 1 AND S.ACTIVE = 1 AND L.USERNAME = ? AND L.PASSWORD = ?";
        try {
              c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                     login.setUsername(rs.getString("USERNAME"));
                    login.setRole(rs.getString("ROLE"));
                    login.setName(rs.getString("NAME"));
                    login.setSurname(rs.getString("SURNAME"));
                }   else {
                     login = null;
                }
            }   else {
                System.out.println("Connection is null!");
            }
        }   catch (Exception ex) {
            ex.printStackTrace();
        }   finally {
            JdbcUtility.close(c,ps,rs);
        }
        return login;
    }
}
