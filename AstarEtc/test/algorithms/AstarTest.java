package algorithms;

import algorithms.Astar;
import datastructures.MyArrayList;
import graph.NetBuilder;
import graph.Node;
import graph.Path;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utilities.FileReader;

public class AstarTest {

    Astar astar;
    NetBuilder netbuild;
    FileReader filereader;

    public AstarTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        astar = new Astar();
        netbuild = new NetBuilder();
        filereader = new FileReader();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pathFound() {
        File file = new File("test.txt");
        MyArrayList array = filereader.readNetFromFile(file);
        Node[][] net = netbuild.createNetFromArray(array);
        astar.astar(net, netbuild.getStartNode(), netbuild.getEndNode(), netbuild.getAdjArray());
        assertEquals(true, astar.getFound());
    }

    @Test
    public void pathNotFound() {
        File file = new File("test2.txt");
        MyArrayList array = filereader.readNetFromFile(file);
        Node[][] net = netbuild.createNetFromArray(array);
        astar.astar(net, netbuild.getStartNode(), netbuild.getEndNode(), netbuild.getAdjArray());
        assertEquals(false, astar.getFound());
    }

}
