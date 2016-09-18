
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StartTest {

    Start start;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        start = new Start();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void startNodeCoordinatesRight() {
        Node[][] net = start.createNet(5, 0, 0, 4, 4);
        assertTrue(net[0][0] == start.getStartNode());
    }

    @Test
    public void startNodeStartDistIsRight() {
        Node[][] net = start.createNet(5, 0, 0, 4, 4);
        assertEquals(start.getStartNode().getStartD(), 0);
    }

    @Test
    public void endNodeCoordinatesRight() {
        Node[][] net = start.createNet(5, 0, 0, 4, 4);
        assertTrue(net[4][4] == start.getEndNode());
    }

    @Test
    public void endNodeStartDistIsRight() {
        Node[][] net = start.createNet(5, 0, 0, 4, 4);
        assertEquals(start.getEndNode().getStartD(), Integer.MAX_VALUE);
    }

}
