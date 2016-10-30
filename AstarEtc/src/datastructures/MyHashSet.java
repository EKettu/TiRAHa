package datastructures;

/**
 * Custom HashSet
 *
 * @author ekettu
 * @param <E> Element
 */
public class MyHashSet<E> {

    /**
     * Map containing objects in MyHashSet
     */
    private MyHashMap<E, Object> myHashMap;

    /**
     * An implementation of a custom HashSet
     */
    public MyHashSet() {
        myHashMap = new MyHashMap<>();
    }

    /**
     * Method to add an object to a set
     *
     * @param value, E, received as a parameter, the element being added
     */
    public void add(E value) {
        myHashMap.put(value, null);
    }

    /**
     * Method to check if the set contains an object
     *
     * @param object, E, received as a parameter, the object being searched
     * @return true if object is in the set
     */
    public boolean contains(E object) {
        if (myHashMap.contains(object) != null) {
            return true;
        }
        return false;
    }
}
