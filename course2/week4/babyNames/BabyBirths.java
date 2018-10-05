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
    
    public void totalBirths (FileResource fr) {
        int totalBirths  = 0;
        int totalFemales = 0;
        int totalMale    = 0;
        
        
        for (CSVRecord record : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(record.get(2));
            totalBirths += numBorn;
            
            if(record.get(1).equals("M")){
                totalMale += numBorn;
            } else  {
                totalFemales += numBorn;
            }
        }
        System.out.println("Total Births: " + totalBirths);
        System.out.println("Total Female Births: " + totalFemales);
        System.out.println("Total Male Births: " + totalMale);
    }
    
    //                    *** TESTER METHODS *** 
    
    public void testTotalBirths() {
        FileResource fr = new FileResource("us_babynames/example-small.csv");
        totalBirths(fr);
    }
}
