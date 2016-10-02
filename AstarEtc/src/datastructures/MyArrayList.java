
package datastructures;

import graph.Node;
import java.util.Arrays;

public class MyArrayList {
    
    private Node[] array;
    private int arraySize = 0;
    
    public MyArrayList() {
        array = new Node[4];
    }
    
    public Node get(int index) {
        if (index < arraySize) {
            return array[index];
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public void add(Node node) {
        if(array.length-arraySize <=2) {
            increaseListSize();
        }
        array[arraySize++] = node;
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
