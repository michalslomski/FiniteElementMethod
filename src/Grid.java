import java.io.FileNotFoundException;

public class Grid {

    private Node[] nodes;
    private Element[] elements;
    GlobalData globalData;

    public Grid() throws FileNotFoundException {
        globalData = GlobalData.getGlobalData();
        elements = new Element[globalData.getnE()];
        nodes = new Node[globalData.getnN()];
    }

    public void createNodes() throws FileNotFoundException {
        int index = 0;
        for (int i = 0; i < globalData.getnW(); i++)
            for (int j = 0; j < globalData.getnH(); j++) {
                nodes[index] = new Node(i * globalData.getdW(), j * globalData.getdH(), 100);
                index++;

            }
    }

    public void createElements() throws FileNotFoundException {
        int index = 0;
        for (int i = 0; i < (globalData.getnW() - 1); i++)
            for (int j = 0; j < (globalData.getnH() - 1); j++) {
                elements[index++] = new Element(i, j + 1);
            }
    }

    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }

    public Element[] getElements() {
        return elements;
    }

    public void setElements(Element[] elements) {
        this.elements = elements;
    }
}
