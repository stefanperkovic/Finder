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
    private static final int p = 249998741;
    private static final int radix = 256;


    public Finder() {}


    public class Pair{
        private String key;
        private String value;
        private int hashValue;

        // Constructor to initialize key, value, and hashValue
        public Pair(String key, String value) {
            this.key = key;
            this.value = value;
            this.hashValue = hash(key);
        }

        // Calculates the hash for the key
        private int hash(String key) {
            int hash = 0;
            for (int i = 0; i < key.length(); i++) {
                hash = (hash * radix + key.charAt(i)) % p;
            }
            return hash;
        }

        public int getHashValue() {
            return hashValue;
        }
    }




    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        String text = br.readLine();
        String current_line[];
        String array[];
        while (text != null){
            current_line = text.split(",");
            String key = current_line[keyCol];
            String value = current_line[valCol];
            Pair pair = new Pair(key, value);



        }


        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!
        return INVALID;
    }
}