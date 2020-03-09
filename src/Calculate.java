import LocalSystem.DerivativesOfShapeFunctions;
import LocalSystem.GaussPoints;
import LocalSystem.ValuesOfShapeFunctions;

import java.io.FileNotFoundException;


public class Calculate {

    private GlobalData gb;
    private Matrices matrices;
    private DerivativesOfShapeFunctions dosf;
    private ValuesOfShapeFunctions vosf;


    public Calculate(Matrices m) throws FileNotFoundException {
        gb = GlobalData.getGlobalData();
        matrices = m;
        dosf = new DerivativesOfShapeFunctions();
        vosf = new ValuesOfShapeFunctions();
    }

    public void run(Grid grid) {

        Node[] cords;
        double[][] invertedMatrix;
        double[] dNdX = new double[4];
        double[] dNdY = new double[4];
        double[] x = new double[4];
        double[] y = new double[4];
        double[] init_temp = new double[4];
        double t;
        double c;
        double det1D;
        double det;
        int id;
        fill2dArray(0, matrices.getGlobalMatrixH());
        fill1dArray(0, matrices.getGlobalMatrixP());
        fill2dArray(0, matrices.getGlobalMatrixC());

        Element[] elements = grid.getElements();
        for (Element el : elements) {
            fill1dArray(0, matrices.getLocalMatrixP());
            fill2dArray(0, matrices.getLocalMatrixH());
            fill2dArray(0, matrices.getLocalMatrixC());
            cords = el.getNodesCoordinatesOfEachElement();

            for (int i = 0; i < 4; i++) {
                id = el.getElementIDs()[i];
                x[i] = cords[i].getX();
                y[i] = cords[i].getY();
                init_temp[i] = grid.getNodes()[id - 1].getT();
            }
            for (int integral_point = 0; integral_point < 4; integral_point++) {
                JacobianMatrix jacobianMatrix = new JacobianMatrix(x, y, integral_point);

                invertedMatrix = jacobianMatrix.invertMatrix(jacobianMatrix.getJacobianMatrix());
                t = 0;
                for (int i = 0; i < 4; i++) {
                    dNdX[i] = invertedMatrix[0][0] * dosf.getdNdKsi()[integral_point][i] + invertedMatrix[0][1] * dosf.getdNdEta()[integral_point][i];
                    dNdY[i] = invertedMatrix[1][0] * dosf.getdNdKsi()[integral_point][i] + invertedMatrix[1][1] * dosf.getdNdEta()[integral_point][i];
                    t += init_temp[i] * vosf.getShapesFunction()[integral_point][i];

                }
                // System.out.println("t: "+t);
                det = jacobianMatrix.getDeterminant();

                for (int i = 0; i < 4; i++)
                    for (int j = 0; j < 4; j++) {
                        c = gb.getC() * gb.getG() * (vosf.getShapesFunction()[integral_point][i] * vosf.getShapesFunction()[integral_point][j]) * det;
                        matrices.getLocalMatrixC()[i][j]+=c;
                        matrices.getLocalMatrixH()[i][j] += gb.getK() * (dNdX[i] * dNdX[j] + dNdY[i] * dNdY[j]) * det + (c / gb.getDsTime());
                        matrices.getLocalMatrixP()[i] += c / gb.getDsTime() * t;

                    }

            }

            //       System.out.println(Arrays.toString(matrices.getLocalMatrixH()));

            int idOfEdgeOnSurface;
            for (int it = 0; it < el.getNumberOfEdgesOfEachElement(); it++) {

                idOfEdgeOnSurface = el.getNumbersOfSurfaces()[it];

                if (idOfEdgeOnSurface == 0)
                    det1D = Math.sqrt(Math.pow(el.getNodesCoordinatesOfEachElement()[3].getX() - el.getNodesCoordinatesOfEachElement()[0].getX(), 2)
                            + Math.pow(el.getNodesCoordinatesOfEachElement()[3].getY() - el.getNodesCoordinatesOfEachElement()[0].getY(), 2)) / 2.0;
                else if (idOfEdgeOnSurface == 1)
                    det1D = Math.sqrt(Math.pow(el.getNodesCoordinatesOfEachElement()[0].getX() - el.getNodesCoordinatesOfEachElement()[1].getX(), 2)
                            + Math.pow(el.getNodesCoordinatesOfEachElement()[0].getY() - el.getNodesCoordinatesOfEachElement()[1].getY(), 2)) / 2.0;
                else if (idOfEdgeOnSurface == 2)
                    det1D = Math.sqrt(Math.pow(el.getNodesCoordinatesOfEachElement()[1].getX() - el.getNodesCoordinatesOfEachElement()[2].getX(), 2)
                            + Math.pow(el.getNodesCoordinatesOfEachElement()[1].getY() - el.getNodesCoordinatesOfEachElement()[2].getY(), 2)) / 2.0;
                else
                    det1D = Math.sqrt(Math.pow(el.getNodesCoordinatesOfEachElement()[2].getX() - el.getNodesCoordinatesOfEachElement()[3].getX(), 2)
                            + Math.pow(el.getNodesCoordinatesOfEachElement()[2].getY() - el.getNodesCoordinatesOfEachElement()[3].getY(), 3)) / 2.0;

                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 4; j++) {
                        for (int k = 0; k < 4; k++) {
                            matrices.getLocalMatrixH()[j][k] += gb.getAlfa() * GaussPoints.gsp[idOfEdgeOnSurface].getShapeFunctions()[i][j] * GaussPoints.gsp[idOfEdgeOnSurface].getShapeFunctions()[i][k] * det1D;

                        }
                        matrices.getLocalMatrixP()[j] += gb.getAlfa() * gb.getaT() * GaussPoints.gsp[idOfEdgeOnSurface].getShapeFunctions()[i][j] * det1D;

                    }
                }
            }

            // System.out.println(Arrays.deepToString(matrices.getLocalMatrixH()));
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {

                    matrices.getGlobalMatrixH()[el.getElementIDs()[i] - 1][el.getElementIDs()[j] - 1] += matrices.getLocalMatrixH()[i][j];
                    matrices.getGlobalMatrixC()[el.getElementIDs()[i] - 1][el.getElementIDs()[j] - 1] += matrices.getLocalMatrixC()[i][j];

                }
                matrices.getGlobalMatrixP()[el.getElementIDs()[i] - 1] += matrices.getLocalMatrixP()[i];
            }


        }



    }


    private void fill1dArray(double x, double[] Array) {
        for (int i = 0; i < Array.length; ++i) {
            Array[i] = x;
        }
    }

    private void fill2dArray(double x, double[][] Array) {
        for (int i = 0; i < Array.length; ++i) {
            for (int j = 0; j < Array[i].length; ++j) {
                Array[i][j] = x;
            }
        }
    }

}