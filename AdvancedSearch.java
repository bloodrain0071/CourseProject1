package az.orient.course.model;

/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 4/15/17
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class AdvancedSearch {

    private int    lessonId;
    private long   teacherId;
    private String beginDate;
    private String endDate;


    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
