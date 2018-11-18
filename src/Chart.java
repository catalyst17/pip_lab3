import net.bootsfaces.component.canvas.Drawing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
@SessionScoped
public class Chart extends Drawing {
    private int h = 600;
    private int w = 600;
    private double r;
    private PointData pointData;

    public Chart() {
        this(2, null);
    }

    public Chart(double r, PointData pointData) {
        this.r = r;
        this.pointData=pointData;
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
        text(w/2+12, 13, "y", "18px Arial");
        text(w-12, h/2-12, "x", "18px Arial");

        if (pointData == null){
            //axis OX
            text(w/6*1-18, h/2+21, "-R", "18px Arial");
            text(w/6*2-18, h/2+21, "-R/2", "18px Arial");
            text(w/6*5-13, h/2+21, "R", "18px Arial");
            text(w/6*4-13, h/2+21, "R/2", "18px Arial");
            //axis OY
            text(w/2+11, h/6*1+6, "R", "18px Arial");
            text(w/2+11, h/6*2+6, "R/2", "18px Arial");
            text(w/2+11, h/6*5+6, "-R", "18px Arial");
            text(w/2+11, h/6*4+6, "-R/2", "18px Arial");
        } else {
            //axis OX
            text(w/6*1-18, h/2+21, "-"+r, "18px Arial");
            text(w/6*2-18, h/2+21, "-"+(r/2), "18px Arial");
            text(w/6*5-13, h/2+21, ""+r, "18px Arial");
            text(w/6*4-13, h/2+21, ""+(r/2), "18px Arial");
            //axis OY
            text(w/2+11, h/6*1+6, ""+r, "18px Arial");
            text(w/2+11, h/6*2+6, ""+(r/2), "18px Arial");
            text(w/2+11, h/6*5+6, "-"+r, "18px Arial");
            text(w/2+11, h/6*4+6, "-"+(r/2), "18px Arial");
        }

        if (pointData != null){
            for (PointData point: pointData.getPoints()) {
                String color;
                double step = r/2/100;
                int xCent = w/2;
                int yCent = h/2;
                int xCord = (int)Math.round(point.getX()/step);
                int yCord = (int)Math.round(point.getY()/step);
                if (point.isInRange())
                    color="green";
                else
                    color="red";
                filledCircle(xCent+xCord, yCent-yCord,4, color);
            }
        }
    }

    public void setPointData(PointData pointData) {
        this.pointData = pointData;
    }

    public PointData getPointData() {

        return pointData;
    }
}
