package algorithms;

import graph.Path;
import graph.Node;
import datastructures.Heap;
import datastructures.MyArrayList;
import datastructures.MyHashMap;
import java.util.*;

public class IDAstar {

    /**
     * a matrix of nodes already visited
     */
    private boolean[][] visited;
    /**
     * map containing the adjacent nodes
     */
    private MyHashMap<Node, MyArrayList<Node>> adjlist;
    /**
     * a map of nodes on the path
     */
    private MyHashMap<Node, Node> path;
    /**
     * End point of the search
     */
    private Node endNode;

    /**
     * IDA* algorithm, calculates the shortest path between two nodes
     *
     * @param net, a matrix of nodes, received as a parameter
     * @param startNode, starting point of the search
     * @param endNode, end point of the search
     */
    public void idastar(Node[][] net, Node startNode, Node endNode, MyHashMap<Node, MyArrayList<Node>> adjlist) {
        this.endNode = endNode;
        this.adjlist = adjlist;
        visited = new boolean[net.length][net.length];
        path = new MyHashMap<Node, Node>();
        int netsize = net.length * net.length;
        int threshold = startNode.getStartD();

        while (true) {
            int temp = search(startNode, 0, threshold);
            if (temp == -1) {
                System.out.println("Polku löytyi");
                Path nodePath = new Path();
                nodePath.shortestPath(netsize, path, endNode, startNode);
                nodePath.showPath(net, visited, startNode, endNode);
                break;
            }
            if (temp > Integer.MAX_VALUE) {
                System.out.println("Polkua ei löydy");
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
     * @return
     */
    private Integer search(Node node, int g, int threshold) {
        visited[node.getY()][node.getX()] = true;
        int f = g + node.getStartD() + node.getWeight();

        if (f > threshold) {
            return f;
        }

        if (node == endNode) {
            return -1;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < adjlist.get(node).size(); i++) {
            Node adjNode = adjlist.get(node).get(i);
            if (adjNode == endNode) {
                visited[adjNode.getY()][adjNode.getX()] = true;
                path.put(adjNode, node);
                return -1;
            }
            if (adjNode.getStartD() > node.getStartD() + adjNode.getWeight()) {
                adjNode.setStartD(node.getStartD() + adjNode.getWeight());
            }
            int temp = search(adjNode, g + adjNode.getEndD(), threshold);

            if (temp < min) {
                min = temp;
            }
            path.put(adjNode, node);
            visited[adjNode.getY()][adjNode.getX()] = true;
        }
        return min;
    }
}
