
/**
 * Write a description of FindAGene here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindAGene {
    public String FindGeneSimple(String dna) {
        // start codon 
        int startCodon = dna.indexOf("ATG");
        if (startCodon == -1) {
            System.out.println("There is no start of DNA");
            return "";
        }    
        // end codon 
        int endCodon = dna.indexOf("TAA", startCodon+3);
        if (endCodon == -1) {
            System.out.println("There is no end the DNA strand");
            return "";
        }
        String result = dna.substring(startCodon, endCodon+3);
        return result;
    }
    
    // this method has some tests for Find Gene Simple method
    public void testFindGene() {
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is: " + dna);
        String gene = FindGeneSimple(dna);
        System.out.println("Your Gene is: " + gene);
        
        dna = "ATTATGEEWLKRWATTTAA";
        System.out.println("DNA strand is: " + dna);
        gene = FindGeneSimple(dna);
        System.out.println("Your Gene is: " + gene);
        
        dna = "ATBGTAA";
        System.out.println("DNA strand is: " + dna);
        gene = FindGeneSimple(dna);
        System.out.println("Your Gene is: " + gene);
        
        dna = "ATGGTBA";
        System.out.println("DNA strand is: " + dna);
        gene = FindGeneSimple(dna);
        System.out.println("Your Gene is: " + gene);
    }
}
