import java.io.BufferedReader;
import java.io.IOException;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Stefan Perkovic
 **/

public class Finder {

    private static final String INVALID = "INVALID KEY";
    private static final int radix = 256;
    private static final int TABLE_SIZE = 131071;
    private static final double CAPACITY = 0.5;

    private HashMap map;

    // Constructor initializes the HashMap with the initial table size
    public Finder() {
        this.map = new HashMap(TABLE_SIZE);
    }

    // Inner class implementing a custom HashMap with linear probing for collision resolution
    private class HashMap{
        private int tableSize;
        private int fullness;
        private String[] keys;
        private String[] values;

        // Constructor initializes the hash table arrays and other properties
        public HashMap(int tableSize) {
            this.tableSize = tableSize;
            this.fullness = 0;
            this.keys = new String[tableSize];
            this.values = new String[tableSize];
        }

        // Calculates the hash for the key
        private int hash(String key) {
            int hash = 0;
            for (int i = 0; i < key.length(); i++) {
                hash = (hash * radix + key.charAt(i)) % tableSize;
            }
            return hash % tableSize;
        }

        // Adds a key-value pair to the hash map
        public void add(String key, String value){
            // Check load factor and resize if necessary
            if ((double)fullness / tableSize > CAPACITY){
                resize();
            }
            int index = hash(key);
            // Use linear probing to find the next empty slot if a collision occurs
            while (keys[index] != null){
                index = (index + 1) % tableSize;
            }

            keys[index] = key;
            values[index] = value;
            fullness++;
        }
        // Retrieves the value associated with a given key or returns INVALID if not found
        public String get(String key){
            int index = hash(key);
            while (keys[index] != null){
                if (keys[index].equals(key)){
                    return values[index];
                }
                index = (index + 1) % tableSize;
            }
            return INVALID;
        }

        // Doubles the size of the hash table and rehashes all keys to new positions
        public void resize(){
            tableSize = 2 * tableSize + 1;
            String[] oldKeys = keys;
            String[] oldValues = values;

            keys = new String[tableSize];
            values = new String[tableSize];
            fullness = 0;

            for (int i = 0; i < oldKeys.length; i++){
                if (oldKeys[i] != null){
                    add(oldKeys[i], oldValues[i]);
                }
            }
        }
    }

    // Builds the hash table from a file given column indices for keys and values
    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        String line = br.readLine();
        String[] current_line;
        // Read each line in the CSV file and split by commas to extract key-value pairs
        while (line != null){
            current_line = line.split(",");
            String key = current_line[keyCol];
            String value = current_line[valCol];
            map.add(key, value);
            line = br.readLine();
        }
        br.close();
    }
    // Queries the hash table for a specific key and returns the associated value
    public String query(String key){
        return map.get(key);
    }
}