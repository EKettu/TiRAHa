package algorithms;

import graph.Path;
import graph.Node;
import datastructures.Heap;
import datastructures.MyArrayList;
import datastructures.MyHashMap;
import java.util.*;

public class Astar {

    /**
     * MyHashMap containing the shortest path between two nodes
     */
    private MyHashMap<Node, Node> path;

    /**
     * A* algorithm, calculates the shortest path between two nodes
     *
     * @param net, a matrix of nodes, received as a parameter
     * @param startNode, starting point of the search
     * @param endNode, end point of the search
     * @param adjArray Node[][], contains adjacency nodes
     */
    public void astar(Node[][] net, Node startNode, Node endNode, Node[][] adjArray) {
        boolean[][] visited = new boolean[net.length][net.length];
        boolean found = false;
        path = new MyHashMap<Node, Node>();
        Heap heap = new Heap(net.length);
        Node[] table = new Node[net.length * net.length];
        int netsize = net.length * net.length;

        heap.heapInsert(table, startNode);

        while (!found) {
            if (heap.empty()) {
                System.out.println("Polkua ei lˆydy.");
                break;
            }
            Node node = heap.heapDeleteMin(table);
            visited[node.getY()][node.getX()] = true;

            for (int i = 0; i < 4; i++) {
                Node adjNode = adjArray[node.getNumber()][i];
                if(adjNode != null) {
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
        }

        if (found) {
            Path path2 = new Path();
            path2.shortestPath(netsize, path, endNode, startNode);
            path2.showPath(net, visited, startNode, endNode);
        }
    }

    public MyHashMap<Node, Node> getPath() {
        return path;
    }
}
