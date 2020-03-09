import java.io.FileNotFoundException;

public class Node {

    private double x, y, t;
    private boolean bc;


    public Node(double x, double y, double t) throws FileNotFoundException {

        GlobalData globalData = GlobalData.getGlobalData();
        this.x = x;
        this.y = y;
        this.t = t;

        double W = globalData.getW();
        double H = globalData.getH();

        bc = this.x == 0.0 || this.x >= W || this.y == 0.0 || this.y >= H;

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    public boolean isBc() {
        return bc;
    }

    public void setBc(boolean bc) {
        this.bc = bc;
    }


}
