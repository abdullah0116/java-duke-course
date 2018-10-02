import edu.duke.*;
import org.apache.commons.csv.*;

public class FirstCSVExample {
    public void readFood(){
        // has a popup that lets you pick the file. 
        FileResource fr = new FileResource();
        // gets the csv parser from the fr instances
        CSVParser parser = fr.getCSVParser();
        
        // ittrates through each text in the csv 
        for(CSVRecord record : parser) {
            // prints out everything under name
            System.out.print(record.get("Name") + " ");
            System.out.print(record.get("Favorite Color") + " ");
            System.out.println(record.get("Favorite Food") + " ");
        }
    }
}
