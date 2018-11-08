import java.util.*;
import edu.duke.*;

public class WordFreqMap {
    public void countWords() {
        FileResource fr = new FileResource();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        int total = 0;
        for (String w : fr.words()) {
            w = w.toLowerCase();
            if (map.keySet().contains(w)) {
                // "map.get(w)" gets the number of times that
                // the word has been shown and adds one too it because of the 
                // one that was just found. 
                map.put(w,map.get(w)+1); 
            } else {
                // this is the first the system has seen this word 
                // so it adds it to the HashMap8
                map.put(w, 1);
            }
        }
        
        for (String w : map.keySet()) {
            int occurrences = map.get(w);
            if (occurrences > 200) {
                System.out.println(occurrences + "\t" + w);
            }
        }
    }
}
