import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {
    public CSVRecord hottestHourInFile(CSVParser parser) {
        //start with largestSoFar as nothing
        CSVRecord largestSoFar = null;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) { 
            //If largestSoFar is nothing 
            if(largestSoFar == null ){
                //If so update largestSoFar to currentRow 
                largestSoFar = currentRow;
            } else { //Otherwise 
                //Check if currentRow's tempture > largestSoFar
                String tempRowStri = currentRow.get("TemperatureF");
                String tempLarStri = currentRow.get("TemperatureF");
                double tempRowInt = Double.parseDouble(tempRowStri);
                double tempLarInt = Double.parseDouble(tempLarStri);
                if (tempRowInt > tempLarInt) {
                    largestSoFar = currentRow; 
                }
            }
        }
        //The largestSoFar is the answer
        return largestSoFar;
    }
}
