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
    
    public CSVRecord getLowestOfTwo(CSVRecord currentRow, CSVRecord lowestSoFar){
        //If largestSoFar is nothing 
            if(lowestSoFar == null ){
                //If so update largestSoFar to currentRow 
                lowestSoFar = currentRow;
            } else { //Otherwise 
                //Check if currentRow's tempture < largestSoFar
                
                String tempLarStri = currentRow.get("TemperatureF");
                double tempRow = Double.parseDouble(currentRow.get("TemperatureF"));
                double tempLar = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                
               
                if (tempRow > -9999) {
                    if (tempRow < tempLar) {
                        lowestSoFar = currentRow; 
                    }
                }
            }
        return lowestSoFar;
    }
    
    public CSVRecord coldestHourInFile(CSVParser parser){
        //start with lowestSoFar as nothing
        CSVRecord lowestSoFar = null;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) { 
            lowestSoFar = getLowestOfTwo(currentRow, lowestSoFar);
        }
        //The largestSoFar is the answer
        return lowestSoFar;
    }
    
    public CSVRecord coldestManyDays() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestSoFar = null;
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // use method to get largest file
            CSVRecord currentRow = coldestHourInFile((fr.getCSVParser()));
            lowestSoFar = getLowestOfTwo(currentRow, lowestSoFar);
        }
        // the largestSoFar is the answer l
        return lowestSoFar;
    }
    
    //                      *** TESTER METHODS ***
    public void testColdestManyDays() {
        CSVRecord coldest = coldestManyDays();
        System.out.println("Coldest temperature on that day was : " 
                           + coldest.get("TemperatureF"));
    }
    
    public void testLowestInDay() {
        FileResource fr = new FileResource("data/2015/weather-2015-01-01.csv");
        CSVRecord lowest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Lowest temperature was " + lowest.get("TemperatureF")
                                                      + "F at " 
                                                      + lowest.get("TimeEST"));
    }
    
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
