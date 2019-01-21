
/**
 * Write a description of MagnitudeFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//Write the class MagnitudeFilter that implements Filter
public class MagnitudeFilter implements Filter{
    private boolean result = false;
   
    //should include private instance variables for a minimum and maximum 
    private double minimum;
    private double maximum;
    private double magnitude;
    
    //a constructor to initialize those variables
    public MagnitudeFilter(double min, double max, double mag) {
        minimum = min;
        maximum = max;
        magnitude = mag;
    }
    
    public boolean satisfies(QuakeEntry qe) {
         boolean result = false;
         double mag = qe.getMagnitude();
         
         if (mag >= minimum && mag <= maximum) {
             result = true;
         }
         
         return result;
    }
}
