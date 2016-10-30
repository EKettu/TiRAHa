package graph;

/**
 * Node in a net
 *
 * @author ekettu
 */
public class Node implements Comparable<Node> {

    /**
     * Value of y coordinate in a matrix
     */
    private int y;
    /**
     * Value of x coordinate in a matrix
     */
    private int x;
    /**
     * Actual distance between a node and the goal node
     */
    private int startDist;
    /**
     * Shortest possible distance between the node and a goal node
     */
    private int endDist;
    /**
     * Cost of visiting the node
     */
    private int weight;

    /*
     * Serial number of a node
     */
    private int number;

    /**
     * Creates a new Node object with following parameters
     *
     * @param number, integer, received as a parameter
     * @param y integer, received as a parameter
     * @param x integer, received as a parameter
     * @param startDist integer, received as a parameter
     * @param endDist integer, received as a parameter
     * @param weight integer, received as a parameter
     */
    public Node(int number, int y, int x, int startDist, int endDist, int weight) {
        this.number = number;
        this.y = y;
        this.x = x;
        this.startDist = startDist;
        this.endDist = endDist;
        this.weight = weight;

    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
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

    public int getNumber() {
        return number;
    }

    //Needed if Java's PriorityQueue is used
    @Override
    public int compareTo(Node node) {
        return (this.startDist + this.endDist) - (node.startDist + node.endDist);
    }
}
