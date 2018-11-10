
import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records; //      Dec 01
                                       // format "MMM DD"
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<String> ips = new ArrayList<String>();
         System.out.println("Data displaying is for the date: " + someday);
         for (LogEntry log : records) {
             String currDate = log.getAccessTime().toString();
             currDate = currDate.substring(4, 10);
             if (currDate.equals(someday) && !ips.contains(log.getIpAddress())) {
                 ips.add(log.getIpAddress());
             }
         }
         return ips;
     }
     
     public void printAllHigherThanNum(int num) {
         for (LogEntry log : records) {
            int statusCode = log.getStatusCode();
            if (statusCode > num) {
                System.out.println("this status code " + statusCode + " is higher than: " + num);
            }
         }
     }
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         for (String line : fr.lines()) {
             records.add(WebLogParser.parseEntry(line));
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs() {
         //uniqueIPs starts as an empty list 
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         // for each element le in records
         for (LogEntry log : records) {
         //ipAddr is le's ipAddress
         String ipAddr = log.getIpAddress();
            //if ipAddr is not in uniqueIPs {
             if (!uniqueIPs.contains(ipAddr)) {
                 // add ipAddr to uniqueIps
                 uniqueIPs.add(ipAddr);
            }
         }
         // return the size of uniqueIPs
         return uniqueIPs.size();
     }
}
