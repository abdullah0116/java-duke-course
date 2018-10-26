import edu.duke.*;

public class CaesarCipher {
   public String encrypt(String input, int key) {
       // make a StringBuilder with message (encrypted)
       //input = input.toUpperCase();
       StringBuilder encrypted = new StringBuilder(input);
       //Write down the alphabet
       String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       //Compute the shifted alphabet
       String shiftedAlphabet = alphabet.substring(key)+
       alphabet.substring(0,key);
       //Count from 0 to < length of encrypted, (call it i)
       for(int i = 0; i < encrypted.length(); i++) {
           //Look at the ith character of encrypted (call it currChar)
           char currChar = encrypted.charAt(i);
           //Find the index of currChar in the alphabet (call it idx)
           int idx = alphabet.indexOf(Character.toUpperCase(currChar));
           //If currChar is in the alphabet
           if(idx != -1){
               //Get the idxth character of shiftedAlphabet (newChar)
               char newChar = shiftedAlphabet.charAt(idx);
               //Replace the ith character of encrypted with newChar
               if (Character.isLowerCase(currChar)) {
                   newChar=Character.toLowerCase(newChar);
               }
               if (Character.isUpperCase(currChar)) {
                   newChar=Character.toUpperCase(newChar);
               }
               encrypted.setCharAt(i, newChar);
           }
           //Otherwise: do nothing
        }
       //Your answer is the String inside of encrypted
       return encrypted.toString();
   }
    
   public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder result = new StringBuilder(input);
        char[] resultChar = result.toString().toCharArray();
        
        for (int i = 0; i < resultChar.length; i++) {
            char currChar = resultChar[i];
            
            if (i % 2 == 0) {
                String currCharStri = String.valueOf(currChar);
                String newStri = encrypt(currCharStri, key1);
                
                result.setCharAt(i, newStri.charAt(0));
            } else if (i % 2 != 0) {
                String currCharStri = String.valueOf(currChar);
                String newStri = encrypt(currCharStri, key2);
                
                result.setCharAt(i, newStri.charAt(0));
            }
        }
        return result.toString();
    }
    
    //                    *** TESTER METHODS ***
    public void testEncryptTwoKeys() {
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
    }
    
    public void testCaesar() {
        int key = 17; 
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("Non Encrypted Message: " + message);
        System.out.println("Encrypted Message: " + encrypted + " using key: " + key);
    }
    
    public void testEncryption() {
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
    }
}
