package graph;

import datastructures.MyArrayList;
import datastructures.MyHashMap;
import graph.Node;

public class NetBuilder {

    /**
     * the starting point of a search
     */
    private static Node startNode;
    /**
     * the end node of a search
     */
    private static Node endNode;

    private static Node[][] adjArray;

    /**
     * a map containing the adjacent nodes
     */
    private static MyHashMap<Node, MyArrayList<Node>> adjlist;

    /**
     * Method to create a net from an array received
     *
     * @param array MyArrayList, received as a parameter, contains the net as
     * strings
     * @return a net of nodes in an array
     */
    public static Node[][] createNetFromArray(MyArrayList array) {
        boolean startFound = false;
        boolean endFound = false;
        int k = 1;
        System.out.println("Alkuperäinen verkko: ");
        Node[][] net = new Node[array.size()][array.size()]; //pit‰‰ olla neliˆnmallinen...
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size(); j++) {
                String row = (String) array.get(i);
                try {
                    if (row.charAt(j) == 's') {
                        startFound = true;
                        startNode = new Node(k, i, j, 0, 0, 1);
                        net[i][j] = startNode;
                        System.out.print("s ");
                    }
                    if (row.charAt(j) == 'e') {
                        endFound = true;
                        endNode = new Node(k, i, j, Integer.MAX_VALUE, 0, 1);
                        net[i][j] = endNode;
                        System.out.print("e ");
                    }
                    if (row.charAt(j) == '#') {
                        net[i][j] = new Node(0, i, j, Integer.MAX_VALUE, Integer.MAX_VALUE,
                                Integer.MAX_VALUE);
                        System.out.print("# ");
                    }
                    if (row.charAt(j) == 'o') {
                        net[i][j] = new Node(k, i, j, Integer.MAX_VALUE, 0, 10);
                        System.out.print("o ");
                    }
                    if (row.charAt(j) == '.') {
                        net[i][j] = new Node(k, i, j, Integer.MAX_VALUE, 0, 1);
                        System.out.print(". ");
                    }
                    k++;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            System.out.println("");
        }

        if (!startFound || !endFound) {
            System.out.println("Verkosta puuttuu alku- tai loppusolmu");
            return null;
        }
        System.out.println("");
      //  createAdjArray(net);
      //  setEndDistances(net);
        createAdjArray(net);
      //  createAdjList(net);
        return net;
    }

//    /**
//     * Method to set the distances of all nodes from the end node
//     *
//     * @param net Node[][], received as a parameter, the net of nodes
//     */
//    private static void setEndDistances(Node[][] net) {
//          System.out.println("Verkon solmujen numerot ");
//        for (int i = 0; i < net.length; i++) {          //taas pit‰‰ olla neliˆit‰
//            for (int j = 0; j < net.length; j++) {
//                net[i][j].setEndD(Math.abs(i - endNode.getY()) + Math.abs(j - endNode.getX()));
//                     System.out.print(net[i][j].getNumber() + " ");
//            }
//               System.out.println("");
//        }
//    }

//    /**
//     * Creates an adjacency list for all nodes
//     *
//     * @param net Node[][], received as a parameter, contains all nodes in the
//     * net
//     */
//    private static void createAdjList(Node[][] net) {
//        adjlist = new MyHashMap<Node, MyArrayList<Node>>();
//        for (int i = 0; i < net.length; i++) {
//            for (int j = 0; j < net.length; j++) {
//                adjlist.put(net[i][j], new MyArrayList());
//                if (i + 1 < net.length && net[i + 1][j].getNumber() != 0) {
//                    adjlist.get(net[i][j]).add(net[i + 1][j]);
//                }
//                if (i - 1 >= 0 && net[i - 1][j].getNumber() != 0) {
//                    adjlist.get(net[i][j]).add(net[i - 1][j]);
//                }
//                if (j + 1 < net.length && net[i][j + 1].getNumber() != 0) {
//                    adjlist.get(net[i][j]).add(net[i][j + 1]);
//                }
//                if (j - 1 >= 0 && net[i][j - 1].getNumber() != 0) {
//                    adjlist.get(net[i][j]).add(net[i][j - 1]);
//                }
//            }
//        }
//    }

        /**
     * Creates an adjacency array for all nodes
     *
     * @param net Node[][], received as a parameter, contains all nodes in the
     * net
     */
    private static void createAdjArray(Node[][] net) {
        adjArray = new Node[(net.length* net.length)+1 ][5];
        int k = 0;
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

//    public MyHashMap<Node, MyArrayList<Node>> getAdjList() {
//        return adjlist;
//    }

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