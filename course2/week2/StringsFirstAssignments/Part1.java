
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna) {
        //Finds the index position of the start codon “ATG”. 
        int startCodon = dna.indexOf("ATG");
        //If there is no “ATG”, return the empty string.
        if (startCodon == -1) {
            return "";
        }
        
        //Finds the index position of the first stop codon “TAA” appearing after
        // the “ATG” that was found. 
        int stopCodon = dna.indexOf("TAA", startCodon+3);
        //If there is no such “TAA”, return the empty string.
        if (stopCodon == -1) {
            return "";
        }
        
        String result = dna.substring(startCodon, stopCodon+3);
        //If the length of the substring between the “ATG” and “TAA” is a 
        //multiple of 3, then return the substring that starts with that 
        if((startCodon + stopCodon) % 3 == 0) {
            return result;
        }
        //“ATG” and ends with that “TAA”.

        return "";
    }
    
    public void SimpleGeneTester() {
        // tester method
        String rawGene = "JKLDJSLKDATGGKGIKCTAAJKDJSDLKJSD";
        System.out.println("The Raw Gene is: " + rawGene);
        String DNA = findSimpleGene(rawGene);
        System.out.println("The DNA is: " + DNA); 
        
        rawGene = "DDATGLDKDATGFKDLFJTAA";
        System.out.println("The Raw Gene is: " + rawGene);
        DNA = findSimpleGene(rawGene);
        System.out.println("The DNA is: " + DNA);
    }
}
