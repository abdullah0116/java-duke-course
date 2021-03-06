import edu.duke.*;

public class CourseThree {
    public String encrypt(String input, int key) {
        // make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        // Write down the alphabet and save it to a variable 
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        // count from 0 to < length of encrypted, (call it i)
        for (int i = 0; i < encrypted.length(); i++) {
            // Look at the iTH character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            // find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            // if currChar is the alphabet 
            if (idx != -1) {
                // get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                // replace the iTH character of encrypted with newChar
                encrypted.setCharAt(i , newChar);
            } 
            
            // otherwise 
            // do nothing
                
        }
        
        // return String inside of encrypted        
        return encrypted.toString();
    }
    
    public String reverse(String s){
        String answer = "";
        
        for (int i = 0; i < s.length(); i ++) {
            answer = s.charAt(i) + answer;
        }
        
        return answer;
    }
   
    public void stringBuilderExample() {
        StringBuilder sb = new StringBuilder("start");
        // the parameters in side the the insert method what they do is 
        // tell substring they want to add the following String "le" starting 
        // on index 4 
        //  *** this doesnt remove the letter T it just pushes it away ***
        sb.insert(4, "le");
        System.out.println(sb);
    }
    
    //                      *** TESTER METHODS ***
    public void encryptTest() {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("Encrypted message: " + encrypted);
        String decrypted = encrypt(encrypted, 26 - key);
        System.out.println("Decrypted message: " + decrypted);
    }
    
    public void conversionTest() {
        String test = "ABCabc0123456789';#!";
        for (int i = 0; i < test.length(); i++) {
            char ch = test.charAt(i);
            char uch = Character.toUpperCase(ch);
            char lch = Character.toLowerCase(ch);
            System.out.println(ch + " " + uch + " " + lch);
        }
    }
    
    public void digitTest() {
        String test = "ABCabc0123456789';#!";
        for (int i = 0; i < test.length(); i++) {
            char ch = test.charAt(i);
            if (Character.isDigit(ch)) {
                System.out.println(ch + " This Char is a number.");
            } else if (Character.isAlphabetic(ch)) {
                System.out.println(ch + " This Char is a letter.");
            } else if (ch == '#') {
                System.out.println(ch + "is a hashtag.");
            }
        }
    }
    
    public void revsereTester() {
        System.out.println(reverse("computer"));
    }
}
