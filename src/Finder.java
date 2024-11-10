import org.hamcrest.Condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

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
    private static final int p = 249998741;
    private static final int radix = 256;
    private static final int TABLE_SIZE = 100000;

    private HashMap map;

    public Finder() {
        this.map = new HashMap(TABLE_SIZE);
    }


    private class HashMap{
        private int tableSize;
        private int n;
        private String[] keys;
        private String[] values;

        public HashMap(int tableSize) {
            this.tableSize = tableSize;
            this.n = 0;
            this.keys = new String[tableSize];
            this.values = new String[tableSize];
        }

        // Calculates the hash for the key
        private int hash(String key) {
            int hash = 0;
            for (int i = 0; i < key.length(); i++) {
                hash = (hash * radix + key.charAt(i)) % p;
            }
            return hash;
        }

        void add(String key, String value){
            // Check load factor and resize if necessary
            if ((double)n / tableSize > 0.5){
                resize();
            }

            int index = hash(key);
            // Loops through all occupied spots
            while (keys[index] != null){
                index = (index + 1) % tableSize;
            }

            keys[index] = key;
            values[index] = value;
            n++;
        }
        String get(String key){
            int index = hash(key);
            while (keys[index] != null){
                if (keys[index].equals(key)){
                    return values[index];
                }
                index = (index + 1) % tableSize;
            }
            return INVALID;

        }
        void resize(){
            tableSize *= 2;
            String[] oldKeys = keys;
            String[] oldValues = values;

            keys = new String[tableSize];
            values = new String[tableSize];
            n = 0;

            for (int i = 0; i < oldKeys.length; i++){
                add(oldKeys[i], oldValues[i]);
            }

        }

    }




    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        String line = br.readLine();
        String[] current_line;
        while (line != null){
            current_line = line.split(",");
            String key = current_line[keyCol];
            String value = current_line[valCol];
            map.add(key, value);
            line = br.readLine();
        }

        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!
        return INVALID;
    }
}