
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
        // end codon 
        int endCodon = dna.indexOf("TAA", startCodon+3);
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
    }
}
