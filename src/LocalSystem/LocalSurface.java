package LocalSystem;

public class LocalSurface {

    private double[][] shapeFunctions;
    private IntegralPoint[] nodes;

    public LocalSurface(IntegralPoint firstNode, IntegralPoint secondNode) {

        nodes = new IntegralPoint[2];
        nodes[0] = firstNode;
        nodes[1] = secondNode;
        shapeFunctions = new double[2][4];

    }


    public double[][] getShapeFunctions() {
        return shapeFunctions;
    }

    public void setShapeFunctions(double[][] shapeFunctions) {
        this.shapeFunctions = shapeFunctions;
    }

    public IntegralPoint[] getNodes() {
        return nodes;
    }

    public void setNodes(IntegralPoint[] nodes) {
        this.nodes = nodes;
    }
}
