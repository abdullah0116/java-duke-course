import edu.duke.URLResource;
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {    
    public String urlCrawler(String url) {
        URLResource file = new URLResource(url);
        for (String item : file.lines()){
            String itemLower = item.toLowerCase();
            int pos = itemLower.indexOf("youtube.com");
            if (pos != -1) {
                int beg = item.lastIndexOf("\"", pos);
                int end = item.indexOf("\"", pos+1);
                System.out.println(item.substring(beg+1,end));
            }
        }
        return "";
    }
    
    public void tester() {
        System.out.println(urlCrawler("http://www.dukelearntoprogram.com/course2/data/manylinks.html"));
    }
}
