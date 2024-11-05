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


    public Finder() {}


    private class HashMap{
        private int DEFAULT_TABLE_SIZE = 1000000;
        private int tableSize;
        private int n;
        private String[] keys;
        private String[] values;
        private String[] map;

        public HashMap(int tableSize, int n, String[] keys, String[] values) {
            this.tableSize = tableSize;
            this.n = 0;
            this.keys = keys;
            this.values = values;
            this.map = new String[DEFAULT_TABLE_SIZE];
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
            if (n / tableSize > 0.5){
                resize();
            }




        }
        String get(String key){



        }
        void resize(){


        }

    }




    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        String text = br.readLine();
        String[] current_line;
        HashMap map = new HashMap();
        table = new ArrayList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new ArrayList<>();
        }
        while (text != null){
            current_line = text.split(",");
            String key = current_line[keyCol];
            String value = current_line[valCol];


        }


        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!
        return INVALID;
    }
}