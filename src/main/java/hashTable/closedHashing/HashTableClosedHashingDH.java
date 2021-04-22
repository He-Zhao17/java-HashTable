package hashTable.closedHashing;

import hashTable.HashEntry;
import hashTable.Map;

import java.math.BigInteger;

/** The class that implements the Map interface using closed hashing;
 *  uses double hashing to resolve collisions */
public class HashTableClosedHashingDH implements Map {
    private HashEntry[] table; // hash table
    private int maxSize;
    private int size; // the number of elements currently in the hash table


    /** Constructor for class HashTableClosedHashingDH.
     *  Creates a hash table of the given size.
     * @param maxSize maximum number of elements the hash table can store
     */
    public HashTableClosedHashingDH(int maxSize) {
        // FILL IN CODE
        this.maxSize = maxSize;
        size = 0;
        this.table = new HashEntry[maxSize];

    }

    /** Return true if the map contains a (key, value) pair associated with this key,
     *  otherwise return false.
     *
     * @param key  key
     * @return true if the key (and the corresponding value) is the in map
     */
    @Override
    public boolean containsKey(String key) {
        // FILL IN CODE
        BigInteger t = getK(key, this.maxSize);
        int hk = getHk(t, this.maxSize);
        //
        int k = hk;
        if (this.table[k] != null && !this.table[k].isDeleted()) {
            if (this.table[k].getKey().equals(key)) {
                return true;
            } else {
                int dk = getDk(t, this.maxSize);
                k += dk;
                while (this.table[k] != null && !this.table[k].isDeleted()) {
                    if (this.table[k].getKey().equals(key)) {
                        return true;
                    } else {
                        k += dk;
                    }
                }
                return false;
            }
        } else {
            return false;
        }
        //return false;
    }

    private int getHk(BigInteger k, int maxSize) {
        return k.remainder(BigInteger.valueOf(maxSize)).intValue();
    }

    private int getDk(BigInteger k, int maxSize) {
        int q = 0;
        if (maxSize % 2 == 1) {
            int half = (maxSize - 1) / 2;
            if (half % 2 == 0) {
                q = half + 1;
            } else {
                q = half + 2;
            }
        } else {
            int half = maxSize / 2;
            if (half % 2 == 0) {
                q = half + 1;
            } else {
                q = half + 2;
            }
        }
        return q - (k.remainder(BigInteger.valueOf(q))).intValue();
    }

    private BigInteger getK (String key, int maxSize) {
        BigInteger a = BigInteger.valueOf(33);

        int resKey = 0;
        BigInteger res = BigInteger.valueOf(0);
        if (key.length() == 0) {
            return res;
        }
        int first = (int) key.charAt(0);
        res = BigInteger.valueOf(first);
        for (int i = 1; i < key.length(); i++) {
            int temp = (int) key.charAt(i);
            BigInteger tempBI = BigInteger.valueOf(temp);
            res = tempBI.add(res.multiply(a));
        }
        return res;
    }


    /** Add (key, value) to the map.
     * Will replace previous value that this key was mapped to.
     * If key is null, throw IllegalArgumentException.
     *
     * @param key
     * @param value associated value
     */
    @Override
    public void put(String key, Object value) {
        // FILL IN CODE
    }

    /** Return the value associated with the given key or null, if the map does not contain the key.
     * If the key is null, throw IllegalArgumentException.
     *
     * @param key key
     * @return value associated value
     */
    @Override
    public Object get(String key) {
        // FILL IN CODE

        return null;
    }

    /** Remove a (key, value) entry if it exists.
     * Return the previous value associated with the given key, otherwise return null
     * @param key key
     * @return previous value
     */
    @Override
    public Object remove(String key) {
        // FILL IN CODE

        return null;
    }

    /** Return the actual number of elements in the map.
     *
     * @return number of elements currently in the map.
     */
    @Override
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

    // Add other helper methods as needed

}
