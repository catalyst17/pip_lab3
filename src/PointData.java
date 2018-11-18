import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(eager = true)
@SessionScoped
public class PointData implements Serializable {
    private static final long serialVersionUID = 1L;
    private double x;
    private double y;
    private double r;
    private boolean inRange;
    private static final ArrayList<PointData> points = new ArrayList<>();

    public ArrayList<PointData> getPoints() {
        return points;
    }

    public PointData() {}

    public PointData(double x, double y, double r, boolean inRange) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.inRange = inRange;
    }

    public boolean isInRange() {
        return inRange;
    }

    public void setInRange(boolean inRange) {
        this.inRange = inRange;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }
}
