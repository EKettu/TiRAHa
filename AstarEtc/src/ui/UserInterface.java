package ui;

import algorithms.Astar;
import algorithms.Dijkstra;
import algorithms.IDAstar;
import datastructures.MyArrayList;
import graph.NetBuilder;
import graph.Node;
import java.io.File;
import java.util.Scanner;
import utilities.FileReader;

public class UserInterface {

    /**
     * Scanner to read input from the user
     */
    private Scanner scanner;

    /**
     * Method to run the program
     */
    public void start() {
        System.out.println("Pathfinding algorithms");
        listFiles();
        scanner = new Scanner(System.in);
        System.out.println("Write the name of your chosen file. Press x to exit the program.");
        String fileName = scanner.nextLine();
        if (fileName.equalsIgnoreCase("x")) {
            System.out.println("Goodbye");
        }
        System.out.println("Choose the algorithm. A -> A*, D -> Dijkstra, I -> IDA*, E -> all three");
        String algorithm = scanner.nextLine();

        if (algorithm.equalsIgnoreCase("x")) {
            System.out.println("Goodbye");
        } else {

            NetBuilder netbuild = new NetBuilder();
            FileReader filereader = new FileReader();
            MyArrayList netArray = filereader.readNetFromFile(new File(fileName));

            System.out.println("The original map: ");
            Node[][] net = netbuild.createNetFromArray(netArray);
            Node startNode = netbuild.getStartNode();
            Node endNode = netbuild.getEndNode();
            Node[][] adjArray = netbuild.getAdjArray();

            if (algorithm.equalsIgnoreCase("A")) {
                runAstar(net, startNode, endNode, adjArray);

            } else if (algorithm.equalsIgnoreCase("D")) {
                runDijkstra(net, startNode, endNode, adjArray);
            } else if (algorithm.equalsIgnoreCase("I")) {
                runIDAstar(net, startNode, endNode, adjArray);
            } else if (algorithm.equalsIgnoreCase("E")) {
                runAstar(net, startNode, endNode, adjArray);
                runDijkstra(net, startNode, endNode, adjArray);
                runIDAstar(net, startNode, endNode, adjArray);
            }

        }

    }

    /**
     * Method to print all .txt-files containing the nets
     */
    private void listFiles() {
        String filePath = ".";
        File file = new File(filePath);
        File[] files = file.listFiles();
        System.out.println("Available files: ");
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().endsWith(".txt") || files[i].getName().endsWith(".TXT")) {
                System.out.println(files[i].getName());
            }
        }
    }

    /**
     * Method to run A* algorithm
     *
     * @param net Node[][], received as a parameter, the net containing all
     * nodes
     * @param startNode Node, received as a parameter, start point of the search
     * @param endNode Node, received as a parameter, end point of the search
     * @param adjArray Node[][], received as a parameter, contains adjacency
     * nodes
     */
    private void runAstar(Node[][] net, Node startNode, Node endNode,
            Node[][] adjArray) {
        Astar astar = new Astar();
        long timestamp = System.currentTimeMillis();
        System.out.println("A*");
        astar.astar(net, startNode, endNode, adjArray);
        System.out.println("Running time " + (System.currentTimeMillis() - timestamp) + " ms");
        System.out.println("");
    }

    /**
     * Method to run IDA* algorithm
     *
     * @param net Node[][], received as a parameter, the net containing all
     * nodes
     * @param startNode Node, received as a parameter, start point of the search
     * @param endNode Node, received as a parameter, end point of the search
     * @param adjArray Node[][], received as a parameter, contains adjacency
     * nodes
     */
    private void runIDAstar(Node[][] net, Node startNode, Node endNode,
            Node[][] adjArray) {
        System.out.println("IDA*");
        IDAstar idastar = new IDAstar();
        long timestamp = System.currentTimeMillis();
        idastar.idastar(net, startNode, endNode, adjArray);
        System.out.println("Running time " + (System.currentTimeMillis() - timestamp) + " ms");
    }

    /**
     * Method to run Dijkstra algorithm
     *
     * @param net Node[][], received as a parameter, the net containing all
     * nodes
     * @param startNode Node, received as a parameter, start point of the search
     * @param endNode Node, received as a parameter, end point of the search
     * @param adjArray Node[][], received as a parameter, contains adjacency
     * nodes
     */
    private void runDijkstra(Node[][] net, Node startNode, Node endNode,
            Node[][] adjArray) {
        System.out.println("Dijkstra");
        Dijkstra dijkstra = new Dijkstra();
        long timestamp = System.currentTimeMillis();
        dijkstra.dijkstra(net, startNode, endNode, adjArray);
        System.out.println("Running time " + (System.currentTimeMillis() - timestamp) + " ms");
    }

}
