import java.io.FileNotFoundException;

public class Matrices {
    private double[][] globalMatrixH;
    private double[][] localMatrixH;
    private double[][] localMatrixC;
    private double[][] globalMatrixC;
    private double[] globalMatrixP;
    private double[] localMatrixP;
    private GlobalData gb;

    public Matrices() throws FileNotFoundException {
        gb = GlobalData.getGlobalData();
        localMatrixH = new double[gb.getnH()][gb.getnW()];
        localMatrixP = new double[gb.getnH()];
        globalMatrixH = new double[gb.getnN()][gb.getnN()];
        globalMatrixP = new double[gb.getnN()];
        localMatrixC = new double[gb.getnH()][gb.getnW()];
        globalMatrixC = new double[gb.getnN()][gb.getnN()];

    }

    public double[][] getGlobalMatrixH() {
        return globalMatrixH;
    }

    public void setGlobalMatrixH(double[][] globalMatrixH) {
        this.globalMatrixH = globalMatrixH;
    }

    public double[] getGlobalMatrixP() {
        return globalMatrixP;
    }

    public void setGlobalMatrixP(double[] globalMatrixP) {
        this.globalMatrixP = globalMatrixP;
    }

    public double[][] getLocalMatrixH() {
        return localMatrixH;
    }

    public void setLocalMatrixH(double[][] localMatrixH) {
        this.localMatrixH = localMatrixH;
    }

    public double[] getLocalMatrixP() {
        return localMatrixP;
    }

    public void setLocalMatrixP(double[] localMatrixP) {
        this.localMatrixP = localMatrixP;
    }

    public double[][] getLocalMatrixC() {
        return localMatrixC;
    }

    public void setLocalMatrixC(double[][] localMatrixC) {
        this.localMatrixC = localMatrixC;
    }

    public double[][] getGlobalMatrixC() {
        return globalMatrixC;
    }

    public void setGlobalMatrixC(double[][] globalMatrixC) {
        this.globalMatrixC = globalMatrixC;
    }
}
