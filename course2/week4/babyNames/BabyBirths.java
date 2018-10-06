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
        int totalBirths      = 0;
        int totalFemales     = 0;
        int totalMale        = 0;
        int totalMaleNames   = 0;
        int totalFemaleNames = 0;
        
        for (CSVRecord record : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(record.get(2));
            totalBirths += numBorn;
            
            if (record.get(1).equals("M")) {
                totalMaleNames++;
            } else if (record.get(1).equals("F")) {
                totalFemaleNames++;
            }
            
            if(record.get(1).equals("M")){
                totalMale += numBorn;
            } else  {
                totalFemales += numBorn;
            }
            
            
        }
        System.out.println("Total Births: " + totalBirths);
        System.out.println("Female DATA:");
        System.out.println("    Total Female Births: " + totalFemales);
        System.out.println("    Total Female Names: " + totalFemaleNames);
        System.out.println("Male DATA:");
        System.out.println("    Total Male Births: " + totalMale);
        System.out.println("    Total Male Names: " + totalMaleNames);
    }
    
    public int getRank(int year, String name, String gender) {
        String yearStri = Integer.toString(year);
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob" 
                                            + yearStri + ".csv");
        int rank = 0;
        
        for (CSVRecord record : fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                rank++;
                
                if (record.get(0).equals(name)) {
                    return rank;
                }
            }
        }
        
        return -1;
    }
    
    public String getName(int year, int rank, String gender) {
        String yearStri = Integer.toString(year);
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob" 
                                            + yearStri + ".csv");
                                            
        int currentRank = 0;                                    
        for (CSVRecord record : fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                currentRank++;
                
                if (currentRank == rank){
                    return record.get(0);
                }
            }
        }
        return null;
    }
    //                    *** TESTER METHODS *** 
    public void testGetName() {
        System.out.println("The name your looking for: " + getName(1880, 2, "F"));
    }
    
    public void testGetRank() {
        System.out.println("The rank of name: " + getRank(1880, "Anna", "F"));
    }
    
    public void testTotalBirths() {
        //FileResource fr = new FileResource("us_babynames/example-small.csv");
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
}
