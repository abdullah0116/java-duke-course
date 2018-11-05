import java.util.*;
import edu.duke.*;

public class WordsWithArrays {
    StorageResource myWords;
    
    public WordsWithArrays() {
        myWords = new StorageResource();
    }
    
    public void readWords() {
        myWords.clear();
        FileResource fr = new FileResource();
        for (String word : fr.words()) {
            myWords.add(word.toLowerCase());
        }
    }
    
    public boolean contains (String[] list, String word, int number) {
        for (int i = 0; i < number; i++) {
            if (list[i].equals(word)) {
                return true;
            }
        }
        return false;
    }
    
    public int numberOfUniqueWords() {
        int numStored = 0;
        String[] words = new String[myWords.size()];
        for (String s : myWords.data())  {
            if (! contains(words, s, numStored)) {
                words[numStored] = s;
                numStored++;
            }
        }
        return numStored;
    }
    
    //                          *** TESTER METHODS ***
    
    public void tester() {
        readWords();
        System.out.println("number of words read: " + myWords.size());
        int unique = numberOfUniqueWords();
        System.out.println("Array Count: " + unique);
    }
}
