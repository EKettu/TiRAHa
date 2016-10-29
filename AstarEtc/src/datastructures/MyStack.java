package datastructures;

public class MyStack {

    /**
     * Table for integers in a stack
     */
    private int[] table;
    /*
     * Pointer to the top of the stack
     */
    private int top;

    /**
     * A stack data structure for integers (node's ID numbers)
     *
     * @param n, integer, received as a parameter, length of the stack
     */
    public MyStack(int n) {
        top = -1;
        table = new int[n];
    }

    /**
     * Method to remove the topmost integer in a stack
     *
     * @return the integer that was removed from the stack
     */
    public int pop() {
        if (!empty()) {
            int removed = table[top];
            top--;
            return removed;
        }
        return -1;
    }

    /*
     * Method to add an integer into a stack
     */
    public void push(int x) {
        if (!full()) {
            top++;
            table[top] = x;
        } else {
            System.out.println("Stack is full.");
        }
    }

    /**
     * Method to check if the stack is empty
     *
     * @return true if the stack has no integers left
     */
    public boolean empty() {
        return top == -1;
    }

    /**
     * Method to check if the stack is full
     *
     * @return true if the stack is full and no integers can be added
     */
    public boolean full() {
        return top == table.length - 1;
    }

}
