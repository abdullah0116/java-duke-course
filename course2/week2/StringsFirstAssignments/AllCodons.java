
/**
 * Write a description of AllCodons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AllCodons {
    public int findStopCodon(String dnaString, int startIndex, String stopCodon) {
        // find stopCodon starting from (startIndex +Find stopCodon 
        // starting from (startIndex +3), call this result cureIndex 
        int currIndex = dnaString.indexOf(stopCodon, startIndex+3);         
        // as long as currIndex is not equal to -1
        while (currIndex != -1) {
            // check if (currIndex - startIndex) is a multiple of 3 
            if ((currIndex - startIndex) % 3 == 0) {
                // if so, currIndex is the answer 
                return currIndex;
            }   
            // if not update currIndex to the index of the next
            else {
                // stopCodon starting from (currIndex + 1)
                currIndex = dnaString.indexOf(stopCodon, currIndex + 1);
            }
        }          
        // your answer is dnaSTR.length()    
        return dnaString.length();
    }
    
    public String findGene(String dna) {
        // find first occurrence of "ATG" call its index startIndex 
        // if startIndex is -1 then your answer is the empty string 
        // findStopCodon(dnaString, startIndex, "TAA") and call the result taaIndex
        // findStopCodon(dnaString, startIndex, "TAG") and call the result tagIndex
        // findStopCodon(dnaString, startIndex, "TGA") and call the result tgaIndex
        // take the smallest of taaIndex, tgaIndex, and tagIndex: call it minIndex
        // your answer is the text from startindex to minindex + 3
        return "";
    }
}
