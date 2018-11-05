import java.util.*;
import edu.duke.*;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique() {
        FileResource fr = new FileResource();
        
        for (String s : fr.words()) {
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index == -1) {
                myWords.add(s);
                myFreqs.add(1);
            } else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);
            }
        }
    }
    
    public void findIndexOfMax() {
        int currHighestValue = 0;
        int highestIndex = 0;

        for (int i = 0; i < myFreqs.size(); i++) {
            if (currHighestValue < myFreqs.get(i)) {
                currHighestValue = myFreqs.get(i);
                highestIndex = myFreqs.indexOf(currHighestValue);
            }
        }
        
        System.out.println("Index of highest value: " + highestIndex
        + " The value is: " + currHighestValue);
    }
    
    //                      *** TESTER METHODS ***
    
    public void testFindUnique() {
        findUnique();
        System.out.println("# unique words: " + myWords.size());
        for (int i = 0; i < myWords.size(); i++) {
            System.out.println(myFreqs.get(i)+"\t" + myWords.get(i));
        }
        findIndexOfMax();
    }
}
