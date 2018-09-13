import edu.duke.*;

public class PerimeterRunner {
    public double getPerimeter(Shape s) {
        // start with totalPerim = 0;
        double totalPerim = 0;
        // start with prevPT = the last point
        Point prevPT = s.getLastPoint();
        // for each point currPT in the shape 
            // find the distance from prevPT pt to currPT set it to currDist 
            // update totalPerim to be totalPerim + (plus) currDist 
            // update prevPT to be currPT
        // totalPerim is the answer 
        return totalPerim;
    }
    
    public void testPerimeter() {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("Perimter =" + length);
    }
    
    public static void main(String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
