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


    public class Pair(){





    }

    // Calculates the hash for the key
    private static int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * radix + key.charAt(i)) % p;
        }
        return hash;
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
            int hash = hash(key);


        }



        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!
        return INVALID;
    }
}