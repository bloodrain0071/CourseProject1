package az.orient.course.dao;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 3/11/17
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class DBHelper {

    public static Connection getConnection() throws Exception{
        Context context = new InitialContext();
        DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/testshema");
        Connection c = dataSource.getConnection();
        return c;
    }



}
