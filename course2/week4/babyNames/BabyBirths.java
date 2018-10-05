import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyBirths {
    public void printName(){
        FileResource fr = new FileResource();
        // the word "false" in the call fr.getCSVParser(false)
        // means there is no "Header row"
        // what the header row is the thing that is called name, dob, ect..
        for (CSVRecord record : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(record.get(2));
            
            if (numBorn <= 100) {
                System.out.println("Name " + record.get(0) 
                                           + " Gender " 
                                           + record.get(1)
                                           + " Num Births "
                                           + record.get(2));
            }                           
        }
    }
    
    //                    *** TESTER METHODS *** 

}
