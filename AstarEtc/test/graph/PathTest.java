package graph;

import graph.Path;
import algorithms.Astar;
import algorithms.Dijkstra;
import algorithms.IDAstar;
import datastructures.MyArrayList;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utilities.FileReader;

public class PathTest {

    Path path;
    Astar astar;
    IDAstar idastar;
    Dijkstra dijkstra;
    NetBuilder netbuild;
    FileReader filereader;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        path = new Path();
        astar = new Astar();
        idastar = new IDAstar();
        dijkstra = new Dijkstra();
        netbuild = new NetBuilder();
        filereader = new FileReader();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void pathLengthOkAstar() {
        File file = new File("test_small1.txt");
        MyArrayList array = filereader.readNetFromFile(file);
        Node[][] net = netbuild.createNetFromArray(array);
        astar.astar(net, netbuild.getStartNode(), netbuild.getEndNode(), netbuild.getAdjArray());
        path.shortestPath(net.length * net.length, astar.getPath(), netbuild.getEndNode(), netbuild.getStartNode());
        assertEquals(6, path.getLength());
    }

    @Test
    public void pathLengthOkIDAstar() {
        File file = new File("test_small1.txt");
        MyArrayList array = filereader.readNetFromFile(file);
        Node[][] net = netbuild.createNetFromArray(array);
        idastar.idastar(net, netbuild.getStartNode(), netbuild.getEndNode(), netbuild.getAdjArray());
        path.shortestPath(net.length * net.length, idastar.getPath(), netbuild.getEndNode(), netbuild.getStartNode());
        assertEquals(6, path.getLength());
    }

    @Test
    public void pathLengthOkDijkstra() {
        File file = new File("test_small1.txt");
        MyArrayList array = filereader.readNetFromFile(file);
        Node[][] net = netbuild.createNetFromArray(array);
        dijkstra.dijkstra(net, netbuild.getStartNode(), netbuild.getEndNode(), netbuild.getAdjArray());
        path.shortestPath(net.length * net.length, dijkstra.getPath(), netbuild.getEndNode(), netbuild.getStartNode());
        assertEquals(6, path.getLength());
    }

}
