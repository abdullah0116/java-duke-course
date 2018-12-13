import java.util.*;
public class LargestQuakes {
    public void findLargestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        
        System.out.println("Total Quakes: " + list.size());
        for (QuakeEntry qe : list) {
            //System.out.println(qe);
        }
    }
}
