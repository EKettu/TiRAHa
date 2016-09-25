
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NodeTest {

    public Node node;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        node = new Node(1, 0, 0, 0, 0, 0);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void methodSetYWorks() {
        node.setY(3);
        assertEquals(3, node.getY());

    }

    @Test
    public void methodSetXWorks() {
        node.setX(3);
        assertEquals(3, node.getX());
    }

    @Test
    public void methodSetStartDistWorks() {
        node.setStartD(30000);
        assertEquals(30000, node.getStartD());
    }

    @Test
    public void methodSetEndDistWorks() {
        node.setEndD(4);
        assertEquals(4, node.getEndD());
    }

}
