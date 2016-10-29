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
        @Test
    public void createNetWorks2() {
        File file = new File("nofile.txt");
        MyArrayList array = filereader.readNetFromFile(file);
        Node[][] net = netbuild.createNetFromArray(array);
        assertTrue(net==null);   
    }
}
