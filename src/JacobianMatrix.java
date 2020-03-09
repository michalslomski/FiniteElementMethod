import LocalSystem.DerivativesOfShapeFunctions;

public class JacobianMatrix {

    private double[][] jacobianMatrix;
    private double[][] invertedJacobianMatrix;
    private double determinant;


    DerivativesOfShapeFunctions dosf = new DerivativesOfShapeFunctions();

    public JacobianMatrix(double[] x, double[] y, int p) {

        jacobianMatrix = new double[2][2];
        invertedJacobianMatrix = new double[2][2];

        jacobianMatrix[0][0] = dosf.getdNdKsi()[p][0] * x[0] + dosf.getdNdKsi()[p][1] * x[1] + dosf.getdNdKsi()[p][2] * x[2] + dosf.getdNdKsi()[p][3] * x[3];
        jacobianMatrix[0][1] = dosf.getdNdKsi()[p][0] * y[0] + dosf.getdNdKsi()[p][1] * y[1] + dosf.getdNdKsi()[p][2] * y[2] + dosf.getdNdKsi()[p][3] * y[3];
        jacobianMatrix[1][0] = dosf.getdNdEta()[p][0] * x[0] + dosf.getdNdEta()[p][1] * x[1] + dosf.getdNdEta()[p][2] * x[2] + dosf.getdNdEta()[p][3] * x[3];
        jacobianMatrix[1][1] = dosf.getdNdEta()[p][0] * y[0] + dosf.getdNdEta()[p][1] * y[1] + dosf.getdNdEta()[p][2] * y[2] + dosf.getdNdEta()[p][3] * y[3];

        determinant = jacobianMatrix[0][0] * jacobianMatrix[1][1] - jacobianMatrix[1][0] * jacobianMatrix[0][1];


    }

    public double[][] invertMatrix(double[][] jacobianMatrix) {

        invertedJacobianMatrix[0][0] = (1 / determinant) * jacobianMatrix[1][1];
        invertedJacobianMatrix[0][1] = -(1 / determinant) * jacobianMatrix[0][1];
        invertedJacobianMatrix[1][0] = -(1 / determinant) * jacobianMatrix[1][0];
        invertedJacobianMatrix[1][1] = (1 / determinant) * jacobianMatrix[0][0];

        return invertedJacobianMatrix;
    }

    public double[][] getInvertedJacobianMatrix() {
        return invertedJacobianMatrix;
    }

    public void setInvertedJacobianMatrix(double[][] invertedJacobianMatrix) {
        this.invertedJacobianMatrix = invertedJacobianMatrix;
    }

    public double[][] getJacobianMatrix() {
        return jacobianMatrix;
    }

    public void setJacobianMatrix(double[][] jacobianMatrix) {
        this.jacobianMatrix = jacobianMatrix;
    }

    public double getDeterminant() {
        return determinant;
    }

    public void setDeterminant(double determinant) {
        this.determinant = determinant;
    }
}
