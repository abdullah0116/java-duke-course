import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

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
        return "No Name is Found!";
    }
    
    public void whatIsNameInYear(String name, String gender, int year, int newYear) {
        String yearBornStri = Integer.toString(year);
        String newYearStri = Integer.toString(newYear);
        int rankBorn = 0;
        int rankNew = 0;
        FileResource bornYearFile = new FileResource("us_babynames/us_babynames_by_year/yob"
                                                    + yearBornStri + ".csv");
        FileResource newYearFile = new FileResource("us_babynames/us_babynames_by_year/yob"
                                                    + newYearStri + ".csv");
        
        //              *** birth year rank loop ***
        for (CSVRecord record : bornYearFile.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                rankBorn++;
                
                if (record.get(0).equals(name)) {
                    break;
                }
            }
        }
        // Isabella born in 2012 would be Sophia if she was born in 2014.
        System.out.println(name + " born in " + year + " would be " 
                                              + getName(newYear, rankBorn, gender)
                                              + " if she was born in "
                                              + newYear + ".");
    }
    
    public static int yearOfHighestRank(String name, String gender) {

	int rank = 1000000;
	int yearHigh = 0;
		
	DirectoryResource dr = new DirectoryResource();
		
	for(File fi : dr.selectedFiles()){
	
	    String fileName = fi.getName();
			
	    int year = Integer.parseInt(fileName.replaceAll("[\\D]", ""));
			

	    FileResource fr = new FileResource(fi);
	    int currRank = -1;
	    int pivot = 0;
	    for(CSVRecord record : fr.getCSVParser(false)){
	        
	        if(record.get(1).equals(gender)) {
					
	            pivot++;
								
	            if(record.get(0).equals(name)) {
	                currRank = pivot;
	                break;
	            }
					
	        }
				
	    }
		
		if(currRank != -1 && currRank < rank){
		    rank = currRank;
		    yearHigh = year;
		}
		
	}
		
	return yearHigh;
    }
    
    public static double getAverageRank(String name, String gender) {
        //get director
        DirectoryResource dr = new DirectoryResource();
        int fileNum = 0;
        int totalRank = 0;
		
        for(File fi : dr.selectedFiles()){
            fileNum++;
			
            //get the file resource
            FileResource fr = new FileResource(fi);
            
            int pivot = 0;
            int currRank = 0;
            for(CSVRecord record : fr.getCSVParser(false) ){
                if(record.get(1).equals(gender)) {
                    pivot++;
                    if(record.get(0).equals(name)) {
                        currRank = pivot;
                        break;
                    } //end if record.equals name condition;
                }
            }//end for Record loop;
            totalRank += currRank;
        }//end for file loop;
        if(totalRank == 0) return -1;
        else return (double)(totalRank)/fileNum;
    }

    public static int getTotalBirthsRankedHigher(int year, String name, String gender) {
        FileResource fr = new FileResource("babynamedata/us_babynames_test/yob" + String.valueOf(year) +"short.csv");
		
        int sum = 0;
        for(CSVRecord record : fr.getCSVParser(false)){
            
            if(record.get(1).equals(gender)){
				
                if(record.get(0).equals(name)) 
                return sum;
				
                sum += Integer.parseInt(record.get(2));
								
            }//end if record euqals gender condition;
			
        }//end for CSV record record;
		
        return sum;
    }//end getTotalBirthsRankedHigher() method;
	


    //                    *** TESTER METHODS ***
    public void testYearOfHighestRank() {
        yearOfHighestRank("Anna", "F");
    }
    
    public void testWhatIsNameInYear() {
        whatIsNameInYear("Anna", "F", 1880, 1900);
    }
    
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
