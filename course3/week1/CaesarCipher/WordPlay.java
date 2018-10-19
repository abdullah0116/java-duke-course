
public class WordPlay {
    public String emphasize(String phrase, char ch) {
        StringBuilder result = new StringBuilder(phrase);
        char[] phraseArray = phrase.toCharArray();
        for (int i = 0; i < phraseArray.length; i++) {
            if (phraseArray[i] == ch) {
                int indexChar = i;
                if (i % 2 == 0) {
                    result.setCharAt(indexChar, '*');
                } else if (i % 2 != 0) {
                    result.setCharAt(indexChar, '+');
                }
            }
        }
        
        return result.toString();
    }
    
    public String replaceVowels(String phrase, char ch) {
        String phraseLowCase = phrase.toLowerCase();
        StringBuilder result = new StringBuilder(phraseLowCase);
        
        for (int i = 0; i < result.length(); i++) {
            if (isVowel(result.charAt(i)) == true) {
                result.setCharAt(i, ch);
            }
        }
        
        return result.toString();
    }

    public boolean isVowel(char ch) {
        boolean result = false;
        char[] chars = {'a', 'e', 'i', 'o', 'u'};      
        for (int i = 0; i < chars.length; i++) {
            char chLow = Character.toLowerCase(ch);
            if (chars[i] == chLow) {
                return true;
            }
        }       
        return result;
    }
    
    //             *** TESTER METHOD ***
    public void testEmphasize() {
        System.out.println("First test case:");
        System.out.println("    " + emphasize("dna ctgaaactga", 'a'));
        System.out.println("Second test case:");
        System.out.println("    " + emphasize("Mary Bella Abracadabra", 'a'));
    }
    
    public void testReplaceVowels() {
        System.out.println(replaceVowels("Hello World", '*'));
    }
    
    public void testIsVowel() {
        System.out.println(isVowel('A'));
    }
}
