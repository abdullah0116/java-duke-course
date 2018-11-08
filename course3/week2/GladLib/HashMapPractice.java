import edu.duke.*;
import java.util.*;

public class HashMapPractice {
    private HashMap<String, Integer> myMap = new HashMap<String, Integer>();
    
    public void countWordsMap() {
        FileResource fr = new FileResource();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (String w : fr.words()) {
            w = w.toLowerCase();
            if (!map.containsKey(w)) {
                map.put(w, 1);
            } else {
                map.put(w, map.get(w)+1);
            }
        }
    }
    
    public void printWords() {
        for (String s : myMap.keySet()) {
            System.out.println(myMap.get(s) + "\t" + s);
        }
    }
}
