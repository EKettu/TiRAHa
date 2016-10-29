package algorithms;

import graph.Path;
import graph.Node;
import datastructures.Heap;
import datastructures.MyArrayList;
import datastructures.MyHashMap;
import java.util.*;

public class IDAstar {

    /**
     * Matrix of nodes already visited
     */
    private boolean[][] visited;
    /**
     * Map of nodes on the path
     */
    private MyHashMap<Node, Node> path;
    /**
     * End point of the search
     */
    private Node endNode;
    /**
     * Array containing the adjacent nodes
     */
    private Node[][] adjArray;
    /**
     * Boolean value, true if the path has been found
     */
    private boolean found;

    /**
     * IDA* algorithm, calculates the shortest path between two nodes
     *
     * @param net, a matrix of nodes, received as a parameter
     * @param startNode, starting point of the search
     * @param endNode, end point of the search
     * @param adjArray Node[][], contains adjacency nodes
     */
    public void idastar(Node[][] net, Node startNode, Node endNode, Node[][] adjArray) {
        found = false;
        this.endNode = endNode;
        this.adjArray = adjArray;
        visited = new boolean[net.length][net.length];
        path = new MyHashMap<Node, Node>();
        int netsize = net.length * net.length;
        int threshold = startNode.getEndD();

        while (true) {
            int temp = search(startNode, 0, threshold);
            if (temp == -1) {
                found = true;
                System.out.println("Path found");
                Path nodePath = new Path();
                nodePath.shortestPath(netsize, path, endNode, startNode);
                nodePath.showPath(net, visited, startNode, endNode);
                break;
            }
            if (temp == Integer.MAX_VALUE) {
                System.out.println("No path exists.");
                break;
            }
            threshold = temp;
        }
    }

    /**
     * Depth-First-Search algorithm
     *
     * @param node Node, received as a parameter, current node being searched
     * @param g Integer, received as a parameter, cost of a node
     * @param threshold Integer, received as a parameter, depth being searched
     * @return the minimum of all f values that is greater than threshold
     */
    private Integer search(Node node, int g, int threshold) {
        visited[node.getY()][node.getX()] = true;
        int f = g + node.getEndD();

        if (f > threshold) {
            return f;
        }

        if (node == endNode) {
            return -1;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            Node adjNode = adjArray[node.getNumber()][i];

            if (adjNode != null) {
                int temp = search(adjNode, g + adjNode.getWeight(), threshold);
                path.put(adjNode, node);
                visited[adjNode.getY()][adjNode.getX()] = true;

                if (temp == -1) {
                    return -1;
                }
                if (temp < min) {
                    min = temp;
                }
            }
        }
        return min;
    }

    public MyHashMap<Node, Node> getPath() {
        return path;
    }
    
    public boolean getFound() {
        return found;
    }
}
