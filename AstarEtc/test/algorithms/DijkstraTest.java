package algorithms;

import datastructures.MyArrayList;
import graph.NetBuilder;
import graph.Node;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.FileReader;

public class DijkstraTest {

    NetBuilder netbuild;
    FileReader filereader;
    Dijkstra dijkstra;

    public DijkstraTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dijkstra = new Dijkstra();
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
        dijkstra.dijkstra(net, netbuild.getStartNode(), netbuild.getEndNode(), netbuild.getAdjArray());
        assertEquals(true, dijkstra.getFound());
    }

    @Test
    public void pathNotFound() {
        File file = new File("test2.txt");
        MyArrayList array = filereader.readNetFromFile(file);
        Node[][] net = netbuild.createNetFromArray(array);
        dijkstra.dijkstra(net, netbuild.getStartNode(), netbuild.getEndNode(), netbuild.getAdjArray());
        assertEquals(false, dijkstra.getFound());
    }

}
