
public class CaesarCipher {
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
    
    //                    *** TESTER METHODS ***
    public void testEncryption() {
        System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
    }
}
