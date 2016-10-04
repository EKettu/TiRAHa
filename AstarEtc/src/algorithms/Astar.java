package algorithms;

import graph.NetBuilder;
import graph.Path;
import graph.Node;
import datastructures.Heap;
import datastructures.MyArrayList;
import java.io.File;
import java.util.*;
import utilities.FileReader;

public class Astar {

    /**
     * set of nodes already visited
     */
    private HashSet<Node> visited;
//    /**
//     * heap from which the next node to be processed is selected
//     */
    //  private static PriorityQueue<Node> nodeheap;
    /**
     * map containing the adjacent nodes
     */
    //  private static Map<Node, ArrayList<Node>> adjlist;
    private Map<Node, MyArrayList<Node>> adjlist;
    /**
     * starting point of the search
     */
    private Node startNode;
    /**
     * end point of the search
     */
    private Node endNode;

    /**
     * A* algorithm, calculates the shortest path between two nodes
     */
    public void astar() {
        //   nodeheap = new PriorityQueue<Node>();
        visited = new HashSet<Node>();
        NetBuilder netbuild = new NetBuilder();
        FileReader filereader = new FileReader(); //siirrettävä Mainiin...
        MyArrayList netArray = filereader.readNetFromFile(new File("test.txt"));

        // Node[][] net = netbuild.createNet(n, startY, startX, endY, endX);
        Node[][] net = netbuild.createNetFromArray(netArray);

        startNode = netbuild.getStartNode();
        endNode = netbuild.getEndNode();
        HashMap<Node, Node> path = new HashMap<Node, Node>();

        Heap heap = new Heap(net.length);
        Node[] table = new Node[net.length * net.length];
        startNode.setStartD(0);
        createAdjList(net);

        //  nodeheap.add(startNode);
        heap.heapInsert(table, startNode);

        while (!visited.contains(endNode)) { //jos ei polkua löydy, säädettävä
            //  Node node = nodeheap.poll();
            Node node = heap.heapDeleteMin(table);
            //  System.out.println("Noden numero " + node.getNumber());
            visited.add(node);
            for (int i = 0; i < adjlist.get(node).size(); i++) {
                Node adjNode = adjlist.get(node).get(i);
                if (adjNode.getStartD() > node.getStartD() + adjNode.getWeight()) {
                    adjNode.setStartD(node.getStartD() + adjNode.getWeight());
                    heap.heapInsert(table, adjNode);
                    path.put(adjNode, node);
                }
//            for (Node adjNode : adjlist.get(node)) {
//                if (adjNode.getStartD() > node.getStartD() + adjNode.getWeight()) {
//                    adjNode.setStartD(node.getStartD() + adjNode.getWeight());
//                      nodeheap.add(adjNode);
//                   // heap.heapInsert(table, adjNode);
//                    path.put(adjNode, node);
//
//                }
            }
        }
        Path path2 = new Path();
        path2.shortestPath(path, endNode, startNode);
        path2.showPath(net, visited, startNode, endNode);

    }

    /**
     * Creates an adjacency list for all nodes
     *
     * @param net Node[][], received as a parameter, contains all nodes in the
     * net
     */
    public void createAdjList(Node[][] net) {
        // adjlist = new HashMap<Node, ArrayList<Node>>();
        adjlist = new HashMap<Node, MyArrayList<Node>>();
        for (int i = 0; i < net.length; i++) {
            for (int j = 0; j < net.length; j++) {
                // adjlist.put(net[i][j], new ArrayList<Node>());
                adjlist.put(net[i][j], new MyArrayList());
                if (i + 1 < net.length && net[i + 1][j].getNumber()!=0) {
                    //   adjlist.get(net[i][j]).add(net[i + 1][j]);
                    adjlist.get(net[i][j]).add(net[i + 1][j]);
                }
                if (i - 1 >= 0 && net[i - 1][j].getNumber()!=0) {
                    //  adjlist.get(net[i][j]).add(net[i - 1][j]);
                    adjlist.get(net[i][j]).add(net[i - 1][j]);
                }
                if (j + 1 < net.length && net[i][j + 1].getNumber()!=0) {
                    //  adjlist.get(net[i][j]).add(net[i][j + 1]);
                    adjlist.get(net[i][j]).add(net[i][j + 1]);
                }
                if (j - 1 >= 0 && net[i][j - 1].getNumber()!=0) {
                    //  adjlist.get(net[i][j]).add(net[i][j - 1]);
                    adjlist.get(net[i][j]).add(net[i][j - 1]);
                }
            }
        }
    }
//
//    public Map<Node, ArrayList<Node>> getAdjList() {
//        return adjlist;
//    }

    public Map<Node, MyArrayList<Node>> getAdjList() {
        return adjlist;
    }
}
