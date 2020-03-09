//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GlobalData {
    private double W;
    private double H;
    private int nW;
    private int nH;
    private int nN;
    private int nE;
    private double dW;
    private double dH;
    private double t0;
    private double sTime;
    private double dsTime;
    private double aT;
    private double alfa;
    private double C;
    private double k;
    private double g;
    public static GlobalData globalData;

    public GlobalData() throws FileNotFoundException {
        String projectPath = System.getProperty("user.dir");
        String pathToFirstTestCase = projectPath + "\\src\\TestCases\\FirstTestCase";
        String pathToSecondTestCase = projectPath + "\\src\\TestCases\\SecondTestCase";

        Scanner scanner = new Scanner(new File(pathToFirstTestCase)); // Change path to pathToSecondTestCase to run second test case
        this.H = scanner.nextDouble();
        scanner.nextLine();
        this.W = scanner.nextDouble();
        scanner.nextLine();
        this.nH = scanner.nextInt();
        scanner.nextLine();
        this.nW = scanner.nextInt();
        scanner.nextLine();
        this.nN = this.getnH() * this.getnW();
        this.nE = (this.nH - 1) * (this.nW - 1);
        this.dW = this.W / (double) (this.nW - 1);
        this.dH = this.H / (double) (this.nH - 1);
        this.t0 = scanner.nextDouble();
        scanner.nextLine();
        this.sTime = scanner.nextDouble();
        scanner.nextLine();
        this.dsTime = scanner.nextDouble();
        scanner.nextLine();
        this.aT = scanner.nextDouble();
        scanner.nextLine();
        this.alfa = scanner.nextDouble();
        scanner.nextLine();
        this.C = scanner.nextDouble();
        scanner.nextLine();
        this.k = scanner.nextDouble();
        scanner.nextLine();
        this.g = scanner.nextDouble();
        scanner.nextLine();
    }

    public static GlobalData getGlobalData() throws FileNotFoundException {
        if (globalData == null) {
            globalData = new GlobalData();
        }

        return globalData;
    }

    public double getW() {
        return this.W;
    }

    public double getdW() {
        return this.dW;
    }

    public void setdW(double dW) {
        this.dW = dW;
    }

    public double getdH() {
        return this.dH;
    }

    public void setdH(double dH) {
        this.dH = dH;
    }

    public void setW(double w) {
        this.W = w;
    }

    public double getH() {
        return this.H;
    }

    public void setH(double h) {
        this.H = h;
    }

    public int getnW() {
        return this.nW;
    }

    public void setnW(int nW) {
        this.nW = nW;
    }

    public int getnH() {
        return this.nH;
    }

    public void setnH(int nH) {
        this.nH = nH;
    }

    public int getnN() {
        return this.nN;
    }

    public void setnN(int nN) {
        this.nN = nN;
    }

    public int getnE() {
        return this.nE;
    }

    public void setnE(int nE) {
        this.nE = nE;
    }

    public double getT0() {
        return this.t0;
    }

    public void setT0(double t0) {
        this.t0 = t0;
    }

    public double getsTime() {
        return this.sTime;
    }

    public void setsTime(double sTime) {
        this.sTime = sTime;
    }

    public double getDsTime() {
        return this.dsTime;
    }

    public void setDsTime(double dsTime) {
        this.dsTime = dsTime;
    }

    public double getaT() {
        return this.aT;
    }

    public void setaT(double aT) {
        this.aT = aT;
    }

    public double getAlfa() {
        return this.alfa;
    }

    public void setAlfa(double alfa) {
        this.alfa = alfa;
    }

    public double getC() {
        return this.C;
    }

    public void setC(double c) {
        this.C = c;
    }

    public double getK() {
        return this.k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getG() {
        return this.g;
    }

    public void setG(double g) {
        this.g = g;
    }
}
