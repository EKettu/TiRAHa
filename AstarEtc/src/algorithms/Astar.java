package algorithms;

import graph.Path;
import graph.Node;
import datastructures.Heap;
import datastructures.MyArrayList;
import java.util.*;

public class Astar {

    /**
     * a map containing the adjacent nodes
     */
    private Map<Node, MyArrayList<Node>> adjlist;
    /**
     * a matrix of nodes already visited
     */
    private boolean[][] visited;

    /**
     * A* algorithm, calculates the shortest path between two nodes
     *
     * @param net, a matrix of nodes, received as a parameter
     * @param startNode, starting point of the search
     * @param endNode, end point of the search
     */
    public void astar(Node[][] net, Node startNode, Node endNode) {
        visited = new boolean[net.length][net.length];
        boolean found = false;
        HashMap<Node, Node> path = new HashMap<Node, Node>();
        Heap heap = new Heap(net.length);
        Node[] table = new Node[net.length * net.length];

        createAdjList(net);
        heap.heapInsert(table, startNode);

        while (!found) {
            if (heap.empty()) {
                System.out.println("Polkua ei löydy.");
                break;
            }
            Node node = heap.heapDeleteMin(table);
            visited[node.getY()][node.getX()] = true;

            for (int i = 0; i < adjlist.get(node).size(); i++) {
                Node adjNode = adjlist.get(node).get(i);
                if (adjNode == endNode) {
                    found = true;
                    visited[adjNode.getY()][adjNode.getX()] = true;
                }
                if (adjNode.getStartD() > node.getStartD() + adjNode.getWeight()) {
                    adjNode.setStartD(node.getStartD() + adjNode.getWeight());
                    heap.heapInsert(table, adjNode);
                    path.put(adjNode, node);
                }
            }
        }
        if (found) {
            Path path2 = new Path();
            path2.shortestPath(path, endNode, startNode);
            path2.showPath(net, visited, startNode, endNode);
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
