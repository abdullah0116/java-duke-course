
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, int startCodon, int stopCodon) {
        if (dna.equals(dna.toUpperCase())) {
            startCodon = dna.indexOf("ATG");
            
            if (startCodon == -1) {
                return "";
            }
        
            stopCodon = dna.indexOf("TAA", startCodon+3);
            String result = dna.substring(startCodon, stopCodon+3);
            
            if((startCodon + stopCodon) % 3 == 0) {
                return result.toUpperCase();
            }
        }
        
        if (dna.equals(dna.toLowerCase())) {
            startCodon = dna.indexOf("atg");
           
            if (startCodon == -1) {
                return "";
            }
        
            stopCodon = dna.indexOf("taa", startCodon+3);
            String result = dna.substring(startCodon, stopCodon+3);
            
            if((startCodon + stopCodon) % 3 == 0) {
                return result.toLowerCase();
            }
        }
 
        return "";
    }
    
    public void SimpleGeneTester() {
        // tester method
        //String rawGene = "JKLDJSLKDATGGKGIKCTAAJKDJSDLKJSD";
        //System.out.println("The Raw Gene is: " + rawGene);
        
        //caps test 
        System.out.println("Upper Caps test"); 
        System.out.println("     The DNA is: " + findSimpleGene("SSSSSSSSAATGGKGIKCTAAJKFDSDLKJSD", 0, 100)); 
        System.out.println("Lower Caps test");
        System.out.println("     The DNA is: " + findSimpleGene("jkldjslkdatggkgikctaajkdjsdlkjsd", 0, 100)); 
                                                                 
    }                                           
}
