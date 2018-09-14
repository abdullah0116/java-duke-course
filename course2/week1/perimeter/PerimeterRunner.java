import edu.duke.*;

public class PerimeterRunner {
    public double getPerimeter(Shape s) {
        // start with totalPerim = 0;
        double totalPerim = 0;
        // start with prevPT = the last point
        Point prevPT = s.getLastPoint();
        // for each point currPT in the shape 
        for(Point currPT: s.getPoints()) {
            // find the distance from prevPT pt to currPT set it to currDist
            double currDist = prevPT.distance(currPT);
            // update totalPerim to be totalPerim + (plus) currDist 
            totalPerim = totalPerim + currDist;
            // update prevPT to be currPT
            prevPT = currPT;
        }
        // totalPerim is the answer that needs to be returned
        return totalPerim;
    }
    
    public void testPerimeter() {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("Your Perimter is: " + length);
    }
    
    public static void main(String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
