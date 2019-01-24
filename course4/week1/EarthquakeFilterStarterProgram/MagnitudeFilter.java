
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
    
    //a constructor to initialize those variables
    public MagnitudeFilter(double min, double max) {
        minimum = min;
        maximum = max;
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
