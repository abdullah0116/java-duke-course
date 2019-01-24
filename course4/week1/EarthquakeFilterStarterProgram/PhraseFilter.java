public class PhraseFilter implements Filter{
    private String type;
    private String phrase;
    
    public PhraseFilter(String type, String phrase) {
        this.type = type;
        this.phrase = phrase; 
    }
    
    public boolean satisfies(QuakeEntry qe) {
        boolean result = false;
        Location loc = qe.getLocation();
        String title = qe.getInfo();
        
        if (title.contains(phrase)) {
            result = true;
        }
        
        return result;
    }
}
