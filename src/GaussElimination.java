public class GaussElimination {


    public static double[] gaussElimination(int numberOfNodes, double[][] H, double[] P) {

        double x, y, e;
        e = Math.pow(10, -12);
        double[] results = new double[numberOfNodes];

        double[][] joinedHP = new double[numberOfNodes][numberOfNodes + 1];
        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 0; j < numberOfNodes; j++) {
                joinedHP[j][i] = H[j][i];
            }
        }

        for (int i = 0; i < numberOfNodes; i++) {
            joinedHP[i][numberOfNodes] = P[i];
        }

        for (int i = 0; i < numberOfNodes - 1; i++) {
            for (int j = i + 1; j < numberOfNodes; j++) {
                if (Math.abs(joinedHP[i][i]) < e) {
                    break;
                }

                x = -joinedHP[j][i] / joinedHP[i][i];
                for (int k = 0; k < numberOfNodes + 1; k++) {
                    joinedHP[j][k] += x * joinedHP[i][k];
                }
            }
        }

        for (int i = numberOfNodes - 1; i >= 0; i--) {
            y = joinedHP[i][numberOfNodes];
            for (int j = numberOfNodes - 1; j >= 0; j--) {
                y -= joinedHP[i][j] * results[j];
            }
            if (Math.abs(joinedHP[i][i]) < e) {
                break;
            }
            results[i] = y / joinedHP[i][i];
        }
        return results;
    }

}
