

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class AstarTest {
    
    Astar astar;

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
    }

    @After
    public void tearDown() {
    }
   
    @Test
    public void adjacencyListRightSize() {
        astar.astar(4, 0, 0, 3, 3);
        assertEquals(16, astar.getAdjList().size());      
    }
    
}
