
public class Start {
    
    public static Node[][] createNet(int n, Node startNode, Node endNode) {
    
        Node[][] net = new Node[n][n];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
              //  net[i][j] = new Node(i, j, 0, 0, i);
                net[i][j] = new Node(i, j, Integer.MAX_VALUE, Math.abs((i - endNode.getI()) + (j - endNode.getJ())), 0);
                   System.out.print(net[i][j].getEndD());
                  // System.out.println("");
            }
            System.out.println("");
        }
    //    initialize(net, startNode, endNode);
        
        return net;
    }

//    public static void initialize(Node[][] nodes, Node startNode, Node endNode) {
//        for (int i = 0; i < nodes.length; i++) {
//            for (int j = 0; j < nodes.length; j++) {
//                nodes[i][j].setStartD(Integer.MAX_VALUE);
//                nodes[i][j].setEndD(Math.abs((i - endNode.getI()) + (j - endNode.getJ())));
//                System.out.print(nodes[i][j].getEndD());
//
//            }
//                 System.out.println("");
//        }
//    }
//
}
