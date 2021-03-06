import java.util.*;
import edu.duke.*;

public class EarthQuakeClient {
   public EarthQuakeClient() {
       // TODO Auto-generated constructor stub
   }
   
   public void quakesByPhrase() {
       EarthQuakeParser parser = new EarthQuakeParser();
       String source = "data/nov20quakedata.atom";
       ArrayList<QuakeEntry> list = parser.read(source);
       ArrayList<QuakeEntry> phrasesList = filterByPhrase(list, "anyfindLargestQuakes", "Creek");
       
       System.out.println("read data for " + list.size() + " quakes.");
       for(QuakeEntry qe : phrasesList) {
           System.out.println(qe);
       }
   }
   
    /* 
     * Write the method filterByPhrase that has three parameters, an ArrayList of type
     * QuakeEntry named quakeData, a String named where that indicates where to search 
     * in the title and has one of three values: (“start”, ”end”, or “any”), and a String 
     * named phrase, indicating the phrase to search for in the title of the earthquake. 
     * The title of the earthquake can be obtained through the getInfo() method. 
     * The filterByPhrase method should return an ArrayList of type QuakeEntry 
     * of all the earthquakes from quakeData whose titles have the given phrase found 
     * at location where (“start” means the phrase must start the title, “end” means 
     * the phrase must end the title and “any” means the phrase is a substring anywhere 
     * in the title.)
       */   
   
   public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String where, String phrase) {
       ArrayList<QuakeEntry> filterByPhraseList = new ArrayList<QuakeEntry>();
 
       for(QuakeEntry qe : quakeData) {
           if (where.equals("start")) {
               if(qe.getInfo().startsWith(phrase)) {
                   filterByPhraseList.add(qe);
               }
           } else if(where.equals("end")) {
               if(qe.getInfo().endsWith(phrase)) {
                   filterByPhraseList.add(qe);
               } 
           } else if(where.equals("any")) {
               if(qe.getInfo().contains(phrase)) {
                   filterByPhraseList.add(qe);
               }
           }
       }
              System.out.println("Found "+ filterByPhraseList.size() +" quakes that match " + phrase + " at " + where);
       return filterByPhraseList;
   }
   
   public void tester() {
       EarthQuakeParser parser = new EarthQuakeParser();
       String source = "data/nov20quakedatasmall.atom";
       ArrayList<QuakeEntry> list = parser.read(source);
       ArrayList<QuakeEntry> randomList = filterByPhrase(list, "any", "California");
       for(QuakeEntry qe : randomList) {
           System.out.println(qe);
       }
   }
   /* 
   Write the void method quakesOfDepth that has no parameters to use 
   filterByDepth and print all the earthquakes from a data source whose 
   depth is between a given minimum and maximum value. You should also 
   print out the number of earthquakes found. After writing this method, 
   when you run your program on the file nov20quakedatasmall.atom for 
   quakes with depth between -10000.0 and -5000.0
   */
   
   public void quakesOfDepth() {
       EarthQuakeParser parser = new EarthQuakeParser();
       String source = "data/nov20quakedatasmall.atom";
       double min = -10000.0;
       double max =  -8000.0;
       ArrayList<QuakeEntry> list  = parser.read(source);
       ArrayList<QuakeEntry> depthsFilterList = filterByDepth(list, min, max);
       
       System.out.println("read data for " + list.size() + " quakes.");
       System.out.println("Find quakes with depth between" + min + " and " + max);
       for (QuakeEntry qe : depthsFilterList) {
           System.out.println(qe);
       }
       System.out.println("Found " + depthsFilterList.size() + " quakes that match that criteria.");
   }
   
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData,
                                               double minDepth, 
                                               double maxDepth) {
        ArrayList<QuakeEntry> earthQuakes = new ArrayList<QuakeEntry>();
        
        for (QuakeEntry qe : quakeData) {
            if (qe.getDepth() > minDepth && qe.getDepth() < maxDepth) {
                earthQuakes.add(qe);
            }
        }
        
        return earthQuakes;
   }
   
    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getMagnitude() > magMin) {
                answer.add(qe);
            }
        }
        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
    double distMax,
    Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for (QuakeEntry qe : quakeData) {
            if(qe.getLocation().distanceTo(from) < distMax) {
                answer.add(qe);
            }
        } 
        return answer;
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }

    public void bigQuakes(double min) {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        ArrayList<QuakeEntry> largerThanMinQuakes = filterByMagnitude(list, min);
        // size of arraylist
        System.out.println("Quakes that are larger than: " + min);
        System.out.println("read data for "+ largerThanMinQuakes.size() +" quakes");
        for (QuakeEntry qe : largerThanMinQuakes) {
            System.out.println(qe);
        }
    }

    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("# quakes read: " + list.size());
        
        //Durham, NC
        Location city = new Location(35.988, -78.907);
        //Bridgeport, CA
       // Location city = new Location(38.17, -118.82);
        ArrayList<QuakeEntry> close = filterByDistanceFrom(list, 1000*1000, city);
        for (int k=0; k< close.size(); k++) {
            QuakeEntry entry = close.get(k);
            double distanceInMeters = city.distanceTo(entry.getLocation());
            System.out.println(distanceInMeters/1000 + " " + entry.getInfo());
        }
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
}
