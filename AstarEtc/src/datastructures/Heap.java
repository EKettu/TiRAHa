package datastructures;

import graph.Node;

public class Heap {

    /**
     * A table containing nodes
     */
    private Node[] table;
    /**
     * Actual size of the heap
     */
    private int heapsize;

    /**
     * A minimum heap data structure for Node objects
     *
     * @param n integer, received as a parameter, determines the size of the
     * heap
     */
    public Heap(int n) {
        table = new Node[n * n];
        heapsize = 0;
        table[0] = null;
    }

    /**
     * Method to fix the heap after deleting a node
     *
     * @param table, contains nodes in the heap
     * @param i index of a node being fixed
     */
    private void heapify(Node[] table, int i) {
        int left = left(i);
        int right = right(i);
        int smallest = 0;
        if (right <= heapsize) {
            if (table[left].getStartD() + table[left].getEndD() + table[left].getWeight()
                    < table[right].getStartD() + table[right].getEndD() + 
                    table[right].getWeight()) {
                smallest = left;
            } else {
                smallest = right;
            }
            if (table[i].getStartD() + table[i].getEndD() + table[i].getWeight()
                    > table[smallest].getStartD() + table[smallest].getEndD() + 
                    table[smallest].getWeight()) {
                Node temp = table[i];
                table[i] = table[smallest];
                table[smallest] = temp;
                heapify(table, smallest);
            }
        } else if (left == heapsize && table[i].getStartD() + table[i].getEndD() 
                + table[i].getWeight()
                > table[left].getStartD() + table[left].getEndD() + 
                table[left].getWeight()) {
            Node temp = table[i];
            table[i] = table[left];
            table[left] = temp;
        }
    }

    /**
     * Method to access the minimum node in the heap
     *
     * @param table, contains nodes in the heap
     * @return the minimum node in the heap
     */
    public Node heapMin(Node[] table) {
        return table[1];
    }

    /**
     * Method to delete the smallest node in the heap
     *
     * @param table, contains nodes in the heap
     * @return the minimum node that was deleted
     */
    public Node heapDeleteMin(Node[] table) {
        Node min = table[1];
        table[1] = table[heapsize];
        heapsize--;
        heapify(table, 1);
        return min;
    }

    /**
     * Method to insert nodes into the heap
     *
     * @param table, contains nodes in the heap
     * @param node received as a parameter, the node to be inserted into the
     * heap
     */
    public void heapInsert(Node[] table, Node node) {
        heapsize++;
        int i = heapsize;
        while (i > 1 && table[parent(i)].getStartD() + table[parent(i)].getEndD()
                > node.getStartD() + node.getEndD()) {
            table[i] = table[parent(i)];
            i = parent(i);
        }
        table[i] = node;
    }

    /**
     * Returns the index of the parent node
     *
     * @param i integer, received as a parameter, an index for a node in the
     * heap
     * @return the parent node of i
     */
    private int parent(int i) {
        return i / 2;
    }

    /**
     * Returns the index of the left child node
     *
     * @param i integer, received as a parameter, an index for a node in the
     * heap
     * @return the index of the left child node
     */
    private int left(int i) {
        return 2 * i;
    }

    /**
     * Returns the index of the right child node
     *
     * @param i integer, received as a parameter, an index for a node in the
     * heap
     * @return the index of the right child node
     */
    private int right(int i) {
        return (2 * i) + 1;
    }

    public Node[] getNodeTable() {
        return table;
    }
    
    /**
     * Method to check if the heap is empty
     * @return true if empty
     */
    public boolean empty() {
        if(heapsize <=0) {
            return true;
        }
        return false;
    }
}
