package graph;

import datastructures.MyArrayList;
import datastructures.MyHashMap;
import datastructures.MyHashSet;
import graph.Node;
import datastructures.MyStack;
import java.util.*;

public class Path {

    /**
     * length of the shortest path
     */
    private int length;
    /**
     * set that contains numbers of the nodes on the shortest path
     */
    private MyHashSet<Integer> nodePath;

    /**
     * Method to print the shortest path between two nodes
     *
     * @param netsize, size of a net, received as a parameter
     * @param path MyHashMap, received as a parameter, contains the path between
     * the start and the end
     * @param node Node, received as a parameter, the end node
     * @param startNode Node, received as a parameter, the start node
     */
    public void shortestPath(int netsize, MyHashMap<Node, Node> path, Node node, Node startNode) {
        Node node2 = path.get(node);
        length = 0 + node2.getWeight();
        MyStack stack = new MyStack(netsize);
        nodePath = new MyHashSet<Integer>();
        while (node2 != startNode) {
            stack.push(node2.getNumber());
            node2 = path.get(node2);
            length = length + node2.getWeight();
        }

        System.out.println("Polku koostuu solmuista : ");
        System.out.print(startNode.getNumber() + " ");
        while (!stack.empty()) {
            int x = stack.pop();
            nodePath.add(x);
            System.out.print(x + " ");
        }

        System.out.print(node.getNumber());
        System.out.println("");
        System.out.println("Polun pituus on " + length);

    }

    /**
     * Method to show the node matrix with the start and end nodes, all visited
     * nodes (and the actual shortest path)
     *
     * @param net Node[][], received as a parameter, the net of nodes
     * @param visited boolean[][], received as a parameter, tells if node is
     * visited
     * @param startNode Node, received as a parameter, the start node
     * @param endNode Node, received as a parameter, the end node
     */
    public void showPath(Node[][] net, boolean[][] visited, Node startNode, Node endNode) {

        for (int i = 0; i < net.length; i++) {
            for (int j = 0; j < net.length; j++) {
                if (visited[i][j]) {
                    if (nodePath.contains(net[i][j].getNumber())) {
                        System.out.print("@ ");
                    } else if (net[i][j] == startNode) {
                        System.out.print("s ");
                    } else if (net[i][j] == endNode) {
                        System.out.print("e ");
                    } else {
                        System.out.print("x ");
                    }
                } else if (net[i][j].getNumber() == 0) {
                    System.out.print("# ");
                } else if (net[i][j].getWeight() > 1) {
                    System.out.print("o ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println("");
        }
    }

    public int getLength() {
        return this.length;
    }
}
