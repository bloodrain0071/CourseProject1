package az.orient.course.model;

/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 4/11/17
 * Time: 9:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Lesson extends AbstractModel {

    private String lessonName;
    private int period;
    private double price;

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonName='" + lessonName + '\'' +
                ", period='" + period + '\'' +
                ", price=" + price +
                '}';
    }
}
