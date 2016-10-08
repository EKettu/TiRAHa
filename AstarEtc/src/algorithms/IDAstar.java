package algorithms;

import graph.Path;
import graph.Node;
import datastructures.Heap;
import datastructures.MyArrayList;
import java.util.*;

public class IDAstar {

    /**
     * a matrix of nodes already visited
     */
    private boolean[][] visited;
    /**
     * map containing the adjacent nodes
     */
    private Map<Node, MyArrayList<Node>> adjlist;
    /**
     * tells if endNode has been found
     */
    private boolean found;
    /**
     * a map of nodes on the path
     */
    private HashMap<Node, Node> path;

    /**
     * IDA* algorithm, calculates the shortest path between two nodes
     *
     * @param net, a matrix of nodes, received as a parameter
     * @param startNode, starting point of the search
     * @param endNode, end point of the search
     */
    public void idastar(Node[][] net, Node startNode, Node endNode) {
        visited = new boolean[net.length][net.length];
        path = new HashMap<Node, Node>();
        found = false;

        createAdjList(net);

        while (!found) {
            DFS(net, startNode, endNode);
            if (!found) {
                System.out.println("Polkua ei löydy. ");
                break;
            }
        }
        if (found) {
            Path path2 = new Path();
            path2.shortestPath(path, endNode, startNode);
            path2.showPath(net, visited, startNode, endNode);
        }

    }

    /**
     * Depth-First-Search algorithm
     *
     * @param net Node[][], received as a parameter, the net of nodes
     * @param node Node, received as a parameter, starting point of DFS
     * @param endNode Node, received as a parameter, end point of DFS
     */
    private void DFS(Node[][] net, Node node, Node endNode) {
        visited[node.getY()][node.getX()] = true;
        // System.out.println("endNode on " + endNode);
        for (int i = 0; i < adjlist.get(node).size(); i++) {
            Node adjNode = (Node) adjlist.get(node).get(i);
            //   System.out.println("adjNode on " + adjNode);
            if (!visited[adjNode.getY()][adjNode.getX()]) {
                if (adjNode == endNode) {
                    visited[adjNode.getY()][adjNode.getX()] = true;
                    path.put(adjNode, node);
                    found = true;
                    break;
                }
                if (adjNode.getStartD() > node.getStartD() + adjNode.getWeight()) {
                    adjNode.setStartD(node.getStartD() + adjNode.getWeight());
                    DFS(net, adjNode, endNode);
                }
            }
            visited[adjNode.getY()][adjNode.getX()] = true;
            path.put(adjNode, node);
        }
    }

    /**
     * Creates an adjacency list for all nodes
     *
     * @param net Node[][], received as a parameter, contains all nodes in the
     * net
     */
    private void createAdjList(Node[][] net) {
        adjlist = new HashMap<Node, MyArrayList<Node>>();
        for (int i = 0; i < net.length; i++) {
            for (int j = 0; j < net.length; j++) {
                adjlist.put(net[i][j], new MyArrayList());
                if (i + 1 < net.length && net[i + 1][j].getNumber() != 0) {
                    adjlist.get(net[i][j]).add(net[i + 1][j]);
                }
                if (i - 1 >= 0 && net[i - 1][j].getNumber() != 0) {
                    adjlist.get(net[i][j]).add(net[i - 1][j]);
                }
                if (j + 1 < net.length && net[i][j + 1].getNumber() != 0) {
                    adjlist.get(net[i][j]).add(net[i][j + 1]);
                }
                if (j - 1 >= 0 && net[i][j - 1].getNumber() != 0) {
                    adjlist.get(net[i][j]).add(net[i][j - 1]);
                }
            }
        }
    }

    public Map<Node, MyArrayList<Node>> getAdjList() {
        return adjlist;
    }

}
