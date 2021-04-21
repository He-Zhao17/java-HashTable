package hashTable.openHashing;
import hashTable.HashEntry;
import hashTable.Map;

import java.math.BigInteger;

public class HashTableOpenHashing implements Map {
    private Node[] table ;
    private int maxSize;
    private int size;

    /** Constructor for class HashTableOpenHashing
     *
     * @param maxSize the size of the table
     */
    public HashTableOpenHashing(int maxSize) {
        // FILL IN CODE
        this.maxSize = maxSize;
        table = new Node[maxSize];
        size = 0;

    }

    /** Return true if the map contains a (key, value) pair associated with this key,
     *  otherwise return false.
     *
     * @param key  key
     * @return true if the key (and the corresponding value) is the in map
     */
    public boolean containsKey(String key) {
        // FILL IN CODE


        return false; // change
    }

    private int Hash(String key, int maxSize) {
        maxSize = this.maxSize;
        // a = 2;
        BigInteger a = BigInteger.valueOf(2);

        int resKey = 0;
        BigInteger res = BigInteger.valueOf(0);
        if (key.length() == 0) {
            return resKey;
        }
        int first = (int) key.charAt(0);
        res = BigInteger.valueOf(first);
        for (int i = 1; i < key.length(); i++) {
            int temp = (int) key.charAt(i);
            BigInteger tempBI = BigInteger.valueOf(temp);
            res = tempBI.add(res.multiply(a));
        }
        BigInteger BMaxSize = BigInteger.valueOf(maxSize);
        BigInteger result = res.remainder(BMaxSize);
        return result.intValue();
    }

    /** Add (key, value) to the map.
     * Will replace previous value that this key was mapped to.
     * If key is null, throw IllegalArgumentException.
     *
     * @param key
     * @param value associated value
     */
    public void put(String key, Object value) {
            // FILL IN CODE
    }

    /** Return the value associated with the given key or null, if the map does not contain the key.
     * If the key is null, throw IllegalArgumentException.
     *
     * @param key key
     * @return value associated value
     */
    public Object get(String key) {
        // FILL IN CODE

        return null; // change
    }

    /** Remove a (key, value) entry if it exists.
     * Return the previous value associated with the given key, otherwise return null
     * @param key key
     * @return previous value
     */
    public Object remove(String key) {
        // FILL IN CODE

        return null; // change
    }

    /** Return the actual number of elements in the map.
     *
     * @return number of elements currently in the map.
     */
    public int size() {
        return this.size;
    }

    /**
     * toString
     * @return a string representing a hash table
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // FILL IN CODE

        return sb.toString();
    }

    // Add may implement other helper methods as needed


}
