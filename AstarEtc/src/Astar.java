
import java.util.*;

public class Astar {

    private static HashSet<Node> visited;
    private static PriorityQueue<Node> nodeheap;
    //   private static LinkedList<Node[]> nodelist;
    private static Map<Node, ArrayList<Node>> adjlist;

    public static void astar(int n, Node startNode, Node endNode) {
        nodeheap = new PriorityQueue<Node>();
        //    nodelist = new LinkedList<Node[]>();
        visited = new HashSet<Node>();
        Start alku = new Start();
        Node[][] net = alku.createNet(n, startNode, endNode);
        list(net);
        startNode.setStartD(0);
        nodeheap.add(startNode);

        while (!visited.contains(endNode)) {
            Node node = nodeheap.poll();
            visited.add(node);
            for (Node adjNode : adjlist.get(node)) {

                if (adjNode.getStartD() > node.getStartD() + adjNode.getWeight()) {
                    adjNode.setStartD(node.getStartD() + adjNode.getWeight());
                    nodeheap.add(adjNode);
                }

            }
        }

    }

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
}
