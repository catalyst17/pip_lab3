import net.bootsfaces.component.canvas.Drawing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlInputText;
import java.io.Serializable;

import static java.lang.Math.pow;

@ManagedBean
@SessionScoped
public class AreaCheck extends Drawing implements Serializable {
    private static final long serialVersionUID = 1L;
    private int x;
    private double y;
    private double r = 2.0;
    private HtmlInputText yField;
    private HtmlInputHidden rField;
    private boolean inRange;
    @ManagedProperty(value = "#{pointData}")
    private PointData pointData;

    public AreaCheck(){
        int h = 600;
        int w = 600;
        //double r = 5;
        //arrows and axises
        line(0, h/2, w, h/2);
        line(w/2, 0, w/2, h);
        line(w/2, 0, w/2-6, 15);
        line(w/2, 0, w/2+6, 15);
        line(w, h/2, w-15, h/2-6);
        line(w, h/2, w-15, h/2+6);
        //zasechki
        line(w/6*1, h/2-5, w/6*1, h/2+5);
        line(w/6*2, h/2-5, w/6*2, h/2+5);
        line(w/6*4, h/2-5, w/6*4, h/2+5);
        line(w/6*5, h/2-5, w/6*5, h/2+5);
        line(w/2-5, h/6*1, w/2+5, h/6*1);
        line(w/2-5, h/6*2, w/2+5, h/6*2);
        line(w/2-5, h/6*4, w/2+5, h/6*4);
        line(w/2-5, h/6*5, w/2+5, h/6*5);
        //begining of axises
        text(w/2-13, h/2+19, "0", "18px Arial");

        //axis OX
        text(w/6*1-18, h/2+19, "-"+r, "18px Arial");
        text(w/6*2-18, h/2+19, "-"+(r/2), "18px Arial");
        //axis OY
        text(w/2+6, h/6*1+6, ""+r, "18px Arial");
        text(w/2+6, h/6*2+6, ""+(r/2), "18px Arial");

        filledCircle(w/2, h/2,4, "green");
        filledCircle(w/2, h/4,4, "red");
    }

    public void check() {
        y=(double)yField.getLocalValue();
        r=Double.parseDouble((String)rField.getLocalValue());
        inRange=((x<=r && x>=0 && y<=0 && y>=-r/2)
                || (y<=-x+r && x>=0 && y>=0)
                || (pow(x, 2)+pow(y, 2)<=pow(r, 2) && x<=0 && y<=0));
        pointData.getPoints().add(new PointData(x, y, r, inRange));
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
