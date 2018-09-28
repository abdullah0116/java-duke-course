public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex+3);
        
        while (startIndex != -1) {
            if((currIndex + startIndex) % 3 == 0){
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, startIndex+1);
            }
        }
        return -1;
    }
    
    public String findGene(String dna) {
        int atg = findStopCodon(dna, 0, "ATG");
        if (atg != -1) {
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }
    //                  *** TESTER METHODS ***
    public void testFindStop() {
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        System.out.println(findStopCodon(dna, 0, "TAA"));
    }
}
