package utilities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import datastructures.MyArrayList;
import java.io.File;

public class FileReaderTest {

    FileReader filereader;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        filereader = new FileReader();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void fileReadWorks() {
        File file = new File("test_small1.txt");
        MyArrayList array = filereader.readNetFromFile(file);
        assertFalse(array == null);
    }

    @Test
    public void fileReadFail() {
        File file = new File("testi");
        MyArrayList array = filereader.readNetFromFile(file);
        assertEquals(array, null);
    }

}
