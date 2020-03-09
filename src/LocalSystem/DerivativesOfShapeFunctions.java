package LocalSystem;

public class DerivativesOfShapeFunctions {

    private double[][] dNdKsi;
    private double[][] dNdEta;

    public DerivativesOfShapeFunctions() {

        dNdKsi = new double[4][4];
        dNdEta = new double[4][4];

        for (int i = 0; i < 4; i++) {

            dNdKsi[i][0] = ShapeFunctions.dN1Ksi(GaussPoints.gnp[i].getEta());
            dNdKsi[i][1] = ShapeFunctions.dN2Ksi(GaussPoints.gnp[i].getEta());
            dNdKsi[i][2] = ShapeFunctions.dN3Ksi(GaussPoints.gnp[i].getEta());
            dNdKsi[i][3] = ShapeFunctions.dN4Ksi(GaussPoints.gnp[i].getEta());

            dNdEta[i][0] = ShapeFunctions.dN1Eta(GaussPoints.gnp[i].getKsi());
            dNdEta[i][1] = ShapeFunctions.dN2Eta(GaussPoints.gnp[i].getKsi());
            dNdEta[i][2] = ShapeFunctions.dN3Eta(GaussPoints.gnp[i].getKsi());
            dNdEta[i][3] = ShapeFunctions.dN4Eta(GaussPoints.gnp[i].getKsi());

        }

    }

    public double[][] getdNdKsi() {
        return dNdKsi;
    }

    public void setdNdKsi(double[][] dNdKsi) {
        this.dNdKsi = dNdKsi;
    }

    public double[][] getdNdEta() {
        return dNdEta;
    }

    public void setdNdEta(double[][] dNdEta) {
        this.dNdEta = dNdEta;
    }


}
