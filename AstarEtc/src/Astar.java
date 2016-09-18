
import java.util.*;

public class Astar {

    /**
     *set of nodes already visited
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
     * A* algorithm, calculates the shortest path between two nodes
     * @param n integer, received as a parameter, the size of the node matrix
     * @param startY integer, received as a parameter, y coordinate of the start node
     * @param startX integer, received as a parameter, x coordinate of the start node
     * @param endY integer, received as a parameter, y coordinate of the end node
     * @param endX integer, received as a parameter, x coordinate of the end node
     */
    public static void astar(int n, int startY, int startX, int endY, int endX) {
        nodeheap = new PriorityQueue<Node>();
        visited = new HashSet<Node>();
        Start start = new Start();
        Node[][] net = start.createNet(n, startY, startX, endY, endX);
        Node startNode = start.getStartNode();
        Node endNode = start.getEndNode();

        list(net);
        startNode.setStartD(0);
        nodeheap.add(startNode);

        while (!visited.contains(endNode)) {
            Node node = nodeheap.poll();
            visited.add(node);

            for (Node adjNode : adjlist.get(node)) {
                if (adjNode.getStartD() > node.getStartD() + node.getWeight()) {
                    adjNode.setStartD(node.getStartD() + adjNode.getWeight());
                    nodeheap.add(adjNode);
                }
            }
        }
    }
/**
 * Creates the adjacency list for all nodes
 * @param net Node[][], received as a parameter, contains all nodes in the net
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
}
