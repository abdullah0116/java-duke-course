import edu.duke.*;
public class homework {
    public void countWordLengths(FileResource fr, int[] counts) {
        int countLen = counts.length;
        
        for (String word : fr.words()) {
            int newLength = 0;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (Character.isLetter(ch) == false) {
                    if (!(i == 0) && !(i == word.length() - 1)) {
                        newLength++; 
                    }
                } else {
                    newLength++;
                }
                counts[newLength]++;
            }
        } 
    }
    
    public int indexOfMax (int[] values) {
        int max = 0;
        for (int i = 0; i <= values.length; i++) {
            if (values[i] >= max) {
                max = values[i];
            }
        }
        return max;
    }
    
    public int wordLength(String word) {
        int length = 0;
        
        for (char currChar : word.toCharArray()) {
            if (Character.isLetter(currChar)) {
                length++;
            }
        } 
        
        return length;
    } 
    
    public void testCountWordLengths () {
        int[] counts = new int[13];
        FileResource fr = new FileResource();
        
        countWordLengths(fr, counts);
        
        for(int i = 0; i < counts.length; i++) {
            System.out.println(counts[i]);
        }
        
    }
}
