
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyStackTest {

    MyStack stack;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        stack = new MyStack(4);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pushWorks() {
        stack.push(1);
        assertEquals(1, stack.pop());
    }

    @Test
    public void popWorks() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
    }

    public void fullWorks() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(true, stack.full());
    }
    
    public void emptyWorks() {
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.pop();
        assertEquals(true, stack.empty());
    }

}
