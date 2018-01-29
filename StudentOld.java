package az.orient.course.model;

import java.util.Arrays;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 3/7/17
 * Time: 8:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class StudentOld extends AbstractModel {

    private String name;
    private String surname;
    private Date dob;
    private String[] foreignLang;
    private String  gender;
    private String country;
    private String[] city;
    private String   note;

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String[] getForeignLang() {
        return foreignLang;
    }

    public void setForeignLang(String[] foreignLang) {
        this.foreignLang = foreignLang;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String[] getCity() {
        return city;
    }

    public void setCity(String[] city) {
        this.city = city;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "StudentOld{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dob +
                ", foreignLang=" + (foreignLang == null ? null : Arrays.asList(foreignLang)) +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", city=" + (city == null ? null : Arrays.asList(city)) +
                ", note='" + note + '\'' +
                '}';
    }
}
