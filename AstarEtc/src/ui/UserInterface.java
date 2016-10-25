package ui;

import algorithms.Astar;
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
        scanner = new Scanner(System.in);
        System.out.println("Kirjoita haluamasi tiedoston nimi. X lopettaa");
        String fileName = scanner.nextLine();
        System.out.println("Valitse haluamasi algoritmi. A -> A*, I -> IDA*, B -> molemmat");
        String algorithm = scanner.nextLine();

        if (fileName.equalsIgnoreCase("x") || algorithm.equalsIgnoreCase("x")) {
            System.out.println("Lopetus");
        } else {

            NetBuilder netbuild = new NetBuilder();
            FileReader filereader = new FileReader();
            MyArrayList netArray = filereader.readNetFromFile(new File(fileName));

            Node[][] net = netbuild.createNetFromArray(netArray);
            Node startNode = netbuild.getStartNode();
            Node endNode = netbuild.getEndNode();
            Node[][] adjArray = netbuild.getAdjArray();

            if (algorithm.equalsIgnoreCase("A")) {
                runAstar(net, startNode, endNode, adjArray);

            } else if (algorithm.equalsIgnoreCase("I")) {
                runIDAstar(net, startNode, endNode, adjArray);
            } else if (algorithm.equalsIgnoreCase("B")) {
                runAstar(net, startNode, endNode, adjArray);
                runIDAstar(net, startNode, endNode, adjArray);
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
     * @param adjArray  Node[][], received as a parameter, contains adjacency
     * nodes
     */
    private void runAstar(Node[][] net, Node startNode, Node endNode,
            Node[][] adjArray) {
        Astar astar = new Astar();
        long timestamp = System.currentTimeMillis();
        System.out.println("A*");
        astar.astar(net, startNode, endNode, adjArray);
        System.out.println("Aikaa kului " + (System.currentTimeMillis() - timestamp) + " ms");
        System.out.println("");

    }

    /**
     * Method to run IDA* algorithm
     *
     * @param net Node[][], received as a parameter, the net containing all
     * nodes
     * @param startNode Node, received as a parameter, start point of the search
     * @param endNode Node, received as a parameter, end point of the search
     * @param adjArray  Node[][], received as a parameter, contains adjacency
     * nodes
     */
    private void runIDAstar(Node[][] net, Node startNode, Node endNode,
            Node[][] adjArray) {
        System.out.println("IDA*");
        IDAstar idastar = new IDAstar();
        long timestamp2 = System.currentTimeMillis();
        idastar.idastar(net, startNode, endNode, adjArray);
        System.out.println("Aikaa kului " + (System.currentTimeMillis() - timestamp2) + " ms");

    }

}
