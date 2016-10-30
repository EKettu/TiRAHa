package datastructures;

/**
 * Stores entries in a custom HashMap
 *
 * @author ekettu
 * @param <K> Key
 * @param <V> Value
 */
public class Entry<K, V> {

    K key;
    V value;
    Entry<K, V> next;

    /**
     * Allows storing of data in key-value pairs
     *
     * @param key, a key in MyHashMap, received as a parameter
     * @param value, a value attached to a key, received as a parameter
     * @param next, next entry in a map, received as a parameter
     */
    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

}
