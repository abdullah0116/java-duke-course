import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int counter = 0;
        for (Point p : s.getPoints()) {
            counter++;
        }    
        return counter;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double length = getPerimeter(s);
        double numPTS = getNumPoints(s);
        double average = length / numPTS;
        return average;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point prevPT = s.getLastPoint();
        double largeSide = 0.0;
        
        for (Point p : s.getPoints()) {
            double ptDist = prevPT.distance(p);
            if (ptDist > largeSide) {
                largeSide = ptDist;
            }
            prevPT = p;
        }
        return largeSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        return 0.0;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        
        double length = getPerimeter(s);
        int numPTS = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double largSide = getLargestSide(s);
        
        System.out.println("Your Perimeter: " + length);
        System.out.println("Number of points: " + numPTS);
        System.out.println("The average length is: " + averageLength);
        System.out.println("The largest value of a side: " + largSide);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
