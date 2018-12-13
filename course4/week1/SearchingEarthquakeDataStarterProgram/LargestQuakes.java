import java.util.*;
public class LargestQuakes {
    public void findLargestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        int largestMag = indexOfLargest(list);
        //System.out.println(largestMag);
        System.out.println("Total Quakes: " + list.size());
        for (QuakeEntry qe : list) {
            //System.out.println(qe);
        }
    }
    
    public int indexOfLargest(ArrayList<QuakeEntry> data) {
        int index = 0;
        
        for(QuakeEntry qe : data) {
            if (qe.getMagnitude() > index) {
                index = data.indexOf(qe);
            }
        } 
        System.out.println("Largest Magnitude " + data.get(index).getMagnitude());
        
        return index;
    }
}
