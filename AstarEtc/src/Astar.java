
import java.util.*;

public class Astar {

    /**
     * set of nodes already visited
     */
    private static HashSet<Node> visited;
    /**
     * heap from which the next node to be processed is selected
     */
    private static PriorityQueue<Node> nodeheap;
    /**
     * map containing the adjacent nodes
     */
    private static Map<Node, ArrayList<Node>> adjlist;
    /**
     * starting point of the search
     */
    private static Node startNode;
    /**
     * end point of the search
     */
    private static Node endNode;

    /**
     * A* algorithm, calculates the shortest path between two nodes
     *
     * @param n integer, received as a parameter, the size of the node matrix
     * @param startY integer, received as a parameter, y coordinate of the start
     * node
     * @param startX integer, received as a parameter, x coordinate of the start
     * node
     * @param endY integer, received as a parameter, y coordinate of the end
     * node
     * @param endX integer, received as a parameter, x coordinate of the end
     * node
     */
    public static void astar(int n, int startY, int startX, int endY, int endX) {
        nodeheap = new PriorityQueue<Node>();
        visited = new HashSet<Node>();
        Start start = new Start();
        Node[][] net = start.createNet(n, startY, startX, endY, endX);
        startNode = start.getStartNode();
        endNode = start.getEndNode();
        HashMap<Node, Node> path = new HashMap<Node,Node>();

        list(net);
        startNode.setStartD(0);
        nodeheap.add(startNode);

        while (!visited.contains(endNode)) {
            Node node = nodeheap.poll();
            visited.add(node);

            for (Node adjNode : adjlist.get(node)) {
                if (adjNode.getStartD() > node.getStartD() + adjNode.getWeight()) {
                    adjNode.setStartD(node.getStartD() + adjNode.getWeight());
                  //  System.out.println("adjNode startD " + adjNode.getStartD() + " adjNode endD " + adjNode.getEndD());
                    nodeheap.add(adjNode);
                    path.put(adjNode, node);

                }
            }
        }
        
        shortestPath(path, endNode);
        showPath(net);
    }

    /**
     * Creates the adjacency list for all nodes
     *
     * @param net Node[][], received as a parameter, contains all nodes in the
     * net
     */
    public static void list(Node[][] net) {
        adjlist = new HashMap<Node, ArrayList<Node>>();
        for (int i = 0; i < net.length; i++) {
            for (int j = 0; j < net.length; j++) {
                adjlist.put(net[i][j], new ArrayList<Node>());

                if (i + 1 < net.length) {
                    adjlist.get(net[i][j]).add(net[i + 1][j]);
                }
                if (i - 1 >= 0) {
                    adjlist.get(net[i][j]).add(net[i - 1][j]);
                }
                if (j + 1 < net.length) {
                    adjlist.get(net[i][j]).add(net[i][j + 1]);
                }
                if (j - 1 >= 0) {
                    adjlist.get(net[i][j]).add(net[i][j - 1]);
                }
            }
        }

    }

    public Map<Node, ArrayList<Node>> getAdjList() {
        return adjlist;
    }

    /**
     * Method to print the shortest path between two nodes
     * @param path Hashmap, received as a parameter, contains the path between the start and the end
     * @param node Node, received as a parameter, the end node
     */
    public static void shortestPath(HashMap<Node, Node> path, Node node) {
        Node node2 = path.get(node);
        Stack<Node> stack = new Stack<Node>();
        while (node2!=startNode) {
            stack.push(node2);
            node2 = path.get(node2);
        }
        System.out.println("Polun pituus on " + stack.size());
        while(!stack.empty()) {
            node2=stack.pop();
            System.out.println("Solmujen koordinaatit ovat y " +node2.getY()+
            " x "+node2.getX());
        }
    }
    /**
     * Method to show the node matrix with the start and end nodes,
     * all visited nodes (and the actual shortest path)
     * @param net Node[][], received as a parameter, the net of nodes
     */
    public static void showPath(Node[][] net) {
 
        for (int i = 0; i < net.length; i++) {
            for (int j = 0; j < net.length; j++) {

                if (visited.contains(net[i][j])) {                            

                    if (net[i][j] == startNode) {
                        System.out.print("s ");
                    } else if (net[i][j] == endNode) {
                        System.out.print("e ");
                    } else {
                        System.out.print("x ");
                    }
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println("");
        }
    }
}
