package datastructures;

import graph.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyHashMapTest {

    Node node;
    Node node2;
    Node node3;
    Node node4;
    Node node5;
    Node node6;
    MyHashMap<Node, Node> nodemap;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        nodemap = new MyHashMap<Node, Node>();
        node = new Node(1, 0, 0, 0, 100, 1);
        node2 = new Node(2, 1, 1, 2, 100, 1);
        node3 = new Node(3, 1, 2, 3, 100, 1);
        node4 = new Node(4, 0, 0, 0, 100, 1);
        node5 = new Node(5, 1, 1, 2, 100, 1);
        node6 = new Node(6, 1, 2, 3, 100, 1);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void addWorks() {
        nodemap.put(node, node2);
        assertEquals(node2, nodemap.get(node));
    }

    @Test
    public void addWorks2() {
        nodemap.put(node, node2);
        nodemap.put(node2, node3);
        nodemap.put(node3, node4);
        nodemap.put(node4, node5);
        nodemap.put(node5, node6);
        assertEquals(node6, nodemap.get(node5));
    }

}
