package az.orient.course.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 3/11/17
 * Time: 5:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Student extends AbstractModel {


    private String name;
    private String surname;
    private Date dob;
    private String address;
    private long  teacherId;
    private String teacherName;
    private String teacherSurname;


    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSurname='" + teacherSurname + '\'' +
                '}';
    }
}
