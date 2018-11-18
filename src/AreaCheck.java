import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlInputText;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class AreaCheck implements Serializable {
    private static final long serialVersionUID = 1L;
    private int x;
    private double y;
    private double r;
    private HtmlInputText yField;
    private HtmlInputHidden rField;
    private boolean inRange;

    @ManagedProperty(value = "#{pointData}")
    private PointData pointData;

    public void check() {
        y=(double)yField.getLocalValue();
        r=Double.parseDouble((String)rField.getLocalValue());
        pointData.getPoints().add(new PointData(x, y, r));
    }

    public boolean getInRange() {
        return inRange;
    }

    public void setInRange(boolean inRange) {
        this.inRange = inRange;
    }

    public int getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public HtmlInputText getyField() {
        return yField;
    }

    public HtmlInputHidden getrField() {
        return rField;
    }

    public void setyField(HtmlInputText yField) {
        this.yField = yField;
    }

    public void setrField(HtmlInputHidden rField) {
        this.rField = rField;
    }

    public String getSayR() {
        return "R is: " + r;
    }

    public void setPointData(PointData pointData) {
        this.pointData = pointData;
    }

    public PointData getPointData() {

        return pointData;
    }
}
