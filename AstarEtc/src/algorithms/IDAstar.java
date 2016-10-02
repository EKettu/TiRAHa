package algorithms;

import graph.Start;
import graph.Path;
import graph.Node;
import datastructures.Heap;
import datastructures.MyArrayList;
import java.util.*;


//Ei toimi...

public class IDAstar {

    /**
     * nodes that have been visited
     */
    private static boolean[][] visited;
    /**
     * starting point of the search
     */
    private static Node startNode;
    /**
     * end point of the search
     */
    private static Node endNode;
    /**
     * map containing the adjacent nodes
     */
    private static Map<Node, MyArrayList> adjlist;
    /**
     * tells if endNode has been found
     */
    private static boolean found;

    //Toistaiseksi mukana, visited[][] korvaa 
    /**
     * set of nodes already visited
     */
    private static HashSet<Node> visitedNodes;

    /**
     * IDA* algorithm, calculates the shortest path between two nodes
     *
     * @param n integer, received as a parameter, the size of the node matrix
     * @param startY integer, received as a parameter, y coordinate of the start
     * node
     * @param startX integer, received as a parameter, x coordinate of the start
     * node
     * @param endY integer, received as a parameter, y coordinate of the end
     * node
     * @param endX integer, received as a parameter, x coordinate of the end
     */
    public static void idastar(int n, int startY, int startX, int endY, int endX) {
        visited = new boolean[n][n];
        visitedNodes = new HashSet<Node>();
        Start start = new Start();
        Node[][] net = start.createNet(n, startY, startX, endY, endX);
        startNode = start.getStartNode();
        endNode = start.getEndNode();
        createAdjList(net);

        found = false;
        while (!found) {
            DFS(net, startNode, endNode);
        }
        Path path2 = new Path();
        path2.showPath(net, visitedNodes, startNode, endNode);

    }

    /**
     * Depth-First-Search algorithm
     *
     * @param net Node[][], received as a parameter, the net of nodes
     * @param node Node, received as a parameter, starting point of DFS
     * @param endNode Node, received as a parameter, end point of DFS
     */
    private static void DFS(Node[][] net, Node node, Node endNode) {
        visited[node.getY()][node.getX()] = true;
        visitedNodes.add(node);
        for (int i = 0; i < adjlist.get(node).size(); i++) {
            Node adjNode = adjlist.get(node).get(i);

            if (!visited[adjNode.getY()][adjNode.getX()]) {
                if (adjNode == endNode) {
                    visited[adjNode.getY()][adjNode.getX()] = true;
                    visitedNodes.add(adjNode);
                    found = true;
                    break;
                }
                if (adjNode.getStartD() > node.getStartD() + adjNode.getWeight()) {
                    adjNode.setStartD(node.getStartD() + adjNode.getWeight());
                    DFS(net, adjNode, endNode);
                }
            }
            visited[adjNode.getY()][adjNode.getX()] = true;
            // visitedNodes.add(adjNode);
        }
    }

    /**
     * Creates an adjacency list for all nodes
     *
     * @param net Node[][], received as a parameter, contains all nodes in the
     * net
     */
    public static void createAdjList(Node[][] net) {
        adjlist = new HashMap<Node, MyArrayList>();
        for (int i = 0; i < net.length; i++) {
            for (int j = 0; j < net.length; j++) {
                adjlist.put(net[i][j], new MyArrayList());
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

    public Map<Node, MyArrayList> getAdjList() {
        return adjlist;
    }

}
