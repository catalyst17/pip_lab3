import net.bootsfaces.component.canvas.Drawing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlInputText;
import java.io.Serializable;

import static java.lang.Math.pow;
import static org.primefaces.component.inplace.Inplace.PropertyKeys.event;

@ManagedBean
@SessionScoped
public class AreaCheck extends Drawing implements Serializable {
    private static final long serialVersionUID = 1L;
    private int x;
    private double y;
    private double r = 3.5;
    private HtmlInputText yField;
    private HtmlInputHidden rField;
    private HtmlInputHidden xPic;
    private HtmlInputHidden yPic;
    private boolean inRange;
    @ManagedProperty(value = "#{pointData}")
    private PointData pointData;
    @ManagedProperty(value = "#{chart}")
    private Chart chart = new Chart();

    public AreaCheck(){
    }

    public void check() {
        y = (Double) yField.getLocalValue();
        r=Double.parseDouble((String)rField.getLocalValue());
        inRange=((x<=r && x>=0 && y<=0 && y>=-r/2)
                || (y<=-x+r && x>=0 && y>=0)
                || (pow(x, 2)+pow(y, 2)<=pow(r, 2) && x<=0 && y<=0));
        pointData.getPoints().add(new PointData(x, y, r, inRange));
        chart = new Chart(r, pointData);
    }

    public void checkFromPic(){
        pointData.getPoints().add(new PointData(0, 0, 4, true));
        chart = new Chart(4, pointData);
    }

    /*public void updateChart(ValueChangeEvent event) {
        if (rField.getLocalValue() != null) {
            chart = new Chart(Double.parseDouble((String)this.rField.getLocalValue()));
        }
        chart = new Chart((Double)event.getNewValue());
    }*/

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
        /*if (rField.getLocalValue() != null) {
            chart = new Chart(Double.parseDouble((String)this.rField.getLocalValue()));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("form");
        }*/
    }

    public void setPointData(PointData pointData) {
        this.pointData = pointData;
    }

    public PointData getPointData() {

        return pointData;
    }

    public void setChart(Chart chart) {
        this.chart = chart;
    }

    public Chart getChart() {
        return chart;
    }

    public HtmlInputHidden getxPic() {
        return xPic;
    }

    public void setxPic(HtmlInputHidden xPic) {
        this.xPic = xPic;
    }

    public HtmlInputHidden getyPic() {
        return yPic;
    }

    public void setyPic(HtmlInputHidden yPic) {
        this.yPic = yPic;
    }
}
