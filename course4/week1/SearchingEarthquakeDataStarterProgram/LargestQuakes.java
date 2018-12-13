import java.util.*;
public class LargestQuakes {
    public void findLargestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
       
   
        System.out.println("Total Quakes: " + list.size());
        ArrayList<QuakeEntry> largest = getLargest(list, 5);
        System.out.println(largest);
        //int largestMag = indexOfLargest(list);
        //System.out.println(largestMag);
        
        for (QuakeEntry qe : largest) {
            System.out.println(qe);
        }
    }
    
    public int indexOfLargest(List<QuakeEntry> data) {
        int indexOfLargest = 0;
        double maxMagnitude = 0;
        for (int i = 0; i < data.size(); i++) {
          QuakeEntry quakeEntry = data.get(i);
          if (quakeEntry.getMagnitude() > maxMagnitude) {
            maxMagnitude = quakeEntry.getMagnitude();
            indexOfLargest = i;
          }
        }
        System.out.println("Largest Mag " + data.get(indexOfLargest).getMagnitude());
        return indexOfLargest;
    }
    
     private ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> quakeDataCopy = new ArrayList<QuakeEntry>(quakeData);
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        
        for(int i = 0; i<howMany; i++){
            int index = this.indexOfLargest(quakeDataCopy);
            
            if(index == -1){ 
                break;
            }
            
            QuakeEntry quake = quakeDataCopy.get(index);
            answer.add(quake);
            quakeDataCopy.remove(quake);
            
        }
        return answer;
    }
}
