import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class AreaCheck implements Serializable {
    private static final long serialVersionUID = 1L;
    private int x;
    private double y;
    private HtmlInputText yField;
    private HtmlCommandLink xField;
    private double r;

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

    public String getsayX() {
        return "X is: " + xField.getValue();
    }

    public String getsayY() {
        return "Y is: " + y;
    }

    public void check() {
        y = (double)yField.getLocalValue();
    }

    public HtmlInputText getyField() {
        return yField;
    }

    public void setyField(HtmlInputText yField) {
        this.yField = yField;
    }

    public void setxField(HtmlCommandLink xField) {
        this.xField = xField;
    }

    public HtmlCommandLink getxField() {
        return xField;
    }

    public String getSayR() {
        return "R is: " + r;
    }
}
