package algorithms;

import algorithms.IDAstar;
import datastructures.MyArrayList;
import graph.NetBuilder;
import graph.Node;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utilities.FileReader;

public class IDAstarTest {

    IDAstar idastar;
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
        idastar = new IDAstar();
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
        idastar.idastar(net, netbuild.getStartNode(), netbuild.getEndNode(), netbuild.getAdjArray());
        assertEquals(true, idastar.getFound());
    }

    @Test
    public void pathFound2() {
        File file = new File("test_small1.txt");
        MyArrayList array = filereader.readNetFromFile(file);
        Node[][] net = netbuild.createNetFromArray(array);
        idastar.idastar(net, netbuild.getStartNode(), netbuild.getEndNode(), netbuild.getAdjArray());
        assertEquals(true, idastar.getFound());
    }
}
