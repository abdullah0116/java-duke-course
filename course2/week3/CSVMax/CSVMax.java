import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {
    public CSVRecord hottestHourInFile(CSVParser parser) {
        //start with largestSoFar as nothing
        CSVRecord largestSoFar = null;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) { 
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
        //The largestSoFar is the answer
        return largestSoFar;
    }
    
    public CSVRecord hottestManyDays() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord largestSoFar = null;
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // use method to get largest file
            CSVRecord currentRow = hottestHourInFile((fr.getCSVParser()));
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
        // the largestSoFar is the answer 
        return largestSoFar;
    }
   
    public CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar) {
        //If largestSoFar is nothing 
        if(largestSoFar == null ){
            //If so update largestSoFar to currentRow 
            largestSoFar = currentRow;
        } else { //Otherwise 
            //Check if currentRow's tempture > largestSoFar
                
            String tempLarStri = currentRow.get("TemperatureF");
            double tempRow = Double.parseDouble(currentRow.get("TemperatureF"));
            double tempLar = Double.parseDouble(largestSoFar.get("TemperatureF"));
            if (tempRow > tempLar) {
                largestSoFar = currentRow; 
            }
        }
        return largestSoFar;
    }
    //                      *** TESTER METHODS ***
    public void testHottestManyDays() {
        CSVRecord largest = hottestManyDays();
        System.out.println("Hottest Temperature was " + largest.get("TemperatureF")
                                                      + " F at " 
                                                      + largest.get("DateUTC"));
    }
    
    public void testHottestInDay() {
        FileResource fr = new FileResource("data/2015/weather-2015-01-02.csv");
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("Hottest temperature was " + largest.get("TemperatureF")
                                                      + "F at " 
                                                      + largest.get("TimeEST"));
    }
}
