package LocalSystem;

public class ValuesOfShapeFunctions {

    private double[][] shapesFunction;


    public ValuesOfShapeFunctions() {

        shapesFunction = new double[4][4];

        for (int i = 0; i < 4; i++) {

            shapesFunction[i][0] = ShapeFunctions.N1(GaussPoints.gnp[i].getKsi(), GaussPoints.gnp[i].getEta());
            shapesFunction[i][1] = ShapeFunctions.N2(GaussPoints.gnp[i].getKsi(), GaussPoints.gnp[i].getEta());
            shapesFunction[i][2] = ShapeFunctions.N3(GaussPoints.gnp[i].getKsi(), GaussPoints.gnp[i].getEta());
            shapesFunction[i][3] = ShapeFunctions.N4(GaussPoints.gnp[i].getKsi(), GaussPoints.gnp[i].getEta());

        }
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 2; ++j) {
                GaussPoints.gsp[i].getShapeFunctions()[j][0] = ShapeFunctions.N1(GaussPoints.gsp[i].getNodes()[j].getKsi(), GaussPoints.gsp[i].getNodes()[j].getEta());
                GaussPoints.gsp[i].getShapeFunctions()[j][1] = ShapeFunctions.N2(GaussPoints.gsp[i].getNodes()[j].getKsi(), GaussPoints.gsp[i].getNodes()[j].getEta());
                GaussPoints.gsp[i].getShapeFunctions()[j][2] = ShapeFunctions.N3(GaussPoints.gsp[i].getNodes()[j].getKsi(), GaussPoints.gsp[i].getNodes()[j].getEta());
                GaussPoints.gsp[i].getShapeFunctions()[j][3] = ShapeFunctions.N4(GaussPoints.gsp[i].getNodes()[j].getKsi(), GaussPoints.gsp[i].getNodes()[j].getEta());


            }
        }
    }

    public double[][] getShapesFunction() {
        return shapesFunction;
    }

    public void setShapesFunction(double[][] shapesFunction) {
        this.shapesFunction = shapesFunction;
    }
}
