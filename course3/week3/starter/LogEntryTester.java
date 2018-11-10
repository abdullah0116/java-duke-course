import java.util.*;
public class LogEntryTester {
    public void tester() {
        LogEntry entry = new LogEntry("1.2.3.4", new Date(), "first request", 
                                       200, 500);
        System.out.println("Log #1: " + entry);                               
        
        LogEntry secondEntry = new LogEntry("186.84.85.9", new Date(), 
        "secondRequst", 300, 400);
        
        System.out.println("Log #2: " + secondEntry);
    }
}