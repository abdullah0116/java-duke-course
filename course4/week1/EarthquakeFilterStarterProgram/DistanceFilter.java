public class DistanceFilter implements Filter{
    private Location location;
    private double maximum;
    
    public DistanceFilter(Location loc, double max) {
        location = loc;
        maximum = max;
    }
    
    public boolean satisfies(QuakeEntry qe) {
        boolean result = false;
        
        double distance = location.distanceTo(qe.getLocation());
        
        return result;
    }
}
