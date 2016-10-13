package graph;

import graph.NetBuilder;
import graph.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import datastructures.MyArrayList;
import java.io.File;
import utilities.FileReader;


public class NetBuilderTest {

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
        netbuild = new NetBuilder();
        filereader = new FileReader();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void createNetWorks() {
        File file = new File("test_small1.txt");
        MyArrayList array = filereader.readNetFromFile(file);
        Node[][] net = netbuild.createNetFromArray(array);
        assertFalse(net==null);   
    }
//
//    @Test
//    public void startNodeStartDistIsRight() {
//        Node[][] net = netbuild.createNet(5, 0, 0, 4, 4);
//        assertEquals(netbuild.getStartNode().getStartD(), 0);
//    }
//
//    @Test
//    public void endNodeCoordinatesRight() {
//        Node[][] net = netbuild.createNet(5, 0, 0, 4, 4);
//        assertTrue(net[4][4] == netbuild.getEndNode());
//    }
//
//    @Test
//    public void endNodeStartDistIsRight() {
//        Node[][] net = netbuild.createNet(5, 0, 0, 4, 4);
//        assertEquals(netbuild.getEndNode().getStartD(), Integer.MAX_VALUE);
//    }

}
