

public class Surface {

    private Node[] nodes;

    public Surface(Node firstNode, Node secondNode) {

        nodes = new Node[2];
        nodes[0] = firstNode;
        nodes[1] = secondNode;
    }


    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }
}
