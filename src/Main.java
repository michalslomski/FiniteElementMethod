import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Matrices matrices = new Matrices();
        GlobalData globalData = new GlobalData();
        Grid grid = new Grid();
        grid.createNodes();
        grid.createElements();
        Calculate calculate = new Calculate(matrices);
        double min = 0, max = 0;

        for (double i = globalData.getDsTime(); i <= globalData.getsTime(); i += globalData.getDsTime()) {

            calculate.run(grid);
            double[] t = GaussElimination.gaussElimination(globalData.getnN(), matrices.getGlobalMatrixH(), matrices.getGlobalMatrixP());
            min = t[0];
            max = t[0];
            for (int j = 0; j < globalData.getnN(); ++j) {


                if (t[j] > max)
                    max = t[j];

                if (t[j] < min)
                    min = t[j];

                grid.getNodes()[j].setT(t[j]);

            }

            System.out.println("Time[s]: " + i + "\t" + " MinTemp[s]: " + min + "\t" + "\t"  + " MaxTemp[s]: " + max);


        }


    }


}
