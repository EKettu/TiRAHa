
package datastructures;

import graph.Node;
import java.util.Arrays;

public class MyArrayList <E>{
    
    private E[] array;
    private int arraySize = 0;
    
    public MyArrayList()  {
        array = (E[])new Object[4];
      //  E[] arr = (E[])new Object[4];
    }
    
    public E get(int index) {
        if (index < arraySize) {
            return array[index];
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public void add(E element) {
        if(array.length-arraySize <=2) {
            increaseListSize();
        }
        array[arraySize++] = element;
    }
    
    public int size() {
        return arraySize;
    }
    
//    public Object remove(int index) {
//        
//    }
    
    private void increaseListSize() {
        array = Arrays.copyOf(array, array.length*2);       
    }
}


