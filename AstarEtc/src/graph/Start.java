package graph;

import graph.Node;

public class Start {

    /**
     * the starting point of a search
     */
    private Node startNode;
    /**
     * the end node of a search
     */
    private Node endNode;

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
    public Node[][] createNet(int n, int startY, int startX, int endY, int endX) {
        Node[][] net = new Node[n][n];
        int k = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == startY && j == startX) {
                    startNode = new Node(k, i, j, 0, Math.abs((i - endY) + (j - endX)), 1);
                    net[i][j] = startNode;
                } else if (i == endY && j == endX) {
                    endNode = new Node(k, i, j, Integer.MAX_VALUE, Math.abs((i - endY) + (j - endX)), 1);
                    net[i][j] = endNode;
                } else {
                    net[i][j] = new Node(k, i, j, Integer.MAX_VALUE, Math.abs((i - endY) + (j - endX)), 1);
                }
                k++;
                // System.out.print(net[i][j].getNumber() + " ");
            }
            //    System.out.println("");
        }
        return net;
    }

    public Node getStartNode() {
        return startNode;
    }

    public Node getEndNode() {
        return endNode;
    }
}
