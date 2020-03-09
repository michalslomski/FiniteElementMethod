package LocalSystem;

public class ShapeFunctions {

    public static double N1(double ksi, double eta) {
        return 0.25 * (1 - ksi) * (1 - eta);
    }

    public static double N2(double ksi, double eta) {
        return 0.25 * (1 + ksi) * (1 - eta);
    }

    public static double N3(double ksi, double eta) {
        return 0.25 * (1 + ksi) * (1 + eta);
    }

    public static double N4(double ksi, double eta) {
        return 0.25 * (1 - ksi) * (1 + eta);
    }

    public static double dN1Ksi(double eta) {
        return -0.25 * (1 - eta);
    }

    public static double dN2Ksi(double eta) {
        return 0.25 * (1 - eta);
    }

    public static double dN3Ksi(double eta) {
        return 0.25 * (1 + eta);
    }

    public static double dN4Ksi(double eta) {
        return -0.25 * (1 + eta);
    }

    public static double dN1Eta(double ksi) {
        return -0.25 * (1 - ksi);
    }

    public static double dN2Eta(double ksi) {
        return -0.25 * (1 + ksi);
    }

    public static double dN3Eta(double ksi) {
        return 0.25 * (1 + ksi);
    }

    public static double dN4Eta(double ksi) {
        return 0.25 * (1 - ksi);
    }
}
