import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {
    public void listExporters(CSVParser parser, String exportOfIntrest){
        // for each row in the CSV file 
        for(CSVRecord record : parser){
            // look at the "exports" column
            String export = record.get("Exports");
            // check if it contains exportOfIntrest 
            if (export.contains(exportOfIntrest)) {
                // if so write down the "country" from that row
                String country = record.get("Country");
                System.out.println("This country exports " + exportOfIntrest + ": " + country);
            }
        }
    }
    
    public String countryInfo(CSVParser parser, String country) {
        for(CSVRecord record : parser){
            String countrySrc = record.get("Country");
            
            if (countrySrc.contains(country)) {
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                System.out.println(country + " : " +  exports +  " : "  + value);
            } else {
                System.out.println("NOT FOUND");
            }
          
        }
        return "";
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for(CSVRecord record : parser){
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                String country = record.get("Country");
                System.out.println("This country has both " + exportItem1 
                                                           + " and "
                                                           + exportItem2 
                                                           + ": " + country);
            }
        }
    }
    
    public String numberOfExports(CSVParser parser, String exportItem){
        int counter = 0;
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportItem)){
                counter++;
            }
        }
        
        System.out.println("Number of exports of item " + exportItem
                                                        + ": " 
                                                        + counter);
        return "";
    }
    
    //                      *** TEST METHODS ***
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryInfo(parser, "Malawi");
        
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");
        
        parser = fr.getCSVParser();
        numberOfExports(parser, "coffee");
    }
    
    public void coffeeExporters() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffee");
    }
}
