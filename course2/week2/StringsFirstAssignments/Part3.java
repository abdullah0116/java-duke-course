
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
  public static boolean twoOccurrences(String stringA, String stringB) {
        int currPos;
        int lenA = stringA.length();

        int nextPos = 0;
        int count = 0;

        while((currPos = stringB.indexOf(stringA, nextPos)) >= 0){
            nextPos = currPos + lenA;
            count += 1;
            System.out.println("String a found starting at char: " +  currPos);
            if(count >= 2){
                return true;
            }
        }
        return false;
  }
    
  public String lastPart(String stringA, String stringB){
      int lenA = stringA.length();
      int firstOccurrence = stringB.indexOf(stringA);
        
      if (firstOccurrence >= 0){
          return stringB.substring(lenA + firstOccurrence);
      }
      return stringB;
  }
    
  public void twoOccurrencesTester(){
      System.out.println("The boolean expression returned: " + twoOccurrences("a", "abdullah"));
      System.out.println("The boolean expression returned: " + lastPart("a", "abdullah"));
  }
}
