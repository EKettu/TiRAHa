package graph;

import graph.Path;
import algorithms.Astar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PathTest {

    Path path;
    Astar astar;

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

    }

    @After
    public void tearDown() {
    }

    @Test
    public void pathLengthOk1() {
        astar.astar(5, 0, 0, 3, 3);
        assertEquals(6, path.getLength());
    }

    @Test
    public void pathLengthOk2() {
        astar.astar(100, 0, 0, 90, 90);
        assertEquals(180, path.getLength());
    }

    @Test
    public void pathLengthOk3() {
        astar.astar(5, 0, 0, 0, 1);
        assertEquals(1, path.getLength());
    }

}
