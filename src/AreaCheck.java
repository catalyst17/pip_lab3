import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlInputText;
import java.io.Serializable;

@ManagedBean
public class AreaCheck implements Serializable {
    private static final long serialVersionUID = 1L;
    private int x;
    private double y;
    private double r = 2.1;
    private HtmlCommandLink xField;
    private HtmlInputText yField;
    private HtmlInputHidden rField;

    public void check() {}

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

    public HtmlCommandLink getxField() {
        return xField;
    }

    public void setyField(HtmlInputText yField) {
        this.yField = yField;
    }

    public void setrField(HtmlInputHidden rField) {
        this.rField = rField;
    }

    public void setxField(HtmlCommandLink xField) {
        this.xField = xField;
    }

    public String getsayX() {
        return "X is: " + x;
    }
}
