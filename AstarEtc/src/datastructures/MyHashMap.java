
package datastructures;

public class MyHashMap <K, V> {
    /**
     * Array for entries
     */
    private Entry<K, V>[] table;
    /**
     * Initial capacity of HashMap
     */
    private int capacity = 4;
    
    /**
     * An implementation of a custom HashMap
     */
    public MyHashMap() {
        table = new Entry[capacity];
    }
    
    /**
     * Method to add an item to hashmap
     * @param key, a key to which a value is attached when adding to a hashmap
     * @param value, a value attached to a key
     */
    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        int hash = hash(key);
        
        Entry<K, V> entry = new Entry<K,V>(key, value, null);
        
        if (table[hash]==null) {
            table[hash] = entry;
        }
        else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];
            
            while(current!=null) {
                if(current.key.equals(key)) {
                    if(previous==null) {
                        entry.next=current.next;
                        table[hash]=entry;
                        return;
                    }
                    else {
                        entry.next=current.next;
                        previous.next=entry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = entry;
        }
            
    }
    
    /**
     * Method to access a value attached to a certain key
     * @param key, received as parameter, the key to which the desired value is 
     * attached
     * @return the value attached to the key
     */
    public V get(K key) {
        int hash = hash(key);
        if(table[hash] == null) {
            return null;
        }
        else {
            Entry<K, V> temp = table[hash];
            while(temp!=null) {
                if(temp.key.equals(key)) {
                    return temp.value;
                }
                temp = temp.next;
            }
        }
        System.out.println("Avaimella ei löydy arvoa");
        return null;
    }
    
    /**
     * Method to implement hashing function, used to find a location to store
     * key-value-pairs
     * @param key, a key to which hash value is calculated
     * @return hash value
     */
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
      
}
