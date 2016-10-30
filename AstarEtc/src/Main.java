import algorithms.Astar;
import algorithms.Dijkstra;
import algorithms.IDAstar;
import datastructures.MyArrayList;
import datastructures.MyHashMap;
import graph.NetBuilder;
import graph.Node;
import java.io.File;
import ui.UserInterface;
import utilities.FileReader;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UserInterface ui = new UserInterface();
        ui.start();
        
//        System.out.println("The original map: ");
//        NetBuilder netbuild = new NetBuilder();
//        FileReader filereader = new FileReader();
//        MyArrayList netArray = filereader.readNetFromFile(new File("map100_1.txt"));
//
//        Node[][] net = netbuild.createNetFromArray(netArray);
//        Node startNode = netbuild.getStartNode();
//        Node endNode = netbuild.getEndNode();
//        Node[][] adjArray = netbuild.getAdjArray();
//
//        Astar astar = new Astar();
//        long timestamp = System.currentTimeMillis();
//        System.out.println("A*");
//        astar.astar(net, startNode, endNode, adjArray);
//        System.out.println("Running time was " + (System.currentTimeMillis() - timestamp) + " ms");
//        System.out.println("");
        
//        Dijkstra dijkstra = new Dijkstra();
//        timestamp = System.currentTimeMillis();
//        System.out.println("Dijkstra");
//        dijkstra.dijkstra(net, startNode, endNode, adjArray);
//        System.out.println("Running time was " + (System.currentTimeMillis() - timestamp) + " ms");
//        System.out.println("");
//
//        System.out.println("IDA*");
//        IDAstar idastar = new IDAstar();
//        long timestamp2 = System.currentTimeMillis();
//        idastar.idastar(net, startNode, endNode, adjArray);
//        System.out.println("Running time was " + (System.currentTimeMillis() - timestamp2) + " ms");

    }
}
