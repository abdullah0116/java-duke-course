import edu.duke.*;
import java.util.*;

public class lines {
    private ArrayList<String> lines;
    
    public lines() {
        lines = new ArrayList<String>();
    }
    
    public void fileToLines() {
        FileResource fr = new FileResource();
        String contents = fr.asString();
        String[] split = contents.split("\n");
        lines.clear();
        for (String s : split) {
            lines.add(s);
        }
        for (String s : split) {
            System.out.println(s);
        }
    }
    
    public String getLineByNumber(int number) {
        fileToLines();
        return lines.get(number);
    }
    
    public void testSplit() {
        //String testString = "Hello\nMy\nName";
        //String[] split = testString.split("\n");
        //for (String s : split) {
        //    System.out.println(s);
        //}
        
        fileToLines();
        
        for (int i = 0; i < 20; i++) {
            System.out.println(getLineByNumber(i));
        }
    }
    
    
}
