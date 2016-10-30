package algorithms;

import datastructures.Heap;
import datastructures.MyHashMap;
import graph.Node;
import graph.Path;

/**
 * Dijkstra's algorithm
 *
 * @author ekettu
 */
public class Dijkstra {

    /**
     * MyHashMap containing the shortest path between two nodes
     */
    private MyHashMap<Node, Node> path;
    /**
     * Array that contains distances of all nodes from the start node
     */
    private int[] distances;
    /**
     * Boolean value, true if the path has been found
     */
    private boolean found;

    /**
     * Dijkstra's path-finding algorithm
     *
     * @param net Node[][], a matrix of nodes, received as a parameter
     * @param startNode, starting point of the search
     * @param endNode, end point of the search
     * @param adjArray Node[][], contains adjacency nodes
     */
    public void dijkstra(Node[][] net, Node startNode, Node endNode, Node[][] adjArray) {
        boolean[][] visited = new boolean[net.length][net.length];
        found = false;
        path = new MyHashMap<Node, Node>();
        int netsize = net.length * net.length;
        distances = new int[netsize + 1];
        Heap heap = new Heap(net.length);
        Node[] table = new Node[net.length * net.length];
        initialize();
        heap.heapInsert(table, startNode);

        while (!heap.empty()) {
            Node node = heap.heapDeleteMin(table);

            if (!visited[node.getY()][node.getX()]) {
                visited[node.getY()][node.getX()] = true;

                for (int i = 0; i < 4; i++) {
                    Node adjNode = adjArray[node.getNumber()][i];

                    if (adjNode != null) {
                        if (adjNode == endNode) {
                            found = true;
                            visited[adjNode.getY()][adjNode.getX()] = true;
                        }
                        if (distances[adjNode.getNumber()] > adjNode.getWeight() + node.getStartD()) {
                            adjNode.setStartD(node.getStartD() + adjNode.getWeight());
                            distances[adjNode.getNumber()] = adjNode.getStartD();
                            heap.heapInsert(table, adjNode);
                            path.put(adjNode, node);
                        }
                    }
                }
            }
        }

        if (found) {
            System.out.println("Path found.");
            Path path2 = new Path();
            path2.shortestPath(netsize, path, endNode, startNode);
            path2.showPath(net, visited, startNode, endNode);
        } else {
            System.out.println("No path exists.");
        }
    }

    /**
     * Method to set all distances first to maximum length
     */
    private void initialize() {
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
    }

    public MyHashMap<Node, Node> getPath() {
        return path;
    }

    public boolean getFound() {
        return found;
    }
}
