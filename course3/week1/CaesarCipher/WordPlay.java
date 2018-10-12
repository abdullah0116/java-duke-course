
public class WordPlay {
    public boolean isVowel(char ch) {
        boolean result = false;
        char[] chars = {'a', 'e', 'i', 'o', 'u'};
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ch) {
                return true;
            }
        }
        
        return result;
    }
    
    //             *** TESTER METHOD ***
    
    public void testIsVowel() {
        System.out.println(isVowel('a'));
    }
}
