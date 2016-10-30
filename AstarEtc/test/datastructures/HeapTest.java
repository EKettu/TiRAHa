package datastructures;

import datastructures.Heap;
import graph.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeapTest {

    Heap heap;
    Node node;
    Node node2;
    Node node3;
    Node node4;
    Node[] table;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        heap = new Heap(2);
        node = new Node(1, 0, 0, 0, 100, 1);
        node2 = new Node(2, 1, 1, 2, 100, 1);
        node3 = new Node(3, 1, 2, 3, 100, 1);
        node4 = new Node(4, 1, 2, 3, 100, 1);
        table = heap.getNodeTable();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void insertWorks1() {
        heap.heapInsert(table, node);
        assertEquals(node, heap.heapMin(table));
    }

    @Test
    public void insertWorks2() {
        heap.heapInsert(table, node);
        heap.heapInsert(table, node2);
        assertEquals(node, heap.heapMin(table));
    }

    @Test
    public void insertWorks3() {
        heap.heapInsert(table, node3);
        heap.heapInsert(table, node2);
        assertEquals(node2, heap.heapMin(table));
    }

    @Test
    public void deleteMinWorks() {
        heap.heapInsert(table, node);
        heap.heapInsert(table, node3);
        heap.heapInsert(table, node2);
        heap.heapDeleteMin(table);
        assertEquals(node2, heap.heapMin(table));
    }

    @Test
    public void deleteMinWorks2() {
        assertEquals(null, heap.heapDeleteMin(table));
    }

    @Test
    public void heapFullWorks() {
        heap.heapInsert(table, node);
        heap.heapInsert(table, node3);
        heap.heapInsert(table, node2);
        heap.heapInsert(table, node4);
        assertEquals(true, heap.full());
    }
}
