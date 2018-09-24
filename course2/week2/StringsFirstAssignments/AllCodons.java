
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
        int startIndex = dna.indexOf("ATG");
        // if startIndex is -1 then your answer is the empty string 
        if(startIndex == -1){
            return "";
        }
        // findStopCodon(dnaString, startIndex, "TAA") and call the result taaIndex
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        // findStopCodon(dnaString, startIndex, "TAG") and call the result tagIndex
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        // findStopCodon(dnaString, startIndex, "TGA") and call the result tgaIndex
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        // take the smallest of taaIndex, tgaIndex, and tagIndex: call it minIndex
        int firstMin = Math.min(taaIndex, tagIndex);
        int minIndex = Math.min(firstMin, tgaIndex);
        
        if(minIndex == dna.length()){
            return "";
        }
        // your answer is the text from startindex to minindex + 3
        return dna.substring(startIndex, minIndex + 3);
    }
    
    public void testFindGene() {
        String dnaTAA = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        String dnaTAG = "xxxyyyzzzTAGxxxyyyzzzTAGxx";
        String dnaTGA = "xxxyyyzzzTGAxxxyyyzzzTGAxx";
        
        System.out.println("Gene of TAA: " + findStopCodon(dnaTAA, 0, "TAA"));
        System.out.println("Gene of TAG: " + findStopCodon(dnaTAG, 0, "TAG"));
        System.out.println("Gene Of TGA: " + findStopCodon(dnaTGA, 0, "TGA"));
    }
    
    public void testFindStop() {
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna, 0, "TAA");
        if (dex != 9) {
            System.out.println("error on line 9!");
        }
        
        dex = findStopCodon(dna, 9, "TAA");
        
        if (dex != 21){
            System.out.println("error on line 21!");
        }
        
        dex = findStopCodon(dna, 1, "TAA");
        
        if (dex != 26){
            System.out.println("error on line 26!");
        }
        
        dex = findStopCodon(dna, 0, "TAG");
        
        if (dex != 26){
            System.out.println("error on line 26!");
        }
        
        System.out.println("All tests are complete.");
    }
}
