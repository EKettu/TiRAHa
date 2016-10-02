package datastructures;

import datastructures.Heap;
import graph.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyArrayListTest {

    MyArrayList array;
    Node node;
    Node node2;
    Node node3;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        array = new MyArrayList();
        node = new Node(1, 0, 0, 0, 100, 1);
        node2 = new Node(2, 1, 1, 2, 100, 1);
        node3 = new Node(3, 1, 2, 3, 100, 1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addWorks() {
        array.add(node);     
        assertEquals(node, array.get(0));
    }
    
    @Test
    public void addWorks2() {
        array.add(node);
        array.add(node2);
        assertEquals(node2, array.get(1));
    }
    
        @Test
    public void addWorks3() {
       for(int i = 0; i<=100; i++) {
           array.add(node);
       }
        assertEquals(101, array.size());
    }
}
