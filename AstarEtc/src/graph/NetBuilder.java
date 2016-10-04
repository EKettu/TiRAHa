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
     * Creates a matrix/net of nodes and sets the start and end distances for
     * all nodes including start node and end node
     *
     * @param n integer, received as a parameter, the size of the node matrix
     * @param startY integer, received as a parameter, y coordinate of the start
     * node
     * @param startX integer, received as a parameter, x coordinate of the start
     * node
     * @param endY integer, received as a parameter, y coordinate of the end
     * node
     * @param endX integer, received as a parameter, x coordinate of the end
     * node
     * @return
     */
    public static Node[][] createNet(int n, int startY, int startX, int endY, int endX) {
        if (startY > n - 1 || startX > n - 1 || endY > n - 1 || endX > n - 1) {
            System.out.println("Koordinaatit ovat verkon ulkopuolella");
            return null;
        } else {
            Node[][] net = new Node[n][n];
            int k = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == startY && j == startX) {
                        startNode = new Node(k, i, j, 0, Math.abs(i - endY) + Math.abs(j - endX), 1);
                        net[i][j] = startNode;
                    } else if (i == endY && j == endX) {
                        endNode = new Node(k, i, j, Integer.MAX_VALUE, Math.abs(i - endY) + Math.abs(j - endX), 1);
                        net[i][j] = endNode;
                    } else {
                        net[i][j] = new Node(k, i, j, Integer.MAX_VALUE, Math.abs(i - endY) + Math.abs(j - endX), 1);
                    }
                    k++;
                    // System.out.print(net[i][j].getNumber() + " ");
                        }
                System.out.println("");
                     }
            return net;
        }
    }

    public static Node[][] createNetFromArray(MyArrayList array) {
        boolean startFound = false;
        boolean endFound = false;
        int k = 1;
        Node[][] net = new Node[array.size()][array.size()]; //pitää olla neliönmallinen...
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size(); j++) {
                String row = (String) array.get(i);
                if (row.charAt(j) == 's') {
                    startFound = true;
                    startNode = new Node(k, i, j, 0, 0, 1);
                    net[i][j] = startNode;
                }
                if (row.charAt(j) == 'e') {
                    endFound = true;
                    endNode = new Node(k, i, j, Integer.MAX_VALUE, 0, 1);
                    net[i][j] = endNode;
                }
                if (row.charAt(j) == '#') {
                    net[i][j] = new Node(0, i, j, Integer.MAX_VALUE, Integer.MAX_VALUE,
                            Integer.MAX_VALUE);
                }
                if (row.charAt(j) == 'o') {
                    net[i][j] = new Node(0, i, j, Integer.MAX_VALUE, 0, 10);
                }
                if (row.charAt(j) == '.') {
                    net[i][j] = new Node(k, i, j, Integer.MAX_VALUE, 0, 1);
                }
                k++;
            }
        }

        if (!startFound || !endFound) {
            System.out.println("Verkosta puuttuu alku- tai loppusolmu");
            return null;
        }
        setEndDistances(net);
        return net;
    }

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

    public Node getStartNode() {
        return startNode;
    }

    public Node getEndNode() {
        return endNode;
    }
}
