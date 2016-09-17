
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node startNode = new Node(0,0,0,0,1);
        Node endNode = new Node(2,2,0,0,2);
        Astar astar = new Astar();
        astar.astar(5, startNode,endNode);
    }
}
