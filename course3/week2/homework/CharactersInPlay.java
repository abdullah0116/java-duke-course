import java.util.*;
import edu.duke.*;

public class CharactersInPlay {
    ArrayList<String> words;
    ArrayList<Integer> counts;
    
    public void update(String name) {
        if (words.contains(name)) {
            int indexOfName = words.indexOf(name);
            counts.set(indexOfName, counts.get(indexOfName) +1);
        } else {
            words.add(name);
            counts.add(1);
        }
    }
}
