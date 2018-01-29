package az.orient.course.model;

/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 3/7/17
 * Time: 8:11 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractModel {

    private long r;
    private long id;
    private int  active;

    public long getR() {
        return r;
    }

    public void setR(long r) {
        this.r = r;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }




}
