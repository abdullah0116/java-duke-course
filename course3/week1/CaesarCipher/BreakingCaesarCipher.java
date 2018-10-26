
public class BreakingCaesarCipher {
    public void eyeBallDecrypt(String encrypted) {
        CaesarCipher cipher = new CaesarCipher();
        for (int i = 0; i < 26; i++) {
            String result = cipher.encrypt(encrypted, i);
            System.out.println("Key: " + i + " String: " + result);
        }
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
        eyeBallDecrypt("Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!");
    }
    
    public void testTextFingerPrint() {
        textFingerPrint("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!");
    }
}
