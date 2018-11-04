
public class BreakingCaesarCipher {
    public void eyeBallDecrypt(String encrypted) {
        CaesarCipher cipher = new CaesarCipher();
        for (int i = 0; i < 26; i++) {
            String result = cipher.encrypt(encrypted, i);
            System.out.println("Key: " + i + " String: " + result);
        }
    }
    
    public String decrypt(String encrypted, int key1,int key2) {
        CaesarCipher cipher = new CaesarCipher();
        String firstString = cipher.encrypt(encrypted, key1);
        String finalResult = cipher.encrypt(firstString , key2);
        
        return finalResult;
    }
    
    public void testDecrypt() {
        System.out.println(decrypt("Hfs cpwewloj loks cd Hoto kyg Cyy.", 14, 24));
    }
    
    public void textFingerPrint(String string) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] counters = new int[26];
        for(int i = 0; i < string.length(); i ++) {
            char currCh = string.charAt(i);
            int index = alpha.indexOf(Character.toLowerCase(currCh));
            if (index != -1) {
                counters[index] += 1;
            }
        }
        for (int i = 0; i < counters.length; i++) {
            System.out.println(alpha.charAt(i) + "\t" + counters[i]);
        }
    }
    //                  ***  TESTER METHODS  ***
    public void eyeBallDecryptTester() {
        // string 
        //    |
        //    V
        //  At noon be in the conference room with your hat on for a surprise party. YELL LOUD!
        eyeBallDecrypt("Top ncmy qkff vi vguv vbg ycpx");
    }
    
    public void testTextFingerPrint() {
        textFingerPrint("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!");
    }
}
