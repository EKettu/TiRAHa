package graph;

import graph.NetBuilder;
import graph.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NetBuilderTest {

    NetBuilder netbuild;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        netbuild = new NetBuilder();
    }

    @After
    public void tearDown() {
    }
//
//    @Test
//    public void startNodeCoordinatesRight() {
//        Node[][] net = netbuild.createNet(5, 0, 0, 4, 4);
//        assertTrue(net[0][0] == netbuild.getStartNode());
//    }
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
