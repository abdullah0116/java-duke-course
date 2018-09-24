
/**
 * 
 * This program finds Genes in DNAs.
 * 
 * @author (Abdullah Kareem) 
 * @version (1.2)
 */
public class FindGeneWhile {
    public String findGene(String dna) {
        // I found the first occurrence of “ATG” — startIndex 
        int startIndex = dna.indexOf("ATG"); 
        // find the “TAA” starting from (startIndex + 3) call this result — currIndex 
        int currIndex = dna.indexOf("TAA", startIndex + 3);
        // as long as currIndex is not equal to -1
        while(currIndex != -1) {
            // check if (currIndex - startIndex) is a multiple of 3 
            if ((currIndex - startIndex) % 3 == 0) {
                // if so the text between start index and currIndex + 3 is 	the answer 
                return dna.substring(startIndex, currIndex+3);
            } else {
                //  if not update currIndex to the index of the next “TAA” 	starting from (currIndex + 1)
                currIndex = dna.indexOf("TAA", currIndex + 1);
            } 
        }
        //answer is an empty string 
        return "";
    }
    
    public void findGeneTester() {
        String dna  = "CGATGGTAAATAAGCCTAAGCTATAA";
        System.out.println("The DNA strand: " + dna);
        String gene = findGene(dna);
        System.out.println("The Gene strand is: " + gene);
    }
}
