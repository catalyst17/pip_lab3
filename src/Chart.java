import net.bootsfaces.component.canvas.Drawing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Chart extends Drawing {
    private int h = 600;
    private int w = 600;
    private double r;

    public Chart() {
        this(2);
    }

    public Chart(double r) {
        this.r = r;
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
}
