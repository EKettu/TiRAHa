
public class Node implements Comparable<Node> {

    private int i;
    private static int j;
    private static int endDist;
    private static int startDist;
    private static int weight;

    public Node(int i, int j, int startDist, int endDist, int weight) {
        this.i = i;
        this.j = j;
        this.startDist = startDist;
        this.endDist = endDist;
        this.weight = weight;

    }

    public int getI() {
        return this.i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return this.j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getStartD() {
        return this.startDist;
    }

    public void setStartD(int startDist) {
        this.startDist = startDist;
    }

    public int getEndD() {
        return this.endDist;
    }

    public void setEndD(int endDist) {
        this.endDist = endDist;
    }

    public int getWeight() {
        return this.weight;
    }
  
    @Override
    public int compareTo(Node node) {
        return (this.startDist+this.endDist) - (node.startDist+node.endDist);
    }
}
