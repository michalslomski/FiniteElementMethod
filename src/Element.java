import java.io.FileNotFoundException;
import java.util.Arrays;

public class Element {

    private Node[] nodesCoordinatesOfEachElement;
    private int[] elementIDs;
    private Surface[] surface;
    private int numberOfEdgesOfEachElement;
    private int[] numbersOfSurfaces; // for example edge 3->0 is '0' 0->1 is '1' etc

    public Element(int x, int y) throws FileNotFoundException {

        GlobalData globalData = GlobalData.getGlobalData();
        nodesCoordinatesOfEachElement = new Node[4];
        elementIDs = new int[4];
        this.surface = new Surface[4];
        numberOfEdgesOfEachElement = 0;

        nodesCoordinatesOfEachElement[0] = new Node(x * globalData.getdW(), (y - 1) * globalData.getdH(), globalData.getT0());
        nodesCoordinatesOfEachElement[1] = new Node((x + 1) * globalData.getdW(), (y - 1) * globalData.getdH(), globalData.getT0());
        nodesCoordinatesOfEachElement[2] = new Node((x + 1) * globalData.getdW(), (y) * globalData.getdH(), globalData.getT0());
        nodesCoordinatesOfEachElement[3] = new Node(x * globalData.getdW(), (y) * globalData.getdH(), globalData.getT0());

        elementIDs[0] = globalData.getnH() * x + y;
        elementIDs[1] = globalData.getnH() * (x + 1) + y;
        elementIDs[2] = globalData.getnH() * (x + 1) + (y + 1);
        elementIDs[3] = globalData.getnH() * x + (y + 1);

        surface[0] = new Surface(nodesCoordinatesOfEachElement[3], nodesCoordinatesOfEachElement[0]);
        surface[1] = new Surface(nodesCoordinatesOfEachElement[0], nodesCoordinatesOfEachElement[1]);
        surface[2] = new Surface(nodesCoordinatesOfEachElement[1], nodesCoordinatesOfEachElement[2]);
        surface[3] = new Surface(nodesCoordinatesOfEachElement[2], nodesCoordinatesOfEachElement[3]);


        for (int i = 0; i < 4; ++i) {
            if (surface[i].getNodes()[0].isBc() && surface[i].getNodes()[1].isBc()) {
                numberOfEdgesOfEachElement++;
            }
        }
        numbersOfSurfaces = new int[numberOfEdgesOfEachElement];

        int counter = 0;
        for (int i = 0; i < 4; ++i) {
            if (surface[i].getNodes()[0].isBc() && surface[i].getNodes()[1].isBc()) {
                numbersOfSurfaces[counter] = i;
                counter++;
            }
        }



    }


    public Node[] getNodesCoordinatesOfEachElement() {
        return nodesCoordinatesOfEachElement;
    }

    public void setNodesCoordinatesOfEachElement(Node[] nodesCoordinatesOfEachElement) {
        this.nodesCoordinatesOfEachElement = nodesCoordinatesOfEachElement;
    }

    public Surface[] getSurface() {
        return surface;
    }

    public void setSurface(Surface[] surface) {
        this.surface = surface;
    }

    public int getNumberOfEdgesOfEachElement() {
        return numberOfEdgesOfEachElement;
    }

    public void setNumberOfEdgesOfEachElement(int numberOfEdgesOfEachElement) {
        this.numberOfEdgesOfEachElement = numberOfEdgesOfEachElement;
    }

    public int[] getNumbersOfSurfaces() {
        return numbersOfSurfaces;
    }

    public void setNumbersOfSurfaces(int[] numbersOfSurfaces) {
        this.numbersOfSurfaces = numbersOfSurfaces;
    }

    public int[] getElementIDs() {
        return elementIDs;
    }

    public void setElementIDs(int[] elementIDs) {
        this.elementIDs = elementIDs;
    }
}

