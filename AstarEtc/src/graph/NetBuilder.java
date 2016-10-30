package graph;

import datastructures.MyArrayList;
import datastructures.MyHashMap;
import graph.Node;

/**
 * Builds a net of nodes for path-finding algorithms
 *
 * @author ekettu
 */
public class NetBuilder {

    /**
     * The starting point of a search
     */
    private static Node startNode;
    /**
     * The end node of a search
     */
    private static Node endNode;
    /**
     * Array that contains adjacency nodes
     */
    private static Node[][] adjArray;

    /**
     * Method to create a net from an array received
     *
     * @param array MyArrayList, received as a parameter, contains the net as
     * strings
     * @return a net of nodes in an array, or null if array containing the net
     * was null
     */
    public static Node[][] createNetFromArray(MyArrayList array) {
        boolean startFound = false;
        boolean endFound = false;
        int k = 1;
        if (array != null) {
            Node[][] net = new Node[array.size()][array.size()]; //pit‰‰ olla neliˆnmallinen...
            for (int i = 0; i < array.size(); i++) {
                for (int j = 0; j < array.size(); j++) {
                    String row = (String) array.get(i);
                    try {
                        if (row.charAt(j) == 's') {
                            if (startFound == true) {
                                System.out.println("Too many start nodes!");
                                return null;
                            }

                            startFound = true;
                            startNode = new Node(k, i, j, 0, 0, 1);
                            net[i][j] = startNode;
                            System.out.print("s");

                        }
                        if (row.charAt(j) == 'e') {
                            if (endFound == true) {
                                System.out.println("Too many end nodes!");
                                return null;
                            }

                            endFound = true;
                            endNode = new Node(k, i, j, Integer.MAX_VALUE, 0, 1);
                            net[i][j] = endNode;
                            System.out.print("e");

                        }
                        if (row.charAt(j) == '#') {
                            net[i][j] = new Node(0, i, j, Integer.MAX_VALUE, Integer.MAX_VALUE,
                                    Integer.MAX_VALUE);
                            System.out.print("#");
                        }
                        if (row.charAt(j) == 'o') {
                            net[i][j] = new Node(k, i, j, Integer.MAX_VALUE, 0, 10);
                            System.out.print("o");
                        }
                        if (row.charAt(j) == '.') {
                            net[i][j] = new Node(k, i, j, Integer.MAX_VALUE, 0, 1);
                            System.out.print(".");
                        }
                        k++;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                System.out.println("");
            }

            if (!startFound || !endFound) {
                System.out.println("Net is missing either the start node or the end node.");
                return null;
            }
            System.out.println("");
            createAdjArray(net);
            return net;
        } else {
            System.out.println("Could not create a net, array null.");
            return null;
        }
    }

    /**
     * Creates an adjacency array for all nodes and calculates end distances for
     * all nodes
     *
     * @param net Node[][], received as a parameter, contains all nodes in the
     * net
     */
    private static void createAdjArray(Node[][] net) {
        adjArray = new Node[(net.length * net.length) + 1][5];
        for (int i = 0; i < net.length; i++) {
            for (int j = 0; j < net.length; j++) {
                int counter = 0;
                if (net[i][j].getNumber() != 0) {

                    net[i][j].setEndD(Math.abs(i - endNode.getY()) + Math.abs(j - endNode.getX()));
                    if (i + 1 < net.length && net[i + 1][j].getNumber() != 0) {
                        adjArray[net[i][j].getNumber()][counter] = net[i + 1][j];
                        counter++;
                    }
                    if (i - 1 >= 0 && net[i - 1][j].getNumber() != 0) {
                        adjArray[net[i][j].getNumber()][counter] = net[i - 1][j];
                        counter++;
                    }
                    if (j + 1 < net.length && net[i][j + 1].getNumber() != 0) {
                        adjArray[net[i][j].getNumber()][counter] = net[i][j + 1];
                        counter++;
                    }
                    if (j - 1 >= 0 && net[i][j - 1].getNumber() != 0) {
                        adjArray[net[i][j].getNumber()][counter] = net[i][j - 1];
                        counter++;
                    }
                    while (counter < 3) {
                        adjArray[net[i][j].getNumber()][counter] = null;
                        counter++;
                    }
                }
            }
        }
    }

    public Node[][] getAdjArray() {
        return adjArray;
    }

    public Node getStartNode() {
        return startNode;
    }

    public Node getEndNode() {
        return endNode;
    }
}
