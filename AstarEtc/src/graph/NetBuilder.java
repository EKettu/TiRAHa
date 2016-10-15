package graph;

import datastructures.MyArrayList;
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
        //   System.out.println("array.size " + array.size());
        Node[][] net = new Node[array.size()][array.size()]; //pitää olla neliönmallinen...
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size(); j++) {
                String row = (String) array.get(i);
                //  System.out.println("row.charAt(j) " + row.charAt(j) + " j on " +j + " i on " + i);
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
                    System.out.println("virhe");
                    System.out.println("row.charAt(j) " + row.charAt(j) + " j on " + j + " i on " + i);
                }
            }
            System.out.println("");
        }

        if (!startFound || !endFound) {
            System.out.println("Verkosta puuttuu alku- tai loppusolmu");
            return null;
        }
        System.out.println("");
        setEndDistances(net);
        return net;
    }

    /**
     * Method to set the distances of all nodes from the end node
     *
     * @param net Node[][], received as a parameter, the net of nodes
     */
    private static void setEndDistances(Node[][] net) {
        //  System.out.println("Verkon solmujen numerot ");
        for (int i = 0; i < net.length; i++) {          //taas pitää olla neliöitä
            for (int j = 0; j < net.length; j++) {
                net[i][j].setEndD(Math.abs(i - endNode.getY()) + Math.abs(j - endNode.getX()));
                //      System.out.print(net[i][j].getNumber() + " ");
            }
            //   System.out.println("");
        }
    }

    public static Node getStartNode() {
        return startNode;
    }

    public static Node getEndNode() {
        return endNode;
    }
}
