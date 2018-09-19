import edu.duke.*;
import java.io.File;
public class PerimeterRunner {
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
    public int getNumPoints(Shape s){
       int pointCount = 0;
       for(Point currPt : s.getPoints()){
            pointCount = pointCount + 1;   
       }
       return pointCount;
    }
    
    public double getAverageLength(Shape s){
       int pointCount = getNumPoints(s);
       double perimeter = getPerimeter(s);
       return perimeter / pointCount;
    }
    
    public double getLargestSide(Shape s){
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();
        for(Point currPt: s.getPoints()){
            double currSide = prevPt.distance(currPt);
            if(currSide > largestSide){
                largestSide = currSide;   
            }
            prevPt = currPt;
        }
        return largestSide;
    }
    
    public double getLargestX(Shape s){
        double largestX = 0;
        for(Point currPt: s.getPoints()){
            if(currPt.getX() > largestX){
                largestX = currPt.getX();   
            }
        }
        return largestX;
    }
    
    public File getFileWithLargestPerimeter(){
        File file_lp = null;
        double largestPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
             FileResource currFR = new FileResource(f);
             Shape currShape = new Shape(currFR);
             double currPerimeter = getPerimeter(currShape);
             if(currPerimeter > largestPerimeter){
                 largestPerimeter = currPerimeter;
                 file_lp = f;
             }
        }
        return file_lp;
    }
     
    public double getLargestPerimeterMultipleFiles(){
        double largestPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
             FileResource currFR = new FileResource(f);
             Shape currShape = new Shape(currFR);
             double currPerimeter = getPerimeter(currShape);
             if(currPerimeter > largestPerimeter){
                 largestPerimeter = currPerimeter;
             }
        }
        return largestPerimeter;
    }
    
    public void testPerimeter () {
        // Assignment 1:
        
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int pointCount = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("Point Count = " + pointCount);
        System.out.println("perimeter = " + length);
        System.out.println("Average Length = " + averageLength);
        System.out.println("Largest Side = " + largestSide);
        System.out.println("Largest X = " + largestX);
    }
    
    public void testPerimeterMultipleFiles(){
        //Assignment 2:
        double lp_mf = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter of multiple files = " + lp_mf); 
    }
    
    public void testFileWithLargestPerimeter(){
        File file_lp = getFileWithLargestPerimeter();
        System.out.println("File with largest perimeter = " + file_lp.getName());
    }
    
    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}