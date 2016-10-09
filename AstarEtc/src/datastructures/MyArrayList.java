
package datastructures;

import graph.Node;
import java.util.Arrays;

public class MyArrayList <E>{
    /**
     * Array for elements in the arraylist
     */
    private E[] array;
    /**
     * initial size of the array
     */
    private int arraySize = 0;
    
    /**
     * An implementation of a custom ArrayList
     */
    public MyArrayList()  {
        array = (E[])new Object[4];
    }
    
    /**
     * Method to get an element in a list according to an index
     * @param index, tells which element will be returned
     * @return an element in a list according to an index
     */
    public E get(int index) {
        if (index < arraySize) {
            return array[index];
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    /**
     * Method to add an element to a list
     * @param element, an element that is added to a list
     */
    public void add(E element) {
        if(array.length-arraySize <=2) {
            increaseListSize();
        }
        array[arraySize++] = element;
    }
    
    /**
     * Method to access the size of a list
     * @return 
     */
    public int size() {
        return arraySize;
    }
    
//    public Object remove(int index) {
//        
//    }
    /**
     * increases the size of a list
     */
    private void increaseListSize() {
        array = Arrays.copyOf(array, array.length*2);       
    }
}


