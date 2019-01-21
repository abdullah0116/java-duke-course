
public class DepthFilter implements Filter {
    private double minimum, maximum;
    public DepthFilter(double min, double max) {
        minimum = min;
        maximum = max;
    }
    
    public boolean satisfies(QuakeEntry qe) {
        boolean result = false;
        double depth = qe.getDepth();
        
        if(depth >= minimum && depth <= maximum) {
            result = true;
        }
        
        return result;
    }
}
