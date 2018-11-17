import javax.faces.bean.ManagedBean;

@ManagedBean
public class AreaCheck {
    private int x;
    private double y;
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

    public String getsayY() {
        return "Y is: " + y;
    }
}
