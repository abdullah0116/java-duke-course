
public class BreakingCaesarCipher {
    public void eyeBallDecrypt(String encrypted) {
        CaesarCipher cipher = new CaesarCipher();
        for (int i = 0; i < 26; i++) {
            String result = cipher.encrypt(encrypted, i);
            System.out.println("Key: " + i + " String: " + result);
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
    
}
