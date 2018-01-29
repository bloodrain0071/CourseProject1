package az.orient.course.model;

/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 4/20/17
 * Time: 9:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Login extends AbstractModel {

    private String username;
    private String password;
    private String role;
    private long   studentId;
    private String name;
    private String surname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", studentId=" + studentId +
                ", studentName='" + name + '\'' +
                ", studentSurname='" + surname + '\'' +
                '}';
    }
}
