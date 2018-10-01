import edu.duke.*;

public class Part1 {
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
        return -1;
    }
    
    public String findGene(String dna, int where) {
        // find first occurrence of "ATG" call its index startIndex 
        int startIndex = dna.indexOf("ATG", where);
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
        //int minIndex = Math.min(firstMin, tgaIndex);
        int minIndex = 0;
        
        if (taaIndex == -1 || (tgaIndex!= -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        }
        else {
            minIndex = taaIndex;
        }
        
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }
        
        if(minIndex == -1){
            return "";
        }
        // your answer is the text from startindex to minindex + 3
        return dna.substring(startIndex, minIndex + 3);
    }

    public StorageResource getAllGenes(String dna){
        StorageResource geneList = new StorageResource();
        // set startIndex at 0
        int startIndex = 0;
        // repeat the following steps
        while(true) {
            // find the next gene after startIndex 
            String currGene = findGene(dna, startIndex);
            // if no gene was found leave the loop
            if(currGene.isEmpty()){
                break;
            }
            
            geneList.add(currGene);
            // print that gene out
            System.out.println("Your Gene is: " + currGene);
            // set startIndex to just past the end of gene
            startIndex = dna.indexOf(currGene, startIndex) + 
                                     currGene.length();
            
        }
        return geneList;
    }
    
    public double cgRatio(String dna){
        int cCounter = 0;
        int gCounter = 0;
        int index    = 0;
        int start = 0; 
        
        while (true) {
            index = dna.indexOf("C", start);
            if(index == -1) {
                break;
            }
            cCounter++;
            start = index + 1;
        }
        
        start = 0; 
        
        while (true) {
            index = dna.indexOf("G", start);
            if (index == -1) {
                break;
            }
            gCounter++;
            start = index+1;
        }
        
        double results = ((double) (cCounter + gCounter)) / dna.length();
        System.out.print("The Ratio is: ");
        return results;
    }
    
    public String printAllGenes(String dna){
        // set startIndex at 0
        int startIndex = 0;
        // repeat the following steps
        while(true) {
            // find the next gene after startIndex 
            String currGene = findGene(dna, startIndex);
            // if no gene was found leave the loop
            if(currGene.isEmpty()){
                break;
            }
            // print that gene out
            System.out.println("Your Gene is: " + currGene);
            // set startIndex to just past the end of gene
            startIndex = dna.indexOf(currGene, startIndex) + 
                                     currGene.length();
            
        }
        return "";
    }
    
    //                        *** TESTER METHODS ***
    public void testPrintAllGenes() {
        System.out.println("First DNA:");
        String dna = "AATGCTAACTAGCTGACTAAT";
        System.out.println("DNA: " + dna);
        System.out.println(printAllGenes(dna));
        
        
        System.out.println("Second DNA:");
        dna = "AATGCTAACTAGCTGACTAAT";
        System.out.println("DNA: " + dna);
        System.out.println(printAllGenes(dna));
    }
    
    public void testFindGene() {
        String dnaTAA = "AATGCTAACTAGCTGACTAAT";
        String dnaTAG = "AATGCTAACTAGCTGACTAAT";
        String dnaTGA = "AATGCTAACTAGCTGACTAAT";
        
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
        
        if (dex != -1){
            System.out.println("error on line 26!");
        }
        
        dex = findStopCodon(dna, 0, "TAG");
        
        if (dex != -1){
            System.out.println("error on line 26!");
        }
        
        System.out.println("All tests are complete.");
    }
    
    public void testOn(String dna){
        System.out.println("Testing getAllGenes: " + dna);
        StorageResource genes = getAllGenes(dna);
        
        for(String s : genes.data()){
        
        }
    }
    
    public void testCGRatio() {
        System.out.println(cgRatio("ATGCCATAG"));
    }
}

