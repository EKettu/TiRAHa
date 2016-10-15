
import algorithms.Astar;
import algorithms.IDAstar;
import datastructures.MyArrayList;
import graph.NetBuilder;
import graph.Node;
import java.io.File;
import utilities.FileReader;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NetBuilder netbuild = new NetBuilder();
        FileReader filereader = new FileReader();
        MyArrayList netArray = filereader.readNetFromFile(new File("map10_2.txt"));

        Node[][] net = netbuild.createNetFromArray(netArray);
        Node startNode = netbuild.getStartNode();
        Node endNode = netbuild.getEndNode();
//
//        Astar astar = new Astar();
//        long timestamp = System.currentTimeMillis();
//        System.out.println("A*");
//        astar.astar(net, startNode, endNode);
//        System.out.println("Aikaa kului " + (System.currentTimeMillis() - timestamp) + " ms");
//        System.out.println("");
//        
//        net = netbuild.createNetFromArray(netArray);  //jos A*:in ja IDA*:in haluaa ajaa  peräkkäin
//        startNode = netbuild.getStartNode();          // pitää tehdä nämä
//        endNode = netbuild.getEndNode();
        System.out.println("IDA*");
        IDAstar idastar = new IDAstar();
        idastar.idastar(net, startNode, endNode);

    }
}
