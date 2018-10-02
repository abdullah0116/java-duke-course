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
    
    public void coffeeExporters() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffee");
    }
}
