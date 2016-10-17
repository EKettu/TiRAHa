
import algorithms.Astar;
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
//        NetBuilder netbuild = new NetBuilder();
//        FileReader filereader = new FileReader();
//        MyArrayList netArray = filereader.readNetFromFile(new File("map10_1.txt"));
//
//        Node[][] net = netbuild.createNetFromArray(netArray);
//        Node startNode = netbuild.getStartNode();
//        Node endNode = netbuild.getEndNode();
//        MyHashMap<Node, MyArrayList<Node>> adjlist = netbuild.getAdjList();
//        MyHashMap<Node, MyArrayList<Node>> adjlist2 = netbuild.getAdjList();
//
//        Astar astar = new Astar();
//        long timestamp = System.currentTimeMillis();
//        System.out.println("A*");
//        astar.astar(net, startNode, endNode, adjlist);
//        System.out.println("Aikaa kului " + (System.currentTimeMillis() - timestamp) + " ms");
//        System.out.println("");
//
//        System.out.println("IDA*");
//        IDAstar idastar = new IDAstar();
//        long timestamp2 = System.currentTimeMillis();
//        idastar.idastar(net, startNode, endNode, adjlist2);
//        System.out.println("Aikaa kului " + (System.currentTimeMillis() - timestamp2) + " ms");

    }
}
