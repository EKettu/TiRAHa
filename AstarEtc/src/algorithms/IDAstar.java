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
     * tells if endNode has been found
     */
      private boolean found2;
    
    /**
     * a map of nodes on the path
     */
    private MyHashMap<Node, Node> path;
    
    /**
     * Number of the endNode
     */
 //   private int found;
    
    /**
     * End point of the search
     */
    private Node endNode;
    

    //Ei toimi...
    
    
    /**
     * IDA* algorithm, calculates the shortest path between two nodes
     *
     * @param net, a matrix of nodes, received as a parameter
     * @param startNode, starting point of the search
     * @param endNode, end point of the search
     */
    public void idastar(Node[][] net, Node startNode, Node endNode) {
        this.endNode = endNode;
        visited = new boolean[net.length][net.length];
        path = new MyHashMap<Node, Node>();
        int netsize = net.length * net.length;
        found2 = false;
    //    found = endNode.getNumber();
        createAdjList(net);

        int threshold = startNode.getStartD();

        while (true) {
            int temp = search(startNode, 0, threshold);
            if (found2) {
                System.out.println("Polku löytyi");
                printVisited(net.length);
//                Path path2 = new Path();
//                path2.shortestPath(netsize, path, endNode, startNode);
//                path2.showPath(net, visited, startNode, endNode);
                break;
            }

            if (temp > Integer.MAX_VALUE) { 
                System.out.println("Polkua ei löydy");
                break;
            }
            threshold = temp;
        }
    }
    
    private void printVisited(int n) {
        for(int i = 0; i < n; i++ ) {
            for (int j = 0; j< n; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private Integer search(Node node, int g, int threshold) {
        visited[node.getY()][node.getX()] = true;
        int f = g + node.getStartD()+node.getWeight()+node.getEndD();
        if (f > threshold) {
            return f;
        }

        if (node == endNode) {
            found2 = true;
         //   return found;
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < adjlist.get(node).size(); i++) {
            Node adjNode = adjlist.get(node).get(i);
            if (adjNode.getStartD() > node.getStartD() + adjNode.getWeight()) {
                    adjNode.setStartD(node.getStartD() + adjNode.getWeight());
            }
            int temp = search(adjNode, g + adjNode.getStartD()+adjNode.getEndD(), threshold);

//            if (temp == found) {
//                return found;
//            }
            if (temp < min) {
                min = temp;
            }
            path.put(adjNode, node);
            visited[adjNode.getY()][adjNode.getX()] = true;
        }

        return min;

    }

    /**
     * Creates an adjacency list for all nodes
     *
     * @param net Node[][], received as a parameter, contains all nodes in the
     * net
     */
    private void createAdjList(Node[][] net) {
        adjlist = new MyHashMap<Node, MyArrayList<Node>>();
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

    public MyHashMap<Node, MyArrayList<Node>> getAdjList() {
        return adjlist;
    }
    
}
