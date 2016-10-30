package datastructures;

import graph.Node;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyHashSetTest {

    Node node;
    Node node2;
    MyHashSet<Node> nodeSet;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        nodeSet = new MyHashSet<Node>();
        node = new Node(1, 0, 0, 0, 100, 1);
        node2 = new Node(2, 1, 1, 2, 100, 1);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void addWorks() {
        nodeSet.add(node);
        assertTrue(nodeSet.contains(node));
    }

    @Test
    public void containsWorks() {
        nodeSet.add(node);
        assertFalse(nodeSet.contains(node2));
    }

}
